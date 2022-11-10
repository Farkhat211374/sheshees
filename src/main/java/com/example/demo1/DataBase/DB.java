package com.example.demo1.DataBase;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class DB {
    private final String url = "jdbc:postgresql://localhost:5433/";
    private final String user = "postgres";
    private final String password = "1234";
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String username,password1;
    Scanner sc = new Scanner(System.in);
    private static DB uniqueDB;
    private Connection conn;
    private DB(){}
    public static DB getInstance(){
        if(uniqueDB == null){
            uniqueDB = new DB();
        }
        return uniqueDB;
    }
    public Connection getConn(){
        if(conn == null){
            conn = connect();
        }
        return conn;
    }
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url+"characters", user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public boolean login_user() {
        Scanner scan = new Scanner(System.in);
        Date currentDate = new Date();
        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        String sql = "SELECT * FROM users where username='"+username+"' and password='"+password1+"';";
        try (PreparedStatement pst = getConn().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                user1=rs.getString("username");
                user_pas=rs.getString("password");
                String status=rs.getString("status");
                Date unban_date= rs.getDate("unban_date");
                LocalDate localDate = null;
                if(unban_date!=null) localDate = ((java.sql.Date) unban_date).toLocalDate();
                if(user1.equals(username) && user_pas.equals(password1)) {
                    if(unban_date==null){
                        if(Objects.equals(status, "deleted")){
                            System.out.println("You are dead");
                            return false;
                        }else return true;
                    }
                    else{
                        if(localDate.compareTo(LocalDate.parse(dateFormat.format(currentDate)))<=0) return true;
                        else{
                            System.out.println("You are banned until "+ unban_date);
                            return false;
                        }
                    }
                }
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(
                    DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    public boolean login_admin(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        String sql = "SELECT * FROM admins where username='"+username+"' and password='"+password1+"'";
        try (PreparedStatement pst = getConn().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                user1=rs.getString("username");
                user_pas=rs.getString("password");
                if(user1.equals(username) && user_pas.equals(password1)) {
                    return true;
                }

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(
                    DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    public boolean create_user() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        String sql = "insert into users(username,password) values('"+username+"', '"+password1+"');";
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            return true;
//            pst.setString(1,username);
//            pst.setString(2, password1);
//            pst.executeUpdate();

        } catch (SQLException ex) {
//            Logger lgr = Logger.getLogger(DB.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }catch (Exception e){
//            System.out.println(e.getMessage());
        }
        return false;

    }
    public int routes(String A, String B) {
        String sql = "Select * from routes where city1='"+A+"'and city2='"+B+"';";
        try( PreparedStatement pst = getConn().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()){
            while (rs.next()) {
                return rs.getInt("distance");
            }
        }catch (Exception e){
            System.out.println(e);

        }
        return 0;
    }
    public void get_users(){
        String sql="Select * from users";
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.println(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;


    }
    public void get_users_by_name(String name){
        String sql = "Select * from users where username='"+name+"' limit 1;";
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;


    }

    public void deleteUser(int id){
        String sql = "update users set status='deleted' where user_id="+id;
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            System.out.println("User deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void banUser(int id){
        Date currentDate;
        currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        System.out.println("For how many days you want to ban user?");
        int days=sc.nextInt();
        c.add(Calendar.DATE, days);
        Date currentDatePlusOne = c.getTime();
        LocalDate date = LocalDate.parse(dateFormat.format(currentDatePlusOne));
        System.out.println(currentDatePlusOne+" | "+dateFormat.format(currentDatePlusOne)+" | "+date);
        String sql = "update users set status='ban', unban_date= ? where user_id="+id;
        try {
/*            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);*/
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(date));
            pst.executeUpdate();
            pst.close();
            System.out.println("User banned for "+ days);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unBanUser(int id){
        String sql = "update users set status='available',unban_date = null where user_id="+id;
        try{
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            System.out.println("User unbanned");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void restoreUser(int id){
        String sql = "update users set status='available' where user_id="+id;
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            System.out.println("User restored");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

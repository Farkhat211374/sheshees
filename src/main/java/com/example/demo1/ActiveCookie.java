package com.example.demo1;

import com.example.demo1.PlaneSub.Klass.Economy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class ActiveCookie {

    public String login;
    public String date;
    public Path path = Paths.get("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\java\\com\\example\\demo1\\files\\cookies.txt");


    public void createCookie() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String str = UserDate.login + "\n" + dateFormat.format(now);
        try {
            File file = new File("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\java\\com\\example\\demo1\\files\\cookies.txt");
            file.createNewFile();
            Files.writeString(path, str, StandardCharsets.UTF_8);

            System.out.println("File created successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            ex.getCause();

            System.out.print("Invalid Path");
        }

    }

    public boolean checkCookie() {

        try {
            File file = new File("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\java\\com\\example\\demo1\\files\\cookies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            login = br.readLine();
            date = br.readLine();

            Path filePath = Paths.get("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\java\\com\\example\\demo1\\files\\cookies.txt");
            BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MM yyyy");
            LocalDateTime now = LocalDateTime.now();
            String inputString1 = sdf.format(file.lastModified());
            String inputString2 = dateFormat.format(now);

            Date date1 = sdf.parse(inputString1);
            Date date2 = sdf.parse(inputString2);
            long diff = Math.abs(date2.getTime() - date1.getTime());

            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));


            if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)>15){
                deleteCookie();
                return false;
            }else{
                System.out.println("Less than 15 days");
                createUserByLogin();
                return true;
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void deleteCookie(){
        File file = new File("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\java\\com\\example\\demo1\\files\\cookies.txt");

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());

        } else {
            System.out.println("Failed to delete the file.");

        }
    }

    public void createUserByLogin(){
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        String verifyLoginUser = "SELECT * FROM users WHERE login = '"+ login +"'";
        try {

            Statement statement = connectionDB.createStatement();
            ResultSet queryResultUser = statement.executeQuery(verifyLoginUser);

            while(queryResultUser.next()){

                UserDate.first_name = queryResultUser.getString("first_name");
                UserDate.last_name = queryResultUser.getString("last_name");
                UserDate.login = queryResultUser.getString("login");
                UserDate.password = queryResultUser.getString("password");
                UserDate.status = queryResultUser.getString("status");

            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}

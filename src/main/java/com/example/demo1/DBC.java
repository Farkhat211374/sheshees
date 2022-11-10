package com.example.demo1;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBC {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "characters";
        String databaseUser = "postgres";
        String databasePassword = "1234";
        String url = "jdbc:postgresql://localhost:5433/" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser,databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }

}

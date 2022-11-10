package com.example.demo1.Basic;

import com.example.demo1.DataBase.DB;

import java.util.Scanner;

public class Program {
    DB db = DB.getInstance();
    Navigator navigator = new Navigator();
    public void start(){
        Scanner sc=new Scanner(System.in);
        boolean option = true;
        while (option){
            if(login()) option = logined_admin();
            else option = navigator.main();
        }
    }
    private boolean login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to 3Gis!");
        System.out.println("Please verify or create an account");
        System.out.println("1.Login");
        System.out.println("2.Create");
        int option=sc.nextInt();
        if(option==1) {
            System.out.println("My friend you are admin or user?");
            System.out.println("1 for admins");
            System.out.println("2 for users");
            option = sc.nextInt();
            if (option == 1) {
                while (!db.login_admin()) {
                    System.out.println("Admin with this username or password doesn't exist. Please try again");
                }
                return true;
            } else if (option == 2) {
                while (!db.login_user()){
                    System.out.println("User with this username or password doesn't exist. Please try again");
                }
                return false;
            }
        } else if (option == 2){
            while (!db.create_user()){
                System.out.println("User with this username already exist. Please try again");
            }
            return false;
        }
        return false;
    }
    private boolean logined_admin(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
            System.out.println("My friend what do you want to do");
            System.out.println("Do you want to see other people? press 1");
            System.out.println("Is there particular person you want to find press 2");
            System.out.println("Do you want to kill user press 3");
            System.out.println("DO you want to ban user for saying N word press 4");
            System.out.println("Do you want to unban user? press 5");
            System.out.println("Do you want to restore user? press 6");
            System.out.println("If you want to exit from account press 7");
            System.out.println("If you want to exit from program press 8");
            option = sc.nextInt();
            String name;
            int id;
            switch (option) {
                case 1 -> db.get_users();
                case 2 -> {
                    name = sc.nextLine();
                    name = sc.nextLine();
                    db.get_users_by_name(name);
                }
                case 3 -> {
                    System.out.print("Enter id of user: ");
                    id = sc.nextInt();
                    db.deleteUser(id);
                }
                case 4 -> {
                    System.out.print("Enter id of user: ");
                    id = sc.nextInt();
                    db.banUser(id);
                }
                case 5 -> {
                    System.out.print("Enter id of user: ");
                    id = sc.nextInt();
                    db.unBanUser(id);
                }
                case 6 -> {
                    System.out.print("Enter id of user: ");
                    id = sc.nextInt();
                    db.restoreUser(id);
                }
                case 7 -> {
                    return true;
                }
                case 8 -> {
                    return false;
                }
                default -> {
                    System.out.println("\nInput number invalid");
                }
            }
        }
        return false;
    }
}

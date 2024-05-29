package service;

import music.MusicDetails;
import beat.user;
import database.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String userName;
        String password;
        user u = null;
        int repeat=1;
        int userid=0;


        ArrayList<user> list1 = MusicDetails.user();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("******************* WELCOME TO THE MUSIC WORLD  *******************");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        try{

            System.out.println("\nEnter 1 for Existing User");
            System.out.println("Enter 2 for New User");

            option = sc.nextInt();

            switch (option) {
                case 1: {
                    int flag=0;
                    do{
                        System.out.println("Enter Your Name");
                        userName = sc.next();

                        System.out.println("Enter the password");
                        password = sc.next();

                        Iterator<user> i = list1.iterator();

                        while (i.hasNext()) {
                            u = i.next();
                            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                                System.out.println("~~~~~~ Your account has Successfully Login ~~~~~~");
                                userid=u.getUserId();
                                flag=1;
                            }
                        }if(flag==1){
                            Menu.mainMenu();
                        }else{
                            System.out.println("**** Re-try ****");
                            repeat=0;

                        }}while (repeat==0);

                    break;
                }
                case 2: {
                    System.out.println("*********** NEW ACCOUNT ***********");
                    System.out.println("Enter your Name");
                    userName = sc.next();
                    System.out.println("Enter User Password");
                    password = sc.next();
                    Account account = new Account();
                    if (account.createNewAccount(userName, password)){
                        System.out.println("Successfully Account Created");
                    }else{
                        System.out.println("***** Invalid Entry *****");
                    }
                    Menu.mainMenu();
                }break;
            }
        }catch (InputMismatchException e){
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
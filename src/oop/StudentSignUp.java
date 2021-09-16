package oop;

import java.io.*;
import java.util.Scanner;

public class StudentSignUp {
    // This function is used for sign up
    void signUp()
    {
        String userName = "", password = "", id = "", str = "";
        try{
            // This file stores the username and password of newly registered students on this application
            File file1 = new File("E:/Varsity/Semesters/Varsity-2_2/OOP/Project/Project-Practice/Files/usernameAndPassword.txt");
            Scanner scanner = new Scanner(file1);
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter the username: ");
            userName = input.next();
            System.out.print("Please enter the password: ");
            password = input.next();
            System.out.print("Please enter the ID: ");
            id = input.next();
            boolean duplicate = false;
            while (scanner.hasNext())
            {
                String user = scanner.next();
                String pass = scanner.next();
                String userID = scanner.next();
                if(user.equals(userName))
                {
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate)
            {
                str = userName + " " + password + " " + id;
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));
                out.println(str);
                out.close();
                System.out.println("Signed up successfully. Please sign in now.");
            }
            else
            {
                System.out.println("Username must be unique. Please try again.");
                signUp();
            }
        }catch (Exception e)
        {
            System.out.println("File not found!!!");
        }
    }
}

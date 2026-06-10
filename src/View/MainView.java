package View;

import java.util.Scanner;

public class MainView {

    private Scanner sc = new Scanner(System.in);

    public int showMainMenu() {

        System.out.println("\n========== Hospital Management System ==========");

        System.out.println("Enter 1 : Patients Management");
        System.out.println("Enter 2 : Doctors Management");
        System.out.println("Enter 3 : Departments Management");
        System.out.println("Enter 4 : Appointments Management");
        System.out.println("Enter 5 : Bills Management");
        System.out.println("Enter 6 : Exit");

        System.out.print("Enter Your Choice : ");

        return sc.nextInt();
    }
}
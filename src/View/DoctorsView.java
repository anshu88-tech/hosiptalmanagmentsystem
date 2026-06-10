package View;

import java.sql.Date;
import java.util.Scanner;

public class DoctorsView {

    private Scanner sc = new Scanner(System.in);

    // Menu
    public int showMenu() {

        System.out.println("\n----------- Doctor Menu ----------");
        System.out.println("Enter 1 : Add Doctor");
        System.out.println("Enter 2 : Delete Doctor");
        System.out.println("Enter 3 : View Doctor Details");
        System.out.println("Enter 4 : View All Doctors");
        System.out.println("Enter 5 : Update Doctor Details");
        System.out.println("Enter 6 : Exit");

        System.out.print("Enter Your Choice : ");

        return sc.nextInt();
    }

    // Doctor Id
    public int getDoctorId() {

        System.out.print("Enter Doctor Id : ");
        return sc.nextInt();
    }

    // First Name
    public String getDoctorFirstName() {

        sc.nextLine();

        System.out.print("Enter First Name : ");
        return sc.nextLine();
    }

    // Last Name
    public String getDoctorLastName() {

        System.out.print("Enter Last Name : ");
        return sc.nextLine();
    }

    // Specialization
    public String getDoctorSpecialization() {

        System.out.print("Enter Specialization : ");
        return sc.nextLine();
    }

    // Phone
    public String getDoctorPhone() {

        System.out.print("Enter Phone Number : ");
        return sc.nextLine();
    }

    // Email
    public String getDoctorEmail() {

        System.out.print("Enter Email : ");
        return sc.nextLine();
    }

    // Hire Date
    public Date getHireDate() {

        System.out.print("Enter Hire Date (yyyy-mm-dd) : ");
        return Date.valueOf(sc.nextLine());
    }

    // Department Id
    public int getDepartmentId() {

        System.out.print("Enter Department Id : ");
        return sc.nextInt();
    }
}
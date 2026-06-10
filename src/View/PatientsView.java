package View;

import java.sql.Date;
import java.util.Scanner;

public class PatientsView {

    private Scanner sc = new Scanner(System.in);

    // Show Menu
    public int showMenu() {

        System.out.println("\n----------- Patients Menu ----------");
        System.out.println("Enter 1 : Add Patient");
        System.out.println("Enter 2 : Delete Patient");
        System.out.println("Enter 3 : View Patient Details");
        System.out.println("Enter 4 : View All Patients");
        System.out.println("Enter 5 : Update Patient Details");
        System.out.println("Enter 6 : Exit");
        System.out.print("Enter Your Choice : ");

        return sc.nextInt();
    }

    // Patient Id
    public int getPatientId() {
        System.out.print("Enter Patient Id : ");
        return sc.nextInt();
    }

    // First Name
    public String getPatientFirstName() {
        sc.nextLine();
        System.out.print("Enter Patient First Name : ");
        return sc.nextLine();
    }

    // Last Name
    public String getPatientLastName() {
        System.out.print("Enter Patient Last Name : ");
        return sc.nextLine();
    }

    // Gender
    public String getPatientGender() {
        System.out.print("Enter Gender : ");
        return sc.nextLine();
    }

    // Date Of Birth
    public Date getPatientDOB() {
        System.out.print("Enter Date Of Birth (yyyy-mm-dd) : ");
        return Date.valueOf(sc.nextLine());
    }

    // Phone
    public String getPatientPhone() {
        System.out.print("Enter Phone Number : ");
        return sc.nextLine();
    }

    // Email
    public String getPatientEmail() {
        System.out.print("Enter Email : ");
        return sc.nextLine();
    }

    // Address
    public String getPatientAddress() {
        System.out.print("Enter Address : ");
        return sc.nextLine();
    }

    // Blood Group
    public String getPatientBloodGroup() {
        System.out.print("Enter Blood Group : ");
        return sc.nextLine();
    }

    // Registration Date
    public Date getRegistrationDate() {
        System.out.print("Enter Registration Date (yyyy-mm-dd) : ");
        return Date.valueOf(sc.nextLine());
    }
}

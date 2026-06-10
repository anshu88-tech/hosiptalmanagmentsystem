package View;

import java.sql.Date;
import java.util.Scanner;

public class BillsView {

    private Scanner sc = new Scanner(System.in);

    // Menu
    public int showMenu() {

        System.out.println("\n----------- Bills Menu ----------");
        System.out.println("Enter 1 : Add Bill");
        System.out.println("Enter 2 : Delete Bill");
        System.out.println("Enter 3 : View Bills");
        System.out.println("Enter 4 : Update Bill");
        System.out.println("Enter 5 : Exit");
        System.out.print("Enter Your Choice : ");
        return sc.nextInt();
    }

    // Bill Id
    public int getBillId() {
        System.out.print("Enter Bill Id : ");
        return sc.nextInt();
    }

    // Patient Id
    public int getPatientId() {
        System.out.print("Enter Patient Id : ");
        return sc.nextInt();
    }

    // Appointment Id
    public int getAppointmentId() {
        System.out.print("Enter Appointment Id : ");
        return sc.nextInt();
    }

    // Total Amount
    public double getTotalAmount() {
        System.out.print("Enter Total Amount : ");
        return sc.nextDouble();
    }

    // Payment Status
    public String getPaymentStatus() {
        sc.nextLine();
        System.out.print("Enter Payment Status : ");
        return sc.nextLine();
    }

    // Bill Date
    public Date getBillDate() {
        System.out.print("Enter Bill Date (yyyy-mm-dd) : ");
        return Date.valueOf(sc.nextLine());
    }
}

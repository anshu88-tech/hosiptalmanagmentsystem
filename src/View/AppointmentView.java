package View;

import java.sql.Timestamp;
import java.util.Scanner;

public class AppointmentView {

    private Scanner sc = new Scanner(System.in);

    // Menu
    public int showMenu() {

        System.out.println("\n----------- Appointments Menu ----------");
        System.out.println("Enter 1 : Add Appointment");
        System.out.println("Enter 2 : Delete Appointment");
        System.out.println("Enter 3 : View Appointment");
        System.out.println("Enter 4 : Update Appointment");
        System.out.println("Enter 5 : Doctor Appointment Report");
        System.out.println("Enter 6 : Patient Appointment History");
        System.out.println("Enter 7 : Exit");
        System.out.print("Enter Your Choice : ");
        return sc.nextInt();
    }

    // Appointment Id
    public int getAppointmentId() {
        System.out.print("Enter Appointment Id : ");
        return sc.nextInt();
    }

    // Patient Id
    public int getPatientId() {
        System.out.print("Enter Patient Id : ");
        return sc.nextInt();
    }

    // Doctor Id
    public int getDoctorId() {
        System.out.print("Enter Doctor Id : ");
        return sc.nextInt();
    }

    // Appointment Time
    public Timestamp getAppointmentTime() {
        sc.nextLine();
        System.out.print("Enter Appointment Time (yyyy-mm-dd hh:mm:ss) : ");
        return Timestamp.valueOf(sc.nextLine());
    }

    // Reason
    public String getAppointmentReason() {
        sc.nextLine();
        System.out.print("Enter Appointment Reason : ");
        return sc.nextLine();
    }
}
package Controller;
import View.MainView;

public class MainController {
    public static void main(String[] args) {
        MainView view = new MainView();
        while (true) {
            int choice = view.showMainMenu();
            switch (choice) {
            // Patients
            case 1:
                PatientController pc = new PatientController();
                pc.start();
                break;

            // Doctors
            case 2:
               DoctorController dc= new DoctorController();
                dc.start();
                break;

            // Departments
            case 3:
                DepartmentController depc = new DepartmentController();
                depc.start();
                break;

            // Appointments
            case 4:
                AppointmentController ac = new AppointmentController();
                ac.start();
                break;

            // Bills
            case 5:
                BillsController bc = new BillsController();
                bc.start();
                break;

            // Exit
            case 6:
                System.out.println( "Application Closed Successfully...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Choice...");
            }
        }
    }
}

package Controller;
import java.util.List;
import Entity.Patients;
import ModelDao.PatientsDao;
import View.PatientsView;

public class PatientController {
    private PatientsDao dao = new PatientsDao();
    private PatientsView view = new PatientsView();
    public void start() {
        while (true) {
            int choice = view.showMenu();
            switch (choice) {

            // Add Patient
            case 1:
                Patients p1 = new Patients(view.getPatientFirstName(),
                        view.getPatientLastName(),
                        view.getPatientGender(),
                        view.getPatientDOB(),
                        view.getPatientPhone(),
                        view.getPatientEmail(),
                        view.getPatientAddress(),
                        view.getPatientBloodGroup(),
                        view.getRegistrationDate()
                );
                boolean add = dao.addPatient(p1);
                if (add) {
                    System.out.println("Patient Added Successfully...");
                } else {
                    System.out.println("Patient Not Added...");
                }
                break;

            // Delete Patient
            case 2:
                int deleteId = view.getPatientId();
                boolean delete = dao.deletePatient(deleteId);
                if (delete) {
                    System.out.println("Patient Deleted Successfully...");
                } else {
                    System.out.println("Patient Not Deleted...");
                }
                break;

            // View Patient By Id
            case 3:
                int viewId = view.getPatientId();
                Patients p = dao.viewPatientById(viewId);
                if (p != null) {
                    System.out.println(p);
                } else {
                    System.out.println("Patient Not Found...");
                }
                break;

            // View All Patients
            case 4:
                List<Patients> list = dao.viewAllPatients();
                if (list.isEmpty()) {
                    System.out.println("No Patients Found...");
                } else {
                    for (Patients patient : list) {
                        System.out.println(patient);
                    }
                }
                break;

            // Update Patient
            case 5:
                Patients p2 = new Patients( view.getPatientFirstName(),
                        view.getPatientLastName(),
                        view.getPatientGender(),
                        view.getPatientDOB(),
                        view.getPatientPhone(),
                        view.getPatientEmail(),
                        view.getPatientAddress(),
                        view.getPatientBloodGroup(),
                        view.getRegistrationDate()
                );
                p2.setPatient_id(view.getPatientId());
                boolean update = dao.updatePatient(p2);
                if (update) {
                    System.out.println("Patient Updated Successfully...");
                } else {
                    System.out.println("Patient Not Updated...");
                }
                break;

            // Exit
            case 6:
                System.out.println("Application Closed...");
                return;

            default:
                System.out.println("Invalid Choice...");
            }
        }
    }
}
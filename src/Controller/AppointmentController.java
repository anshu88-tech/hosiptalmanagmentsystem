package Controller;

import java.util.List;

import Entity.Appointments;
import Entity.DoctorAppointmentReport;
import Entity.Doctors;
import Entity.Patients;
import ModelDao.AppointmentsDao;
import View.AppointmentView;

public class AppointmentController {
    private AppointmentsDao dao = new AppointmentsDao();
    private AppointmentView view = new AppointmentView();
    public void start() {

        while (true) {

            int choice = view.showMenu();

            switch (choice) {

                // Add Appointment
                case 1:
                    int pid1 = view.getPatientId();
                    int did1 = view.getDoctorId();
                    Patients p1 = dao.getPatientById(pid1);
                    Doctors d1 = dao.getDoctorById(did1);
                    if (p1 == null || d1 == null) {
                        System.out.println("Invalid Patient or Doctor ID...");
                        break;
                    }
                    Appointments a1 = new Appointments( p1,
                            d1,view.getAppointmentTime(),
                            view.getAppointmentReason()  );
                    int add = dao.addAppointment(a1);
                    System.out.println(add > 0 ? "Appointment Added Successfully..."
                            : "Appointment Not Added...");

                    break;
                // Delete appointment
                case 2:
                    int deleteId = view.getAppointmentId();
                    int delete = dao.deleteAppointment(deleteId);
                    System.out.println(delete > 0
                            ? "Appointment Deleted Successfully..."
                            : "Appointment Not Deleted...");

                    break;

                //View Appointment
                case 3:
                    int viewId = view.getAppointmentId();
                    Appointments a = dao.viewAppointmentById(viewId);
                    if (a != null) {
                        System.out.println(a);
                    } else {
                        System.out.println("Appointment Not Found...");
                    }
                    break;
                // Update Appointment
                case 4:
                    int pid2 = view.getPatientId();
                    int did2 = view.getDoctorId();
                    Patients p2 = dao.getPatientById(pid2);
                    Doctors d2 = dao.getDoctorById(did2);
                    if (p2 == null || d2 == null) {
                        System.out.println("Invalid Patient or Doctor ID...");
                        break;
                    }
                    Appointments a2 = new Appointments( p2,
                            d2,view.getAppointmentTime(),
                            view.getAppointmentReason()
                    );
                    a2.setAppointment_id(view.getAppointmentId());
                    int update = dao.updateAppointment(a2);
                    System.out.println(update > 0 ? "Appointment Updated Successfully..."
                            : "Appointment Not Updated...");

                    break;

                // Doctor report
                case 5:
                    List<DoctorAppointmentReport> report = dao.getDoctorWiseAppointments();
                    if (report.isEmpty()) {
                        System.out.println("No Data Found...");
                    } else {
                        for (DoctorAppointmentReport r : report) {
                            System.out.println(r);
                        }
                    }
                    break;

                // Patient History
                case 6:
                    int patientId = view.getPatientId();
                    List<Appointments> list = dao.getPatientAppointmentHistory(patientId);
                    if (list.isEmpty()) {
                        System.out.println("No Appointment History Found...");
                    } else {
                        for (Appointments ap : list) {
                            System.out.println(ap);
                        }
                    }
                    break;

                // Exit
                case 7:
                    System.out.println("Application Closed...");
                    return;

                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }
}
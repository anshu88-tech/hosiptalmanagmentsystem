package Controller;
import Entity.Appointments;
import Entity.Bills;
import Entity.Patients;
import ModelDao.BillsDao;
import View.BillsView;

public class BillsController {

    private BillsDao dao = new BillsDao();
    private BillsView view = new BillsView();

    public void start() {

        while (true) {
            int choice = view.showMenu();
            switch (choice) {

            // Add Bill
            case 1:
                Patients p1 = new Patients();
                p1.setPatient_id(view.getPatientId());
                Appointments a1 = new Appointments();
                a1.setAppointment_id(view.getAppointmentId());
                Bills b1 = new Bills( p1, a1, view.getTotalAmount(),
                        view.getPaymentStatus(),
                        view.getBillDate()
                );
                int add = dao.addBill(b1);
                if (add > 0) {
                    System.out.println("Bill Added Successfully...");
                } else {
                    System.out.println("Bill Not Added...");
                }
                break;

            // Delete Bill
            case 2:
                int deleteId = view.getBillId();
                int delete = dao.deleteBill(deleteId);
                if (delete > 0) {
                    System.out.println("Bill Deleted Successfully...");
                } else {
                    System.out.println("Bill Not Deleted...");
                }
                break;

            // View Bill By Id
            case 3:
                int viewId = view.getBillId();
                Bills b = dao.viewBillById(viewId);
                if (b != null) {
                    System.out.println(b);
                } else {
                    System.out.println("Bill Not Found...");
                }
                break;

            // Update Bill
            case 4:
                Patients p2 = new Patients();
                p2.setPatient_id(view.getPatientId());
                Appointments a2 = new Appointments();
                a2.setAppointment_id(view.getAppointmentId());

                Bills b2 = new Bills(p2,a2,view.getTotalAmount(),
                        view.getPaymentStatus(),
                        view.getBillDate()
                );

                b2.setBill_id(view.getBillId());
                int update = dao.updateBill(b2);
                
                if (update > 0) {
                    System.out.println("Bill Updated Successfully...");
                } else {
                    System.out.println("Bill Not Updated...");
                }
                break;

            // Exit
            case 5:
                System.out.println("Application Closed...");
                return;

            default:
                System.out.println("Invalid Choice...");
            }
        }
    }
}
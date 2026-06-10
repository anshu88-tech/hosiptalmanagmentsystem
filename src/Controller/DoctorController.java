      package Controller;
	import java.util.List;
	import Entity.Departments;
	import Entity.Doctors;
	import ModelDao.DoctorDao;
	import View.DoctorsView;

	public class DoctorController {
	    private DoctorDao dao = new DoctorDao();
	    private DoctorsView view = new DoctorsView();
	    public void start() {
	        while (true) {
	            int choice = view.showMenu();
	            switch (choice) {
	            // Add Doctor
	            case 1:
	                Departments dept1 = new Departments();
	                dept1.setDepartment_id(view.getDepartmentId());
	                Doctors d1 = new Doctors(view.getDoctorFirstName(),
	                        view.getDoctorLastName(),
	                        view.getDoctorSpecialization(),
	                        view.getDoctorPhone(),
	                        view.getDoctorEmail(),
	                        view.getHireDate(),
	                        dept1
	                );
	                int add = dao.addDoctor(d1);
	                if (add > 0) {
	                    System.out.println("Doctor Added Successfully...");
	                } else {
	                    System.out.println("Doctor Not Added...");
	                }
	                break;

	            // Delete Doctor
	            case 2:
	                int deleteId = view.getDoctorId();
	                int delete = dao.deleteDoctor(deleteId);
	                if (delete > 0) {
	                    System.out.println("Doctor Deleted Successfully...");
	                } else {
	                    System.out.println("Doctor Not Deleted...");
	                }
	                break;

	            // View Doctor By Id
	            case 3:
	                int viewId = view.getDoctorId();
	                Doctors d = dao.viewDoctorById(viewId);
	                if (d != null) {
	                    System.out.println(d);
	                } else {
	                    System.out.println("Doctor Not Found...");
	                }
	                break;

	            // View All Doctors
	            case 4:
	                List<Doctors> list = dao.viewAllDoctors();
	                if (list.isEmpty()) {
	                    System.out.println("No Doctors Found...");
	                } else {
	                    for (Doctors doctor : list) {
	                        System.out.println(doctor);
	                    }
	                }

	                break;

	            // Update Doctor
	            case 5:
	                Departments dept2 = new Departments();
	                dept2.setDepartment_id(view.getDepartmentId());

	                Doctors d2 = new Doctors( view.getDoctorFirstName(),
	                        view.getDoctorLastName(),
	                        view.getDoctorSpecialization(),
	                        view.getDoctorPhone(),
	                        view.getDoctorEmail(),
	                        view.getHireDate(),
	                        dept2
	                );
	                d2.setDoctor_id(view.getDoctorId());
	                int update = dao.updateDoctor(d2);
	                if (update > 0) {
	                    System.out.println("Doctor Updated Successfully...");
	                } else {
	                    System.out.println("Doctor Not Updated...");
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


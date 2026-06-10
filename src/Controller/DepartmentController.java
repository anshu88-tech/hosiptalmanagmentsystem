package Controller;
import Entity.Departments;
import ModelDao.DepartmentDao;
import View.DepartmentsView;

public class DepartmentController {
    private DepartmentDao dao = new DepartmentDao();
    private DepartmentsView view = new DepartmentsView();
    public void start() {
        while (true) {
            int choice = view.showmwnu();
            switch (choice) {
            // Add Department
            case 1:
                Departments d1 = new Departments(view.getDepartmentName(),
                        view.getDepartmentlocation()
                );

                int add = dao.addDepartment(d1);
                if (add > 0) {
                    System.out.println("Department Added Successfully...");
                } else {
                    System.out.println("Department Not Added...");
                }
                break;

            // Delete Department
            case 2:
                int deleteId = view.getDepartmentId();
                int delete = dao.deleteDepartment(deleteId);
                if (delete > 0) {
                    System.out.println("Department Deleted Successfully...");
                } else {
                    System.out.println("Department Not Deleted...");
                }
                break;

            // View Department By Id
            case 3:
                int viewId = view.getDepartmentId();
                Departments d = dao.viewDepartmentById(viewId);
                if (d != null) {
                    System.out.println(d);
                } else {
                    System.out.println("Department Not Found...");
                }
                break;

            // Update Department
            case 4:
                Departments d2 = new Departments(view.getDepartmentName(),
                        view.getDepartmentlocation()
                );

                d2.setDepartment_id(view.getDepartmentId());
                int update = dao.updateDepartment(d2);
                if (update > 0) {
                    System.out.println("Department Updated Successfully...");
                } else {
                    System.out.println("Department Not Updated...");
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
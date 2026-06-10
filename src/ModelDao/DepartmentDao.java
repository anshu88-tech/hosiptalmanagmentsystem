package ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entity.Departments;
public class DepartmentDao {

    // Add Department
    public int addDepartment(Departments d) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "insert into departments(department_name,location) values(?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, d.getDepartment_name());
            pst.setString(2, d.getLocation());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Delete Department
    public int deleteDepartment(int departmentId) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "delete from departments where department_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, departmentId);
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Update Department
    public int updateDepartment(Departments d) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "update departments set department_name=?, location=? where department_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, d.getDepartment_name());
            pst.setString(2, d.getLocation());
            pst.setInt(3, d.getDepartment_id());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // View All Departments
    public List<Departments> viewDepartments() {
        List<Departments> list = new ArrayList<>();
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from departments";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Departments d = new Departments( rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("location"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // View Department By Id
    public Departments viewDepartmentById(int id) {
        Departments d = null;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from departments where department_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                d = new Departments(rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }
}
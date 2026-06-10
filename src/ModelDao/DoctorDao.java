package ModelDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entity.Departments;
import Entity.Doctors;

public class DoctorDao {
    // Add Doctor
    public int addDoctor(Doctors d) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query =
            "insert into doctors(first_name,last_name,specialization,phone,email,hire_date,department_id) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, d.getFirst_name());
            pst.setString(2, d.getLast_name());
            pst.setString(3, d.getSpecialization());
            pst.setString(4, d.getPhone());
            pst.setString(5, d.getEmail());
            pst.setDate(6,new Date(d.getHire_date().getTime()));
            pst.setInt(7,d.getDepartments_id().getDepartment_id());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Delete Doctor
    public int deleteDoctor(int doctorId) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query ="delete from doctors where doctor_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, doctorId);
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Update Doctor
    public int updateDoctor(Doctors d) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "update doctors set first_name=?,last_name=?,specialization=?,phone=?,email=?,hire_date=?,department_id=? where doctor_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, d.getFirst_name());
            pst.setString(2, d.getLast_name());
            pst.setString(3, d.getSpecialization());
            pst.setString(4, d.getPhone());
            pst.setString(5, d.getEmail());
            pst.setDate(6, new Date(d.getHire_date().getTime()));
            pst.setInt(7,d.getDepartments_id().getDepartment_id());
            pst.setInt(8, d.getDoctor_id());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // View All Doctors
    public List<Doctors> viewAllDoctors() {
        List<Doctors> list = new ArrayList<>();
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from doctors";
            PreparedStatement pst =con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Departments dept = new Departments();
                dept.setDepartment_id( rs.getInt("department_id"));
                Doctors d = new Doctors( rs.getInt("doctor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("specialization"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDate("hire_date"), dept );
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // View Doctor By Id
    public Doctors viewDoctorById(int id) {
        Doctors d = null;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from doctors where doctor_id=?";
            PreparedStatement pst =con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Departments dept = new Departments();
                dept.setDepartment_id( rs.getInt("department_id"));
                d = new Doctors( rs.getInt("doctor_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("specialization"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDate("hire_date"),  dept);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return d;
    }
    
    
    
}
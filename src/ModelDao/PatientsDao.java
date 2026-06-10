package ModelDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Entity.Patients;

public class PatientsDao {

    // Add Patient
    public boolean addPatient(Patients p) {
        try {
            Connection con = DBUtil.makeConnection();
            String query = "insert into patients(first_name,last_name,gender,date_of_birth,phone,email,address,blood_group,registration_date) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, p.getFirst_name());
            pst.setString(2, p.getLast_name());
            pst.setString(3, p.getGender());
            pst.setDate(4, new Date(p.getDate_of_birth().getTime()));
            pst.setString(5, p.getPhone());
            pst.setString(6, p.getEmail());
            pst.setString(7, p.getAddress());
            pst.setString(8, p.getBlood_group());
            pst.setDate(9, new Date(p.getRegistration_date().getTime()));
            int i = pst.executeUpdate();
            if (i > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // View All Patients
    public List<Patients> viewAllPatients() {
        List<Patients> list = new ArrayList<>();
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from patients";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Patients p = new Patients(rs.getInt("patient_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getDate("date_of_birth"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("blood_group"),
                        rs.getDate("registration_date"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // View Patient By Id
    public Patients viewPatientById(int id) {
        Patients p = null;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from patients where patient_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = new Patients( rs.getInt("patient_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getDate("date_of_birth"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("blood_group"),
                        rs.getDate("registration_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    // Delete Patient
    public boolean deletePatient(int id) {
        try {
            Connection con = DBUtil.makeConnection();
            String query = "delete from patients where patient_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update Patient
    public boolean updatePatient(Patients p) {
        try {
            Connection con = DBUtil.makeConnection();
            String query = "update patients set first_name=?,last_name=?,gender=?,date_of_birth=?,phone=?,email=?,address=?,blood_group=?,registration_date=? where patient_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, p.getFirst_name());
            pst.setString(2, p.getLast_name());
            pst.setString(3, p.getGender());
            pst.setDate(4, new Date(p.getDate_of_birth().getTime()));
            pst.setString(5, p.getPhone());
            pst.setString(6, p.getEmail());
            pst.setString(7, p.getAddress());
            pst.setString(8, p.getBlood_group());
            pst.setDate(9, new Date(p.getRegistration_date().getTime()));
            pst.setInt(10, p.getPatient_id());
            int i = pst.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
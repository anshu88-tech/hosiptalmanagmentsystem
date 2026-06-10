package ModelDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import Entity.Appointments;
import Entity.DoctorAppointmentReport;
import Entity.Doctors;
import Entity.Patients;

public class AppointmentsDao {
    // Add Appointment
    public int addAppointment(Appointments a) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query =
            "insert into appointments(patient_id,doctor_id,appointment_date,reason) values(?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(query);
            pst.setInt(1,a.getPatient_id().getPatient_id());
            pst.setInt(2,a.getDoctor_id().getDoctor_id());
            pst.setTimestamp(3,new Timestamp( a.getAppointment_time().getTime()));
            pst.setString(4,a.getReason());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Delete Appointment
    public int deleteAppointment(int appointmentId) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query ="delete from appointments where appointment_id=?";
            PreparedStatement pst =  con.prepareStatement(query);
            pst.setInt(1,appointmentId);
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Update Appointment
    public int updateAppointment(Appointments a) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query =
            "update appointments set patient_id=?,doctor_id=?,appointment_date=?,reason=? where appointment_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,a.getPatient_id().getPatient_id());
            pst.setInt(2,a.getDoctor_id().getDoctor_id());
            pst.setTimestamp(3,new Timestamp( a.getAppointment_time().getTime()));
            pst.setString(4,a.getReason());
            pst.setInt(5,a.getAppointment_id());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    // View All Appointments
    public List<Appointments> viewAllAppointments() {
        List<Appointments> list = new ArrayList<>();
        try {
            Connection con = DBUtil.makeConnection();
            String query = "select * from appointments";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Patients p = new Patients();
                p.setPatient_id( rs.getInt("patient_id"));
                Doctors d = new Doctors();
                d.setDoctor_id(  rs.getInt("doctor_id"));
                Appointments a =new Appointments(
                        rs.getInt("appointment_id"),p,
                        d, rs.getTimestamp("appointment_date"),
                        rs.getString("reason")
                );
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // View Appointment By Id
    public Appointments viewAppointmentById(int id) {
        Appointments a = null;
        try {
            Connection con = DBUtil.makeConnection();
            String query ="SELECT a.*, "
            + "p.first_name AS patient_first_name, "
            + "p.last_name AS patient_last_name, "
            + "p.gender, "
            + "p.phone AS patient_phone, "
            + "p.email AS patient_email, "
            + "d.first_name AS doctor_first_name, "
            + "d.last_name AS doctor_last_name, "
            + "d.specialization, "
            + "d.phone AS doctor_phone, "
            + "d.email AS doctor_email "
            + "FROM appointments a "
            + "JOIN patients p "
            + "ON a.patient_id = p.patient_id "
            + "JOIN doctors d "
            + "ON a.doctor_id = d.doctor_id "
            + "WHERE a.appointment_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,id);
            ResultSet rs =pst.executeQuery();
            if (rs.next()) {
                Patients p = new Patients();
                p.setPatient_id( rs.getInt("patient_id"));
                p.setFirst_name(rs.getString("patient_first_name"));
                p.setLast_name( rs.getString("patient_last_name"));
                p.setGender( rs.getString("gender"));
                p.setPhone(rs.getString("patient_phone"));
                p.setEmail(rs.getString("patient_email"));
                Doctors d = new Doctors();
                d.setDoctor_id( rs.getInt("doctor_id"));
                d.setFirst_name( rs.getString("doctor_first_name"));
                d.setLast_name(rs.getString("doctor_last_name"));
                d.setSpecialization( rs.getString("specialization"));
                d.setPhone( rs.getString("doctor_phone"));
                d.setEmail(rs.getString("doctor_email"));
                a = new Appointments(rs.getInt("appointment_id"),p,
                        d,  rs.getTimestamp("appointment_date"),
                        rs.getString("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    // Doctor Appointment Report
    public List<DoctorAppointmentReport>
    getDoctorWiseAppointments() {
        List<DoctorAppointmentReport> list =  new ArrayList<>();
        try {
            Connection con = DBUtil.makeConnection();
            String query = "SELECT d.doctor_id,"
            + " CONCAT(d.first_name,' ',d.last_name)"
            + " AS doctor_name,"
            + " d.specialization,"
            + " COUNT(a.appointment_id)"
            + " AS total_appointments "
            + "FROM doctors d "
            + "LEFT JOIN appointments a "
            + "ON d.doctor_id = a.doctor_id "
            + "GROUP BY d.doctor_id,"
            + " d.first_name,"
            + " d.last_name,"
            + " d.specialization "
            + "ORDER BY total_appointments DESC";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                DoctorAppointmentReport d =   new DoctorAppointmentReport();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setDoctorName(rs.getString("doctor_name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setTotalAppointments( rs.getInt("total_appointments"));
                list.add(d);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Patient Appointment History
    public List<Appointments>
    getPatientAppointmentHistory(int patientId) {
        List<Appointments> list =
                new ArrayList<>();
        try {
            Connection con =  DBUtil.makeConnection();
            String query ="SELECT a.*, "
            + "p.first_name AS patient_first_name, "
            + "p.last_name AS patient_last_name, "
            + "p.gender, "
            + "p.phone AS patient_phone, "
            + "p.email AS patient_email, "
            + "d.first_name AS doctor_first_name, "
            + "d.last_name AS doctor_last_name, "
            + "d.specialization, "
            + "d.phone AS doctor_phone, "
            + "d.email AS doctor_email "
            + "FROM appointments a "
            + "JOIN patients p "
            + "ON a.patient_id = p.patient_id "
            + "JOIN doctors d "
            + "ON a.doctor_id = d.doctor_id "
            + "WHERE a.patient_id=? "
            + "ORDER BY a.appointment_date DESC";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,patientId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Patients p = new Patients();
                p.setPatient_id( rs.getInt("patient_id"));
                p.setFirst_name(rs.getString("patient_first_name"));
                p.setLast_name( rs.getString("patient_last_name"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("patient_phone"));
                p.setEmail( rs.getString("patient_email"));
                Doctors d = new Doctors();
                d.setDoctor_id( rs.getInt("doctor_id"));
                d.setFirst_name( rs.getString("doctor_first_name"));
                d.setLast_name( rs.getString("doctor_last_name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setPhone( rs.getString("doctor_phone"));
                d.setEmail(  rs.getString("doctor_email"));
                Appointments a =  new Appointments(
                        rs.getInt("appointment_id"),p,
                        d,rs.getTimestamp("appointment_date"),
                        rs.getString("reason") );
                list.add(a);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // doctor details for history
    public Doctors getDoctorById(int id) {
        Doctors d = null;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "SELECT * FROM doctors WHERE doctor_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                d = new Doctors();
                d.setDoctor_id(rs.getInt("doctor_id"));
                d.setFirst_name(rs.getString("first_name"));
                d.setLast_name(rs.getString("last_name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setPhone(rs.getString("phone"));
                d.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
    
    //patient details
    public Patients getPatientById(int id) {
        Patients p = null;
        try {
            Connection con = DBUtil.makeConnection();
            String query = "SELECT * FROM patients WHERE patient_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = new Patients();
                p.setPatient_id(rs.getInt("patient_id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setGender(rs.getString("gender"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
}
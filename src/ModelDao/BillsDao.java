package ModelDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import Entity.Appointments;
import Entity.Bills;
import Entity.Patients;

public class BillsDao {

    // Add Bill
    public int addBill(Bills b) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query =
            "insert into bills(patient_id,appointment_id,total_amount,payment_status,bill_date) values(?,?,?,?,?)";

            PreparedStatement pst =con.prepareStatement(query);
            pst.setInt(1,b.getPatient_id().getPatient_id());
            pst.setInt(2,b.getAppointment_id().getAppointment_id());
            pst.setDouble(3, b.getTotal_amount());
            pst.setString(4, b.getStatus());
            pst.setTimestamp(5,new Timestamp(b.getBill_date().getTime()));
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Delete Bill
    public int deleteBill(int billId) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query ="delete from bills where bill_id=?";
            PreparedStatement pst =  con.prepareStatement(query);
            pst.setInt(1, billId);
            i = pst.executeUpdate();
           } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // Update Bill
    public int updateBill(Bills b) {
        int i = 0;
        try {
            Connection con = DBUtil.makeConnection();
            String query =
            "update bills set patient_id=?,appointment_id=?,total_amount=?,payment_status=?,bill_date=? where bill_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, b.getPatient_id().getPatient_id());
            pst.setInt(2,b.getAppointment_id().getAppointment_id());
            pst.setDouble(3,b.getTotal_amount());
            pst.setString(4,b.getStatus());
            pst.setTimestamp(5,new Timestamp(b.getBill_date().getTime()));
            pst.setInt(6,b.getBill_id());
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // View All Bills
    public List<Bills> viewAllBills() {
        List<Bills> list = new ArrayList<>();
        try {
            Connection con = DBUtil.makeConnection();
            String query ="select * from bills";
            PreparedStatement pst =con.prepareStatement(query);
            ResultSet rs =pst.executeQuery();
            while (rs.next()) {
                Patients p = new Patients();
                p.setPatient_id(rs.getInt("patient_id"));
                Appointments a = new Appointments();
                a.setAppointment_id(rs.getInt("appointment_id"));
                Bills b = new Bills(rs.getInt("bill_id"),
                        p,a,rs.getDouble("total_amount"),
                        rs.getString("payment_status"),
                        rs.getTimestamp("bill_date")
                );
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

 // View Bill By Id
    public Bills viewBillById(int id) {

        Bills b = null;

        try {
            Connection con = DBUtil.makeConnection();
            String query =
            "SELECT b.*, "
            + "p.first_name, "
            + "p.last_name, "
            + "a.reason "
            + "FROM bills b "
            + "JOIN patients p "
            + "ON b.patient_id = p.patient_id "
            + "JOIN appointments a "
            + "ON b.appointment_id = a.appointment_id "
            + "WHERE b.bill_id=?";

            PreparedStatement pst =con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Patients p = new Patients();
                p.setPatient_id(rs.getInt("patient_id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name( rs.getString("last_name"));

                Appointments a =
                        new Appointments();
                a.setAppointment_id( rs.getInt("appointment_id"));
                a.setReason(rs.getString("reason"));
                        b = new Bills( rs.getInt("bill_id"),
                        p,a,rs.getDouble("total_amount"),
                        rs.getString("payment_status"),
                        rs.getTimestamp("bill_date")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
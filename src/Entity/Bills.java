package Entity;

import java.util.Date;

public class Bills {
	private int bill_id;
	private Patients patient_id ;
	private Appointments appointment_id;
	private double Total_amount;
	private String status;
	private Date bill_date;
	public Bills(int bill_id, Patients patient_id, Appointments appointment_id, double total_amount, String status,
			Date bill_date) {
		super();
		this.bill_id = bill_id;
		this.patient_id = patient_id;
		this.appointment_id = appointment_id;
		Total_amount = total_amount;
		this.status = status;
		this.bill_date = bill_date;
	}
	public Bills(Patients patient_id, Appointments appointment_id, double total_amount, String status, Date bill_date) {
		super();
		this.patient_id = patient_id;
		this.appointment_id = appointment_id;
		Total_amount = total_amount;
		this.status = status;
		this.bill_date = bill_date;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public Patients getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Patients patient_id) {
		this.patient_id = patient_id;
	}
	public Appointments getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Appointments appointment_id) {
		this.appointment_id = appointment_id;
	}
	public double getTotal_amount() {
		return Total_amount;
	}
	public void setTotal_amount(double total_amount) {
		Total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBill_date() {
		return bill_date;
	}
	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}
	@Override
	public String toString() {
		return "Bills [bill_id=" + bill_id + ", patient_id=" + patient_id + ", appointment_id=" + appointment_id
				+ ", Total_amount=" + Total_amount + ", status=" + status + ", bill_date=" + bill_date + "]";
	}
	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

package Entity;

import java.util.Date;

public class Appointments {
	
	private int appointment_id;
	private Patients patient_id;
	private Doctors doctor_id;
	private Date appointment_time;
	private String reason ;
	public Appointments(int appointment_id, Patients patient_id, Doctors doctor_id, Date appointment_time,
			String reason) {
		super();
		this.appointment_id = appointment_id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.appointment_time = appointment_time;
		this.reason = reason;
	}
	public Appointments(Patients patient_id, Doctors doctor_id, Date appointment_time, String reason) {
		super();
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.appointment_time = appointment_time;
		this.reason = reason;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public Patients getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Patients patient_id) {
		this.patient_id = patient_id;
	}
	public Doctors getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Doctors doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Date getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(Date appointment_time) {
		this.appointment_time = appointment_time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Appointments [appointment_id=" + appointment_id + ", patient_id=" + patient_id + ", doctor_id="
				+ doctor_id + ", appointment_time=" + appointment_time + ", reason=" + reason + "]";
	}
	public Appointments() {
		super();
		// TODO Auto-generated constructor stub
	}		
}

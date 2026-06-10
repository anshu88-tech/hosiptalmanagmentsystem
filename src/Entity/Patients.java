package Entity;

import java.util.Date;

public class Patients {
	
	private int patient_id;
	private String first_name;
	private String last_name;
	private String gender;
	private Date date_of_birth;
	private String phone;
	private String email;
	private String address;
	private String blood_group;
	private Date registration_date;
	public Patients(int patient_id, String first_name, String last_name, String gender, Date date_of_birth,
			String phone, String email, String address, String blood_group, Date registration_date) {
		super();
		this.patient_id = patient_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.blood_group = blood_group;
		this.registration_date = registration_date;
	}
	public Patients(String first_name, String last_name, String gender, Date date_of_birth, String phone, String email,
			String address, String blood_group, Date registration_date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.blood_group = blood_group;
		this.registration_date = registration_date;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	@Override
	public String toString() {
		return "Patients [patient_id=" + patient_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", date_of_birth=" + date_of_birth + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", blood_group=" + blood_group + ", registration_date=" + registration_date
				+ "]";
	}
	
	public Patients() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

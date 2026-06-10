package Entity;

import java.util.Date;

public class Doctors {

    private int doctor_id;
    private String first_name;
    private String last_name;
    private String specialization;
    private String phone;
    private String email;
    private Date hire_date;
    private Departments departments_id;
    public Doctors(int doctor_id, String first_name, String last_name,
            String specialization, String phone, String email,
            Date hire_date, Departments departments_id) {

        this.doctor_id = doctor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.hire_date = hire_date;
        this.departments_id = departments_id;
    }

    public Doctors(String first_name, String last_name,
            String specialization, String phone, String email,
            Date hire_date, Departments departments_id) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.hire_date = hire_date;
        this.departments_id = departments_id;
    }

    public Doctors() {

    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Departments getDepartments_id() {
        return departments_id;
    }

    public void setDepartments_id(Departments departments_id) {
        this.departments_id = departments_id;
    }

    @Override
    public String toString() {
        return "Doctors [doctor_id=" + doctor_id
                + ", first_name=" + first_name
                + ", last_name=" + last_name
                + ", specialization=" + specialization
                + ", phone=" + phone
                + ", email=" + email
                + ", hire_date=" + hire_date
                + ", departments_id=" + departments_id + "]";
    }
}
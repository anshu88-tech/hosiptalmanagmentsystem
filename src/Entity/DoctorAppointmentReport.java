package Entity;

public class DoctorAppointmentReport {

    private int doctorId;
    private String doctorName;
    private String specialization;
    private int totalAppointments;

    public DoctorAppointmentReport() {

    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(int totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    @Override
    public String toString() {

        return "\nDoctor Id = " + doctorId
                + "\nDoctor Name = " + doctorName
                + "\nSpecialization = " + specialization
                + "\nTotal Appointments = "
                + totalAppointments;
    }
}
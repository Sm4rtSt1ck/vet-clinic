package vetclinic.model;

import vetclinic.dao.PetDAO;
import vetclinic.dao.VetDAO;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

public class Appointment {
    private int appointmentId;
    private Date date;
    private Time time;
    private int petId;
    private int vetId;
    private String petName;
    private String vetName;

    public Appointment(int id, Date date, Time time, int petId, int vetId) throws SQLException {
        this.appointmentId = id;
        this.date = date;
        this.time = time;
        this.petId = petId;
        this.vetId = vetId;
        PetDAO petDAO = new PetDAO();
        this.petName = petDAO.get(petId).getName();
        VetDAO vetDAO = new VetDAO();
        this.vetName = vetDAO.get(vetId).getName();

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getPetId() {
        return petId;
    }

    public int getVetId() {
        return vetId;
    }

    public String getPetName() {
        return petName;
    }

    public String getVetName() {
        return vetName;
    }
}

package vetclinic.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int appointmentId;
    private LocalDate date;
    private LocalTime time;
    private int petId;
    private int vetId;

    public int getAppointmentId() {
        return appointmentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getPetId() {
        return petId;
    }

    public int getVetId() {
        return vetId;
    }
}

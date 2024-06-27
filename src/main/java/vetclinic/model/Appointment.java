package vetclinic.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int appointmentId;
    private LocalDate date;
    private LocalTime time;
    private int petId;
    private int vetId;
}

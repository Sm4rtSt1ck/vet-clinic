package vetclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vetclinic.model.Appointment;

public class AppointmentController {

    @FXML
    private TableView<Appointment> appointmentTable;

    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField petField;
    @FXML
    private TextField vetField;

    // Methods for handling CRUD operations
}

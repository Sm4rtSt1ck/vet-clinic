package vetclinic.scene;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vetclinic.model.Diagnosis;

public class DiagnosisController {

    @FXML
    private TableView<Diagnosis> diagnosisTable;

    @FXML
    private TextField diseaseField;
    @FXML
    private TextField appointmentField;

    // Methods for handling CRUD operations
}
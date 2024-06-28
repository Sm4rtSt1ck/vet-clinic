package vetclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vetclinic.model.Vet;

public class VetController {

    @FXML
    private TableView<Vet> vetTable;

    @FXML
    private TextField nameField;
    @FXML
    private TextField officeNumberField;
    @FXML
    private TextField phoneNumberField;

    // Methods for handling CRUD operations
}

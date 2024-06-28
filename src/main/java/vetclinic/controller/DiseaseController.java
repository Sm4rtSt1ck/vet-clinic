package vetclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vetclinic.model.Disease;

public class DiseaseController {

    @FXML
    private TableView<Disease> diseaseTable;

    @FXML
    private TextField commonNameField;
    @FXML
    private TextField scientificNameField;

    // Methods for handling CRUD operations
}

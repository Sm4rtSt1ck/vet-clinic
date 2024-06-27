package vetclinic.scene;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vetclinic.model.Owner;

public class OwnerController {

    @FXML
    private TableView<Owner> ownerTable;

    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumberField;

    // Methods for handling CRUD operations
}

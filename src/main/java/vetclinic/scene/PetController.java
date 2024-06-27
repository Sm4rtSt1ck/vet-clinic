package vetclinic.scene;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import vetclinic.model.Pet;

public class PetController {

    @FXML
    private TableView<Pet> petTable;
    @FXML
    private TextField nameField;
    @FXML
    private TextField identifierField;
    @FXML
    private TextField ownerField;
    @FXML
    private TextField breedField;

    // Methods for handling CRUD operations
}

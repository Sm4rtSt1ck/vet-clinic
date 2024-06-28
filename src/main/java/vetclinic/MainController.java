package vetclinic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vetclinic.client.Client;
import vetclinic.dao.PetDAO;
import vetclinic.model.Pet;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private static Client client;
    private static PetDAO petDAO = new PetDAO();

    public static void setClient(Client client) {
        MainController.client = client;
    }

    @FXML
    private TableView<Pet> tableView;
    @FXML
    private TableColumn<Pet, Integer> idColumn;
    @FXML
    private TableColumn<Pet, String> nameColumn;
    @FXML
    private TableColumn<Pet, Integer> ownerColumn;
    @FXML
    private TableColumn<Pet, Integer> breedColumn;

    @FXML
    protected void viewOwners() {
        showInfo("Owners View", "This will show the list of owners.");
    }

    @FXML
    protected void viewPets() {
        try {
            tableView.getItems().clear();
            ObservableList<Pet> pets = FXCollections.observableArrayList();
            tableView.setItems(pets);
            for (Pet pet : petDAO.getAllPets()) {
                pets.add(pet);
            }
        } catch (SQLException e) {
            showError("SQL Error", e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    protected void viewVets() {
        showInfo("Vets View", "This will show the list of vets.");
    }

    @FXML
    protected void viewAppointments() {
        showInfo("Appointments View", "This will show the list of appointments.");
    }

    private void showInfo(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("petId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ownerColumn.setCellValueFactory(new PropertyValueFactory<>("ownerId"));
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breedId"));
    }
}

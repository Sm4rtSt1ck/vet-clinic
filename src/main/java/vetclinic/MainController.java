package vetclinic;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import vetclinic.client.Client;
import vetclinic.dao.PetDAO;
import vetclinic.model.Pet;

import java.sql.SQLException;
import java.util.List;

public class MainController {
    private static Client client;
    private static PetDAO petDAO = new PetDAO();

    public static void setClient(Client client) {
        MainController.client = client;
    }

    @FXML
    private ListView<String> petsListView;

    @FXML
    protected void viewOwners() {
        showInfo("Owners View", "This will show the list of owners.");
    }

    @FXML
    protected void viewPets() {
        try {
            List<Pet> pets = petDAO.getAllPets();
            petsListView.getItems().clear();

            for (Pet pet : pets) {
                petsListView.getItems().add(pet.getName());
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
}

package vetclinic;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import vetclinic.client.Client;

public class MainController {
    private Client client;

    @FXML
    protected void viewOwners() {
        showInfo("Owners View", "This will show the list of owners.");
    }

    @FXML
    protected void viewPets() {
        showInfo("Pets View", "This will show the list of pets.");
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
}

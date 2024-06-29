package vetclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vetclinic.Session;
import vetclinic.dao.UserDAO;
import vetclinic.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class AuthViewController {
    public TextField loginField;
    public PasswordField passwordField;
    public Label incorrectInputLabel;

    @FXML
    protected void registerAction() throws IOException {
        SceneController.setScene("registration-view.fxml");
    }

    @FXML
    public void loginAction() throws Exception {
        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.get(loginField.getText(), passwordField.getText());
            Session.setUser(user);
            SceneController.setScene("appointment-view.fxml");
        }
        catch (SQLException e) {
            incorrectInputLabel.setVisible(true);
        }
    }
}

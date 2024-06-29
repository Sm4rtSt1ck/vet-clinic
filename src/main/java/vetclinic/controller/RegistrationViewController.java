package vetclinic.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.mindrot.jbcrypt.BCrypt;
import vetclinic.Session;
import vetclinic.dao.UserDAO;
import vetclinic.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationViewController {
    public TextField nameField;
    public TextField addressField;
    public TextField phoneField;
    public TextField loginField;
    public PasswordField passwordField;

    @FXML
    protected void backToLoginAction() throws IOException {
        SceneController.setScene("auth-view.fxml");
    }

    @FXML
    protected void registerAction() throws SQLException, IOException {
        UserDAO userDAO = new UserDAO();
        String passwordHash = BCrypt.hashpw(passwordField.getText(), BCrypt.gensalt());
        User user = new User(0, nameField.getText(), addressField.getText(), phoneField.getText(), loginField.getText(), passwordHash, 0);
        userDAO.add(user);
        Session.setUser(user);
        SceneController.setScene("appointment-view.fxml");
    }
}

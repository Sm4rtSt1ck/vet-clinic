package vetclinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vetclinic.controller.SceneController;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load user settings
        Settings.loadSettings();
        DatabaseManager.createConnection();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("auth-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("/style.css");
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        stage.setTitle("VetSystem");
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setScene(scene);
        // stage.show();

        SceneController.init(stage, scene);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DatabaseManager.closeConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

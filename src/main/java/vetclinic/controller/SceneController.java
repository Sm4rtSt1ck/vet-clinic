package vetclinic.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vetclinic.MainApp;

import java.io.IOException;

public class SceneController {
    private static Stage stage;
    private static Scene scene;

    public static void init(Stage stage, Scene scene) {
        SceneController.stage = stage;
        SceneController.scene = scene;
        stage.show();
    }

    public static void init(Stage stage, String sceneName) throws IOException {
        SceneController.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(sceneName));
        SceneController.scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("/style.css");
        stage.show();
    }

    public static void setStage(Stage stage) {
        SceneController.stage = stage;
    }

    public static void setScene(Scene scene) {
        SceneController.scene = scene;
        stage.setScene(scene);
        stage.show();
    }

    public static void setScene(String sceneName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(sceneName));
        double width = stage.getWidth(), height = stage.getHeight();
        SceneController.scene = new Scene(fxmlLoader.load());
        stage.setWidth(width);
        stage.setHeight(height);
        scene.getStylesheets().add("/style.css");
        stage.setScene(scene);
        stage.show();
    }
}

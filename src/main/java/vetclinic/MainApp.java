package vetclinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vetclinic.client.Client;

public class MainApp extends Application {
    private Client client;

    @Override
    public void start(Stage stage) throws Exception {
        // Load settings
        Settings.loadSettings();
        // Инициализация клиента
        client = new Client();
        client.startConnection(Settings.getServerIp(), Settings.getServerPort());
        MainController.setClient(client);

        // Настройка JavaFX UI
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        scene.getStylesheets().add("/style.css");

        stage.setTitle("VetSystem");
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        client.stopConnection();
        DatabaseManager.closeConnection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

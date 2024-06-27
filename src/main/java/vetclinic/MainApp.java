package vetclinic;

// import org.json;
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
        // Инициализация клиента
        client = new Client();
        client.startConnection("127.0.0.1", 1488);

        // Настройка JavaFX UI
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

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
    }

    public static void main(String[] args) {
        launch(args);
    }
}

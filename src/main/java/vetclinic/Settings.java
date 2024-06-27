package vetclinic;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Settings {
    private static String serverIp;
    private static int serverPort;
    public static final String path = "settings.json";

    public static String getServerIp() {
        return serverIp;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static void loadSettings() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject jsonObject = new JSONObject(content);

        String serverIp = jsonObject.getString("server_ip");
        int serverPort = jsonObject.getInt("server_port");
        Settings.serverIp = serverIp;
        Settings.serverPort = serverPort;
    }
}

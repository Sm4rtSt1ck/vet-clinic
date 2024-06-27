package vetclinic;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Settings {
    private String serverIp;
    private int serverPort;
    public static final String path = "settings.json";

    public Settings(String serverIp, int serverPort) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public String getServerIp() {
        return serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public static Settings loadSettings() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject jsonObject = new JSONObject(content);

        String serverIp = jsonObject.getString("server_ip");
        int serverPort = jsonObject.getInt("server_port");

        return new Settings(serverIp, serverPort);
    }
}

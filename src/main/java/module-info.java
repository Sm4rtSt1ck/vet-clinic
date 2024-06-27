module vetclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires org.json;

    opens vetclinic to javafx.fxml;
    opens vetclinic.model to javafx.base;
    opens vetclinic.scene to javafx.fxml;

    exports vetclinic;
    exports vetclinic.model;
    exports vetclinic.scene;
    exports vetclinic.client;
}
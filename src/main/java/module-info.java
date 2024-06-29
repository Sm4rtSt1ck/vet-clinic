module vetclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires org.json;
    requires jbcrypt;

    opens vetclinic to javafx.fxml;
    opens vetclinic.model to javafx.base;
    opens vetclinic.controller to javafx.fxml;

    exports vetclinic;
    exports vetclinic.model;
    exports vetclinic.controller;
}
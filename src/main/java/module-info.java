module ru.pasnin.vetclinic {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.pasnin.vetclinic to javafx.fxml;
    exports ru.pasnin.vetclinic;
}
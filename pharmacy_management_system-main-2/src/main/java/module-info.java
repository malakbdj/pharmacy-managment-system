module pharmacy {
    requires javafx.controls;
    requires javafx.fxml;

    opens pharmacy to javafx.fxml;
    exports pharmacy;
}

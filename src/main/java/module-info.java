module com.example.lifedobesad {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.lifedobesad to javafx.fxml;
    exports com.example.lifedobesad;
}
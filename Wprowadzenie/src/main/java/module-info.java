module com.example.wprowadzenie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wprowadzenie to javafx.fxml;
    exports com.example.wprowadzenie;
}
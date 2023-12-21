module com.example.prezent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prezent to javafx.fxml;
    exports com.example.prezent;
}
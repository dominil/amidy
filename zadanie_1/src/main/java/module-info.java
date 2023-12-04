module com.example.zadanie_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zadanie_1 to javafx.fxml;
    exports com.example.zadanie_1;
}
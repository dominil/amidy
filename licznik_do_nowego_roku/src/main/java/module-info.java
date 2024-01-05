module com.example.licznik_do_nowego_roku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.licznik_do_nowego_roku to javafx.fxml;
    exports com.example.licznik_do_nowego_roku;
}
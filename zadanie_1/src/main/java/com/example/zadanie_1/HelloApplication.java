package com.example.zadanie_1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Text imie = new Text("Imie: ");
        Text nazwisko = new Text("Nazwisko: ");
        Text adres = new Text("Adres: ");
        Text miejscowosc = new Text("Miejscowość: ");
        Text telefon = new Text("Telefon: ");
        Text email = new Text("Email: ");

        TextField imie_field= new TextField();
        TextField nazwisko_field= new TextField();
        TextField adres_field= new TextField();
        TextField miejscowosc_field= new TextField();
        TextField telefon_field= new TextField();
        TextField email_field= new TextField();



        Button button= new Button("ZATWIERDŹ");
        button.setStyle("-fx-background-color:GREEN;-fx-text-fill:WHITE;");
        Button button1 = new Button("RESET");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500,500);
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(imie,0,0);
        gridPane.add(imie_field,1,0);
        gridPane.add(nazwisko,0,1);
        gridPane.add(nazwisko_field,1,1);
        gridPane.add(adres,0,2);
        gridPane.add(adres_field,1,2);
        gridPane.add(miejscowosc,0,3);
        gridPane.add(miejscowosc_field,1,3);
        gridPane.add(telefon,0,4);
        gridPane.add(telefon_field,1,4);
        gridPane.add(email,0,5);
        gridPane.add(email_field,1,5);
        gridPane.add(button,1,6);
        gridPane.add(button1,1,7);



        button.setOnMouseClicked((new EventHandler<MouseEvent>() {


            int punkty=0;
            @Override
            public void handle(MouseEvent mouseEvent) {

                boolean patternImie = Pattern.matches("^[A-Za-z]{2,}+$", imie_field.getText().toString());
                boolean patternNazwisko = Pattern.matches("^[A-Za-z]{2,}+$", nazwisko_field.getText().toString());
                boolean patternMiejscowosc= Pattern.matches("^[A-Za-z]{3,}+$",miejscowosc_field.getText().toString());
                boolean patternAdres=adres_field.getText().isEmpty();
                boolean patternTelefon= Pattern.matches("\\d{9,}",telefon_field.getText());
                boolean patternEmail= Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}",email_field.getText().toString());




                if (patternAdres==false){
                    System.out.println("adres :poprawne");
                    punkty++;
                }else {
                    System.out.println("Błąd w adresie : X");
                }

                if (patternImie == true){
                    System.out.println("imie :poprawne");
                    punkty++;
                }else {
                    System.out.println("Błąd w imieniu : X");
                }

                if (patternNazwisko==true) {
                    System.out.println("nazwisko :poprawne");
                    punkty++;
                }else {
                    System.out.println("Błąd w nazwisku : X");
                }

                if (patternMiejscowosc==true){
                    punkty++;
                    System.out.println("miejscowos :poprawne");
                }else {
                    System.out.println("Błąd w miejscowosc : X");
                }

                if (patternEmail==true){
                    punkty++;
                    System.out.println("email :poprawne");
                }else {
                    System.out.println("Błąd w emailu : X");
                }


                if (patternTelefon==true){
                    System.out.println("telefon :poprawne");
                    punkty++;
                }else {
                    System.out.println("Błąd w telefonie : X");
                }


                if (punkty==6){
                    System.out.println("udalo sie poprawnie wypełnic formularz <3");
                }else{
                    System.out.println("nie podano wszystkich danych");
                }
                punkty=0;
            }
        }));


        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imie_field.setText("");
                nazwisko_field.setText("");
                adres_field.setText("");
                miejscowosc_field.setText("");
                telefon_field.setText("");
                email_field.setText("");
            }
        });

        Group group = new Group(gridPane);
        Scene scene= new Scene(group,500,500);
        scene.setFill(Color.BEIGE);

        stage.setTitle("Formularz");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
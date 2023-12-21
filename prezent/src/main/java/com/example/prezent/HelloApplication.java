package com.example.prezent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ArrayList prezenty_id = new ArrayList();
        ArrayList prezenty_nazwa = new ArrayList();
        ArrayList prezenty_cena = new ArrayList();
        ArrayList prezenty_opis = new ArrayList();
        ArrayList prezenty_oznaczenia= new ArrayList();


        //buttony
        Button dodaj_prezent = new Button("Dodaj prezent");
        Button usun_prezent= new Button("usun prezent");
        Button oznacz_wyznaczony_prezent = new Button("Oznacz wyznaczony prezent");
        Button suma_wartosci_worka = new Button("suma wartosci worka");
        Button dostarcz_prezenty=  new Button("Dostarcz prezenty");
        Button wyswietl_liste_orezentow = new Button("Wyswietl liste prezentów");

        //text fields
        TextField dodaj_prezent1= new TextField();
        TextField dodaj_prezent2= new TextField();
        TextField dodaj_prezent3= new TextField();
        TextField dodaj_usun_prezent= new TextField();
        TextField dodaj_oznacz_wyznaczony_prezent= new TextField();

        //texts
        Text nazwa= new Text("Nazwa");
        Text opis = new Text("Opis");
        Text cena= new Text("Cena");
        Text id_1 = new Text("ID prezentu");
        Text id_2 = new Text("ID prezentu");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500,500);
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(dostarcz_prezenty,0,0);

        gridPane.add(nazwa,1,1);
        gridPane.add(opis,2,1);
        gridPane.add(cena,3,1);

        gridPane.add(dodaj_prezent,0,2);
        gridPane.add(dodaj_prezent1,1,2);
        gridPane.add(dodaj_prezent2,2,2);
        gridPane.add(dodaj_prezent3,3,2);

        gridPane.add(id_1,1,3);
        gridPane.add(usun_prezent,0,4);
        gridPane.add(dodaj_usun_prezent,1,4);

        gridPane.add(id_2,1,5);
        gridPane.add(oznacz_wyznaczony_prezent,0,6);
        gridPane.add(dodaj_oznacz_wyznaczony_prezent,1,6);

        gridPane.add(suma_wartosci_worka,0,7);

        gridPane.add(wyswietl_liste_orezentow,0,8);

        //funkcje

        dodaj_prezent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int id= prezenty_id.size()+1;

                if (dodaj_prezent1.getText().toString().isEmpty()==false && dodaj_prezent2.getText().toString().isEmpty()==false && dodaj_prezent3.getText().toString().isEmpty()==false) {
                    prezenty_id.add(id);
                    prezenty_nazwa.add(dodaj_prezent1.getText().toString());
                    prezenty_cena.add(dodaj_prezent3.getText().toString());
                    prezenty_opis.add(dodaj_prezent2.getText().toString());
                    prezenty_oznaczenia.add("");


                    Alert alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("DODAWANIE!");
                    alert.setHeaderText("Dodawanie");
                    alert.setContentText("ID prezentu "+prezenty_id.get(prezenty_id.size()-1)+"\n Nazwa prezentu: "+prezenty_nazwa.get(id-1)+"\n Opis prezentu: "+prezenty_opis.get(id-1)+"\n Cena: "+prezenty_cena.get(id-1));
                    alert.show();

                }else {
                    System.out.println("nie ma wystarczajacej ilosci danych");
                }



            }
        });

        usun_prezent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int id= Integer.parseInt(dodaj_usun_prezent.getText())-1;

                prezenty_id.remove(id);
                prezenty_cena.remove(id);
                prezenty_opis.remove(id);
                prezenty_nazwa.remove(id);

                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("USUWANIE");
                alert.setHeaderText("USUWANIE");
                alert.setContentText("USUNIETO "+dodaj_usun_prezent.getText().toString()+" prezent");
                alert.show();

            }
        });

        oznacz_wyznaczony_prezent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int id_prezentu=Integer.parseInt(dodaj_oznacz_wyznaczony_prezent.getText())-1;
                prezenty_oznaczenia.set(id_prezentu,"+");

                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Oznaczenie");
                alert.setHeaderText("Oznaczenie");
                alert.setContentText("Oznaczono "+(id_prezentu+1)+" prezent");
                alert.show();

            }
        });

        suma_wartosci_worka.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int cena=0;

                for (int i =0;i<prezenty_cena.size();i++){
                    cena = Integer.parseInt((String) prezenty_cena.get(i))+cena;
                }
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cena");
                alert.setHeaderText("Cena");
                alert.setContentText("Cena "+cena+" prezentów");
                alert.show();


            }
        });

        wyswietl_liste_orezentow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            String alert_srodek="";
            @Override
            public void handle(MouseEvent mouseEvent) {

                for (int i=0;i<prezenty_id.size();i++){
                    alert_srodek+=" ID \t"+(i+1)+" nazwa \t"+prezenty_nazwa.get(i)+" Opis: \t"+prezenty_opis.get(i)+" Cena: \t"+prezenty_cena.get(i)+" Oznaczenie: \t"+prezenty_oznaczenia.get(i)+"\n";
                }

                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lista");
                alert.setHeaderText("Lista");
                alert.setContentText(alert_srodek);
                alert.show();
                alert_srodek="";
            }
        });

        dostarcz_prezenty.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                prezenty_id.clear();
                prezenty_cena.clear();
                prezenty_oznaczenia.clear();
                prezenty_nazwa.clear();
                prezenty_opis.clear();

                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Dostarczenie");
                alert.setHeaderText("Dostarczono");
                alert.setContentText("Dostarczono prezenty");
                alert.show();
            }
        });



        Group group = new Group(gridPane);
        Scene scene= new Scene(group,700,500);
        scene.setFill(Color.BEIGE);

        stage.setTitle("Formularz");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
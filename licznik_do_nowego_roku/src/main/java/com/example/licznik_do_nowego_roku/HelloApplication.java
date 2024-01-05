package com.example.licznik_do_nowego_roku;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //fomart czasu
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime rok_odliczanie = LocalDateTime.from(LocalDate.of(2025,1,1).atStartOfDay(ZoneId.systemDefault()));





        Label label_czas = new Label();

        Thread timerThread = new Thread(()->{
            boolean countdownTrue = true;
            while (countdownTrue==true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                LocalDateTime czas = LocalDateTime.now();



                long roznicaSekundy = czas.until(rok_odliczanie, ChronoUnit.SECONDS);

                if (roznicaSekundy<=0){
                    countdownTrue=false;
                    Platform.runLater(()->{
                        label_czas.setText("Szczęśliwego nowego roku!");
                    });
                }else{
                    int days = (int) TimeUnit.SECONDS.toDays(roznicaSekundy);
                    long hours = TimeUnit.SECONDS.toHours(roznicaSekundy) - (days*24);
                    long minutes = TimeUnit.SECONDS.toMinutes(roznicaSekundy) - (TimeUnit.SECONDS.toHours(roznicaSekundy)* 60);
                    long seconds = TimeUnit.SECONDS.toSeconds(roznicaSekundy) - (TimeUnit.SECONDS.toMinutes(roznicaSekundy) *60);

                    String caly = String.valueOf(days) + " dni " + String.format("%02d",hours) + ":" + String.format("%02d",minutes) + ":" + String.format("%02d",seconds);

                    Platform.runLater(()->{
                        label_czas.setText(caly);
                    });
                }
            }

        }); timerThread.start();


        HBox root = new HBox(label_czas);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 400);
        scene.setFill(Color.BEIGE);

        stage.setTitle("Odliczanie !!!!!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
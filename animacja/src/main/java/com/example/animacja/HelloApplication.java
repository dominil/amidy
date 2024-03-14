package com.example.animacja;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {


        Text napis_animacja= new Text("ANIMACJA !!!");
        Button start= new Button();
        Button stop= new Button();
        Button tworca= new Button();
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        Rectangle kwadrat= new Rectangle(40,40,40,40);
        RotateTransition rotateTransition= new RotateTransition();


        alert.setContentText("Dominik Danicki");
        alert.setHeaderText("Twórca");

        napis_animacja.setFill(Color.WHITE);

        start.setText("START");
        stop.setText("STOP");
        tworca.setText("TWORCA");

        kwadrat.setFill(Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700,500);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);

        gridPane.add(napis_animacja,1,0);

        gridPane.add(kwadrat,1,2);

        gridPane.add(start,0,3);
        gridPane.add(stop,1,3);
        gridPane.add(tworca,2,3);

        rotateTransition.setByAngle(360);
        Duration duration= new Duration(10);
        rotateTransition.setDuration(Duration.seconds(10));

        rotateTransition.setDelay(Duration.millis(5));
        rotateTransition.setNode(kwadrat);


        tworca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                alert.show();

            }
        });

        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                rotateTransition.play();}


        });

        stop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                rotateTransition.stop();
            }
        });


        Group group = new Group(gridPane);
        Scene scene= new Scene(group,700,500);
        scene.setFill(Color.BLACK);

        stage.setTitle("Aniamcja");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
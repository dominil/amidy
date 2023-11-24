package com.example.wprowadzenie;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {



//  //       Podstawowa linia
//        Line line= new Line();
//        line.setStartX(150);
//        line.setEndX(160);
//        line.setStartY(200);
//        line.setEndY(250);


//        Czworokąt
//        Path path= new Path();
//        MoveTo moveTo= new MoveTo(0,0);
//        LineTo line= new LineTo(160,170);
//        LineTo line2= new LineTo(200,170);
//        LineTo line3= new LineTo(200,140);
//        LineTo line4= new LineTo(0,0);
//
//        path.getElements().add(moveTo);
//        path.getElements().addAll(line,line2,line3,line4);

//      text
//        String text_string=" HELLO";
//        Text text= new Text();
//        text.setX(50);
//        text.setY(50);
//        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
//        text.setText(text_string);
//        text.setFill(Color.BLUE);
//
        //Efekty
//        Image image= new Image("https://www.tutorialspoint.com/green/images/logo.png");
//        ImageView imageView= new ImageView(image);
//        imageView.setX(70);
//        imageView.setY(70);
//        imageView.setFitWidth(100);
//        imageView.setFitHeight(70);
//        imageView.setPreserveRatio(true);
//
//        Glow glow= new Glow();
//        glow.setLevel(2);
//
//        imageView.setEffect(glow);

//        Transformacje
//        Rectangle rectangle= new Rectangle(50,60,70,90);
//        rectangle.setStroke(Color.DARKBLUE);
//
//        Translate translate= new Translate();
//        translate.setX(180);
//        translate.setY(200);
//        translate.setZ(0);
//
//        rectangle.getTransforms().add(translate);

        //Animacje
//        Circle circle = new Circle();
//        circle.setCenterX(200);
//        circle.setCenterY(200);
//        circle.setRadius(50);
//        circle.setFill(Color.DARKBLUE);
//
//        ScaleTransition scaleTransition= new ScaleTransition();
//
//        scaleTransition.setDuration(Duration.millis(1000));
//        scaleTransition.setNode(circle);
//        scaleTransition.setByX(5);
//        scaleTransition.setByY(5);
//        scaleTransition.setCycleCount(20);
//        scaleTransition.setAutoReverse(false);
//
//        scaleTransition.play();


        //kolory
//        Stop[] stops= new Stop[]{
//                new Stop(0.0,Color.WHITE),
//                new Stop(0.3,Color.RED),
//                new Stop(1,Color.DARKRED)
//        };
//
//        RadialGradient radialGradient= new RadialGradient(0,0,300,178,60,false, CycleMethod.NO_CYCLE,stops);
//
//        Circle circle = new Circle();
//        circle.setCenterX(300);
//        circle.setCenterY(180);
//        circle.setRadius(90);
//        circle.setFill(radialGradient);

// zdjecia
//        Image image= new Image("https://www.tutorialspoint.com/green/images/logo.png");
//
//        ImageView imageView= new ImageView(image);
//        imageView.setX(70);
//        imageView.setY(70);
//        imageView.setFitWidth(100);
//        imageView.setFitHeight(70);
//        imageView.setPreserveRatio(true);

//  3D Shapes

//        Box box = new Box();
//
//        box.setDepth(200);
//        box.setHeight(200);
//        box.setWidth(200);
//
//        box.setTranslateX(200);
//        box.setTranslateY(150);
//        box.setTranslateZ(0);
//
//        box.setDrawMode(DrawMode.LINE);
//
//        PerspectiveCamera camera= new PerspectiveCamera(false);
//        camera.setTranslateX(0);
//        camera.setTranslateY(0);
//        camera.setTranslateZ(0);

//      Eventy
//        Circle circle = new Circle();
//        circle.setCenterX(300);
//        circle.setCenterY(180);
//        circle.setRadius(90);
//        circle.setFill(Color.DARKBLUE);
//
//        EventHandler<MouseEvent> eventEventHandler= new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//           circle.setFill(Color.RED);
//            }
//        } ;
//
//        circle.addEventFilter(MouseEvent.MOUSE_CLICKED,eventEventHandler);


//      UI
//        TextField textField= new TextField();
//        textField.setText("dominik");

//      chards
//        CategoryAxis xaxis=new CategoryAxis();
//        xaxis.setCategories(FXCollections.<String>observableList(Arrays.asList("name")));
//
//        xaxis.setLabel("names");
//
//        LineChart lineChart= new LineChart(xaxis,xaxis);

//      Layout

//        HBox hBox= new HBox();
//        hBox.setSpacing(50);
//
//        TextField textField= new TextField();
//        Button button = new Button();
//        TextField textField_1= new TextField();
//
//        hBox.getChildren().addAll(textField,button,textField_1);

//      CSS
        Button button= new Button();
        button.setText("Przycisk");
        button.setStyle("-fx-background-color: red; -fx-text-fill:blue;");



        Group root= new Group(button);
        Scene scene= new Scene(root,600,600);


//        scene.setCamera(camera);


        stage.setTitle("Strona");
        stage.setScene(scene);
        stage.show();








    }

    public static void main(String[] args) {
        launch();
    }
}
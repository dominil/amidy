package com.example.pogoda;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.FontWeight;
import org.json.JSONArray;
import org.json.JSONObject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        String link_1= "https://api.openweathermap.org/data/2.5/weather?q=";
        String link_2="&appid=dbf2677cfd923964172672906d1b0f03&lang=pl";

        Image lupa_zdjecie= new Image("C:\\Users\\Użytkownik\\IdeaProjects\\pogoda\\zdjecia\\lupa.jpg");
        ImageView lupa= new ImageView(lupa_zdjecie);
        Text api_weather= new Text("API WEATHER");
        Text wartosci= new Text();
        ImageView ikona_zdjecie = new ImageView();
        TextField pole_do_wypelnienia= new TextField();
        Button button_wyszukaj= new Button();

        wartosci.setFill(Color.RED);
        wartosci.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

        api_weather.setFill(Color.BLUE);
        api_weather.setFont(new Font(40));

        lupa.setFitHeight(40);
        lupa.setPreserveRatio(true);

        button_wyszukaj.setGraphic(lupa);
        button_wyszukaj.setPrefSize(40,40);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700,500);
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(api_weather,0,0);
        gridPane.add(pole_do_wypelnienia,0,2);
        gridPane.add(button_wyszukaj,1,2);
        gridPane.add(ikona_zdjecie,0,3);
        gridPane.add(wartosci,0,4);


        button_wyszukaj.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String nazwa_miasta=pole_do_wypelnienia.getText().toString();
                try {
                    //połączenie JSON
                    URL url_api= new URL(link_1+nazwa_miasta+link_2);
                    HttpURLConnection connection= (HttpURLConnection) url_api.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String dane=reader.readLine();
                    JSONObject jsonObject= new JSONObject(dane);
                    String dane_do_pokazania="";




                    dane_do_pokazania=dane_do_pokazania+jsonObject.get("name")+"\n";


                    //temperatura
                    String temp ="";
                    String min_temp="";
                    String max_temp="";
                    String feels_temp="";
                    String cisnienie="";
                    String wiatr="";
                    String zachmurzenie="";

                    temp +=jsonObject.getJSONObject("main").get("temp");
                    min_temp +=jsonObject.getJSONObject("main").get("temp_min");
                    max_temp +=jsonObject.getJSONObject("main").get("temp_max");
                    feels_temp +=jsonObject.getJSONObject("main").get("feels_like");
                    cisnienie +=jsonObject.getJSONObject("main").get("pressure");
                    wiatr +=jsonObject.getJSONObject("wind").get("speed");
                    zachmurzenie +=jsonObject.getJSONObject("clouds").get("all");


                    float tmp = parseFloat(temp);
                    tmp = tmp - 273;
                    tmp= (float) Math.round(tmp*10)/10;

                    float tmp_min = parseFloat(min_temp);
                    tmp_min -=273;
                    tmp_min= (float) Math.round(tmp_min*10)/10;

                    float tmp_max = parseFloat(max_temp);
                    tmp_max -=273;
                    tmp_max= (float) Math.round(tmp_max*10)/10;

                    float tmp_feels = parseFloat(feels_temp);
                    tmp_feels -=273;
                    tmp_feels= (float) Math.round(tmp_feels*10)/10;

                    dane_do_pokazania+="Temperatura: "+tmp+" °C \n";
                    dane_do_pokazania+="Temperatura min: "+tmp_min+" °C \n";
                    dane_do_pokazania+="Temperatura max: "+tmp_max+" °C \n";
                    dane_do_pokazania+="Temperatura odczuwalna: "+tmp_feels+" °C \n";
                    dane_do_pokazania+="Cisnienie: "+cisnienie+" hPa\n";
                    dane_do_pokazania+="Predkosc wiatru: "+wiatr+" Km/H\n";
                    dane_do_pokazania+="Zachmurzenei: "+zachmurzenie+" %\n";

                    //

                    wartosci.setText(dane_do_pokazania);

                    //Ikona
                    String ikona="";
                    JSONArray weather= (JSONArray) jsonObject.get("weather");
                    JSONObject pogoda= (JSONObject) weather.get(0);
                    ikona+=pogoda.get("icon");
                    Image image_ikona= new Image("https://openweathermap.org/img/wn/"+ikona+"@2x.png");
                    ikona_zdjecie.setImage(image_ikona);



                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });



        Group group = new Group(gridPane);
        Scene scene= new Scene(group,700,500);
        scene.setFill(Color.BLACK);

        stage.setTitle("Pogoda");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baza {

    Connection connection = null;
    baza(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            String url = "jdbc:mysql://localhost:3306/amidy";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);


//            ResultSet resultSet = statement.executeQuery("SELECT * FROM pracownicy");
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("nr_pracownika");
//                String name = resultSet.getString("imie");
//                String surname = resultSet.getString("nazwisko");
//                String position = resultSet.getString("stanowisko");
//
//                System.out.println("ID: " + id);
//                System.out.println("Name: " + name);
//                System.out.println("Surname: " + surname);
//                System.out.println("Position: " + position);
//                System.out.println("---------");
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void wybieranie(int numer) throws SQLException {

        switch (numer){
            case 1:
                Scanner scanner= new Scanner(System.in);

                String query="CREATE TABLE ";

                int wiersze;
                String nazwa_tabeli,nazwa_zmiennej;

                System.out.println("podaj nazwe tabeli");
                nazwa_tabeli=scanner.nextLine().toString();

                query+=nazwa_tabeli+" ( ";

                System.out.println("podaj ile chcesz miec wierszy w tabeli");
                wiersze=scanner.nextInt();

                for (int i=0;i<wiersze;i++){

                    System.out.println("podaj nazwe zmiennej");
                    nazwa_zmiennej= scanner.next();

                    query+=nazwa_zmiennej+" ";

                    System.out.println("Wybierz typ danej");
                    System.out.println("1:INT");
                    System.out.println("2:VARCHAR");
                    System.out.println("3:DATE");

                    switch (scanner.nextInt()){
                        case 1:query+="INT";break;
                        case 2:
                            System.out.println("podaj maksymalna ilosc znaków");
                            query+="VARCHAR("+scanner.nextInt()+")";
                            break;
                        case 3:query+="DATE";
                    }
                        if (i==wiersze-1){
                            query+=");";
                        }else {
                            query+=" , ";
                        }

                }
                System.out.println(query);

                Statement statement = connection.createStatement();
                statement.execute(query);



                break;

            case 2:
                Scanner scanner2= new Scanner(System.in);
                String query_koncowe,nazwa_tablicy;
                String m="wybierz tablice: \n";
                String field="";
                int sprawdzanie=0;

                Statement statement_2 = connection.createStatement();

                ResultSet resultSet= statement_2.executeQuery("SHOW TABLES;");

                while (resultSet.next()){
                    m+= resultSet.getString("Tables_in_amidy")+"\n";
                }

                System.out.println(m);

                nazwa_tablicy=scanner2.next();
                ResultSet resultSet_2= statement_2.executeQuery("DESCRIBE "+nazwa_tablicy+" ;");
                query_koncowe="INSERT INTO "+nazwa_tablicy+" VALUES (";

                while (resultSet_2.next()){
                    field=resultSet_2.getString("Field");
                    System.out.println("podaj wartosc dla "+field);
                    String zmienna= scanner2.next();
                    if (sprawdzanie==0){
                        query_koncowe+=" "+zmienna+" ";
                    }else {
                        query_koncowe += " , " + zmienna + " ";
                    }
                    sprawdzanie++;
                }
                query_koncowe+=" ) ;";
                System.out.println(query_koncowe);

                statement_2.execute(query_koncowe);

                break;

            case 3:
                String wybierz_tablice="wybierz tablice: \n";
                Scanner scanner3= new Scanner(System.in);
                String tablica_nazwa,koncowa_dana="",probna="";
                System.out.println("tablice");
                Statement statement_3 = connection.createStatement();

                ResultSet resultSet_3= statement_3.executeQuery("SHOW TABLES;");

                while (resultSet_3.next()){
                    wybierz_tablice+= resultSet_3.getString("Tables_in_amidy")+"\n";
                }
                System.out.println(wybierz_tablice);
                tablica_nazwa=scanner3.next();

                ResultSet resultSet_4=statement_3.executeQuery("SELECT * FROM "+tablica_nazwa+" ;");
                ResultSetMetaData metaData= (ResultSetMetaData) resultSet_4.getMetaData();
                int columny=metaData.getColumnCount();


                String zadanie[]= new String[columny];

                for (int i=1;i<=columny;i++){
                    zadanie[i-1]=metaData.getColumnName(i);
                    koncowa_dana+=zadanie[i-1]+" \t";
                   // probna+=resultSet_4.getString(metaData.getColumnName(i))+" ";
                }

                koncowa_dana+="\n";

                while (resultSet_4.next()){
                    for (int i=1;i<=columny;i++){
                        koncowa_dana+=resultSet_4.getString(zadanie[i-1])+"\t";
                    }
                    koncowa_dana+="\n";
                }
                System.out.println(probna);
                System.out.println(koncowa_dana);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Podano niewłaściwa dane :[");
                break;




        }

    }


}

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        baza baza= new baza();
        Scanner scanner= new Scanner(System.in);
        int dana;
        System.out.println("Witamy w formuarzu bazy danych amidy");
        for (;;){
            System.out.println("--------");
            System.out.println("1: Tworzenie tabeli");
            System.out.println("2: Dodaj rekord do tebeli");
            System.out.println("3: Wyszukiwanie rekordu");
            System.out.println("4: Wyjscie");
            System.out.println("--------");
            dana=scanner.nextInt();
            baza.wybieranie(dana);

        }


    }


}

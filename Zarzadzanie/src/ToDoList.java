import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ToDoList toDoList= new ToDoList();

        for (;;){
            toDoList.wejscie_programu();
            }
    }

    Scanner scanner= new Scanner(System.in);

    ArrayList<String> tresc= new ArrayList<>();
    ArrayList<String> opis= new ArrayList<>();
    ArrayList<String> status= new ArrayList<>();

    void wejscie_programu(){
        System.out.println("-----------------------");
        System.out.println("" +
                "1. Dodaj nowe zadanie\n" +
                "2. Oznacz zadanie jako zakończone\n" +
                "3. Usuń zadanie\n" +
                "4. Wyświetl listę zadań\n" +
                "5. Wyjście");
        System.out.println("-----------------------");
        int wybor= scanner.nextInt();
        scanner.nextLine();

        switch (wybor){
            case 1: dodaj();break;
            case 2: zakoncz();break;
            case 3: usun();break;
            case 4: wyswietl();break;
            case 5: exit();break;
        }
    }

    void dodaj() {
        System.out.println("-----------------------");
        String dana="";
        System.out.println("Podaj nazwe: ");
        dana=scanner.nextLine();
        tresc.add(dana);
        System.out.println("Podaj tresc: ");
        dana=scanner.nextLine();

        opis.add(dana);
        status.add("-");
        System.out.println("-----------------------");
    }

    void zakoncz(){
        System.out.println("jakie zadanie chcesz zakończyc: ");
        int dana= scanner.nextInt();
        scanner.nextLine();

        status.set(dana,"+");
        System.out.println("-----------------------");
    };
    void usun(){
        System.out.println("jakie zadanie chcesz usunąć: ");
        int dana= scanner.nextInt();
        status.remove(dana);
        opis.remove(dana);
        tresc.remove(dana);
        System.out.println("USUNIETO!!!");
        System.out.println("-----------------------");
    }
    void  wyswietl(){
        System.out.println("Lista ");

        boolean chk = opis.isEmpty();

        if(chk == true) {
            System.out.println("Brak listy zadań!");
        } else {
            for (int i=0;i<opis.size();i++){
                System.out.println(tresc.get(i)+" "+opis.get(i)+" "+status.get(i));

            }
            System.out.println("-----------------------");
        }
    }
    void exit(){
        System.out.println("Do widzenia <3");
        System.exit(0);
    }

}

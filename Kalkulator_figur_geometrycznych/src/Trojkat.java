import java.util.Scanner;

public class Trojkat {
    Scanner scanner= new Scanner(System.in);

    Trojkat(){
        double a1,h;
        System.out.println("Podaj podstawe: ");
        a1=scanner.nextDouble();
        System.out.println("Podaj wysokosc: ");
        h=scanner.nextDouble();
        if (a1>0 && h>0){
            System.out.println("pole wynosi: " + (a1 * h / 2));
        }else {
            System.out.println("nie ma takiego trojkata");
        }
        }
}

import java.util.Scanner;

public class Prostokat {
    Scanner scanner= new Scanner(System.in);
    Prostokat(){
        double a1,h;
        System.out.println("podaj pierwszy bok: ");
        a1=scanner.nextDouble();
        System.out.println("podaj wysokosc: ");
        h=scanner.nextDouble();
        if (a1>0 && h>0) {
            System.out.println("pole wynosi: " + (a1 * h));
        }else {
            System.out.println("nie ma takiego prostokata");
        }
        }
}

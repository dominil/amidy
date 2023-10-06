import java.util.Scanner;

public class Kwadrat {
    Scanner scanner= new Scanner(System.in);
    Kwadrat(){
        double a1;
        System.out.println("podaj bok kwadratu: ");
        a1=scanner.nextDouble();
        if (a1>0) {
            double pole = a1 * a1;
            System.out.println("pole wynosi:" + pole);
        }else {
            System.out.println("Nie ma takeigo kwadratu");
        }
    }

}

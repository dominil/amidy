import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        for (;;){
            int wybor;
            System.out.println("-------------------------");
            System.out.println("Wybierz figurę do obliczeń:\n" +
                    "1. Kwadrat\n" +
                    "2. Prostokąt\n" +
                    "3. Trójkąt\n" +
                    "4. Wyjście");
            wybor=scanner.nextInt();
            if (wybor>0 && wybor<5) {
                switch (wybor) {
                    case 1:
                        Kwadrat kwadrat = new Kwadrat();
                        break;
                    case 2:
                        Prostokat prostokat = new Prostokat();
                        break;
                    case 3:
                        Trojkat trojkat = new Trojkat();
                        break;
                    case 4:
                        System.exit(0);
                        break;

                }
            }else {
                System.out.println("nie ma takiego wyboru!!!!!!!");
            }
        }

    }
}
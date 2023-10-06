import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    Sala[] sala= new Sala[10];
        sala[1] = new Sala(6,1);
        sala[2] = new Sala(10,2);


        Scanner scanner= new Scanner(System.in);
    for (;;){
        int myszka;
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Witamy w wypozyczalni sal");
        System.out.println("Co chciałby pan zrobic:");
        System.out.println("1:wynajac sale");
        System.out.println("2:sprawdzic mozliwosc rezerwacji");
        System.out.println("3:wyjscie");

        myszka=scanner.nextInt();

        switch (myszka){
            case 1:{
                int id;
                System.out.println("wynajmowanie");
                System.out.println("prosze wybrac id sali: ");
                id=scanner.nextInt();
                sala[id].rezerwacja();
                System.out.println("----------------");

            }break;
            case 2:{
                int id,godz;
                double data;
                System.out.println("sprawdzanie");
                System.out.println("prosze wybrac id sali: ");
                id=scanner.nextInt();
                System.out.println("podaj date");
                data=scanner.nextInt();
                if (data>31 || data<1){
                    System.out.println("podano nieodpowiednia date");
                    return;
                }
                System.out.println("podaj godz");

                godz=scanner.nextInt();
                if (godz>24 || godz<1){
                    System.out.println("podano nieodpowiednia godzine");
                    return;
                }

                sala[id].sprawdzenie_rezerwacji(data,godz);

                System.out.println("----------------");

            }break;
            case 3:{

                System.exit(0);
            }

        }
        }
    }


    }





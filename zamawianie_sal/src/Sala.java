import java.util.Scanner;

public class Sala {
    Scanner scanner= new Scanner(System.in);
    int ilosc_miejsc,id_sali;

    int tablica_rezerwacji[] = new int[9];
    int tablica_data[]= new int[9];
    int tablica_godz[]= new int[9];

    Sala(int ilosc_miejsc,int id_sali){
        this.ilosc_miejsc=ilosc_miejsc;
        this.id_sali=id_sali;
    }
    int rezerwacja(){
        int data,godz,miejsca;
        System.out.println("witamy przy rezerwacji sali nr: "+id_sali);
        System.out.println("podaj date: ");
        data= scanner.nextInt();
        System.out.println("podaj godz: ");
        godz= scanner.nextInt();
        System.out.println("podaj ilosc miejsc");
        miejsca=scanner.nextInt();
        if (miejsca>ilosc_miejsc){
            System.out.println("podano za duzo miejsc przekierowywanie do strony glownej");
            return 0;
        }
        if (sprawdzenie_rezerwacji(data,godz)==0){
            System.out.println("data jest zajeta przekierowywanie do strony glownej");
            return 0;
        }else {
            System.out.println("Dodawanie rejestracji");
            for (int i=0;i< tablica_rezerwacji.length;i++){
                if (tablica_rezerwacji[i]==0){
                    tablica_rezerwacji[i]=i;
                    dodanie_daty(data);
                    dodanie_godz(godz);
                    System.out.println("poprawnie ");
                    return 0;
                }
            }
        }
     return 0;
    }
    int sprawdzenie_rezerwacji(double data,int godz){
        System.out.println("sprawdznie rezerwacji: ");

        for (int i=0;i<tablica_data.length;i++){
            if (tablica_data[i]==data){
                if (tablica_godz[i]==godz){
                    System.out.println("podana data jest zajeta");
                    return 0;
                }
            }
        }
        System.out.println("Dana data jest dostepna");
        return 1;
    }
    int dodanie_daty(int data){
        for (int i=0;i<tablica_data.length;i++){
        if (tablica_data[i]==0){
            tablica_data[i]=data;
            return 0;
        }
        }
        System.out.println("brak dat");
        return 0;
    }
    int dodanie_godz(int godz){
        for (int i=0;i<tablica_godz.length;i++){
            if (tablica_godz[i]==0){
                tablica_godz[i]=godz;
                return 0;
            }
        }
        System.out.println("brak godzin");
        return 0;
    }


}

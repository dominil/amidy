import java.util.concurrent.TimeUnit;

public class Termostat {
     int obecna_temp,planowana_temp;

     Termostat(int obecna_temp,int planowana_temp){
         this.obecna_temp=obecna_temp;
         this.planowana_temp=planowana_temp;

     }
    void wlanczOgrzewanie() throws InterruptedException {
    for (int i=obecna_temp;i<planowana_temp;i++){
        TimeUnit.SECONDS.sleep(1);
        obecna_temp+=1;
        System.out.println(obecna_temp);
    }
    wylanczOgrzewanie();
    }

    void wylanczOgrzewanie(){
        System.out.println("!wyłączono ogrzewanie!");
        System.out.println("Dziekujemy za skorzystanie z termostatu");
    }

    void wlanczChlodzenie() throws InterruptedException {
        System.out.println("!włączono chłodzenie!");
        for (int i=obecna_temp;i>planowana_temp;i--){
            TimeUnit.SECONDS.sleep(1);
            obecna_temp-=1;
            System.out.println(obecna_temp);
        }
        wylanczChlodzenie();
    }

    void wylanczChlodzenie(){
        System.out.println("!wyłączono chłodzenie!");
    }

    void sprawdzTemperature() throws InterruptedException {
        System.out.println("Właczanie termostatu");
        System.out.println("....");
        System.out.println("termostat sprawny");

        if (obecna_temp<planowana_temp){
            if (planowana_temp>30){
                System.out.println("Podano temperature niebezpieczna");
            }else{
                System.out.println("!włączono ogrzewanie!");
                wlanczOgrzewanie();
            }
        } else if (obecna_temp>planowana_temp) {
            if (planowana_temp<-5){
                System.out.println("Podano temperature niebezpieczna");
            }else {
                wlanczChlodzenie();
            }
        }
        System.out.println("obecna temp wynosi: "+obecna_temp);
    }
}

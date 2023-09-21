import java.util.concurrent.TimeUnit;

public class Symulatortermostatu {
    public static void main(String[] args) throws InterruptedException {
        int planowana=26;
        Termostat termostat= new Termostat(20,planowana);
        for(;;){
            TimeUnit.SECONDS.sleep(1);
            termostat.obecna_temp-=1;
            System.out.println(termostat.obecna_temp);
            if (planowana- termostat.obecna_temp<-5||planowana- termostat.obecna_temp>5){
            termostat.sprawdzTemperature();
            }
        }

    }
}

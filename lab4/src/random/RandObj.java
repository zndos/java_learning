package random;
//Класс создающий обьект класса Dps из случайных данных
import road_transp_control.Dps;
import java.util.Random;


public class RandObj {

    public Dps RandDps() {
        Random rand = new Random();
        int id = rand.nextInt(100001);
        int speed = rand.nextInt(200);
        int height = rand.nextInt(100);
        int weight = rand.nextInt(100);
        Dps dps = new Dps(id,speed,height,weight);
        return dps;
    }












}

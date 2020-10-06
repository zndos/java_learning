/*Класс описывающий автомобиль
* Автомобиль имее поля  марка машины, максимальная скорость, радио
* Есть метод Move.*/
package transport;
import car_staff.Radio;

public class Car {
    private String brend;
    public int max_speed;
    private Radio fm ;
    /*конструктор*/
    public Car(){
        this.brend="BMW";
        this.max_speed=60;
        this.fm = new Radio();
    }

    public Car(String brend, int max_speed,String current_station,int status){
        this.brend=brend;
        this.max_speed=max_speed;
        this.fm = new Radio(current_station,status);
    }

    public int show_max_speed(){
        return this.max_speed;
    }
    public String show_brend(){
        return this.brend;
    }

    public void move(){
        /*метод показывающий что автомобиль едет*/
        System.out.println("Brrrrr ,i am moving!");
    }
}

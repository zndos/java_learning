/*Класс описывающий автомобиль
* Автомобиль имее поля  марка машины, максимальная скорость, радио
* Есть метод Move.*/
package transport;
import car_staff.Radio;
import vehicle.Vehicle;

public class Car extends Vehicle {

    private Radio fm ;
    /*конструктор*/
    public Car(){
        super();
        this.fm = new Radio();
    }

    public Car(String brend, int max_speed,String current_station ,int status){
        super(brend,max_speed);
        this.fm = new Radio(current_station,status);
    }

    public String show_fm(){
        return this.fm.show_station();
    }

    public String ToString(){
        String result = this.show_brend() +" "+this.show_max_speed()+" "+this.show_fm();
        return result;
    }

}

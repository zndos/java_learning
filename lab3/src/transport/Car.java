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

    public Car(String brend, int max_speed,String current_station,int status){
        super(brend,max_speed);
        this.fm = new Radio(current_station,status);
    }


}

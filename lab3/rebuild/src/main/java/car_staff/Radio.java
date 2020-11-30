/*Класс Радио имеющий поля текущая станция, статус работы (вкл/выкл)
Есть метод PlayTune.*/
package car_staff;
public class Radio {

    private String current_station;


/*Конструктор*/
    public Radio(){
        this.current_station="Vesti FM";

    }

    public Radio(String current_station){
        this.current_station=current_station;

    }

    public String show_station(){
        return this.current_station;
    }

}

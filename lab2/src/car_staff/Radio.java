/*Класс Радио имеющий поля текущая станция, статус работы (вкл/выкл)
Есть метод PlayTune.*/
package car_staff;
public class Radio {

    String current_station;
    int status;//статус работы (вкл/выкл)

/*Конструктор*/
    public Radio(){
        this.current_station="Vesti FM";
        this.status = 0;
    }

    public Radio(String current_station,int status){
        this.current_station=current_station;
        this.status=status;
    }

    public void playTunes(){
        /*метод включающий радио*/
        this.status=1;
        System.out.print("Music time!");
    }
}

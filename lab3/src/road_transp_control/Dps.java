/*Класс ДПС имеет поля: номер поста, допустимая скорость, высота , ширина
* Метод pass , который определяет пропустить ли автомобиль ( грузовик) по выборочным параметрам*/
package road_transp_control;

import transport.Car;
import transport.Truck;

public class Dps {
    private int dps_id;
    private int allowable_speed;
    private int allowable_height;
    private int allowable_weight;

    public Dps(){
        this.dps_id=0;
        this.allowable_speed=60;
        this.allowable_height=10;
        this.allowable_weight=10;

    }

    public Dps(int id, int speed , int height, int weight){
        this.dps_id=id;
        this.allowable_speed=speed;
        this.allowable_height=height;
        this.allowable_weight=weight;
    }

    public String pass(Car object){
        /*метод решающий пропустить машину или нет , основываясь на скорости тс*/
        if (object.show_max_speed()<=this.allowable_speed){
            return "pass";
        }
        else {
            return "stop";
        }
    }
    public String pass(Truck object){
        /*метод решающий пропустить грузовик или нет , основываясь на скорости , весе и  высоте тс */
        if ((object.show_max_speed()<=this.allowable_speed)
                &&(object.show_height()<=this.allowable_height)
                    &&(object.show_weight()<=allowable_weight)){
            return "pass";
        }
        else {
            return "stop";
        }
    }

    public int show_dps_id(){
        return this.dps_id;
    }

}

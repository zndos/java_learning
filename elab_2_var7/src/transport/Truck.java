/*Класс Грузовик наследуемый от Автомобиля
 имеет дополнительные поля вес, высота кузова.*/
package transport;

public class Truck extends  Car{
    public int height;
    public int weight;

    public Truck(){
        super();
        this.height=100;
        this.weight = 100;
    }

    public Truck(String brend, int max_speed,String current_station,int status,int height,int weight){
        super(brend,max_speed,current_station,status);
        this.height = height;
        this.weight = weight;
    }

    public int show_height(){
        return this.height;

    }

    public int show_weight(){
        return this.weight;
    }
}

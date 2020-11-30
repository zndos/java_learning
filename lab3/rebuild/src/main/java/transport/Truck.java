/*Класс Грузовик наследуемый от Автомобиля
 имеет дополнительные поля вес, высота кузова.*/
package transport;
import vehicle.Vehicle;

public class Truck extends Vehicle{
    public int height;
    public int weight;

    public Truck(){
        super();
        this.height=100;
        this.weight = 100;
    }

    public Truck(String brend, int max_speed,int height,int weight){
        super(brend,max_speed);
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }

    public int show_height() {
        return this.height;
    }

    public int show_weight() {
        return this.weight;
    }

    public String ToString(){
        String result = this.show_brend() +" "+this.show_max_speed()+" "+this.show_height()+" "+this.show_weight() ;
        return result;
    }

}

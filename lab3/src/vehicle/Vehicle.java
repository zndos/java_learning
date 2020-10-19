package vehicle;
/*Абстрактный класс описывающий любое транспортное средство, будь то машина или мотоцикл*/
public abstract class Vehicle {

    private String brend;
    private  int max_speed;

    protected Vehicle(){
        this.brend = "BMW";
        this.max_speed = 100;
    }

    protected Vehicle(String brend, int max_speed ){
        this.brend = brend;
        this.max_speed = max_speed;
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

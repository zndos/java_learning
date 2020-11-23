package Creators;

import road_transp_control.Dps;
import transport.Car;
import transport.Truck;

import java.util.Scanner;

public class Creator {
    public Car carCreator(){
        //TODO: try catch and error logs
        System.out.print("Введи бренд автомобиля: ");
        Scanner brend_scn = new Scanner(System.in);
        String brend = brend_scn.nextLine();

        System.out.print("Введи максимальную скорость автомобиля: ");
        Scanner speed_scn = new Scanner(System.in);
        int speed = speed_scn.nextInt();

        System.out.print("Введи название радиостанции которая будет играть в автомобиле: ");
        Scanner radio_scn = new Scanner(System.in);
        String radio = radio_scn.nextLine();

        return new Car(brend,speed,radio,1);

    }

    public Truck truckCreator(){
        //TODO: try catch and error logs
        System.out.print("Введи бренд грузовика: ");
        Scanner brend_scn = new Scanner(System.in);
        String brend = brend_scn.nextLine();

        System.out.print("Введи максимальную скорость грузовика: ");
        Scanner speed_scn = new Scanner(System.in);
        int speed = speed_scn.nextInt();

        System.out.print("Введи высоту грузовика: ");
        Scanner height_scn = new Scanner(System.in);
        int height = height_scn.nextInt();

        System.out.print("Введи вес грузовика: ");
        Scanner weight_scn = new Scanner(System.in);
        int weight = weight_scn.nextInt();

        return new Truck(brend, speed, height, weight);
    }

    public Dps dpsCreator(){
        //TODO: try catch and error logs
//        System.out.print("Введи id поста дпс: ");
//        Scanner id_scn = new Scanner(System.in);
//        int id = id_scn.nextInt();

        System.out.print("Введи максимальную  допустимую скорость транспортного средства: ");
        Scanner speed_scn = new Scanner(System.in);
        int speed = speed_scn.nextInt();

        System.out.print("Введи максимальную  допустимую высоту транспортного средства:: ");
        Scanner height_scn = new Scanner(System.in);
        int height = height_scn.nextInt();

        System.out.print("Введи максимальную  допустимый вес ранспортного средства:: ");
        Scanner weight_scn = new Scanner(System.in);
        int weight = weight_scn.nextInt();

        return new Dps(0,speed,height,weight);
    }



}

import road_transp_control.Dps;
import transport.Car;
import transport.Truck;

public class main {
    public static void main(String[] args) {
        /*Демонстрация работы конструктора автомобиля*/
        Car lastochka = new Car();
        Car galchonok = new Car("reno", 30, "Dacha FM", 1);
        /*Демонстрация работы конструктора грузовика*/
        Truck big_muck = new Truck();
        Truck big_tasty = new Truck("kamaz", 25, "Dorozhnoe", 1, 50, 50);
        /*Демонстрация работы конструктора поста ДПС*/
        Dps post = new Dps();
        Dps big_post = new Dps(2, 100, 100, 100);
        /*Демонстрация работы метода move()*/
        System.out.print(lastochka.show_brend() + " ");
        lastochka.move();
        System.out.print(galchonok.show_brend() + " ");
        galchonok.move();
        System.out.print(big_muck.show_brend() + " ");
        big_muck.move();
        System.out.print(big_tasty.show_brend() + " ");
        big_tasty.move();
        /*Демонстрация работы метода pass()*/
        System.out.println("Демонстрация работы метода pass()");
        System.out.println("Первый пост");
        System.out.println(lastochka.show_brend() +
                " speed " + lastochka.show_max_speed() + " " + post.pass(lastochka));
        System.out.println(galchonok.show_brend() +
                " speed " + galchonok.show_max_speed() + " " + post.pass(galchonok));
        System.out.println(big_muck.show_brend() +
                " speed " + big_muck.show_max_speed() + " weight " + big_muck.show_weight() + " height " + big_muck.show_height() + " " + post.pass(big_muck));
        System.out.println(big_tasty.show_brend() +
                " speed " + big_tasty.show_max_speed() + " weight " + big_tasty.show_weight() + " height " +
                big_tasty.show_height() + " " + post.pass(big_tasty));
        System.out.println("Второй пост");
        System.out.println(lastochka.show_brend() +
                " speed " + lastochka.show_max_speed() + " " + big_post.pass(lastochka));
        System.out.println(galchonok.show_brend() +
                " speed " + galchonok.show_max_speed() + " " + big_post.pass(galchonok));
        System.out.println(big_muck.show_brend() +
                " speed " + big_muck.show_max_speed() + " weight " + big_muck.show_weight() + " height " +
                big_muck.show_height() + " " + big_post.pass(big_muck));
        System.out.println(big_tasty.show_brend() +
                " speed " + big_tasty.show_max_speed() + " weight " + big_tasty.show_weight() + " height " +
                big_tasty.show_height() + " " + big_post.pass(big_tasty));



    }
}



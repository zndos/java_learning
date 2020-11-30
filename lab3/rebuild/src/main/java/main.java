
import Creators.Creator;
import FileSystem.DbManager;
import FileSystem.FileManager;
import FileSystem.LogsManager;
import com.google.gson.Gson;
import road_transp_control.Dps;
import transport.Car;
import transport.Truck;
import vehicle.Vehicle;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {

    public static void create_foo(int choice, LogsManager logs, DbManager db) throws IOException {
        switch (choice){
            case 0: {
                Creator creator = new Creator();
                Dps dps_post = creator.dpsCreator();
                logs.add(dps_post);
                db.add(dps_post);
            break;
            }
            case 1: {
                Creator creator = new Creator();
                Car car = creator.carCreator();
                logs.add(car);
                db.add(car);
                break;
            }
            case 2: {
                Creator creator = new Creator();
                Truck truck = creator.truckCreator();
                logs.add(truck);
                db.add(truck);
                break;
            }
        }
    }

    public static String  change_foo(int change_id , int type , LogsManager logs, DbManager db) throws IOException, InterruptedException {
        System.out.println("Данные об элементе: " + db.getData(change_id));
        String new_information="";
        if (type==1) {
            Car veh = (Car) db.veh_get(type,change_id);

            System.out.println("Какое поле изменить? ");
            Scanner atr_scn = new Scanner(System.in);
            TimeUnit.SECONDS.sleep(1);

            System.out.println("Какое значение вставить?");
            Scanner change_scn = new Scanner(System.in);

            String atr = atr_scn.nextLine();

            if (atr.equals("max_speed")){
                veh.setMaxSpeed(change_scn.nextInt());
            }
            if (atr.equals("brend")){
                veh.setBrend(change_scn.nextLine());
            }
            if (atr.equals("current_station")){
                veh.setRadio(change_scn.nextLine());
            }

            Gson g = new Gson();
            new_information  = g.toJson(veh);
        }
        if (type==1) {
            Truck veh = (Truck) db.veh_get(type, change_id);

            System.out.println("Какое поле изменить? ");
            Scanner atr_scn = new Scanner(System.in);
            TimeUnit.SECONDS.sleep(1);

            System.out.println("Какое значение вставить?");
            Scanner change_scn = new Scanner(System.in);

            String atr = atr_scn.nextLine();

            if (atr.equals("max_speed")) {
                veh.setMaxSpeed(change_scn.nextInt());
            }
            if (atr.equals("brend")) {
                veh.setBrend(change_scn.nextLine());
            }
            if (atr.equals("height")) {
                veh.setHeight(change_scn.nextInt());
            }
            if (atr.equals("weight")) {
                veh.setWeight(change_scn.nextInt());
            }

            Gson g = new Gson();
            new_information  = g.toJson(veh);
        }
        if (type==2) {
            Dps dps = db.dps_get(change_id);

            System.out.println("Какое поле изменить? ");
            Scanner atr_scn = new Scanner(System.in);

            TimeUnit.SECONDS.sleep(1);

            System.out.println("Какое значение вставить?");
            Scanner change_scn = new Scanner(System.in);

            String atr = atr_scn.nextLine();

            if (atr.equals("dps_id")) {
                dps.setDps_id(change_scn.nextInt());
            }
            if (atr.equals("allowable_speed")) {
                dps.setAllowable_speed(change_scn.nextInt());
            }
            if (atr.equals("allowable_height")) {
                dps.setAllowable_height(change_scn.nextInt());
            }
            if (atr.equals("allowable_weight")) {
                dps.setAllowable_weight(change_scn.nextInt());
            }

            Gson g = new Gson();
            new_information  = g.toJson(dps);
        }
        return new_information;

    }

    public static void main(String[] args) throws IOException, InterruptedException {


        String db_path = "G:\\rebuild\\src\\main\\resources\\db.txt";
        String log_path = "G:\\rebuild\\src\\main\\resources\\logs.txt";
        String config_path = "G:\\rebuild\\src\\main\\resources\\Property.ini";

        Boolean logging_flag = false;
        String username="Noname";
        Properties property = new Properties();

        /*Работаем с файлом конфигурации
         * Достаем из него настройки */
        try {
            FileInputStream fis;
            fis = new FileInputStream(config_path);
            property.load(fis);
            username = property.getProperty("username");
            logging_flag = Boolean.parseBoolean(property.getProperty("logging_flag"));
            System.out.println(" «Добро пожаловать —  " + username);
        }catch (Exception e){
            System.out.println("Property file error");
        }



        /*Работаем с файлом БД
         * Если такого файла нет , то создаем его */
        FileManager file = new FileManager(db_path);
        DbManager db = new DbManager(file);

        /*Работаем с файлом логирования
         * Если такого файла нет , то создаем его */
        FileManager logs_file = new FileManager(log_path);
        LogsManager logs = new LogsManager(logs_file, username);

        /*начинаем вести записи о работе программы*/
        if (logging_flag){
            logs.start();
        }
        Boolean flag = true;



        while (flag) {
            System.out.println("////////////////////////////////Меню////////////////////////////////\n" +
                    "1.Считать данные из бд\n"+
                    "2.Запись в базу данных\n" +
                    "3.Изменить запись \n" +
                    "4.Удалить запись \n" +
                    "5.Проверка \n" +
                    "6.Выход\n");

            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        /*1.Чтение из базы данных*/
                        System.out.println("Вывести всю бд или определенный элемент (0- всю бд иначе введите номер id нужного элемента");
                        Scanner scn = new Scanner(System.in);
                        if (scn.hasNextInt()) {
                            int read_id = scn.nextInt();
                            if (read_id == 0) {
                                try {
                                    if (logging_flag) {
                                        logs.read();
                                    }
                                    System.out.println("-------------Данные об объектах-------------\n" + file.read());
                                } catch (Exception read_error) {
                                    logs.error("Ошибка чтения");
                                }
                            } else {
                                try {
                                    if (logging_flag) {
                                        logs.read();
                                    }
                                    System.out.println("Данные об элементе: " + db.getData(read_id));
                                } catch (Exception read_1elem_error) {
                                    logs.error("Ошибка чтения");
                                }
                            }
                        } else {
                            System.out.println("Вводи число");
                            break;
                        }
                        break;
                    case 2:
                        /*2.Запись в базу данных*/
                        System.out.println("Что делаем пост дпс, машину или грузовик? (0-пост, 1- машина, 2- грузовик )");
                        Scanner choice_scn = new Scanner(System.in);
                        create_foo(choice_scn.nextInt(),logs,db);
                        break;
                    case 3:
                        /*3. Изменить запись */
                        System.out.println("Введите номер изменяемого обьекта: ");
                        Scanner scn_change = new Scanner(System.in);


                        System.out.println("Введите тип  изменяемого обьекта( 0 - Car, 1 - Truck, 2 - Dps):  ");
                        Scanner scn_type = new Scanner(System.in);

                        if (scn_change.hasNextInt()) {
                            try {
                                int change_id = scn_change.nextInt();

                                String new_information=change_foo(change_id,scn_type.nextInt(),logs,db);
                                String new_line =String.valueOf(change_id)+new_information;//TODO нормальную замену
                                db.change(change_id, new_line);
                                if (logging_flag) {
                                    logs.change(scn_change.nextInt());
                                }
                            } catch (Exception change_error) {
                                if (logging_flag) {
                                    logs.error("Ошибка изменения элемента в бд");
                                }
                            }
                        } else {
                            System.out.println("Введи число");
                        }

                        break;
                    case 4:
                        /*4.Удалить запись*/
                        System.out.print("Введите номер удаляемого обьекта: ");
                        Scanner scn_del = new Scanner(System.in);

                        if (scn_del.hasNextInt()) {
                            try {
                                int a = scn_del.nextInt();
                                db.del(a);
                                if (logging_flag) {
                                    logs.del(a);
                                }
                            } catch (Exception del_exp) {
                                if (logging_flag) {
                                    logs.error("Ошибка удаления элемента из бд");
                                }
                            }
                        } else {
                            System.out.println("Введи число");
                        }
                        break;
                    case 5:
                        //Проверка на прохождение поста
                        System.out.print("Введите номер поста дпс ");
                        Scanner scn_pass_dps = new Scanner(System.in);
                        Dps dps = db.dps_get(scn_pass_dps.nextInt());

                        System.out.print("Введите  тип тс и номер тс через пробел (0- машина , 1- грузовик) ");
                        Scanner scn_pass_veh = new Scanner(System.in);
                        Vehicle veh = db.veh_get(scn_pass_veh.nextInt(), scn_pass_veh.nextInt());

                        System.out.println(dps.ToString());
                        System.out.println(veh.ToString());

                        try {
                            System.out.println(dps.pass((Truck) veh));
                        }catch(Exception s_exc){
                            System.out.println(dps.pass((Car) veh));
                        }
                        break;

                    case 6:
                        /*5.Выход*/
                        flag = false;
                        if (logging_flag) {
                            logs.finish();
                        }
                        break;

            }
            } else {
                System.out.println("Вводи число");
                continue;
            }

        }
    }

}




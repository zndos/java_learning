package Main;

import FileSystem.DbManager;
import FileSystem.FileManager;
import FileSystem.LogsManager;
import road_transp_control.Dps;
import transport.Car;
import transport.Truck;

import java.time.*;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class main {

    
    public static void main(String[] args) throws IOException {


        String db_path = "\\db.txt";
        String log_path = "\\logs.txt";
        String config_path ="\\Property.ini";

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

        /*начинаем ввести записи о работе программы*/
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
                    "5.Выход\n");

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
                        Dps big_post = new Dps(2, 100, 100, 100);
                        Car lastochka = new Car();
                        Car galchonok = new Car("reno", 30, "Dacha FM", 1);
                        Truck big_muck = new Truck();
                        Truck big_tasty = new Truck("kamaz", 25, 50, 50);
                        try {
                            db.add(lastochka, big_post);
                            db.add(galchonok, big_post);
                            db.add(big_muck, big_post);
                            db.add(big_tasty, big_post);
                            if (logging_flag) {
                                logs.add(lastochka);
                                logs.add(galchonok);
                                logs.add(big_muck);
                                logs.add(big_tasty);
                            }
                        } catch (Exception add_error) {
                            if (logging_flag) {
                                logs.error("Ошибка добавления элемента из бд");
                            }
                        }
                        break;
                    case 3:
                        /*3. Изменить запись */
                        System.out.print("Введите номер изменяемого обьекта: ");
                        Scanner scn_change = new Scanner(System.in);
                        if (scn_change.hasNextInt()) {

                            try {
                                int change_id = scn_change.nextInt();
                                String new_line =String.valueOf(change_id)+"new information";//TODO нормальную замену
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




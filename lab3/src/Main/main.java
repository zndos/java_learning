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


        String db_path = "F:\\java_learning\\java_learning\\lab3\\db.txt";
        String log_path = "F:\\java_learning\\java_learning\\lab3\\logs.txt";
        String username;
        Boolean logging_flag = false;
        Properties property = new Properties();
        FileManager file = new FileManager(db_path);

        /*Работаем с файлом конфигурации
         * Достаем из него настройки */
        FileInputStream fis;
        fis = new FileInputStream("F:\\java_learning\\java_learning\\lab3\\Property.ini");
        property.load(fis);
        username = property.getProperty("username");
        logging_flag = Boolean.parseBoolean(property.getProperty("logging_flag"));
        System.out.println(" «Добро пожаловать —  " + username);

        /*Работаем с файлом БД
         * Если такого файла нет , то создаем его */
        DbManager db = new DbManager(file);

        /*Работаем с файлом логирования
         * Если такого файла нет , то создаем его */
        if (logging_flag) {
            FileManager logs_file = new FileManager(log_path);
            LogsManager logs = new LogsManager(logs_file, username);
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
                            if (read_id==0){
                                System.out.println("-------------Данные об объектах-------------\n" + file.read());
                            }
                            else{
                                System.out.println("Данные об элементе: "+db.getData(read_id));
                            }
                        }
                        else{
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

                        db.add(lastochka,big_post);
                        db.add(galchonok,big_post);
                        db.add(big_muck,big_post);
                        db.add(big_tasty,big_post);
                        if (logging_flag) {

                        }

                        break;
                    case 3:
                        /*3. Изменить запись */
                        System.out.print("Введите номер изменяемого обьекта: ");
                        Scanner scn_change = new Scanner(System.in);
                        String new_line="alalalalaa";//TODO нормальную замену

                        db.change(scn_change.nextInt(), new_line);

                        break;
                    case 4:
                        /*4.Удалить запись*/
                        System.out.print("Введите номер удаляемого обьекта: ");
                        Scanner scn_del = new Scanner(System.in);
                        db.del(scn_del.nextInt());

                        break;
                    case 5:
                        /*5.Выход*/
                        flag = false;
                        if (logging_flag) {
                            FileManager logs_file = new FileManager("logs.txt");
                            LocalTime end_time = LocalTime.now();
                            logs_file.write(end_time.getHour() + ":" + end_time.getMinute() + ":" + end_time.getSecond() + " Конец работы с БД" + "\n");
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




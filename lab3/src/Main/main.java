package Main;

import FileSystem.FileManager;
import road_transp_control.Dps;
import transport.Car;
import transport.Truck;
import java.time.*;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        /*Работаем с файлом конфигурации
         * Достаем из него настройки */
        FileInputStream fis;
        String username = "";
        Boolean logging_flag=false ;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("F:\\java_learning\\java_learning\\lab3\\Property.ini");
            property.load(fis);

            username = property.getProperty("username");
            logging_flag =Boolean.parseBoolean(property.getProperty("logging_flag"));


            System.out.println(" «Добро пожаловать —  " + username);


        /*Работаем с файлом логирования
         * Если такого файла нет , то создаем его */
        if (logging_flag) {
            File new_logs_file = new File("F:\\java_learning\\java_learning\\lab3\\logs.txt");
            if (new_logs_file.exists()) {
                System.out.println("logs готова к работе");
            } else {
                if (new_logs_file.createNewFile()) {
                    System.out.println("Создана logs");
                } else {
                    System.out.println("Ошибка создания logs ");
                }



            }
            FileManager logs_file = new FileManager("F:\\java_learning\\java_learning\\lab3\\logs.txt");
            LocalTime time = LocalTime.now();
            logs_file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Старт работы с БД"+" пользователь: "+username+"\n");

        }

    } catch (FileNotFoundException e) {
        System.err.println("ОШИБКА: Файл свойств отсуствует!");
    } catch (IOException e) {
        e.printStackTrace();
    }
        //Проверяем базу данных на существование, если ее нет - создаем
        File new_file = new File("F:\\java_learning\\java_learning\\lab3\\db.txt");
        if (new_file.exists()) {
            System.out.println("База данных готова к работе");
        } else {
            if (new_file.createNewFile()) {
                System.out.println("Создана база данных");
            } else {
                System.out.println("Ошибка создания  базы данных");
            }
        }
        FileManager file = new FileManager("db.txt");


        Boolean flag = true;
        while (flag) {
            System.out.println("////////////////////////////////Меню////////////////////////////////\n" +
                    "1.Чтение из базы данных\n" +
                    "2.Запись в базу данных\n" +
                    "3.Выход\n");

            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        /*1.Чтение из базы данных*/
                        System.out.println("-------------Данные об объектах-------------\n" + file.read());
                        break;
                    case 2:
                        /*2.Запись в базу данных*/
                        Car lastochka = new Car();
                        Car galchonok = new Car("reno", 30, "Dacha FM", 1);
                        Truck big_muck = new Truck();
                        Truck big_tasty = new Truck("kamaz", 25, 50, 50);
                        Dps big_post = new Dps(2, 100, 100, 100);
                        LocalTime add_time = LocalTime.now();
                        file.write(lastochka.ToString() + " " + big_post.show_dps_id() + " " + big_post.pass(lastochka) + "\n");
                        file.write(galchonok.ToString() + " " + big_post.show_dps_id() + " " + big_post.pass(galchonok) + "\n");
                        file.write(big_muck.ToString() + " " + big_post.show_dps_id() + " " + big_post.pass(big_muck) + "\n");
                        file.write(big_tasty.ToString() + " " + big_post.show_dps_id() + " " + big_post.pass(big_tasty) + "\n");
                        if (logging_flag){
                            FileManager logs_file = new FileManager("F:\\java_learning\\java_learning\\lab3\\logs.txt");
                            LocalTime time = LocalTime.now();
                            logs_file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Добавлен обьект "+ galchonok.getClass()+"\n");
                            logs_file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Добавлен обьект "+ lastochka.getClass()+"\n");
                            logs_file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Добавлен обьект "+ big_muck.getClass()+"\n");
                            logs_file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Добавлен обьект "+ big_tasty.getClass()+"\n");


                        }

                        break;
                    case 3:
                        /*3.Выход*/
                        flag = false;
                        if (logging_flag) {
                            FileManager logs_file = new FileManager("logs.txt");
                            LocalTime end_time = LocalTime.now();
                            logs_file.write(end_time.getHour() + ":" + end_time.getMinute() + ":" + end_time.getSecond() + " Конец работы с БД"+"\n");
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




package FileSystem;

import transport.Car;
import transport.Truck;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class LogsManager {
    //TODO LogsManager
    private  FileManager file;
    private String username;

    public LogsManager(FileManager file, String username) throws IOException {
        this.file = file;
        this.username = username;
        File new_file = new File(file.show_path());
        if (new_file.exists()) {
            System.out.println("Файлов логов готова к работе");

        } else {
            if (new_file.createNewFile()) {
                System.out.println("Создан файл логов");

            } else {
                System.out.println("Ошибка создания файл логов");
            }
        }
    }

    public void start() throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Старт работы с БД"+" пользователь: "+this.username+"\n");
    }

    public void finish() throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Конец работы с БД"+" пользователь: "+this.username+"\n");
    }

    public void add(Car transport) throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Добавлен обьект "+ transport.getClass()+"\n");

    }

    public void add(Truck transport) throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Добавлен обьект "+ transport.getClass()+"\n");

    }

    public void change(int ch_id) throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Изменен обьект под номером "+ String.valueOf(ch_id)+"\n");
    }


    public void del(int del_id) throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Удален обьект под номером "+ String.valueOf(del_id)+"\n");
    }

    public void read() throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() +" пользователь: "+this.username+" считывает данные "+"\n");
    }

    public void error(String error_info) throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond()+"получена ошибка"+ error_info);
    }



}

package fileSystem;
////Класс упрощающий работу с логами


import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class LogsManager {
    private  FileManager file;
    private String username;

    public LogsManager(FileManager file, String username) throws IOException {
        //Создаем обьект логирования
        // попутно првоеряя на существование файл в котором будут хранится данные

        this.file = file;
        this.username = username;
        File new_file = new File(file.show_path());
        if (new_file.exists()) {
            System.out.println("Файл логов готова к работе");
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
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Старт работы прораммы "+" пользователь: "+this.username+"\n");
    }

    public void finish() throws IOException {
        LocalTime time = LocalTime.now();
        this.file.write(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " Конец работы прораммы"+" пользователь: "+this.username+"\n");
    }

    public void write(String info) throws IOException {
        //Запись любой информации в лог
        LocalTime time = LocalTime.now();
        this.file.write(info+"\n");
    }

}

package FileSystem;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager {

    private String path;

    // Экземпляр класса который обеспечит возможность 
    // работать с файлом
    private RandomAccessFile file;

    // говорим конструктору проинициализировать путь к файлу
    public FileManager(String path) {
        this.path = path;
    }

    // метод демонстрирует переход на указанный символ


    // этот метод читает файл и выводит его содержимое
    public String read() throws IOException {
        file = new RandomAccessFile(path, "r");
        StringBuilder res = new StringBuilder();
        int b = file.read();
        // побитово читаем символы и плюсуем их в строку
        while(b != -1){
            res.append((char) b);
            b = file.read();
        }
        file.close();

        return res.toString();
    }

    // читаем файл с определенного символа
    public String readFrom(int numberSymbol) throws IOException {
        // открываем файл для чтения
        file = new RandomAccessFile(path, "r");
        StringBuilder res = new StringBuilder();

        // ставим указатель на нужный вам символ
        file.seek(numberSymbol);
        int b = file.read();

        // побитово читаем и добавляем символы в строку
        while(b != -1){
            res.append((char) b);

            b = file.read();
        }
        file.close();

        return res.toString();
    }

    // запись в файл
    public void write(String st) throws IOException {
        // открываем файл для записи
        // для этого указываем модификатор rw (read & write)
        // что позволит открыть файл и записать его
        file = new RandomAccessFile(path, "rw");

        // записываем строку переведенную в биты
        file.seek(file.length());
        file.write(st.getBytes());

        // закрываем файл, после чего данные записываемые данные попадут в файл
        file.close();
    }

}
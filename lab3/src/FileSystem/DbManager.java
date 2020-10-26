package FileSystem;

import road_transp_control.Dps;
import transport.Car;
import transport.Truck;
import vehicle.Vehicle;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DbManager {
    private FileManager file;
    private int count;

    public DbManager(FileManager file) {
        try {
            this.file = file;
            File new_file = new File(file.show_path());
            if (new_file.exists()) {
                System.out.println("База данных готова к работе");
                this.count = file.count();
            } else {
                if (new_file.createNewFile()) {
                    System.out.println("Создана база данных");
                    this.count = 0;
                } else {
                    System.out.println("Ошибка создания  базы данных");
                }
            }
        }catch(Exception  e ) {
            
        }

    }

    public String show_count() {
        return String.valueOf(this.count);
    }

    /*метод показывает элементы*/
    public String getData(int ch_id) throws IOException {
        String result = "";
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(this.file.show_path()), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).startsWith(String.valueOf(ch_id))) {
                result =  fileContent.get(i);
                break;
            }
        }
        return result;
    }
    /*метод добавляет элементы в бд*/
    public void  add(Car vehicle_obj , Dps dps_obj) throws IOException {
        this.count+=1;
        this.file.write(this.show_count() +" "+ vehicle_obj.ToString() + " " + dps_obj.show_dps_id() + " " + dps_obj.pass(vehicle_obj) + "\n");
    }
    public void  add(Truck vehicle_obj , Dps dps_obj) throws IOException {
        this.count+=1;
        this.file.write(this.show_count() +" "+ vehicle_obj.ToString() + " " + dps_obj.show_dps_id() + " " + dps_obj.pass(vehicle_obj) + "\n");
    }
    /*метод меняет элементы*/
    public void change(int ch_id, String change_obj) throws IOException {

        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(this.file.show_path()), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).startsWith(String.valueOf(ch_id))) {
                fileContent.set(i, change_obj);
                break;
            }
        }
        Files.write(Path.of(this.file.show_path()), fileContent, StandardCharsets.UTF_8);
    }
    /*метод удаляет элементы*/
    public void del(int del_id) throws IOException {
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(this.file.show_path()), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).startsWith(String.valueOf(del_id))) {
                fileContent.set(i, "");

                break;
            }
        }

        Files.write(Path.of(this.file.show_path()), fileContent, StandardCharsets.UTF_8);

        Scanner file;
        PrintWriter writer;
        file = new Scanner(new File(this.file.show_path()));
        File new_file = new File( (this.file.show_path().substring(0, this.file.show_path().length() - 4)+"_copy.txt"));
        if (new_file.exists()) {
            System.out.println("Ошибка");

        } else {
            if (new_file.createNewFile()) {
                System.out.println("Создана ");
                writer = new PrintWriter(this.file.show_path().substring(0, this.file.show_path().length() - 4)+"_copy.txt");


                while (file.hasNext()) {
                    String line = file.nextLine();
                    if (!line.isEmpty()) {
                        writer.write(line);
                        writer.write("\n");
                    }
                }

                file.close();
                writer.close();

                File file1 = new File(this.file.show_path());
                file1.delete();
                new_file.renameTo(file1);
            }
        }
    }
}

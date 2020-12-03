package FileSystem;

import com.google.gson.Gson;
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
        } catch (Exception e) {
            System.out.println("Ошибка");
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
                result = fileContent.get(i);
                break;
            }
        }
        return result;
    }



    public Dps dps_get(int id) throws IOException {
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(this.file.show_path()), StandardCharsets.UTF_8));
        String new_str = "";
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).startsWith(String.valueOf(id))) {
                String str = fileContent.get(i);

                for (int j = 2; j < str.length(); j++) {
                    new_str += str.charAt(j);
                }
                break;
            }
        }
        Gson gson = new Gson();
        Dps dps_obj = gson.fromJson(new_str, Dps.class);
        return dps_obj;

    }


    public Vehicle veh_get(int type, int id) throws IOException {
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(this.file.show_path()), StandardCharsets.UTF_8));
        String new_str = "";
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).startsWith(String.valueOf(id))) {
                String str = fileContent.get(i);
                for (int j = 2; j < str.length(); j++) {
                    new_str += str.charAt(j);
                }
            }
        }
        Gson gson = new Gson();

        if (type==0) {
            Car car = gson.fromJson(new_str, Car.class);
            return car;
        }else {
            Truck truck = gson.fromJson(new_str, Truck.class);
            return truck;
        }

    }



    /*метод добавляет элементы в бд*/

    public void add(Dps dps) throws IOException {
        this.count += 1;
        Gson gson = new Gson();
        String jsonStr = gson.toJson(dps);
        this.file.write(this.count+" "+jsonStr+"\n");
    }

    public void add(Car vehicle_obj) throws IOException {
        this.count += 1;
        Gson gson = new Gson();
        String jsonStr = gson.toJson(vehicle_obj);
        this.file.write(this.count+" "+jsonStr+"\n");


    }

    public void add(Truck vehicle_obj) throws IOException {
        this.count += 1;
        Gson gson = new Gson();
        String jsonStr = gson.toJson(vehicle_obj);
        this.file.write(this.count+" "+jsonStr+"\n");
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
    //Тут я передвигаю строки чтобы было красиво
        Files.write(Path.of(this.file.show_path()), fileContent, StandardCharsets.UTF_8);

        Scanner file;
        PrintWriter writer;
        file = new Scanner(new File(this.file.show_path()));
        File new_file = new File((this.file.show_path().substring(0, this.file.show_path().length() - 4) + "_copy.txt"));
        if (new_file.exists()) {
            System.out.println("Ошибка");

        } else {
            if (new_file.createNewFile()) {
                System.out.println("Создана ");
                writer = new PrintWriter(this.file.show_path().substring(0, this.file.show_path().length() - 4) + "_copy.txt");


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


package main;

import fileSystem.FileManager;
import fileSystem.LogsManager;
import road_transp_control.Dps;
import random.RandObj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {


        RandObj randomaizer = new RandObj();

        Random rand = new Random();
        ///ArrayList
        for (int arr_size = 10; arr_size <= 100000; arr_size = arr_size * 10) {
            //Создание файла с пометкой кол-ва элементов
            String path = "C:\\Users\\Евгений\\IdeaProjects\\lab4\\ArrayListLogs\\logs" + arr_size + ".txt";
            FileManager logs_file = new FileManager(path);
            LogsManager logs = new LogsManager(logs_file, "eugene");

            long summary_time = 0;
            //Начинаем вести лог (не включаем приготовления )
            logs.start();

            ArrayList<Dps> dps_posts = new ArrayList<Dps>();
            //Заполняем наш ArrayList
            for (int i = 0; i < arr_size; i++) {

                Dps dps_post = randomaizer.RandDps();
                long start = System.nanoTime();
                dps_posts.add(dps_post);
                long finish = System.nanoTime();
                long time = finish - start;
                logs.write("ADD " + "id: " + i + " time: " + time);
                summary_time += time;

            }
            //Удаляем ~10% элементов случайным образом
            int remove_count = 0;
            long remove_time = 0;
            int num = arr_size;
            while (remove_count <= arr_size * 0.1) {

                int removed_index = rand.nextInt(num);
                long start = System.nanoTime();
                dps_posts.remove(removed_index);
                long finish = System.nanoTime();
                long time = finish - start;
                remove_time += time;
                num -= 1;
                remove_count += 1;
                logs.write("REMOVE " + "id: " + removed_index + " time: " + time);
            }

            //Записываем выводы
            logs.write("Количество добавлений: " + arr_size);
            logs.write("Количество удалений: " + remove_count);
            logs.write("Среднее время добавления: " + summary_time / arr_size);
            logs.write("Среднее время удаления: " + remove_time / remove_count);
            logs.write("Общее время выполнения: " + summary_time);
            logs.finish();
            logs.write("");
            System.out.println("ArrayList " + arr_size);
        }

        ///LinkedList
        for (int arr_size = 10; arr_size <= 100000; arr_size = arr_size * 10) {
            //Создание файла с пометкой кол-ва элементов
            String path = "C:\\Users\\Евгений\\IdeaProjects\\lab4\\LinkedListLogs\\logs" + arr_size + ".txt";
            FileManager logs_file = new FileManager(path);
            LogsManager logs = new LogsManager(logs_file, "eugene");
            long summary_time = 0;
            //Начинаем вести лог (не включаем приготовления )
            logs.start();
            LinkedList<Dps> dps_linked_posts = new LinkedList<Dps>();
            //Заполняем наш LinkedList
            for (int i = 0; i < arr_size; i++) {

                Dps dps_post = randomaizer.RandDps();
                long start = System.nanoTime();
                dps_linked_posts.add(dps_post);
                long finish = System.nanoTime();
                long time = finish - start;
                logs.write("ADD " + "id: " + i + " time: " + time);
                summary_time += time;

            }

            //Удаляем ~10% элементов случайным образом
            int remove_count = 0;
            int num = arr_size;
            long remove_time = 0;
            while (remove_count <= arr_size * 0.1) {

                int removed_index = rand.nextInt(num);
                long start = System.nanoTime();
                dps_linked_posts.remove(removed_index);
                long finish = System.nanoTime();
                long time = finish - start;
                remove_time += time;
                num -= 1;
                remove_count += 1;
                logs.write("REMOVE " + "id: " + removed_index + " time: " + time);
            }

            //Записываем выводы
            logs.write("Количество добавлений: " + arr_size);
            logs.write("Количество удалений: " + remove_count);
            logs.write("Среднее время добавления: " + summary_time / arr_size);
            logs.write("Среднее время удаления: " + remove_time / remove_count);
            logs.write("Общее время выполнения: " + summary_time);
            logs.finish();
            logs.write("");
            System.out.println("LinkedList " + arr_size);

        }
    }

}


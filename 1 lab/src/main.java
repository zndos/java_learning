import java.util.*;
import java.math.*;
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        if (str.equals(new StringBuilder(str).reverse().toString())) {
            System.out.println("Полиндром");
            int square = (int) Math.pow(Integer.parseInt(str), 2);
            String square_str = Integer.toString(square);
            if (square_str.equals(new StringBuilder(square_str).reverse().toString())) {
                System.out.println("Квадратный полиндром");
            } else {
                System.out.println("Не квадратный полиндром");

            }
        } else {
            System.out.println("Не полиндром");
        }
    }
}
package homework11.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import homework11.src.model.Car;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("program Car, version 0.9");
        HashSet<Car> Cars = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/homework11/src/data/cars_in.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // TODO System.out.println(line); 
                String[] d = line.split("\\|");
                Car oCar = new Car(d[0], d[1], d[2], d[3], d[4]);
                Cars.add(oCar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println(Cars); 

    }
}

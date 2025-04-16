import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GlobalWeatherManager g = new GlobalWeatherManager(new File("city_temperature.csv"));
        System.out.println("\n\nDone processing file.");
        System.out.println("READINGS: " + g.getReadingCount());
        System.out.println("First 50 readings:");
        WeatherReading[] r = g.getReadings(0, 50);
        for (int i = 0; i < 50; i++) {
            System.out.println(r[i]);
        }
        System.out.println("City stats for Africa,Namibia,-,Windhoek");
        System.out.println(g.getCityListStats("Namibia", "", "Windhoek"));
    }
}
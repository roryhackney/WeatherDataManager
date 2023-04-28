import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GlobalWeatherManager g = new GlobalWeatherManager(new File("city_temperature.csv"));
    }
}
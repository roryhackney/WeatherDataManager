import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Manages global weather data, sorting by area and providing methods to retrieve data and stats
 */
public class GlobalWeatherManager implements GlobalWeatherManagerInterface, Iterable<WeatherReading> {
    /**
     * List of WeatherReading data, sorted by region, then date
     */
    private ArrayList<WeatherReading> readings;

    /**
     * Constructor, populates readings ArrayList and sorts
     * @param dataFile  File to read weather data from
     * @throws FileNotFoundException if weather data file not found
     */
    public GlobalWeatherManager(File dataFile) throws FileNotFoundException {
        readings = new ArrayList<>();
        Scanner fileScan = new Scanner(dataFile);
        fileScan.nextLine();
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            readings.add(new WeatherReading(
                    lineScan.next(),
                    lineScan.next(),
                    lineScan.next(),
                    lineScan.next(),
                    lineScan.nextInt(),
                    lineScan.nextInt(),
                    lineScan.nextInt(),
                    lineScan.nextDouble()));
            lineScan.close();
        }
        fileScan.close();
        Collections.sort(readings);
    }

    /**
     * Retrieves the number of readings
     * @return count of readings
     */
    @Override
    public int getReadingCount() {
        return readings.size();
    }

    /**
     * Retrieves the weather reading at the specified index.
     *
     * @param index the index for the desired reading; must be a valid element index.
     * @return the reading at the specified index.
     */
    @Override
    public WeatherReading getReading(int index) {
        return readings.get(index);
    }

    /**
     * Retrieves a set of weather readings.
     *
     * @param index the index of the first reading; must be a valid index.
     * @param count the count of readings to potentially include.  Must be at least 1.  Must imply a valid range;
     *              index + count must be less than the total reading count.
     * @return an array of readings.
     */
    @Override
    public WeatherReading[] getReadings(int index, int count) {
        WeatherReading[] subset = new WeatherReading[count];
        for (int subIndex = 0; subIndex < count; subIndex++) {
            subset[subIndex] = readings.get(index + subIndex);
        }
        return subset;
    }

    /**
     * Retrieves a set of weather readings.
     *
     * @param index the index of the first reading.
     * @param count the count of readings to check for potential inclusion.  Must be at least 1.
     *              Must imply a valid range; index + count must be less than the total reading count.
     * @param month the month to filter; must be a valid month (1 to 12).
     * @param day   the day to filter; must be a valid day (1 to 31).
     * @return an array of readings matching the specified criteria.  Length will usually be smaller than
     * the count specified as a parameter, as each year will only have one matching day.
     */
    @Override
    public WeatherReading[] getReadings(int index, int count, int month, int day) {
        return new WeatherReading[0];
    }

    /**
     * Retrieves key list statistics for the specified country/state/city.
     * Student note:  okay to use an additional ArrayList in this method.
     *
     * @param country the country of interest; must not be null or blank.
     * @param state   the state of interest; must not be null.
     * @param city    the city of interest; must not be null or blank.
     * @return the list stats for the specified city, or null if not found.
     */
    @Override
    public CityListStats getCityListStats(String country, String state, String city) {
        return null;
    }

    /**
     * Retrieves an iterator over all weather readings.
     *
     * @return strongly typed iterator for.
     */
    @Override
    public Iterator<WeatherReading> iterator() {
        return readings.iterator();
    }

    /**
     * Does a linear regression analysis on the data, using x = year and y = temperature.
     * Calculates the slope of a best-fit line using the Least Squares method.   For more information
     * on that method, see <a href="https://www.youtube.com/watch?v=P8hT5nDai6A">...</a>
     * Student note:  okay to use two additional ArrayLists in this method.
     *
     * @param readings array of readings to analyze.  Should typically be readings for a single day over
     *                 a number of years; larger data sets will likely yield better results.  Ignores
     *                 temperature data of -99.0, a default value indicating no temperature data was present.
     *                 Must not be null and must contain at least two readings.
     * @return slope of best-fit line; positive slope indicates increasing temperatures.
     */
    @Override
    public double getTemperatureLinearRegressionSlope(WeatherReading[] readings) {
        return 0;
    }

    /**
     * Calculates the slope of the best-fit line calculated using the Least Squares method.  For more information
     * on that method, see <a href="https://www.youtube.com/watch?v=P8hT5nDai6A">...</a>
     *
     * @param x an array of x values; must not be null and must contain at least two elements.
     * @param y an array of y values; must be the same length as the x array and must not be null.
     * @return the slope of the best-fit line
     */
    @Override
    public double calcLinearRegressionSlope(Integer[] x, Double[] y) {
        return 0;
    }
}

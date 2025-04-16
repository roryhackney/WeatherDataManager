import java.util.ArrayList;

/**
 * Data transport class for weather stats on a city
 * @param  startingIndex  starting index of WeatherReading data lines for a city
 * @param  count  number of WeatherReading data lines for a city
 * @param  years  years represented in the data for a city
 */
public record CityListStats(int startingIndex, int count, ArrayList<Integer> years) {}


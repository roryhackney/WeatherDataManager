/**
 * Represents a single weather reading data line from the city_temperature.csv data file
 * @param region Continental region the data was taken in; must not be null or blank
 * @param country Country the data was taken in; must not be null or blank
 * @param state State the data was taken in (can be blank); must not be null
 * @param city City the data was taken in; must not be null or blank
 * @param month Month the data was taken during; must be 1 through 12
 * @param day Day the data was taken during; must be 1 through 31
 * @param year Year the data was taken during; must be 1800 through 3000
 * @param avgTemperature Average temperature measured on this day in this place; must be -99 through 200
 */
public record WeatherReading(String region, String country, String state, String city, int month, int day, int year,
                             double avgTemperature) implements Comparable<WeatherReading> {

    /**
     * Constructor
     * @param region Continental region the data was taken in; must not be null or blank
     * @param country Country the data was taken in; must not be null or blank
     * @param state State the data was taken in (can be blank); must not be null
     * @param city City the data was taken in; must not be null or blank
     * @param month Month the data was taken during; must be 1 through 12
     * @param day Day the data was taken during; must be 1 through 31
     * @param year Year the data was taken during; must be 1800 through 3000
     * @param avgTemperature Average temperature measured on this day in this place; must be -99 through 200
     */
    public WeatherReading {
        Utility.verifyNotNullOrBlank("region", region);
        Utility.verifyNotNullOrBlank("country", country);
        if (state == null) {throw new IllegalArgumentException("state cannot be null");}
        Utility.verifyNotNullOrBlank("city", city);
        Utility.verifyInRange(1, 12, "month", month);
        Utility.verifyInRange(1, 31, "day", day);
        Utility.verifyInRange(1800, 3000, "year", year);
        Utility.verifyInRange(-99.0, 200.0, "avgTemperature", avgTemperature);
    }

    /**
     * Compares this WeatherReading to another WeatherReading, used for sorting
     * @param other the WeatherReading to be compared.
     * @return negative for less than, 0 for equal, or positive for greater than
     */
    @Override
    public int compareTo(WeatherReading other) {
        if (other == null) {return 1;}
        if (!country.equals(other.country)) {
            return country.compareTo(other.country);
        } else if (!state.equals(other.state)) {
            return state.compareTo(other.state);
        } else if (!city.equals(other.city)) {
            return city.compareTo(other.city);
        } else if (year != other.year) {
            return year - other.year;
        } else if (month != other.month) {
            return month - other.month;
        } else {
            return day - other.day;
        }
    }

    /**
     * Checks to see if the content is equal between two WeatherReading objects
     * @param other   the WeatherReading to compare.
     * @return        whether the content matches or not
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof WeatherReading) {
            return this.compareTo((WeatherReading)other) == 0;
        }
        return false;
    }
}

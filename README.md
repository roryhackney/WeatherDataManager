# WeatherDataManager
Processes almost 3 million rows of global weather data and provides useful methods. Java 2 course project.

Reads the city_temperature.csv file which contains almost 3 million rows of global weather data. You can find the file at Kaggle, because it is a very large file I did not include it in the repo.
[https://www.kaggle.com/datasets/sudalairajkumar/daily-temperature-of-major-cities](city_temperature)

Main runs the demo, instantiating the GlobalWeatherManager which reads the file using Scanner, producing an array of WeatherReading objects. It also contains various methods, such as getReadings(index, count) and getCityListStats(String country, String state, String city), both of which are demoed in Main.main().
![image](https://github.com/user-attachments/assets/86cda362-cf49-4a19-916d-1796ebd03755)

To run the application, clone the repo, download the CSV file linked above and put it into the folder, and run Main.main().


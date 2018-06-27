package Provider;

import Aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider _weatherProvider = null;

    private WeatherProvider() {

    }

    public static WeatherProvider getWeatherProvider() {
        if (_weatherProvider == null)
            _weatherProvider = new WeatherProvider();
        return _weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
        int randomGenerator = new Random().nextInt(weather.length);
        String randomWeather = (weather[randomGenerator]);

        return randomWeather;
    }
}

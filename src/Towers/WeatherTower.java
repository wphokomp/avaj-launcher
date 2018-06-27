package Towers;

import Aircrafts.Coordinates;
import Provider.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}

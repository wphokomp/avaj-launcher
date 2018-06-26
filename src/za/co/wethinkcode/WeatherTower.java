package za.co.wethinkcode;

import java.util.Random;

public class WeatherTower extends Tower {
    public String getWeather() {
        String[] conditions = new String[]{"SUN", "RAIN", "FOG", "SNOW"};

        return (conditions[(new Random()).nextInt(conditions.length)]);
    }

    void changeWeather() {
        //Change weather
        this.conditionsChanged();
    }
}

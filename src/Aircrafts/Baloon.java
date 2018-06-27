package Aircrafts;

import Interfaces.IFlyable;
import Towers.WeatherTower;

public class Baloon extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherTemp = weatherTower.getWeather(this.coordinates);
        String writerToFile = "";
        String writerToFileUnregister = "";
        String temp = "Baloon#" + this.name + "(" + this.id + ") :";

        switch (weatherTemp) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 5));
                writerToFile = temp + " It's raining. Better watch out for lightings. (H -5)";
                break;
            case "SUN":
                coordinates = new Coordinates((coordinates.getLongitude() + 2), coordinates.getLatitude(), (coordinates.getHeight() + 4));
                writerToFile = temp + "Some sun light, lets take some pictures. (Long +2 H +4)";
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 3));
                writerToFile = temp + " I cant see anything! (H -3)";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 15));
                writerToFile = temp + " Its snowing out here. (H -15)";
                break;
        }
        System.out.println(writerToFile);

        if (this.coordinates.getHeight() <= 0) {
            writerToFileUnregister =  "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.";
            System.out.println(writerToFileUnregister);
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        String writeTo = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.";
        System.out.println(writeTo);
    }
}

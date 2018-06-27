package Aircrafts;

import Interfaces.IFlyable;
import Towers.WeatherTower;

public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String temp = "Helicopter#" + this.name + "(" + this.id + ") :";
        String writerToFile = "";
        String writerToFileUnregister = "";
        String weatherTemp = weatherTower.getWeather(this.coordinates);

        switch (weatherTemp) {
            case "RAIN":
                coordinates = new Coordinates((coordinates.getLongitude() + 5), coordinates.getLatitude(), coordinates.getHeight());
                writerToFile = temp + " It's raining. Better watch out for lightings. (Long +5)";
                break;
            case "SUN":
                coordinates = new Coordinates((coordinates.getLongitude() + 10), coordinates.getLatitude(), coordinates.getHeight() + 2);
                writerToFile = temp + "Some sun light, lets take some pictures. (Long +10 H +2)";
                break;
            case "FOG":
                coordinates = new Coordinates((coordinates.getLongitude() + 1), coordinates.getLatitude(), coordinates.getHeight());
                writerToFile = temp + " I cant see anything! (Long +1)";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 12));
                writerToFile = temp + " Its snowing out here, going down . (H -12)";
                break;
        }

        System.out.println(writerToFile);
        if (this.coordinates.getHeight() <= 0) {
            writerToFileUnregister = "Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.";
            System.out.println(writerToFileUnregister);
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String writeTo = "Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.";
        this.weatherTower = weatherTower;
        System.out.println(writeTo);
    }
}

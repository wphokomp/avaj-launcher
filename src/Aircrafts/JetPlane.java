package Aircrafts;

import Interfaces.IFlyable;
import Towers.WeatherTower;

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String temp = "JetPlane#" + this.name + "(" + this.id + ") :";
        String writerToFile = "";
        String writerToFileUnregister = "";
        String weatherTemp = _weatherTower.getWeather(this.coordinates);

        switch (weatherTemp) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 5), coordinates.getHeight());
                writerToFile = temp + " It's raining. Better watch out for lightings.";
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 10), (coordinates.getHeight() + 2));
                writerToFile = temp + "Some sun light, lets take some pictures";
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 1), coordinates.getHeight());
                writerToFile = temp + " I cant see anything!";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 7));
                writerToFile = temp + " Its snowing out here.";
                break;
        }
        System.out.println(writerToFile);
        if (this.coordinates.getHeight() <= 0)
        {
            writerToFileUnregister = "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.";
//            _weatherTower.writeToFile("write", writerToFileUnregister);
            System.out.println(writerToFileUnregister);
            _weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String writeTo = "Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.";
        this._weatherTower = weatherTower;
//        _weatherTower.writeToFile("write", writeTo);
        System.out.println(writeTo);
    }
}

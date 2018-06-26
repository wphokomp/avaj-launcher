package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.Coordinates;
import za.co.wethinkcode.interfaces.IFlyable;

public class AircraftFactory {
    public static IFlyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Helicopter helicopter;
        Balloon balloon;
        JetPlane jetPlane;

        switch (type) {
            case "Helicopter":
                helicopter = new Helicopter(name, coordinates);
                return helicopter;
            case "Baloon":
                balloon = new Balloon(name, coordinates);
                return balloon;
            case "JetPlane":
                jetPlane = new JetPlane(name, coordinates);
                return jetPlane;
            default:
                return null;
        }
    }
}

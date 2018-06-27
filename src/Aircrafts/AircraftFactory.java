package Aircrafts;

import Interfaces.IFlyable;

public class AircraftFactory {
    public static IFlyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception{
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Helicopter helicopter;
        Baloon baloon;
        JetPlane jetPlane;

        switch (type) {
            case "Baloon":
                baloon = new Baloon(name, coordinates);
                return baloon;
            case "Helicopter":
                helicopter = new Helicopter(name, coordinates);
                return helicopter;
            case "JetPlane":
                jetPlane = new JetPlane(name, coordinates);
                return jetPlane;
             default:
                 throw new Exception("Aircraft type is not recognised");
        }
    }
}

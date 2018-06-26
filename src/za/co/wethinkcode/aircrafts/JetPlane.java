package za.co.wethinkcode.aircrafts;

import za.co.wethinkcode.Aircraft;
import za.co.wethinkcode.Coordinates;
import za.co.wethinkcode.WeatherTower;
import za.co.wethinkcode.interfaces.IFlyable;

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        _weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower");
        _weatherTower.register(this);
    }

    @Override
    public void updateConditions() {
        if (coordinates.getHeight() <= 0) {
            _weatherTower.unregister(this);
        }
    }
}

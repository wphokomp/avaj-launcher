package za.co.wethinkcode.interfaces;

import za.co.wethinkcode.WeatherTower;

public interface IFlyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}

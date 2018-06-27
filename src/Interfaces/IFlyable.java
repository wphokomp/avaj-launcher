package Interfaces;

import Towers.WeatherTower;

public interface IFlyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}

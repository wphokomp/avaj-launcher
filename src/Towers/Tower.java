package Towers;

import Interfaces.IFlyable;
import java.util.ArrayList;

public class Tower {
    private ArrayList<IFlyable> observers = new ArrayList<>();
    private ArrayList<IFlyable> unregistered = new ArrayList<>();

    public void register(IFlyable flyable) {
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregister(IFlyable flyable) {

        if (unregistered.contains(flyable))
            return;
        unregistered.add(flyable);
    }

    public void conditionsChanged() {
        for (IFlyable flyable : observers) {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    }
}

package za.co.wethinkcode;

import za.co.wethinkcode.interfaces.IFlyable;

import java.util.ArrayList;

public class Tower {
    private ArrayList<IFlyable> observers;
    private ArrayList<IFlyable> unregister;

    public void register(IFlyable flyable) {
        observers.add(flyable);
    }

    public void unregister(IFlyable flyable) {
        unregister.add(flyable);
    }

    protected void conditionsChanged() {
        observers.removeAll(unregister);
    }
}

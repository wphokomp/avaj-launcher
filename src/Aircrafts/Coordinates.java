package Aircrafts;

public class Coordinates {
    int longitude;
    int latitude;
    int height;

    Coordinates(int longitude, int latitude, int height) {
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}

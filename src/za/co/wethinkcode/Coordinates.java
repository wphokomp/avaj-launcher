package za.co.wethinkcode;

public class Coordinates {
    int longitude;
    int latitude;
    int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }
}

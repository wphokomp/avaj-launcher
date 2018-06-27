package Aircrafts;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idContainer;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return (++idContainer);
    }
}

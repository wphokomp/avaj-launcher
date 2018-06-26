package za.co.wethinkcode;
import java.util.Random;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.coordinates = coordinates;
        this.name = name;
        this.id = nextId();
    }

    private long nextId() {
        //generate new id
        Random rand = new Random();
        //increment number of generated id's since instance
        idCounter++;
        return (rand.nextInt(50) + 1);
    }
}

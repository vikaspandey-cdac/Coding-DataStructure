package transferwise;

public class Cyclist {

    int id;
    int distance;
    int speed;

    public Cyclist(int id, int distance, int speed) {
        this.id = id;
        this.distance = distance;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public int getSpeed() {
        return speed;
    }
}


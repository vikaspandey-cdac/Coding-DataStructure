package transferwise;

public class Path {
    int cityId, speed, remaining_distance, time_spent;

    public Path(int cityId, int speed, int remaining_distance, int time_spent) {
        this.cityId = cityId;
        this.speed = speed;
        this.remaining_distance = remaining_distance;
        this.time_spent = time_spent;
    }

    public int getCityId() {
        return cityId;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRemaining_distance() {
        return remaining_distance;
    }

    public int getTime_spent() {
        return time_spent;
    }
}

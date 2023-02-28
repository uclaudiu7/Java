package week2;

enum roadType{
    HIGHWAY, EXPRESS, COUNTRY
}
public class Road {
    roadType type;
    int length;
    int speedLimit;

    public Road(roadType type, int length, int speedLimit) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public roadType getType() {
        return type;
    }

    public void setType(roadType type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}

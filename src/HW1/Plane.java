package HW1;

public class Plane implements Movable, Comparable {
    public static final int HEIGHT_LIMIT = 1500;
    int licenceNumber;
    Location source, destination;
    int maximalHeight;

    public Plane(int id, Location src, Location dst, int maxHeight) {
        licenceNumber = id;
        source = src;
        destination = dst;
        maximalHeight = maxHeight;
    }

    @Override
    public String toString() {
        return String.format("licence = %d, source = %s, destination = %s, maxHeight = %d",
                licenceNumber, source, destination, maximalHeight);
    }

    @Override
    public String getType() {
        return "Plane";
    }

    @Override
    public int getId() {
        return licenceNumber;
    }

    @Override
    public Location getSource() {
        return source;
    }

    @Override
    public Location getDestination() {
        return destination;
    }

    @Override
    public String getCurrentLocation() {
        // the plane is currently located at it's source
        return String.format("%s", source);
    }

    @Override
    public void move() {
        // swap the source and destination using a temp value
        Location temp = source;
        source = destination;
        destination = temp;
    }

    @Override
    // It is presumed that the Object passed is of type Plane
    public int compareTo(Object o) {
        // o is cast to a Plane and the maximalHeight difference between o and p is
        // returned
        Plane p = (Plane) o;
        return this.maximalHeight - p.maximalHeight;
    }
}

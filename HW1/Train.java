public class Train implements Comparable, Movable {
    public static final int PASSENGER_LIMIT = 500;
    public static final int STATION_LIMIT = 5;
    int licenceNumber;
    Location source, destination;
    int numberOfStations;
    int currentStation;
    int maximalPassenger;

    public Train(int id, Location src, Location dst, int numOfStations, int maxPassengers) {
        licenceNumber = id;
        source = src;
        destination = dst;
        numberOfStations = numOfStations;
        currentStation = 0;
        maximalPassenger = maxPassengers;
    }

    @Override
    public String toString() {
        return String.format("licence = %d, source = %s, destination = %s, station = %d, maxPassengers = %d",
                licenceNumber, source, destination, currentStation, maximalPassenger);
    }

    @Override
    public String getType() {

        return "Train";
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
        String returnString = "station" + String.valueOf(currentStation) + "between" + source.name() + "and"
                + destination.name();
        return currentStation > 0 ? returnString : source.name();
    }

    @Override
    public void move() {
        if (currentStation + 1 == numberOfStations) {
            currentStation = 0;

            Location temp = source;
            source = destination;
            destination = temp;
        } else {
            currentStation++;
        }
    }

    @Override
    public int compareTo(Object o) {
        // compares the maximal flight altitude between objects
        Train train = (Train) o;

        if (this.maximalPassenger > train.maximalPassenger)
            return 1;
        if (this.maximalPassenger < train.maximalPassenger)
            return -1;
        return 0;
    }
}

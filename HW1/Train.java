public class Train implements Comparable, Movable{
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
        //return source if currently located there
        if (currentStation == 0) {
            return String.format("%s", source);
        }
        //otherwise return the current station
        else {
            return String.format("station %d between %s and %s", currentStation, source, destination);
        }
    }

    @Override
    public void move() {
        //move on to next station
        ++currentStation;
        //swap direction if currently at the last station
        if (currentStation == numberOfStations) {
            Location temp = source;
            source = destination;
            destination = temp;
            currentStation = 0;
        }
    }

    @Override
    //It is presumed that the Object passed is of type Train
    public int compareTo(Object o) {
        //o is cast to a Train and the maximalPassenger difference between o and t is returned
        Train t = (Train)o;
        return this.maximalPassenger - t.maximalPassenger;
    }
}

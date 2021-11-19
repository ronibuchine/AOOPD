import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class TwoDPoint implements Clusterable<TwoDPoint> {
	double x;
	double y;

	public TwoDPoint(String str) {
		this.x = Double.parseDouble(str.split(",")[0]);
		this.y = Double.parseDouble(str.split(",")[1]);
	}

	public TwoDPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double distance(TwoDPoint other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}

	public static Set<TwoDPoint> readClusterableSet(String path) throws IOException {
		Stream<String> readStream = Files.lines(Paths.get(path));
		Set<TwoDPoint> set = new HashSet<>();
		readStream.map(x -> set.add(new TwoDPoint(x)));
		return set;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object other) {
		TwoDPoint otherP = (TwoDPoint) other;
		return (otherP.x == x && otherP.y == y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
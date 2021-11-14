import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BitArray implements Clusterable<BitArray> {
	private ArrayList<Boolean> bits;

	public BitArray(String str) {
		this.bits = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		words.addAll(Arrays.asList(str.split(",")));
		this.bits.addAll(words.stream().map(x -> x.equals("true") ? true : false).collect(Collectors.toList()));
	}

	public BitArray(boolean[] bits) {
		this.bits = new ArrayList<>();
		Stream<Boolean> boolStream = IntStream.range(0, bits.length).mapToObj(index -> bits[index]);
		this.bits.addAll(boolStream.collect(Collectors.toList()));
	}

	@Override
	public double distance(BitArray other) {
		IntStream indices = IntStream.range(0, this.bits.size());
		return indices.map(i -> this.bits.get(i) == other.bits.get(i) ? 1 : 0).sum();
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {

		Stream<String> readStream = Files.lines(Paths.get(path));

		List<Integer> lengths = readStream.map(x -> x.split(",")).map(x -> x.length).collect(Collectors.toList());
		Integer length = Collections.max(lengths);

		Set<BitArray> set = new HashSet<>();
		readStream.map(x -> x.split(",")).filter(x -> x.length == length).map(x -> String.join(",", x))
				.map(x -> new BitArray(x)).forEach(set::add);

		return set;

	}

	@Override
	public String toString() {
		return bits.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BitArray bitArray = (BitArray) o;
		return bits.equals(bitArray.bits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bits);
	}
}

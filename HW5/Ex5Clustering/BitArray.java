import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

		// add each comma-seperated-value of str to an ArrayList words
		ArrayList<String> words = new ArrayList<>();
		words.addAll(Arrays.asList(str.split(",")));

		// convert the Strings to boolean values and add the result to bits
		this.bits.addAll(words.stream().map(bit -> bit.equals("true")).collect(Collectors.toList()));
	}

	public BitArray(boolean[] bits) {
		this.bits = new ArrayList<>();

		// convert the given boolean array to a stream
		Stream<Boolean> boolStream = IntStream.range(0, bits.length).mapToObj(index -> bits[index]);

		// convert the stream to a List and add the result to bits
		this.bits.addAll(boolStream.collect(Collectors.toList()));
	}

	@Override
	public double distance(BitArray other) {
		IntStream indices = IntStream.range(0, this.bits.size());

		// every matching index is marked as 0, non=matching index marked as 1, so the sum returned is the hamming distance
		return indices.map(i -> this.bits.get(i) == other.bits.get(i) ? 0 : 1).sum();
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {

		// read each line in the file into a stream
		Stream<String> readStream1 = Files.lines(Paths.get(path));

		// find the length of each line, and return the max
		List<Integer> lengths = readStream1.map(line -> line.split(","))
					.map(stringArr -> stringArr.length)
					.collect(Collectors.toList());
		Integer length = Collections.max(lengths);

		// read each line in the file into a stream again
		Stream<String> readStream2 = Files.lines(Paths.get(path));

		// of the lines that are of the length found above, construct BitArrays from them and add them to a set
		Set<BitArray> set = readStream2.map(line -> line.split(","))
					.filter(stringArr -> stringArr.length == length)
					.map(stringArr -> String.join(",", stringArr))
					.map(line -> new BitArray(line))
					.collect(Collectors.toSet());

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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AgglomerativeClustering<T extends Clusterable<T>> implements Clustering<T> {
	double threshold;

	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	public double DistanceBetweenSets(Set<T> set1, Set<T> set2) {

	}

	public Set<Set<T>> clusterSet(Set<T> elements) {
		Set<Set<T>> clusters = new HashSet<>();
		elements.stream().map(x ->clusters.add(new HashSet<>(Arrays.asList(x))));
		
		while (clusters.size() > 1) {
			
			// find the 2 closest items (c1 and c2)
			clusters.stream().flatMap(cluster1 -> Stream.of(cluster1) 
				.filter(cluster2 -> !cluster2.equals(cluster1).) 
				)

			double minDistance = Double.POSITIVE_INFINITY;
			Pair<T> items = new Pair<>();
			for (T item1 : clusters) {
				for (T item2 : clusters) {
					if (item1.distance(item2) < minDistance) {
						minDistance = item1.distance(item2);
						items.clear();
						items.add(item1, item2);
					}
				}
			}
			// if (distance(c1, c2) > threshhold) return clusters
			// add back to the set the set containing the union of c1 and c2
		}
		return null;
	}
}

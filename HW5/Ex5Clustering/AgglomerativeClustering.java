import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

//For seperating the TwoDPoint spiral dataset into 3 clusters, a threshold of either 2 or 3 needs to be used.

public class AgglomerativeClustering<T extends Clusterable<T>> implements Clustering<T> {
	double threshold;

	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	// find distance between two sets/clusters
	public double distanceBetweenSets(Set<T> set1, Set<T> set2) {
		
		// get pair of closest T objects, where each T is in a different set
		Optional<SimpleEntry<T,T>> closestItemPair = set1.stream()
					.flatMap(set1Item -> set2.stream()
					.map(set2Item -> new SimpleEntry<T,T>(set1Item, set2Item)))
					.min(Comparator.comparingDouble(itemPair -> itemPair.getKey().distance(itemPair.getValue())));
		
		// return distance between the T objects in the pair
		return closestItemPair.get().getKey().distance(closestItemPair.get().getValue());
	}

	public Set<Set<T>> clusterSet(Set<T> elements) {

		// initialize clusters
		Set<Set<T>> clusters = elements.stream().map(elem -> new HashSet<>(Arrays.asList(elem))).collect(Collectors.toSet());
		
		while (clusters.size() > 1) {
			
			// find the 2 closest clusters (c1 and c2)
			Optional<SimpleEntry<Set<T>, Set<T>>> closestClusters = clusters.stream().flatMap(cluster1 -> clusters.stream() 
						.filter(cluster2 -> !cluster2.equals(cluster1))
						.map(cluster2 -> new SimpleEntry<Set<T>, Set<T>>(cluster1, cluster2)))
						.min(Comparator.comparingDouble(clusterPair -> distanceBetweenSets(clusterPair.getKey(), clusterPair.getValue())));
			
			Set<T> c1 = closestClusters.get().getKey();
			Set<T> c2 = closestClusters.get().getValue();

			// if (distance(c1, c2) > threshhold) return clusters
			if (distanceBetweenSets(c1, c2) > threshold) {
				return clusters;
			}

			// add back to the set the set containing the union of c1 and c2
			clusters.remove(c1);
			clusters.remove(c2);
			c1.addAll(c2);
			clusters.add(c1);
		}

		return clusters;
	}
}

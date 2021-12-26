//package sortingClean;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Random;
// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {
    @Inject
    @Named("Quadratic") SortingAlgorithm<Integer> quadraticAlgorithm;// = new BubbleSort();
    @Inject
    @Named("NlogN") SortingAlgorithm<Integer> nlognAlgorithm;// = new QuickSort();
    @Inject
    @Named("Number") int numberOfElements;// = 100000;

    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
//        System.out.println(Arrays.toString(intsClone));
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
//        System.out.println(Arrays.toString(intsClone));

    }
}

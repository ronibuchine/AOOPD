//package sortingClean;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MainApp {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();

        algorithmRunner.runAlgorithms();
    }

    @Produces
    public @Named("Quadratic") SortingAlgorithm<Integer> quadraticAlgorithmGenerator(){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        return container.select(BubbleSort.class).get();
    }

    @Produces
    public @Named("NlogN") SortingAlgorithm<Integer> nlognAlgorithmGenerator(){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        return container.select(QuickSort.class).get();
    }

    @Produces
    public @Named("Number") int numberGenerator(){
        return 10000;
    }
}

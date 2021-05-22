import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        all(0,10,1,10000);
    }
    public static void all (int minRange, int maxRange, int rounds, int elements) throws ClassNotFoundException {
        IOutput.output(Comparing.compare(minRange,maxRange,rounds,elements,
                new BubbleSort(),
                new InsertionSort(),
                new UnstableSelectionSort(),
                new StableSelectionSort(),
                new QuickSort()));
    }
}

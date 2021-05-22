import java.util.List;

public class UnstableSelectionSort implements ISorting{
    private ICounting compareCounting = new Counting();
    private ICounting swapCounting = new Counting();
    private ICounting timeCounting = new Counting();
    private String name ="Unstable-SelectionSort";
    private boolean stabilität = false;
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean getStability() {
        return this.stabilität;
    }

    @Override
    public List<Integer> sortInteger(List<Integer> values) {
        compareCounting.setCount(0);
        swapCounting.setCount(0);
        timeCounting.setCount(System.nanoTime());
        int tempVariable; int temp_idx;
        for (int i = 0; i < values.size(); i++) {
            temp_idx= i;
            for (int j = i + 1; j < values.size(); j++) {
                // Anzahl der Vergleiche
                compareCounting.setCount((Long) compareCounting.getCount()+1);
                if (values.get(temp_idx) > values.get(j)) {
                    temp_idx = j;
                }
            }
            swapCounting.setCount((Long) swapCounting.getCount()+1);
            tempVariable = values.get(temp_idx);
            values.set(temp_idx, values.get(i));
            values.set(i, tempVariable);

        }
        timeCounting.setCount(System.nanoTime() - (Long) timeCounting.getCount());
        return values;
    }

    @Override
    public ICounting getCompareCounting() {
        return this.compareCounting;
    }

    @Override
    public ICounting getSwapCounting() {
        return this.swapCounting;
    }

    @Override
    public ICounting getTimeCounting() {
        return timeCounting;
    }
}

import java.util.List;

public class StableSelectionSort implements ISorting{
    private ICounting compareCounting = new Counting();
    private ICounting swapCounting = new Counting();
    private ICounting timeCounting = new Counting();
    private String name ="Stable-SelectionSort";
    private boolean stabilität = true;
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
        timeCounting.setCount(System.nanoTime());
        compareCounting.setCount(0);
        swapCounting.setCount(0);
        int temp_index, tempVariable;
        for (int i = 0; i < values.size() - 1; i++) {
            temp_index = i;
            for (int j = i + 1; j < values.size(); j++) {
                // Anzahl der Vergleiche
                compareCounting.setCount((Long) compareCounting.getCount() + 1);
                if (values.get(temp_index) > values.get(j)) {

                    temp_index = j;
                }
            }
            for (int k = temp_index; k > i; k--) {
                swapCounting.setCount((Long)swapCounting.getCount()+1);
                tempVariable = values.get(k);
                values.set(k, values.get(k-1));
                values.set(k-1,tempVariable);

            }
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

import java.util.List;

public class QuickSort implements ISorting{
    private ICounting compareCounting = new Counting();
    private ICounting swapCounting = new Counting();
    private ICounting timeCounting = new Counting();
    private String name ="Quick-Sort";
    private boolean stabilität = false;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean getStability() {
        return this.stabilität;
    }
    void swap(List<Integer> values, int i, int j)
    {
        int temp= values.get(i);
        values.set(i,values.get(j));
        values.set(j,temp);
        swapCounting.setCount((Long) swapCounting.getCount()+1);
    }
    public int partition(List<Integer> values, int low, int high)
    {
        int pivot = values.get(high);
        int i = (low -1);
        for(int j = low; j<= high -1 ; j++)
        {
            compareCounting.setCount((Long) compareCounting.getCount()+1);
            if(values.get(j) < pivot)
            {
                i++;
                swap(values,i,j);
            }
        }
        swap(values,i+1,high);
        return(i+1);
    }
    public List<Integer> quickSort(List<Integer> values, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(values, low ,high);
            quickSort(values, low, pi-1);
            quickSort(values, pi+1, high);
        }
        return values;
    }
    @Override
    public List<Integer> sortInteger(List<Integer> values)
    {
        swapCounting.setCount(0);
        compareCounting.setCount(0);
        timeCounting.setCount(System.nanoTime());
        quickSort(values,0,values.size()-1);
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

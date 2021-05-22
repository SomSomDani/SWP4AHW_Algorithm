import java.util.List;

public class InsertionSort implements ISorting{
    private ICounting compareCounting = new Counting();
    private ICounting swapCounting = new Counting();
    private ICounting timeCounting = new Counting();
    private String name ="InsertionSort";
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
        swapCounting.setCount(0);
        compareCounting.setCount(0);
        int temp_index, tempVariable;
        for (int i = 1; i < values.size(); i++) {
            temp_index=i;
            for(int j=0;j<i;j++)
            {
                compareCounting.setCount((Long) compareCounting.getCount()+1);
                if(values.get(j)>values.get(temp_index))
                {
                    temp_index=j;
                    break;
                }
            }
            for(int k = i;k>temp_index;k--)
            {
                swapCounting.setCount((Long) swapCounting.getCount()+1);
                tempVariable= values.get(k);
                values.set(k,values.get(k-1));
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

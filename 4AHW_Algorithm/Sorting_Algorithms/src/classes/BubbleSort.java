import java.util.List;

public class BubbleSort implements ISorting{
    private ICounting compareCounting = new Counting();
    private ICounting swapCounting = new Counting();
    private ICounting timeCounting = new Counting();
    private String name ="BubbleSort";
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
        compareCounting.setCount(0);
        swapCounting.setCount(0);
        timeCounting.setCount(System.nanoTime());
        int tempVariable;
        for(int i = 0; i < values.size();i++)
        {
            for(int j = 1 ; j<values.size() - i; j++)
            {
                compareCounting.setCount((Long)compareCounting.getCount() +1);
                if(values.get(j-1) > values.get(j))
                {
                    swapCounting.setCount((Long) swapCounting.getCount()+1);
                    tempVariable = values.get(j-1);
                    values.set(j-1, values.get(j));
                    values.set(j,tempVariable);
                }
            }
        }
        timeCounting.setCount(System.nanoTime()- (Long)timeCounting.getCount());
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

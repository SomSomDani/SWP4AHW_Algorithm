public class Counting implements ICounting{
    private Long counter = Long.valueOf(0);

    @Override
    public void setCount(Object counter) {
        if(counter.getClass() == Long.class)
        {
            this.counter = (Long) counter;
        }
    }

    @Override
    public Object getCount() {
        return counter;
    }
}

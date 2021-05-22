import java.util.List;

public interface ISorting {
    public String getName();
    public boolean getStability();
    public List<Integer> sortInteger(List<Integer> values);
    public ICounting getCompareCounting();  //Vergleiche
    public ICounting getSwapCounting();     //Tauschungen
    public ICounting getTimeCounting();     //Zeit beim Durchlaufen
}

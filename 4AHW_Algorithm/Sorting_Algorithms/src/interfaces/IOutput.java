public interface IOutput {
    public static void output(String... values)
    {
        for(String value : values)
        {
            System.out.println(value);
        }
    }
}

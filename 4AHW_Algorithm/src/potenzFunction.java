import java.util.Scanner;
public class potenzFunction {
	static Scanner scanner = new Scanner(System.in);
	static double number;
	static double hochzahl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Geben Sie eine Zahl ein: ");
			number = scanner.nextDouble();
			System.out.println("Geben Sie die Hochzahl ein:");
			hochzahl = scanner.nextDouble();
			System.out.println(potenzSequence(number,hochzahl));
	}
	public static double potenzSequence(double number,double hochzahl)
	{
		if(hochzahl < 0)
		{
			return 1 / potenzSequence(number, -hochzahl);
		}
		if(hochzahl == 0)
		{
			return 1;
		}
		return number * potenzSequence(number, hochzahl-1);
	}
}

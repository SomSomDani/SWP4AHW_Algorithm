import java.util.Scanner;

public class fibonacci_berechnung {
	static Scanner scanner = new Scanner(System.in);
	static double number;
	public static void main(String[] args)
	{
		System.out.println("Geben Sie eine Zahl ein: ");
		number = scanner.nextDouble(); 
		System.out.println(fibonacciSequence(number)); 		// Ausgabe der gesuchten Fibonacci-Zahl
	}
	public static double fibonacciSequence(double number)
	{	if(number >= 0)
		{
			if(number==0)
				return 0;
			if(number == 1)
				return 1;
			else
				return fibonacciSequence(number-1) + fibonacciSequence(number-2);
		}
		else
		{
			number = 0;
			return number;
		}
	}
}

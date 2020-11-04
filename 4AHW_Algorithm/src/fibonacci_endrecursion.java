import java.util.Scanner;

public class fibonacci_endrecursion {
	static Scanner scanner = new Scanner(System.in);
	static int n;
	public static void main(String[] args)
	{
		System.out.println("Geben Sie eine Zahl ein: ");
		n = scanner.nextInt(); 
		System.out.println(fibonacci(n));
	}
	public static int endrecursionFibonacci(int n, int fbn1, int fbn2)
	{
		System.out.println(n + " " + fbn1 + " " + fbn2);
		if(n<=1)
		{
			return fbn1+fbn2;
		}
		else
		{
			return endrecursionFibonacci(n-1, fbn2+fbn1, fbn1);
		}
	}
	public static  int fibonacci(int n)
	{
		return endrecursionFibonacci(n-1,1,0);
	}
}

import java.util.Scanner;

// Diese Aufgabe sollte uns zeigen, dass er mehrere Arten von Sortierungen gibt und welche am Schnellsten oder am Langsamten ist
// Aufgabe vom 9.12.2020 bis 16.12.2020

public class InsertionSort {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort ob = new InsertionSort();
		int arr[] = new int [100];
		int highestNumber = 200;
		System.out.println("Filling array with random numbers:");
		if(scanner.next().equals("y"))
		{
			for(int i = 0; i <arr.length; i++)
			{
				arr[i] = (int)(Math.random()*highestNumber);
			}
		}
		final long timeStart = System.currentTimeMillis();
		System.out.println("Unsorted Array:");
		printArray(arr);
		System.out.println("Sorting begins!");
		ob.sort(arr);
		final long timeEnd= System.currentTimeMillis();
		System.out.println("Time for sorting the array:" + (timeEnd-timeStart) + " milliseconds");
		printArray(arr);
		
	}
	public static void printArray(int arr[])
	{
		int n = arr.length;
		
		for(int i = 0;i<n;i++)
		{
			System.out.println(arr[i]+ "");
		}
		System.out.println();
		
	}
	public void sort (int arr[])
	{
		int n = arr.length;
		for(int i = 1; i<n;i++)
		{
			int key = arr[i];
			int j = i-1;
			
			while(j>= 0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = key;
		}
	}

}

import java.util.Random;
import java.util.Scanner;

// Diese Aufgabe sollte uns zeigen, dass er mehrere Arten von Sortierungen gibt und welche am Schnellsten oder am Langsamten ist
// Aufgabe vom 9.12.2020 bis 16.12.2020

public class InsertionSort {
	static Scanner scanner = new Scanner(System.in);
	static int index, temp = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort ob = new InsertionSort();
		int arr[] = new int [10];
		int arrTemp[] = new int [10];
		int highestNumber = 20;
		System.out.println("Filling array with random numbers:");
		if(scanner.next().equals("y"))
		{
			for(int i = 0; i <arr.length; i++)
			{
				arr[i] = (int)(Math.random()*highestNumber);
				
			}
			for(int i = 0; i<arrTemp.length;i++)
			{
				arrTemp[i] = (int) (Math.random()*highestNumber);
			}
		}
		final long timeStart = System.currentTimeMillis();
		System.out.println("Unsorted Array:");
		printArray(arr);
		System.out.println("Sorting begins!");
		printArray(arr);
		System.out.println("Sorting upwards, downwards or Lotto [U,D,L]");
		switch (scanner.next().toUpperCase())	// Cases to use the right option to sort the array
		{
			case "U":
				ob.sortUpwards(arr);
				printArray(arr);
				final long timeEnd= System.currentTimeMillis();
				System.out.println("Time for sorting the array:" + (timeEnd-timeStart) + " milliseconds");	
			break;
			case "D":
				ob.sortDownwards(arr);
				printArray(arr);
				final long timeEnd2= System.currentTimeMillis();
				System.out.println("Time for sorting the array:" + (timeEnd2-timeStart) + " milliseconds");
			break;
			case "L":
				ob.sortLotto(arr, arrTemp);
				printArray(arr);
				final long timeEnd3= System.currentTimeMillis();
				System.out.println("Time for sorting the array:" + (timeEnd3-timeStart) + " milliseconds");
			break;
		}
		
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
	public void sortUpwards (int arr[])
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
	public void sortDownwards(int arr[])
	{
		int n;
		for(int i = 1; i< arr.length;i++)
		{
			for(int j = 0; j<arr.length-i;j++)
			{
				if(arr[j]<arr[j+1])
				{
					n = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=n;
				}
			}
		}
	}
	public void sortLotto(int arr[], int arrTemp[])
	{
		for (int i = 0; i < arr.length; i++) {
            Random rnd = new Random();
            index = rnd.nextInt(arrTemp.length - i);
            arr[i] = arrTemp[index];
            temp = arrTemp[arrTemp.length - i - 1];
            arrTemp[arrTemp.length - i - 1] = arrTemp[index];
            arrTemp[index] = temp;
        }
	}
}

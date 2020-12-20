import java.util.Scanner;

public class BubbleSort {
	static Scanner scanner = new Scanner(System.in);
		static int counter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort ob = new BubbleSort();
		int arr[] = new int[1000];
		int highestNumber  = 1000;
		
		final long timeStart = System.currentTimeMillis();
		
		for(int i = 0; i <arr.length; i++)
		{
			arr[i] = (int)(Math.random()*highestNumber);
		}
		System.out.println("Unsorted array");
		ob.printArray(arr);
		System.out.println("Start sorting process");
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
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
				ob.sortLotto(arr);
				printArray(arr);
				final long timeEnd3= System.currentTimeMillis();
				System.out.println("Time for sorting the array:" + (timeEnd3-timeStart) + " milliseconds");
			break;
		}
		final long timeEnd= System.currentTimeMillis();
		System.out.println("Time for sorting the array:" + (timeEnd-timeStart) + " milliseconds");
		System.out.println("Schritte:" + counter);
		System.out.println("No Double Number:");
		ob.printArray(arr);
	}
	public void bubbleSort(int arr[])
	{
		int n = arr.length;
		for(int i = 0; i< n-1; i++)
		{
			for(int j= 0; j < n-i-1;j++)
			{
				if(arr[j]> arr[j+1])
				{
					counter ++;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
	}
	public static void printArray(int arr[])
	{
		int n = arr.length;
		for(int i = 0; i<n; i++)
		{
			System.out.print(arr[i]+ "");
			System.out.println();
		}
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
	public void sortLotto(int arr[])
	{
		int n = 0;
		int number;
		for(int i = 0; i<arr.length;i++)
		{
			 if(arr[i] == n)
			 {
				 number = n;
				 if(arr[arr.length] < number)
				 {
					 n = arr[arr.length];
					 arr[arr.length] = number;
				 }
			 }
		}
	}
}

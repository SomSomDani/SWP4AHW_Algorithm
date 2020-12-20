import java.util.Scanner;

// Diese Aufgabe sollte uns zeigen, dass er mehrere Arten von Sortierungen gibt und welche am Schnellsten oder am Langsamten ist
// Aufgabe vom 9.12.2020 bis 16.12.2020

public class InsertionSort {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort ob = new InsertionSort();
		int arr[] = new int [10];
		int highestNumber = 20;
		int searchNumber = 10;
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
		binaerSearch(arr, searchNumber);
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
				ob.sortLotto(arr);
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
	public static boolean binaerSearch(int[] arr, int searchNumber) {
        int minNumber=0;
        int maxNumber = arr.length;

        int middle=(minNumber+maxNumber)/2;
        while(arr[middle] != searchNumber && minNumber <= maxNumber ){
            middle=(minNumber+maxNumber)/2;

            if(searchNumber > arr[middle]){
                minNumber=middle+1;
            }
            if(searchNumber < arr[middle] ){
                maxNumber=middle-1;
            }
        }
        if(arr[middle]==searchNumber){
            return true;
        }
        else{
            return  false;
        }

    }
}

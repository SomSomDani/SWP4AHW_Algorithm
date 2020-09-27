import java.util.Scanner;

public class BinarySearch_01_Algorithm {

	static Scanner scan = new Scanner (System.in);			//Scanner für das einlesen der Search Variable
	
	public static int binarySearch(int[] arr, int search, int lowestNumber, int highestNumber)
	{
		int index = -1;
		while (lowestNumber <= highestNumber)				// While Schleife zum durchgehen der Zahlen im Array
		{
			int mid = (lowestNumber + highestNumber) /2;
			if(arr[mid] < search)
			{
				lowestNumber = mid + 1;
			}
			else if(arr[mid] > search)
			{
				highestNumber = mid -1;
			}
			else if(arr[mid] == search)
			{
				index = mid;
				break;
			}
		}
		return index;
	}
	public static int sequentiel_Seach(int[] arr, int search)
	{
		for(int i = 0; i < arr.length; i++) 
		{
			arr[i] = i + (int)Math.random()*100;
			return arr[i];
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [100];							// Erzeugen eines 100 Arrays
		int search = scan.nextInt();
		
		int lowestNumber = 0;
		int highestNumber = arr.length-1;
		int index = binarySearch(arr,search,lowestNumber,highestNumber);
		if(index != -1)
		{
			System.out.println(search+"Die Zahl befindet sich im Array");
		}
		else
		{
			System.out.println(search+"Die Zahl existiert nicht im Array");
		}
	}

}

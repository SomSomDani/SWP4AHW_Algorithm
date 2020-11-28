
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort ob = new BubbleSort();
		int arr[] = new int[50];
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
		final long timeEnd= System.currentTimeMillis();
		System.out.println("Time for sorting the array:" + (timeEnd-timeStart) + " milliseconds");
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
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
	}
	public void printArray(int arr[])
	{
		int n = arr.length;
		for(int i = 0; i<n; i++)
		{
			System.out.print(arr[i]+ "");
			System.out.println();
		}
	}
}

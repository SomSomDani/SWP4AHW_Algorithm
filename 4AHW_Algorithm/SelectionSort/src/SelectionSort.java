import java.util.ArrayList;

public class SelectionSort {
    static int countSelectionSort;
    static int countSelectionSortStable;
    static int countBubbleSort;
    static int countAVGSelectionSort;
    static int countAVGSelectionSortStable;
    static int countAVGBubbleSort;
    public static void main(String[] args) {
        for(int i = 0; i <= 100; i++)
        {
            int[] arr = new int[10000];
            int n = arr.length;
            int range = 1000;
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int) (Math.random() * range);
            }
            bubbleSort(arr,n);
            selectionSort(arr,n);
            selectionSortStable(arr,n);

        }
        System.out.println(countSelectionSort);
        System.out.println(countSelectionSortStable);
        System.out.println(countBubbleSort);
        System.out.println(countAVGSelectionSort);
        System.out.println(countAVGSelectionSortStable);
        System.out.println(countAVGBubbleSort);
    }
    public static int selectionSort(int arr[], int n)
    {
        countSelectionSort = 0;
        for(int i= 0;i<n-1;i++)
        {
            int min_idx = i;
            for(int j = i+1;j<n;j++)
            {
                if(arr[j] < arr[min_idx])
                {
                    min_idx = j;
                }
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                countSelectionSort++;
            }
        }
        countAVGSelectionSort = (countSelectionSort/100);
        return countSelectionSort;
    }
    public static int selectionSortStable(int arr[],int n)
    {
        countSelectionSortStable = 0;
        for (int i = 0; i<n-1;i++)
        {
            int min = i;
            for (int j = i+1; j <n;j++)
            {
                if(arr[min]>arr[j])
                {
                    min = j;
                }
                int key = arr[min];
                while(min>i)
                {
                    arr[min] = arr[min-1];
                    min--;
                }
                arr[i] = key;
                countSelectionSortStable++;
            }
        }
        countAVGSelectionSortStable = (countSelectionSortStable / 100);
        return countSelectionSortStable;
    }
    public static int bubbleSort(int arr[], int n)
    {
        countBubbleSort= 0;
        for (int i = 0; i< n-1; i++)
        {
            for(int j = 0; j<n-i-1;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    countBubbleSort++;
                }
            }
        }
        countAVGBubbleSort = (countBubbleSort/100);
        return countBubbleSort;
    }
}

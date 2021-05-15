
public class SelectionSort {
    static int countSelectionSort;
    static int countSelectionSortStable;
    static int countBubbleSort;
    static int swapSelectionSort;
    static int swapSelectionSortStable;
    static int swapBubbleSort;
    static int countInsertionSort;
    static int swapInsertionSort;
    static int swapQuickSort;
    static int countQuickSort;
    static double calc;
    static long dauer1;
    static long dauer2;
    static long dauer3;
    static long dauer4;
    static long dauer5;
    static long startdauer1;
    static long startdauer2;
    static long startdauer3;
    static long startdauer4;
    static long startdauer5;
    static long enddauer1;
    static long enddauer2;
    static long enddauer3;
    static long enddauer4;
    static long enddauer5;

    public static void main(String[] args) {
        for (int i = 0; i <= 0; i++) {
            int[] arr = new int[1000];
            int range = 10;

            randomArray(arr, range);
            bubbleSort(arr);
            average(arr);
            //printArray(arr);

            randomArray(arr, range);
            selectionSort(arr);
            average(arr);
            //printArray(arr);

            randomArray(arr, range);
            selectionSortStable(arr);
            average(arr);
            //printArray(arr);

            randomArray(arr, range);
            insertionSort(arr);
            average(arr);
            //printArray(arr);

            randomArray(arr, range);
            quickSort(arr, 0, arr.length-1);
            average(arr);

        }
        System.out.println("UnstableSelektionSort: ");
        System.out.println("Vergleichoperationen: " + countSelectionSort);
        System.out.println("Tauschoperationen: " + swapSelectionSort);
        System.out.println("Dauer: " + dauer1);
        System.out.println("");

        System.out.println("SelektionSortStable: ");
        System.out.println("Vergleichoperationen: " + countSelectionSortStable);
        System.out.println("Tauschoperationen: " + swapSelectionSortStable);
        System.out.println("Dauer: " + dauer2);
        System.out.println("");

        System.out.println("BubbleSort: ");
        System.out.println("Vergleichoperationen: " + countBubbleSort);
        System.out.println("Tauschoperationen: " + swapBubbleSort);
        System.out.println("Dauer: " + dauer3);
        System.out.println("");

        System.out.println("InsertionSort: ");
        System.out.println("Vergleichoperationen: " + countInsertionSort);
        System.out.println("Tauschoperationen: " + swapInsertionSort);
        System.out.println("Dauer: " + dauer4);
        System.out.println("");

        System.out.println("QuickSort: ");
        System.out.println("Vergleichoperationen: " + countInsertionSort);
        System.out.println("Tauschoperationen: " + swapInsertionSort);
        System.out.println("Dauer: " + dauer5);
        System.out.println("");
    }

    public static int selectionSort(int[] arr) {
        startdauer1 = System.nanoTime();
        countSelectionSort = 0;
        swapSelectionSort = 0;
        for (int i = 0; i < arr.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                // Anzahl der Vergleiche
                countSelectionSort++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            swapSelectionSort++;
        }
        enddauer1 = System.nanoTime();
        dauer1 = enddauer1 - startdauer1;
        return 0;
    }

    public static int selectionSortStable(int[] arr) {
        startdauer2 = System.nanoTime();
        countSelectionSortStable = 0;
        swapSelectionSortStable = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                // Anzahl der Vergleiche
                countSelectionSortStable++;
                if (arr[min] > arr[j]) {

                    min = j;
                }
            }
            for (int k = min; k > i; k--) {
                int temp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = temp;
                swapSelectionSortStable++;
            }
        }
        enddauer2 = System.nanoTime();
        dauer2 = enddauer2 - startdauer2;
        return 0;
    }

    public static int bubbleSort(int[] arr) {
        startdauer3 = System.nanoTime();
        countBubbleSort = 0;
        swapBubbleSort = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Anzahl der Vergleiche
                countBubbleSort++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // Anzahl der Tauschoperationen
                    swapBubbleSort++;
                }
            }
        }
        enddauer3 = System.nanoTime();
        dauer3 = enddauer3 - startdauer3;
        return 0;
    }

    public static int insertionSort(int[] arr) {
        startdauer4 = System.nanoTime();
        countInsertionSort = 0;
        swapInsertionSort = 0;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            countInsertionSort++;
            while (j >= 0 && arr[j] > key) {
                countInsertionSort++;
                swapInsertionSort++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        swapInsertionSort++;
        enddauer4 = System.nanoTime();
        dauer4 = enddauer4 - startdauer4;
        return 0;
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition (int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low -1);
        for(int j = low; j<= high -1 ; j++)
        {
            countQuickSort++;
            if(arr[j] < pivot)
            {
                i++;
                swap(arr,i,j);
                swapQuickSort++;
            }
        }
        swap(arr,i+1,high);
        return(i+1);
    }
    static void quickSort(int[] arr, int low, int high)
    {
        startdauer5 = System.nanoTime();
        if(low < high)
        {
            int pi = partition(arr, low ,high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
        enddauer5 = System.nanoTime();
        dauer5 = enddauer5 - startdauer5;
    }
    public static double average(int[] arr) {
        calc = 0;
        for (int i = 0; i < arr.length; i++) {
            calc = calc + arr[i];
        }
        return (calc / arr.length);
    }

    public static double median(int[] arr) {
        calc = arr[arr.length / 2];
        return calc;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a);
            System.out.print(",");
        }
        System.out.println("");
    }

    private static void randomArray(int[] arr, int range) {
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (int) (Math.random() * range);
        }
    }
}

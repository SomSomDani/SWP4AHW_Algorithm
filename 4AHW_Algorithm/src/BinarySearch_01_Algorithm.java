import java.util.Arrays;
import java.util.*;
import java.util.Random;

public class BinarySearch_01_Algorithm {
    public static void main(String[] args) {
        System.out.println("Änderung der Spannweite erfolgt im Programm Zeile 11");
        //Deklarationen
        int startnumber=1;
        int spannweite = 1000;
        int [] numbers = new int[spannweite];
        int searchNumber = 0;
        boolean sequentiellFound;
        boolean binaerFound;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Benutzereingabe
        System.out.println("[R]andom zahlen oder [N]ormal");
        switch (scanner.nextLine().toUpperCase().charAt(0)){
            case 'N':
                //Array normal befüllen
                for(int i = 0; i < numbers.length; i++){
                    numbers[i] = startnumber;
                    startnumber++;
                }
                break;
            case'R':
                //Array random befüllen
                for(int i = 0; i < numbers.length; i++){
                    numbers[i] = random.nextInt(spannweite+1);
                    startnumber++;
                }

                Arrays.sort(numbers);
                break;
            default:
                System.out.println("Falsche Eingabe!");
                System.exit(0);
                break;
        }
        System.out.println("[R]andom Zahl oder [O]Selbst gewählte Zahl?");
        switch (scanner.nextLine().toUpperCase().charAt(0)){
            case'R':
                searchNumber= random.nextInt(spannweite+1);
                break;
            case 'O':
                System.out.println("Ihre Zahl: ");
                searchNumber = scanner.nextInt();
                break;
            default:
                System.out.println("Falsche Eingabe");
                System.exit(0);
        }




        long searchTimeBeginSeq = System.nanoTime();
        sequentiellFound = sequentiellSearch(numbers, searchNumber);
        long searchTimeEndSeq = System.nanoTime();
        long seqDifferenz = (searchTimeEndSeq-searchTimeBeginSeq);
        if(sequentiellFound==true){

            System.out.println("Zahl " + searchNumber + " in " + seqDifferenz + " Nanosekunden mithilfe Sequentieller Suche in dem Array gefunden!");
        }

        else {
            System.out.println("Zahl nicht gefunden!");
            System.exit(0);
        }

        System.out.println("Wollen Sie das Array ausgeben? [y/n]");

        if(scanner.next().charAt(0)=='y') {
            //Array ausgeben
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
            }
        }

        long searchTimeBeginBinaer = System.nanoTime();
        binaerFound = binaerSearch(numbers, searchNumber);
        long searchTimeEndBinaer = System.nanoTime();
        long binDifferenz= (searchTimeEndBinaer-searchTimeBeginBinaer);
        if(binaerFound){
            System.out.println("Zahl " + searchNumber + " in " + binDifferenz + " Nanosekunden mithilfe Binärer Suche in dem Array gefunden!");
        }
        else{
            System.out.println("nicht gefunden");
        }
        //Float zu Double, da der Wert von Float zu klein ist für so viele Nanosekunden
        double binTimeDouble = binDifferenz;
        double seqTimeDouble = seqDifferenz;
        double DifferenzSeqtoBin = (seqDifferenz - binDifferenz);
        double percentagefaster = Math.round(100*(seqTimeDouble/binTimeDouble));
        System.out.println();
        System.out.println("Vergleich: ");
        System.out.print("Sequentielles Verfahren Dauer: " + seqDifferenz + " Nanosekunden  ,  ");
        System.out.println("Binäres Verfahren Dauer: " + binDifferenz + " Nanosekunden");
        System.out.println("Daraus folgt, dass das Binaere Verfahren um " + (DifferenzSeqtoBin) +
                " Nanosekunden --> " + (percentagefaster)/100 + " mal schneller ist!");




    }
    public static boolean sequentiellSearch(int[] numbers, int searchNumber){
        for(int i=0; i < numbers.length; i++){
            if(numbers[i]==searchNumber){
                return true;
            }
        }
        return false;
    }
    public static boolean binaerSearch(int[] numbers, int searchNumber) {
        int minNumber=0;
        int maxNumber = numbers.length;

        int middle=(minNumber+maxNumber)/2;
        while(numbers[middle] != searchNumber && minNumber <= maxNumber ){
            middle=(minNumber+maxNumber)/2;

            if(searchNumber > numbers[middle]){
                minNumber=middle+1;
            }
            if(searchNumber < numbers[middle] ){
                maxNumber=middle-1;
            }
        }
        if(numbers[middle]==searchNumber){
            return true;
        }
        else{
            return  false;
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
}
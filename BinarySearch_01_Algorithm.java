import java.util.Arrays;
import java.util.*;
import java.util.Random;

public class BinarySearch_01_Algorithm {
    public static void main(String[] args) {
        System.out.println("Änderung der Spannweite erfolgt im Programm Zeile 11");
        //Deklarationen
        int zaehler=1;
        int spannweite = 10000000;
        int [] numbers = new int[spannweite];
        int searchNumber = 0;
        boolean sequentiellFound;
        boolean binaerFound;
        Random random = new Random();
        Scanner reader = new Scanner(System.in);

        //Benutzereingabe
        System.out.println("[R]andom zahlen oder [N]ormal");
        switch (reader.nextLine().toUpperCase().charAt(0)){
            case 'N':
                //Array normal befüllen
                for(int i = 0; i < numbers.length; i++){
                    numbers[i] = zaehler;
                    zaehler++;
                }
                break;
            case'R':
                //Array random befüllen
                for(int i = 0; i < numbers.length; i++){
                    numbers[i] = random.nextInt(spannweite+1);
                    zaehler++;
                }

                Arrays.sort(numbers);
                break;
            default:
                System.out.println("Falsche Eingabe!");
                System.exit(0);
                break;
        }
        System.out.println("[R]andom Zahl oder [O]Selbst gewählte Zahl?");
        switch (reader.nextLine().toUpperCase().charAt(0)){
            case'R':
                searchNumber= random.nextInt(spannweite+1);
                break;
            case 'O':
                System.out.println("Ihre Zahl: ");
                searchNumber = reader.nextInt();
                break;
            default:
                System.out.println("Falsche Eingabe");
                System.exit(0);
        }




        long startZeitSeq = System.nanoTime();
        sequentiellFound = sequentiellSearch(numbers, searchNumber);
        long endZeitSeq = System.nanoTime();
        long seqDauer = (endZeitSeq-startZeitSeq);
        if(sequentiellFound==true){

            System.out.println("Zahl " + searchNumber + " in " + seqDauer + " Nanosekunden mithilfe Sequentieller Suche in dem Array gefunden!");
        }

        else {
            System.out.println("Zahl nicht gefunden!");
            System.exit(0);
        }

        System.out.println("Kontrollieren? [J,N]");

        if(reader.next().toLowerCase().charAt(0)=='J') {
            //Array ausgeben
            for (int i = 0; i < numbers.length; i++) {
                System.out.println(numbers[i]);
            }
        }

        long startZeitBinaer = System.nanoTime();
        binaerFound = binaerSearch(numbers, searchNumber);
        long endZeitBinaer = System.nanoTime();
        long binDauer= (endZeitBinaer-startZeitBinaer);
        if(binaerFound){
            System.out.println("Zahl " + searchNumber + " in " + binDauer + " Nanosekunden mithilfe Binärer Suche in dem Array gefunden!");
        }
        else{
            System.out.println("nicht gefunden");
        }
        //Float zu Double, da Berechnung nicht funkt
        double binDauerDouble = binDauer;
        double seqDauerDouble = seqDauer;
        double wievielSchneller = Math.round(100*(seqDauerDouble/binDauerDouble));
        System.out.println();
        System.out.println("Vergleich: ");
        System.out.print("Sequentielles Verfahren Dauer: " + seqDauer + " Nanosekunden  ,  ");
        System.out.println("Binäres Verfahren Dauer: " + binDauer + " Nanosekunden");
        System.out.println("Daraus folgt, dass das Binaere Verfahren um " + (seqDauer-binDauer) +
                " Nanosekunden --> " + (wievielSchneller)/100 + " mal schneller ist!");




    }
    public static boolean sequentiellSearch(int[] zahlen, int searchNumber){
        for(int i=0; i < zahlen.length; i++){
            if(zahlen[i]==searchNumber){
                return true;
            }
        }
        return false;
    }
    public static boolean binaerSearch(int[] zahlen, int searchNumber) {
        int minNumber=0;
        int maxNumber = zahlen.length;

        int middle=(minNumber+maxNumber)/2;
        while(zahlen[middle] != searchNumber && minNumber <= maxNumber ){
            middle=(minNumber+maxNumber)/2;

            if(searchNumber > zahlen[middle]){
                minNumber=middle+1;
            }
            if(searchNumber < zahlen[middle] ){
                maxNumber=middle-1;
            }
        }
        if(zahlen[middle]==searchNumber){
            return true;
        }
        else{
            return  false;
        }

    }
}
import java.io.IOException;
import java.lang.Math;


public class AlgorithmComparison {

    public static final int NUMBER_OF_DIGITS = 10;

    public static void main(String[] args) throws IOException {

        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        RadixSort radixSort = new RadixSort();
        RandSelect randSelect = new RandSelect();

        int n1 = 400000;
        int n2 = 800000;
        double span1;
        double span2;

        System.out.println("Quicksort test:");
        span1 = calculateAverageRunTime(n1,quickSort, null);
        span2 = calculateAverageRunTime(n2,quickSort, null);
        printTimeSpans(n1, span1, n2, span2);

        System.out.println("Mergesort test:");
        span1 = calculateAverageRunTime(n1,mergeSort, null);
        span2 = calculateAverageRunTime(n2,mergeSort, null);
        printTimeSpans(n1, span1, n2, span2);

        System.out.println("RadixSort test:");
        span1 = calculateAverageRunTime(n1,radixSort, null);
        span2 = calculateAverageRunTime(n2,radixSort, null);
        printTimeSpans(n1, span1, n2, span2);

        System.out.println("RandSelect test:");
        span1 = calculateAverageRunTime(n1, null, randSelect);
        span2 = calculateAverageRunTime(n2, null, randSelect);
        printTimeSpans(n1, span1, n2, span2);
    }


    public static void printTimeSpans(int size1, double span1, int size2, double span2) {
        System.out.println("For size " + size1 +" we got time: " + span1);
        System.out.println("For size " + size2 +" we got time: " + span2);
    }


    public static double calculateAverageRunTime(int size, Sorter sorter, Selector selector) {
        RandomArrayFactory arrayFactory = new RandomArrayFactory();
        int numOfSamples = 	10;
        long total = 0;
        for (int i=0; i<numOfSamples; i++) {
            double [] ar = arrayFactory.getRandomArray(size);
            long start = System.nanoTime();
            if (sorter != null)	{
                sorter.sort(ar);
            }
            else if (selector != null){
                double retVal = selector.select(ar, (int)Math.floor(ar.length / 2));

                // FOR TESTING ONLY
                // System.out.println("Median: " + retVal);
            }

            long end = System.nanoTime();
            total += end - start;
        }
        return (total / (numOfSamples*Math.pow(10, 9))); //calculate the average, and change units from nano-seconds to seconds
    }

}
import java.util.*;
import java.text.DecimalFormat;

public class RadixSort implements Sorter{

    // Offset from which the numbers after the 0. start.
    private static final int DECIMAL_OFFSET = 2;

    /**
     * Sorts an array using radix and counting sort algorithms.
     * This method uses counting sort for every place of digit.
     * @param ar The array to be sorted
     */
    public void sort(double[] ar) {
        if (!ArraylUtils.doesArrayValid(ar)) {
            throw new RuntimeException("Given array is not valid");
        }

        // Creating an array of strings from the numbers
        String[] numAsStrings = new String[ar.length];
        for (int i =0; i < ar.length; i++) {
            numAsStrings[i] = String.format("%1$,.10f", ar[i]);
        }

        // Use counting sort at each number's place
        for(int index = AlgorithmComparison.NUMBER_OF_DIGITS - 1; index >= 0; index--){
            numAsStrings = countingSort(numAsStrings, index);
        }

        // Fill the original array, sorted this time
        for (int i =0; i < ar.length; i++) {
            ar[i] = Double.valueOf(numAsStrings[i]);
        }

    }

    /**
     * Sorts an array using counting sort algorithm.
     * @param input The array to be sorted.
     * @param index The index of the digit.
     */
    private static String[] countingSort(String[] input, int index){
        String[] out = new String[input.length];

        int[] count = new int[AlgorithmComparison.NUMBER_OF_DIGITS];

        // Set number of elements in input in count.
        for (int i = 0; i < input.length; i++){
            int digit = input[i].charAt(DECIMAL_OFFSET + index) -'0';
            count[digit] += 1;
        }

        for (int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        // Set final out array to have the sorted values after counting.
        for (int i = input.length-1; i >= 0; i--){
            int digit = input[i].charAt(DECIMAL_OFFSET + index) -'0';
            out[count[digit]-1] = input[i];
            count[digit]--;
        }

        return out;

    }

}

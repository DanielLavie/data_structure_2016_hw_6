import java.text.DecimalFormat;

public class RadixSort extends SortingAlgorithm implements Sorter{

    // Offset from which the numbers after the 0. start.
    private static final int DECIMAL_OFFSET = 2;

    /**
     * Sorts an array using radix and counting sort algorithms.
     * This method uses counting sort for every place of digit.
     * @param ar The array to be sorted
     */
    public void sort(double[] ar) {
        if (!doesArrayValid(ar)) {
            throw new RuntimeException("Given array is not valid");
        }

        for(int index = AlgorithmComparison.NUMBER_OF_DIGITS - 1; index >= 0; index--){
            // Use counting sort at each number's place
            ar = countingSort(ar, index);
        }
    }

    /**
     * Sorts an array using counting sort algorithm.
     * @param input The array to be sorted.
     * @param index The index of the digit.
     */
    private static double[] countingSort(double[] input, int index){
        double[] out = new double[input.length];

        int[] count = new int[AlgorithmComparison.NUMBER_OF_DIGITS];

        // Set number of elements in input in count.
        for(int i = 0; i < input.length; i++){
            int digit = getDigit(input[i], index);
            count[digit] += 1;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        // Set final out array to have the sorted values after counting.
        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], index);
            out[count[digit]-1] = input[i];
            count[digit]--;
        }

        return out;

    }

    /**
     * Returns digit at digitPlace from value.
     * @param value The value to get the digit from.
     * @param digitIndex The index of the digit.
     */
    private static int getDigit(double value, int digitIndex){
        DecimalFormat maxDigitsFormatter = new DecimalFormat("0.0000000000");
        String valueAsStr = maxDigitsFormatter.format(value);
        return valueAsStr.charAt(DECIMAL_OFFSET + digitIndex) -'0';
    }

}

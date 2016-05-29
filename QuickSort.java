import java.util.Arrays;
import java.util.Map;

/**
 * This class implement the quick sort algorithm
 */
public class QuickSort implements Sorter {

    private static final int MINIMUM_NUMBER_OF_ELEMENTS_FOR_QUICK_SORT = 4;

    private double array[];

    /**
     * Sort the given array with quick sort algorithm
     * @param ar    The array to be sorted
     */
    @Override
    public void sort(double[] ar) {

        if (!ArraylUtils.doesArrayValid(ar)) {
            throw new RuntimeException("The input array is not valid");
        }

        // Initiate the member of this class
        this.array = ar;

        quickSort(0, array.length - 1);
    }

    /**
     * Recursive function which implements the quick sort algorithm.
     * @param firstIndex    The first index to be taken in account
     * @param lastIndex     The last index to be taken in account
     */
    private void quickSort(int firstIndex, int lastIndex) {

        // Check if we have more than the minimum defined number elements
        int numberOfElementsToSort = (lastIndex - firstIndex) + 1;
        if (numberOfElementsToSort >= MINIMUM_NUMBER_OF_ELEMENTS_FOR_QUICK_SORT) {

            int pivotLocation =
                    ArraylUtils.partitionArrayWithPivot(array, firstIndex, lastIndex);

            // Recursively call the algorithm on the two halves of the array
            if (pivotLocation > 0 && pivotLocation > firstIndex) {
                quickSort(firstIndex, pivotLocation - 1);
            }
            if (pivotLocation < array.length - 1 && pivotLocation < lastIndex) {
                quickSort(pivotLocation + 1, lastIndex);
            }
        }

        // If we have less than the maximum, perform a naive sort
        else {
            naiveSort(firstIndex, lastIndex);
        }

    }

    /**
     * Provide naive sort for quick sort algorithm
     * In our case, we will insertion sort as the naive sort
     * @param firstIndex    The first index which will be included in the sort.
     * @param lastIndex     The last index which will be included in the sort.
     */
    private void naiveSort(int firstIndex, int lastIndex) {

        double[] subArrayToNaiveSort =
                Arrays.copyOfRange(array, firstIndex, lastIndex + 1);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(subArrayToNaiveSort);

        System.arraycopy(
                subArrayToNaiveSort,
                0,
                array,
                firstIndex,
                subArrayToNaiveSort.length);
    }
}

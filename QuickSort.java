/**
 * This class implement the quick sort algorithm
 */
public class QuickSort implements Sorter {

    private static final int MAXIMUM_NUMBER_OF_ELEMENTS_FOR_QUICK_SORT = 3;

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

        // Check if we have more than the maximum defined number elements
        if ((firstIndex + (MAXIMUM_NUMBER_OF_ELEMENTS_FOR_QUICK_SORT - 1)) <
                lastIndex) {

            int pivotLocation = ArraylUtils.partitionArrayWithPivot(array, firstIndex, lastIndex);

            // Recursively call the algorithm on the two halves of the array
            if (pivotLocation > 0) {
                quickSort(firstIndex, pivotLocation - 1);
            }
            if (pivotLocation < array.length - 1) {
                quickSort(pivotLocation + 1, lastIndex);
            }
        }

        // If we have less than the maximum, perform a naive sort
        else {
            naiveSort(firstIndex, lastIndex);
        }

    }

    // TODO: Replace this with the real impl of insertion sort
    private void naiveSort(int firstIndex, int lastIndex) {

        for (int i = firstIndex; i <= lastIndex; i++) {
            double valueToInsert = array[i];
            int indexToInsert = i;

            while(
                    (indexToInsert > firstIndex) &&
                            (array[indexToInsert - 1] > valueToInsert)) {
                array[indexToInsert] = array[indexToInsert - 1];
                --indexToInsert;
            }

            array[indexToInsert] = valueToInsert;
        }
    }
}

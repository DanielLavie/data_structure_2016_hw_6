/**
 * This class implement the quick sort algorithm
 */
public class QuickSort extends SortingAlgorithm implements Sorter {

    private static final int MAXIMUM_NUMBER_OF_ELEMENTS_FOR_QUICK_SORT = 3;

    private double array[];
    private int arrayLength;

    /**
     * Sort the given array with quick sort algorithm
     * @param ar    The array to be sorted
     */
    @Override
    public void sort(double[] ar) {

        if (!doesArrayValid(ar)) {
            throw new RuntimeException("The input array is not valid");
        }

        // Initiate the members of this class
        this.array = ar;
        arrayLength = ar.length;

        quickSort(0, arrayLength - 1);
    }

    private void quickSort(int firstIndex, int lastIndex) {

        // Check if we have more than the maximum defined number elements
        if ((firstIndex + (MAXIMUM_NUMBER_OF_ELEMENTS_FOR_QUICK_SORT - 1)) <
                lastIndex) {

            int pivotLocation = partitionArrayWithPivot(firstIndex, lastIndex);

            // Recursively call the algorithm on the two halves of the array
            if (pivotLocation > 0) {
                quickSort(firstIndex, pivotLocation - 1);
            }
            if (pivotLocation < arrayLength - 1) {
                quickSort(pivotLocation + 1, lastIndex);
            }
        }

        // If we have less than the maximum, perform a naive sort
        else {
            naiveSort(firstIndex, lastIndex);
        }

    }

    private int partitionArrayWithPivot(int firstIndex, int lastIndex) {

        // For simplicity, we pick the pivot as the first element of the array
        int pivotIndex = firstIndex;
        double pivot = array[pivotIndex];

        // This variables will help with the iteration on the array
        int lowMarker = firstIndex + 1;
        int highMarker = lastIndex;

        while (lowMarker < highMarker) {
            while (highMarker > firstIndex &&
                    array[highMarker] >= pivot) {
                --highMarker;
            }
            while (lowMarker < arrayLength &&
                    array[lowMarker] < pivot) {
                ++lowMarker;
            }

            // Check that we did not overlapped
            if (lowMarker < highMarker) {
                swapElementsAtLocation(array, lowMarker, highMarker);
            }
        }

        // Place the pivot in it's right place and return it's index
        swapElementsAtLocation(array, pivotIndex, highMarker);

        return highMarker;
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

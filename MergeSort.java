/**
 * This class implements merge sort algorithm
 */
public class MergeSort implements Sorter {

    private double array[];

    /**
     * Sort the given array with merge sort algorithm
     * @param ar    The array to be sorted
     */
    @Override
    public void sort(double[] ar) {

        if (!ArraylUtils.doesArrayValid(ar)) {
            throw new RuntimeException("The input array is not valid");
        }

        // Initiate the members of this class
        this.array = ar;

        mergeSort(0, array.length - 1);
    }

    /**
     * Recursive function which implements the merge sort algorithm
     * @param firstIndex    The first index to be taken in account in the algorithm
     * @param lastIndex     The last index to be taken in account in the algorithm
     */
    private void mergeSort(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            mergeSort(firstIndex, middleIndex);
            mergeSort(middleIndex + 1, lastIndex);
            merge(firstIndex, middleIndex, lastIndex);
        }
    }

    /**
     * Merge two halves of the array member
     * @param firstIndex    The first index in the array
     * @param middleIndex   The middle index in the array
     * @param lastIndex     The last index in the array
     */
    private void merge(int firstIndex, int middleIndex, int lastIndex) {

        // Calculate the length of each sub array

        int leftArrayLength = (middleIndex - firstIndex) + 1;
        int rightArrayLength = lastIndex - middleIndex;

        // Create the two sub arrays

        double[] leftArray = new double[leftArrayLength + 1]; // The extra one here is for the infinite value
        for (int i = 0; i < leftArrayLength; i++) {
            leftArray[i] = array[i + firstIndex];
        }
        double[] rightArray = new double[rightArrayLength + 1]; // The extra one here is for the infinite value
        for (int i = 0; i < rightArrayLength; i++) {
            rightArray[i] = array[i + middleIndex + 1];
        }

        // Sets the infinite value at the end of each sub array
        leftArray[leftArrayLength] = Double.MAX_VALUE;
        rightArray[rightArrayLength] = Double.MAX_VALUE;

        // Merge the two arrays into the main array in the right order

        int leftArrayMarker = 0;
        int rightArrayMarker = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (leftArray[leftArrayMarker] <= rightArray[rightArrayMarker]) {
                array[i] = leftArray[leftArrayMarker];
                ++leftArrayMarker;
            }
            else {
                array[i] = rightArray[rightArrayMarker];
                ++rightArrayMarker;
            }
        }
    }
}

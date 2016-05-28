/**
 * This class implements merge sort algorithm
 */
public class MergeSort extends SortingAlgorithm implements Sorter {

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

        mergeSort(0, arrayLength - 1);
    }

    private void mergeSort(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            mergeSort(firstIndex, middleIndex);
            mergeSort(middleIndex + 1, lastIndex);
            merge(firstIndex, middleIndex, lastIndex);
        }
    }

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

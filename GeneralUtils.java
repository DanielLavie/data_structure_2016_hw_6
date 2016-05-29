public class GeneralUtils {

    /**
     * Select the first element as a pivot, then partition the array according to this pivot.
     * @param array         The array to partition
     * @param firstIndex    The starting index in the array for the partition
     * @param lastIndex     The last index in the array for the partition
     * @return              The index of the pivot at the end of the process
     */
    public static int partitionArrayWithPivot(double[] array, int firstIndex, int lastIndex) {

        // Handle the case where the array has only 1 element
        if (firstIndex == lastIndex) {
            return firstIndex;
        }

        // Handle the case where the array has only 2 elements
        if (lastIndex - firstIndex == 1) {
            if (array[firstIndex] > array[lastIndex]) {
                swapElementsAtLocation(array, firstIndex, lastIndex);
                return lastIndex;
            }
            else {
                return firstIndex;
            }
        }

        // In any other case

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
            while (lowMarker < array.length &&
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

    /**
     * Check if the given array is valid.
     *
     * @param array The array to be checked
     * @return  true if the array is valid, false otherwise
     */
    public static boolean doesArrayValid(double[] array) {

        if (null == array || array.length == 0) {
            return false;
        }
        return true;
    }

    /**
     * Swap to elements in an array according to their index.
     *
     * @param array         The array to operate on
     * @param firstIndex    First index in the array
     * @param secondIndex   Second in the array
     */
    public static void swapElementsAtLocation(
            double[] array,
            int firstIndex,
            int secondIndex) {

        double temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}

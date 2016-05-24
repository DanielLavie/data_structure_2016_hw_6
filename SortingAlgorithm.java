/**
 * This class is a base class for all the sorting algorithms.
 * It is implementing some of the common functionality of the different algorithms
 */
abstract class SortingAlgorithm {

    /**
     * Check if the given array is valid
     * @param array The array to be checked
     * @return  true if the array is valid, false otherwise
     */
    protected static boolean doesArrayValid(double[] array) {

        if (null == array || array.length == 0) {
            return false;
        }
        return true;
    }
}

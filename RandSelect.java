import org.jcp.xml.dsig.internal.dom.Utils;

import java.util.Arrays;

/**
 *  This class implements randomized selection algorithm
 */
public class RandSelect implements Selector {

    private double[] array;
    private int arrayLength;

    /**
     * Finds the element whose rank is i in the given array.
     * @param ar    The array to be searched
     * @param i     The rank to be searched in the array
     * @return      The element whose rank is i
     */
    @Override
    public double select(double[] ar, int i) {

        if (!GeneralUtils.doesArrayValid(ar)) {
            throw new RuntimeException("The input array is not valid");
        }

        if (i < 1 || i > ar.length) {
            throw new RuntimeException("The given rank is invalid");
        }

        // Initiate the members of this class.
        // We use deep copy to avoid messing up the original array
        arrayLength = ar.length;
        this.array = Arrays.copyOf(ar, arrayLength);

        return RandomSelection(0, arrayLength - 1, i);
    }

    private double RandomSelection(int firstIndex, int lastIndex, int rank) {

        // If we have reached the desired rank, return its value
        if (firstIndex == lastIndex) {
            return array[firstIndex];
        }

        // Finds a pivot and its relative location to the sub array
        int pivotLocation =
                GeneralUtils.partitionArrayWithPivot(array, firstIndex, lastIndex);
        int relativePivotLocation = (pivotLocation - firstIndex) + 1;

        if (rank == relativePivotLocation) {
            return array[pivotLocation];
        }

        if (rank <  relativePivotLocation) {
            return RandomSelection(firstIndex, pivotLocation - 1, rank);
        }
        else {
            return RandomSelection(pivotLocation + 1, lastIndex, rank - relativePivotLocation);
        }
    }
}

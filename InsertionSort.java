
public class InsertionSort implements Sorter{

    /**
     * Sorts an array using insertion sort algorithm.
     * @param ar The array to be sorted
     */
    public void sort(double[] ar) {
        if (!ArraylUtils.doesArrayValid(ar)) {
            throw new RuntimeException("Given array is not valid");
        }

        int j;
        for (int i = 1; i < ar.length; i++) {
            double newValue = ar[i];
            j = i;
            while (j > 0 && ar[j - 1] > newValue) {
                ar[j] = ar[j - 1];
                j--;
            }
            ar[j] = newValue;
        }
    }
}

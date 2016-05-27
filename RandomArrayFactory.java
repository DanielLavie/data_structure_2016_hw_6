import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class is responsible for generating random arrays for the testing
 * the algorithms.
 */
public class RandomArrayFactory {

    /**
     * Generate a random array of the given size,
     * with values of 0 (included) up to 1 (excluded)
     * @param size  The size of the array to generate
     * @return      An array with random generated values
     */
    public double[] getRandomArray(int size) {
        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = generateRandomNumberBetweenZeroAndOne();
        }

        return array;
    }

    private static double generateRandomNumberBetweenZeroAndOne() {
        double randomNumber = Math.random();
        return round(
                randomNumber,
                AlgorithmComparison.NUMBER_OF_DIGITS
        );
    }

    private static double round(double value, int places) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}

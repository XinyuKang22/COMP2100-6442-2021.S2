public class StatementComplete {
    /**
     * The following method sums the number of items from 1 to n
     *  then multiplies the sum with n
     * @param number to sum from 1 to.
     * @return sum(1 to n)*n or 0 if n <= 0.
     */
    public static int sumAndMultiply(int number) {
        // Notice that you cannot complete the statement in this if condition and continue.
        if (number <= 0) { // S1
            return 0; // S2
        }

        // Store the sum and the number we will multiply by at the end.
        int sum = 0, multi = number; // S3 and S4

        // We already know number must be at least 1...
        do {
            sum += number--; // S5 and S6
        } while (number > 0); // S7

        return sum*multi; // S8
    }
}

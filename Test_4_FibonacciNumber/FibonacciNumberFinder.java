package Test_4_FibonacciNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * FibonacciNumberFinder serves for calculating Fibonacci sequence and for finding the N - number of sequence
 */
public class FibonacciNumberFinder {

    // List in which will be stored Fibonacci sequence
    private List<Integer> fibonacciNumbers = new ArrayList<Integer>();

    /** Calculate and remember to list all numbers in the Fibonacci sequence
     * between "0" sequences number and number from parameter.
     *
     * @param number - sequences number of the numbers in the Fibonacci sequence
     */
    private void calculateFibonacciNumbers(int number) {
        // Known that first number of Fibonacci sequence = 0
        fibonacciNumbers.add(0);
        // Second number of Fibonacci sequence = 1
        fibonacciNumbers.add(1);

        // Each following number of Fibonacci sequence = amount of two previous numbers
        for (int i = 2; i <= number; i++) {
            fibonacciNumbers.add(fibonacciNumbers.get(i - 2) + fibonacciNumbers.get(i - 1));
        }
    }

    /**
     * Calculate and get from list of fibonacciNumbers the N - number of Fibonacci sequence
     *
     * @param number - sequences number of the numbers in the Fibonacci sequence
     * @return - N - numbers of the Fibonacci sequence
     */
    public int findFibonacciNumber (int number) {
        calculateFibonacciNumbers(number);
        return fibonacciNumbers.get(number);
    }

    // Test drive
    public static void main(String[] args) {
        System.out.println(new FibonacciNumberFinder().findFibonacciNumber(6));
    }
}

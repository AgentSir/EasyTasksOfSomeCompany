package Test_3_CommonDivisor;

import java.util.*;

/**
 *  GreatestCommonDivisorFinder serves for find the greatest common divisor of numbers
 *  GCD - greatest common divisor
 */
public class GreatestCommonDivisorFinder {

    // Array of integers for which need to find the common divisor
    private List<Integer> digitsList = new LinkedList<Integer>();
    private int numDigits;

    private void readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of numbers for which need to find the common divisor");
        numDigits = scanner.nextInt();
        System.out.println("Enter numbers");
        for (int i = 0; i < numDigits; i++){
            digitsList.add(scanner.nextInt());
        }
    }


    public GreatestCommonDivisorFinder() {
        readIntegers();
    }

    /** For find the GCD of two integers used Euclid's algorithm
     *
     * @param firstNum - the first number for which you want to find GCD
     * @param secondNum - the second number for which you want to find GCD
     * @return - GCD of two numbers
     */
    private int findGCD(int firstNum, int secondNum) {
        while (firstNum != secondNum){
            if(firstNum > secondNum) {
                firstNum = firstNum - secondNum;
            } else secondNum = secondNum - firstNum;
        }
        return firstNum;
    }

    // Implementation search of the greatest common divisor of all numbers in the list of digits.
    public int findGCD(){
        while (digitsList.size() != 1) {
            digitsList.set(0, findGCD(digitsList.get(0), digitsList.get(digitsList.size() - 1)));
            digitsList.remove(digitsList.size()-1);
        }
        return digitsList.get(0);
    }

    // Test drive
    public static void main(String[] args) {
        GreatestCommonDivisorFinder finder = new GreatestCommonDivisorFinder();
        System.out.println("The greatest common divisor = " + finder.findGCD());
    }

}

package com.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * The StringCalculator class provides methods to perform mathematical
 * operations on a string of numbers.
 * It supports addition, subtraction, multiplication, and division operations.
 * 
 * @author sridhar
 * @implNote This class is a simple calculator that can perform basic arithmetic
 *           operations on a string of numbers.
 * 
 */
public class StringCalculator {
    /**
     * The extractDelimiter method extracts the delimiter from the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the delimiter extracted from the input string
     */
    private String extractDelimiter(String numbers) {
        if (numbers.startsWith("//")) {
            return numbers.substring(2, numbers.indexOf("\n"));
        }
        return ",";
    }

    /**
     * The extractNumbers method extracts the numbers from the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the numbers extracted from the input string
     */
    private String extractNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            int index = numbers.indexOf("\n");
            return numbers.substring(index + 1);
        }
        return numbers;
    }

    /**
     * The parseNumbers method parses the numbers from the input string.
     * 
     * @param numbers   the input string containing numbers and delimiter
     * @param delimiter the delimiter used to separate the numbers
     * @return an array of parsed numbers
     */
    private int[] parseNumbers(String numbers, String delimiter) {
        String[] nums = numbers.split("[\n" + delimiter + "]");
        int[] parsedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parsedNums[i] = Integer.parseInt(nums[i]);
        }
        return parsedNums;
    }

    /**
     * The ensureNoNegatives method ensures that the input numbers do not contain
     * any negative numbers.
     * 
     * @param nums the array of numbers to check for negatives
     * @throws IllegalArgumentException if any negative numbers are found
     */
    private void ensureNoNegatives(int[] nums) {
        List<Integer> negatives = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                negatives.add(num);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
    }

    /**
     * The calculateSum method calculates the sum of the numbers.
     * 
     * @param nums the array of numbers to calculate the sum
     * @return the sum of the numbers
     */
    private int calculateSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * The calculateSubract method calculates the subtraction of the numbers.
     * 
     * @param nums the array of numbers to calculate the subtraction
     * @return the subtraction of the numbers
     */
    private int calculateSubract(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        return result;

    }

    /**
     * The calculateProduct method calculates the product of the numbers.
     * 
     * @param nums the array of numbers to calculate the product
     * @return the product of the numbers
     */
    private int calculateProduct(int[] nums) {
        int product = 1;
        for (int num : nums) {
            product *= num;
        }
        return product;
    }

    /**
     * The calculateQuotient method calculates the quotient of the numbers.
     * 
     * @param nums the array of numbers to calculate the quotient
     * @return the quotient of the numbers
     * @throws IllegalArgumentException if any number in the array is zero
     */
    private double calculateQuotient(int[] nums) {
        double quotient = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            quotient /= nums[i];
        }
        return quotient;
    }

    /**
     * Adds the numbers in the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the sum of the numbers
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = extractDelimiter(numbers);
        numbers = extractNumbers(numbers);
        int[] nums = parseNumbers(numbers, delimiter);
        ensureNoNegatives(nums);

        return calculateSum(nums);
    }

    /**
     * Subtracts the numbers in the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the subtraction of the numbers
     */
    public int subtract(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = extractDelimiter(numbers);
        numbers = extractNumbers(numbers);
        int[] nums = parseNumbers(numbers, delimiter);
        ensureNoNegatives(nums);
        return calculateSubract(nums);
    }

    /**
     * Multiplies the numbers in the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the product of the numbers
     */
    public int multiply(String numbers) {
        if (numbers.isEmpty()) {
            return 1;
        }
        String delimiter = extractDelimiter(numbers);
        numbers = extractNumbers(numbers);
        int[] nums = parseNumbers(numbers, delimiter);
        ensureNoNegatives(nums);
        return calculateProduct(nums);
    }

    /**
     * Divides the numbers in the input string.
     * 
     * @param numbers the input string containing numbers and delimiter
     * @return the quotient of the numbers
     * @throws IllegalArgumentException if any number in the array is zero
     */
    public double divide(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = extractDelimiter(numbers);
        numbers = extractNumbers(numbers);
        int[] nums = parseNumbers(numbers, delimiter);
        ensureNoNegatives(nums);
        return calculateQuotient(nums);

    }
}

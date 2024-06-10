package com.calculator;
import java.util.ArrayList;
import java.util.List;

/**
 * The StringCalculator class provides methods to perform mathematical operations on a string of numbers.
 * It supports addition, subtraction, multiplication, and division operations.
 */
public class StringCalculator {

    private String extractDelimiter(String numbers) {
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            delimiter = parts[0].substring(2);
        }
        return delimiter;
    }

    private String extractNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            return numbers.split("\n", 2)[1];
        }
        return numbers;
    }

    private int[] parseNumbers(String numbers, String delimiter) {
        String[] nums = numbers.split("[\n" + delimiter + "]");
        int[] parsedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parsedNums[i] = Integer.parseInt(nums[i]);
        }
        return parsedNums;
    }

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

    private int calculateSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private int calculateSubract(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        return result;

    }

    private int calculateProduct(int[] nums) {
        int product = 1;
        for (int num : nums) {
            product *= num;
        }
        return product;
    }

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

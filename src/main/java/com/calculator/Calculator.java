
package com.calculator;

import java.util.logging.Logger;

import java.util.Scanner;

public class Calculator extends StringCalculator {
    private final Scanner scanner;
    
    private static final Logger logger = Logger.getLogger(StringCalculator.class.getName());

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner inputScanner = new Scanner(System.in);

        logger.info("Choose operation:");
        logger.info("1. Addition");
        logger.info("2. Multiplication");
        logger.info("3. Division");
        logger.info("Enter your choice (1, 2, or 3): ");
        int choice = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline

        logger.info("Enter numbers separated by commas (e.g., 1,2,3): ");
        String input = inputScanner.nextLine();

        switch (choice) {
            case 1:
                int sum = calculator.add(input);
                logger.info("Sum: " + sum);
                break;
            case 2:
                int product = calculator.multiply(input);
                logger.info("Product: " + product);
                break;
            case 3:
                double quotient = calculator.divide(input);
                logger.info("Quotient: " + quotient);
                break;
            default:
                logger.info("Invalid choice.");
        }

        inputScanner.close();
    }
}
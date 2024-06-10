
package com.calculator;
import java.util.logging.Logger;
import java.util.Scanner;

public class Calculator extends StringCalculator {    
    private static final Logger logger = Logger.getLogger("Calculator");

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner inputScanner = new Scanner(System.in);

        log("Choose operation:");
        log("1. Addition");
        log("2. Multiplication");
        log("3. Division");
        log("Enter your choice (1, 2, or 3): ");
        int choice = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline

        log("Enter numbers separated by commas (e.g., 1,2,3): ");
        String input = inputScanner.nextLine();

        switch (choice) {
            case 1:
                int sum = calculator.add(input);
                log("Sum: " + sum);
                break;
            case 2:
                int product = calculator.multiply(input);
                log("Product: " + product);
                break;
            case 3:
                double quotient = calculator.divide(input);
                log("Quotient: " + quotient);
                break;
            default:
                log("Invalid choice.");
        }

        inputScanner.close();
    }

    private static void log(String message) {
        System.out.println(message);
    }
}
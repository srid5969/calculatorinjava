# Calculator Application

This calculator application allows users to perform basic arithmetic operations such as addition, multiplication, and division. It provides a simple command-line interface for user interaction.

## Features:

Addition: Add multiple numbers separated by commas.
Multiplication: Multiply multiple numbers separated by commas.
Division: Divide two numbers.
## Usage:

Clone or download the repository.
Compile the Java files using a Java compiler.
Run the Calculator class.
Choose the operation you want to perform (1 for addition, 2 for multiplication, 3 for division).
Enter the numbers separated by commas when prompted.
View the result of the chosen operation.


```java
package com.calculator;
import java.util.logging.Logger;
import java.util.Scanner;

public class Calculator extends StringCalculator {    
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
```


## Note:

This application assumes valid input for arithmetic operations.
Division by zero is not handled explicitly and may result in unexpected behavior.
Ensure to provide valid input according to the specified format for accurate results.

## Author:
Sridhar

## License:
This project is licensed under the terms of the MIT License.
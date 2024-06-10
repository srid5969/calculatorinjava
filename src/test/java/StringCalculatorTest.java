import org.junit.jupiter.api.Test;
import com.calculator.StringCalculator;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void canAddEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void canAddSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void canAddTwoNumbersReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    void canAddNewLineDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void canAddCustomDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void canAddNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
    }

    @Test
    void canSubtractEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.subtract(""));
    }

    @Test
    void canSubtractSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.subtract("1"));
    }

    @Test
    void canSubtractTwoNumbersReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-4, calculator.subtract("1,5"));
    }

    @Test
    void canSubtractNewLineDelimiterReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-4, calculator.subtract("1\n2,3"));
    }

    @Test
    void canSubtractCustomDelimiterReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-1, calculator.subtract("//;\n1;2"));
    }

    @Test
    void canSubtractNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.subtract("1,-2,3,-4");
        });
    }

    @Test
    void canDivideEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0.0, calculator.divide(""));
    }

    @Test
    void canDivideSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1.0, calculator.divide("1"));
    }

    @Test
    void canDivideTwoNumbersReturnsQuotient() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2.5, calculator.divide("5,2"));
    }

    @Test
    void canDivideCustomDelimiterReturnsQuotient() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0.5, calculator.divide("//;\n1;2"));
    }

    @Test
    void canDivideDivisionByZeroThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide("1,0,3");
        });
    }

    @Test
    void canMultiplyEmptyStringReturnsOne() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.multiply(""));
    }

    @Test
    void canMultiplySingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.multiply("5"));
    }

    @Test
    void canMultiplyTwoNumbersReturnsProduct() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.multiply("3,5"));
    }

    @Test
    void canMultiplyCustomDelimiterReturnsProduct() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.multiply("//;\n2;3"));
    }

    @Test
    void canMultiplyNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.multiply("1,-2,3,-4");
        });
    }
}

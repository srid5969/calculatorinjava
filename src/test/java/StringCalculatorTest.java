import org.junit.jupiter.api.Test;
import com.calculator.StringCalculator;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void testAddEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testAddSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void testAddTwoNumbersReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    void testAddNewLineDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void testAddCustomDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void testAddNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
    }

    @Test
    void testSubtractEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.subtract(""));
    }

    @Test
    void testSubtractSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.subtract("1"));
    }

    @Test
    void testSubtractTwoNumbersReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-4, calculator.subtract("1,5"));
    }

    @Test
    void testSubtractNewLineDelimiterReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-4, calculator.subtract("1\n2,3"));
    }

    @Test
    void testSubtractCustomDelimiterReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-1, calculator.subtract("//;\n1;2"));
    }

    @Test
    void testSubtractNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.subtract("1,-2,3,-4");
        });
    }

    @Test
    void testDivideEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0.0, calculator.divide(""));
    }

    @Test
    void testDivideSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1.0, calculator.divide("1"));
    }

    @Test
    void testDivideTwoNumbersReturnsQuotient() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2.5, calculator.divide("5,2"));
    }

    @Test
    void testDivideCustomDelimiterReturnsQuotient() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0.5, calculator.divide("//;\n1;2"));
    }

    @Test
    void testDivideDivisionByZeroThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide("1,0,3");
        });
    }

    @Test
    void testMultiplyEmptyStringReturnsOne() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.multiply(""));
    }

    @Test
    void testMultiplySingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.multiply("5"));
    }

    @Test
    void testMultiplyTwoNumbersReturnsProduct() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.multiply("3,5"));
    }

    @Test
    void testMultiplyCustomDelimiterReturnsProduct() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.multiply("//;\n2;3"));
    }

    @Test
    void testMultiplyNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.multiply("1,-2,3,-4");
        });
    }
}

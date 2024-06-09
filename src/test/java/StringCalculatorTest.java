import org.junit.jupiter.api.Test;

import com.calculator.StringCalculator;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void testAdd_EmptyString_ReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testAdd_SingleNumber_ReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void testAdd_TwoNumbers_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    void testAdd_NewLineDelimiter_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void testAdd_CustomDelimiter_ReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void testAdd_NegativeNumbers_ThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
    }

    @Test
    void testSubtract_EmptyString_ReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.subtract(""));
    }

    @Test
    void testSubtract_SingleNumber_ReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.subtract("1"));
    }

    @Test
    void testSubtract_TwoNumbers_ReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-4, calculator.subtract("1,5"));
    }

    @Test
    void testSubtract_NewLineDelimiter_ReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-4, calculator.subtract("1\n2,3"));
    }

    @Test
    void testSubtract_CustomDelimiter_ReturnsDifference() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(-1, calculator.subtract("//;\n1;2"));
    }

    @Test
    void testSubtract_NegativeNumbers_ThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.subtract("1,-2,3,-4");
        });
    }

    @Test
    void testDivide_EmptyString_ReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0.0, calculator.divide(""));
    }

    @Test
    void testDivide_SingleNumber_ReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1.0, calculator.divide("1"));
    }

    @Test
    void testDivide_TwoNumbers_ReturnsQuotient() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2.5, calculator.divide("5,2"));
    }

    @Test
    void testDivide_CustomDelimiter_ReturnsQuotient() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0.5, calculator.divide("//;\n1;2"));
    }

    @Test
    void testDivide_DivisionByZero_ThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide("1,0,3");
        });
    }

    @Test
    void testMultiply_EmptyString_ReturnsOne() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.multiply(""));
    }

    @Test
    void testMultiply_SingleNumber_ReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.multiply("5"));
    }

    @Test
    void testMultiply_TwoNumbers_ReturnsProduct() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.multiply("3,5"));
    }

    @Test
    void testMultiply_CustomDelimiter_ReturnsProduct() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.multiply("//;\n2;3"));
    }

    @Test
    void testMultiply_NegativeNumbers_ThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.multiply("1,-2,3,-4");
        });
    }
}

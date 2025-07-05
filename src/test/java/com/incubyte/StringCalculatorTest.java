package com.incubyte;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    // ✅ Common helper method to log and assert output
    private void assertAndLog(int expected, String input, StringCalculator calc) {
        int actual = calc.add(input);
        System.out.println("Input: \"" + input + "\" => Output: " + actual);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testEmptyStringShouldReturnZero() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(0, "", calc);
    }
    @Test
    public void testSingleNumberShouldReturnValue() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(1, "1", calc);
    }
    @Test
    public void testTwoNumbersShouldReturnSum() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(3, "1,2", calc);
    }
    @Test
    public void testMultipleNumbersShouldReturnSum() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(15, "1,2,3,4,5", calc);
    }

    @Test
    public void testNewlineBetweenNumbersShouldReturnSum() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(6, "1\n2,3", calc);
    }
    @Test
    public void testCustomDelimiterSemicolon() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(3, "//;\n1;2", calc);
    }


}

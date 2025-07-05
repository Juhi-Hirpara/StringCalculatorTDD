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
    @Test
    public void testNegativeNumbersShouldThrowException() {
        StringCalculator calc = new StringCalculator();
        try {
            calc.add("1,-2,-3");
            Assert.fail("Exception expected for negative numbers");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("-2"));
            Assert.assertTrue(e.getMessage().contains("-3"));
        }
    }
    @Test
    public void testNumbersGreaterThan1000AreIgnored() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(2, "2,1001", calc);
    }
    @Test
    public void testCustomDelimiterOfAnyLength() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(6, "//[***]\n1***2***3", calc);
    }
    @Test
    public void testMultipleDelimiters() {
        StringCalculator calc = new StringCalculator();
        assertAndLog(6, "//[*][%]\n1*2%3", calc);
    }




}

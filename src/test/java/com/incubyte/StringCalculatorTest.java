package com.incubyte;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void testEmptyStringShouldReturnZero() {
        StringCalculator calc = new StringCalculator();
        Assert.assertEquals(0, calc.add(""));
    }
    @Test
    public void testSingleNumberShouldReturnValue() {
        StringCalculator calc = new StringCalculator();
        Assert.assertEquals(1, calc.add("1"));
    }

}

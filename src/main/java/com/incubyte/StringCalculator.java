package com.incubyte;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            String[] headerParts = numbers.split("\n", 2);
            String delimiter = headerParts[0].substring(2);
            numbers = headerParts[1].replace(delimiter, ",");
        }

        numbers = numbers.replace("\n", ",");
        String[] parts = numbers.split(","); // Split by comma

        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }
}

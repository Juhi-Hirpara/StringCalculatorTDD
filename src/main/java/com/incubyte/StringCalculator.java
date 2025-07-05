package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//[")) {
            // ✅ Handle multi-character and multiple custom delimiters
            String delimitersPart = numbers.substring(2, numbers.indexOf("\n"));
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimitersPart);
            while (matcher.find()) {
                String delimiter = Pattern.quote(matcher.group(1));
                numbers = numbers.replaceAll(delimiter, ",");
            }
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        } else if (numbers.startsWith("//")) {
            // Handle single character delimiter
            String[] headerParts = numbers.split("\n", 2);
            String delimiter = Pattern.quote(headerParts[0].substring(2));
            numbers = headerParts[1].replaceAll(delimiter, ",");
        }

        numbers = numbers.replace("\n", ",");
        String[] parts = numbers.split(",");

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {

            if (part.isEmpty()) continue;
            int num = Integer.parseInt(part.trim());
            if (num < 0) {
                negatives.add(num);
                } else if (num <= 1000) {
                    sum += num;
                }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed " + negatives);
        }

        return sum;
    }
}

package com.incubyte;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
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

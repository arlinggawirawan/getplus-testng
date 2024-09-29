package com.getplus.automation.tests.Utils;
import java.util.Random;

public class StringUtils {
    public static String randomizeCase(String input) {
        Random random = new Random();
        StringBuilder randomized = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            if (random.nextBoolean()) {
                randomized.append(Character.toUpperCase(c));
            } else {
                randomized.append(Character.toLowerCase(c));
            }
        }
        return randomized.toString();
    }
}
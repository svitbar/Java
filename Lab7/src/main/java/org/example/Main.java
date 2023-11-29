package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(run()));
    }

    public static String[] run() {
        while (true) {
            try {
                String[] str = input();
                validateInput(str);

                return wordsWithUniqueChars(str);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static String[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");

        return sc.nextLine().split("\\s+");
    }

    public static Predicate<String> isChar = str -> str
            .chars()
            .allMatch(Character::isLetter);

    public static void validateInput(String[] arr) {
        if (arr.length == 1 && arr[0].isEmpty()) {
            throw new IllegalArgumentException("Please enter a non-empty string.");
        }

        Arrays.stream(arr).forEach(w -> {
            if (!isChar.test(w)) {
                throw new IllegalArgumentException("Please use only alphabet characters.");
            }
        });
    }

    public static Predicate<String> isUnique = str -> str
            .chars()
            .distinct()
            .count() == str.length();

    public static String[] wordsWithUniqueChars(String[] arr) {
        return Arrays.stream(arr)
                .filter(w -> isUnique.test(w))
                .toList()
                .toArray(new String[0]);
    }
}
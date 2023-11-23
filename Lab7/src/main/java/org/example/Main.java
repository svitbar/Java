package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public static void validateInput(String[] arr) {
        if (arr.length == 1 && arr[0].isEmpty()) {
            throw new IllegalArgumentException("Please enter a non-empty string.");
        }

        for (String key : arr) {

            for (int i = 0; i < key.length(); i++) {
                if (!Character.isLetter(key.charAt(i))) {
                   throw new IllegalArgumentException("Please use only alphabet characters.");
                }
            }
        }
    }

    public static String[] wordsWithUniqueChars(String[] arr) {
        List<String> resultList = new ArrayList<>();

        for (String i : arr) {

            char[] word = i.toCharArray();
            boolean unique = true;

            out:
            for (int j = 0; j < word.length; j++) {

                for (int k = j + 1; k < word.length; k++) {
                    if (word[j] == word[k]) {
                        unique = false;
                        break out;
                    }
                }
            }

            if (unique) resultList.add(i);
        }

        return resultList.toArray(new String[0]);
    }
}
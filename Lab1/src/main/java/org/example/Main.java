package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        fifth(input());
    }

    public static String[] input() {
        Scanner sc = new Scanner(System.in);
        String[] str;

        do {
            System.out.println("Enter a string:");
            str = sc.nextLine().split(" ");
        } while (!inputCheck(str));

        return str;
    }

    public static Boolean inputCheck(String[] arr) {
        if (arr.length == 1 && arr[0].isEmpty()) {
            System.out.println("Please enter a non-empty string.");
            return false;
        }

        for (String key : arr) {

            for (int i = 0; i < key.length(); i++) {
                if (!Character.isLetter(key.charAt(i))) {
                    System.out.println("Please use only alphabet characters.");
                    return false;
                }
            }
        }

        return true;
    }

    public static void fifth(String[] arr) {
        StringBuilder res = new StringBuilder();

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

                // if (!unique) break;
            }

            if (unique) res.append(i).append(" ");
        }

        String[] array = res.toString().split(" ");
        System.out.println(Arrays.toString(array));
    }
}

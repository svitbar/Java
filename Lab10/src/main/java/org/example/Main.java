package org.example;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a replace string: ");
        String strThatReplace = getInputString();

        System.out.println("Literal string example: ");
        String strLiteral = "This is a string.";
        replaceStr(strLiteral, strThatReplace);

        System.out.println("\nConsole string example: ");
        System.out.println("Enter a string to modify: ");
        String strConsole = getInputString();
        replaceStr(strConsole, strThatReplace);
    }

    public static void replaceStr(String str, String replace) {
        try {
            System.out.println("\nString before modifying: " + str);

            Class<?> clazz = str.getClass();
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            field.set(str, replace.toCharArray());

            System.out.println("String after modifying: " + str);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static String getInputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
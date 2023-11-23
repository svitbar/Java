package org.example.utils;

import java.util.Scanner;

public class TranslatorUtils {
    private static final Scanner sc = new Scanner(System.in);
    public static final String MENU = "menu";
    public static final String EXIT = "exit";
    public static final String SHOW = "show";
    public static final String ADD = "add";
    public static final String TRANSLATE = "translate";

    public static String getCommand(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}

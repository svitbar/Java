package org.example.utils;

import org.example.views.BookView;

import java.util.Scanner;

public class BookUtils {
    private static final Scanner sc = new Scanner(System.in);
    public static final String MENU = "menu";
    public static final String EXIT = "exit";
    public static final String SHOW = "show";
    public static final String AUTHOR = "author";
    public static final String PUBLISHER = "publisher";
    public static final String YEAR = "year";
    public static final String SORT = "sort";

    public static String getInput() {
        System.out.println(BookView.ENTER);
        return sc.nextLine();
    }
}

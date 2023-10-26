package org.example.views;

import org.example.models.Book;

public class BookView {
    public static final String ENTER = "\nPlease enter a command:";
    public static final String MENU = """
            \nMenu:
            - 'menu' to see menu;
            - 'show' to see all books;
            - 'author' to find books by a specific author;
            - 'publisher' to find books published by a specific publisher;
            - 'year' to find books published after a specific year;
            - 'sort' to view books sorted by publishers;
            - 'exit' to quit the program.
            """;

    public static final String WRONG_CMD = "Wrong command! Please try again!";
    public static final String ALL_BOOKS = "All books: ";
    public static final String BY_AUTHOR = "Books written by ";
    public static final String BY_PUBLISHER = "Books published by ";
    public static final String AFTER_YEAR = "Books published after ";
    public static final String SORTED = "Books sorted by publisher:";
    public static final String NO_AUTHOR = "Not found any book by ";
    public static final String NO_PUBLISHER = "Not found any book published by ";
    public static final String NO_YEAR = "Not found any book published after ";

    public void printMessage(String mess) {
        System.out.println(mess + "\n");
    }

    public void printByRequestStr(String mess, String value) {
        System.out.println(mess + value + ":\n");
    }

    public void printByRequestNum(String mess, int value) {
        System.out.println(mess + value + ":\n");
    }

    public void displayBooks(Book[] books) {
        for (Book book: books) {
            System.out.println(book.toString());
        }
    }
}

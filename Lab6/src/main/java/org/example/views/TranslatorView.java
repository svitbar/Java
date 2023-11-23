package org.example.views;

import java.util.Map;

public class TranslatorView {
    public static final String ENTER_CMD = "Please enter a command:";
    public static final String ENTER_WORD = "Please enter a word:";
    public static final String ENTER_TR = "Please enter a translation:";
    public static final String ENTER_TEXT = "Please enter a text to translate:";
    public static final String MENU = """
            \nMenu:
            - 'menu' to see menu;
            - 'show' to see dictionary;
            - 'add' to add ne word to dictionary;
            - 'translate' to translate text;
            - 'exit' to exit the program.
            """;
    public static final String WRONG_CMD = "Wrong command! Please try again!";
    public static final String DICTIONARY = "Dictionary:";

    public void printMessage(String mess) {
        System.out.println(mess);
    }

    public void displayDictionary(Map<String, String> dict) {
        for (Map.Entry<String, String> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

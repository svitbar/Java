package org.example.models;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    private final Map<String, String> dictionary;

    public Translator() {
        dictionary = new HashMap<>();
        getDefaultRecords();
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void validateWord(String word) {
/*        String[] words = word.split("\\s+");
        for (String w: words) {
            if (!w.matches("^[A-Za-z-]+$")) {
                throw new InputMismatchException("Word should be written using latin alphabet!");
            }
        }*/
        if (word.split("\\s+").length != 1) {
            throw new InputMismatchException("Only one word should be entered.");
        }

        if (!word.matches("^[A-Za-z-]+$")) {
            throw new InputMismatchException("Word should be written using latin alphabet!");
        }
    }

    public void validateTranslation(String translation) {
/*        String[] translations = translation.split("\\s+");

        for (String t: translations) {
            if (!t.matches("^[А-ЩЬЮЯҐЄІЇа-щьюяґєії'-]+$")) {
                throw new InputMismatchException("Translation should be written using cyrillic alphabet!");
            }
        }*/
        if (translation.split("\\s+").length != 1) {
            throw new InputMismatchException("Only one word should be entered.");
        }

        if (!translation.matches("^[А-ЩЬЮЯҐЄІЇа-щьюяґєії'-]+$")) {
            throw new InputMismatchException("Translation should be written using cyrillic alphabet!");
        }
    }

    public void addNewRecord(String word, String translation) {
        validateWord(word);
        validateTranslation(translation);
        dictionary.put(word.toLowerCase(), translation.toLowerCase());
    }

    public String translatePhrase(String phrase) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phrase);

        StringBuilder translatedText = new StringBuilder();
        int index = 0;

        while (matcher.find()) {
            String word = matcher.group(1).toLowerCase();
            String translation = dictionary.get(word);

            if (translation == null) {
                throw new InputMismatchException("No such a word in a dictionary.");
            }

            if (Character.isUpperCase(matcher.group(1).charAt(0))) {
                char firstLetter = Character.toUpperCase(translation.charAt(0));
                translation = translation.replace(translation.charAt(0), firstLetter);
            }

            translatedText.append(phrase, index, matcher.start());
            translatedText.append(translation);
            index = matcher.end();
        }
        translatedText.append(phrase, index, phrase.length());

        return translatedText.toString();
    }

    public void getDefaultRecords() {
        dictionary.put("hello", "привіт");
        dictionary.put("goodbye", "бувай");
        dictionary.put("name", "ім'я");
        dictionary.put("ball", "м'яч");
        dictionary.put("game", "гра");
        dictionary.put("code", "код");
        dictionary.put("language", "мова");
        dictionary.put("how", "як");
        dictionary.put("world", "світ");
        dictionary.put("anywhere", "будь-де");
        dictionary.put("extraordinary", "незвичайний");
        dictionary.put("island", "острів");
    }
}

package org.example.models;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    Translator translator = new Translator();

    @Test
    void testValidateWordSuccess() {
        translator.validateWord("hello");
    }

    @Test
    void testValidateWordSuccessWithHyphen() {
        translator.validateWord("hello-hi");
    }

    @Test
    void testValidateWordSeveralWords() {
        String excMess = "Only one word should be entered.";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.validateWord("hello hi");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateWordWrongLanguage() {
        String excMess = "Word should be written using latin alphabet!";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.validateWord("привіт");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateWordWithAnotherCharacters() {
        String excMess = "Word should be written using latin alphabet!";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.validateWord("hi!");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateTranslationSuccess() {
        translator.validateTranslation("європа");
    }

    @Test
    void testValidateTranslationSuccessWithHyphen() {
        translator.validateTranslation("синьо-жовтий");
    }

    @Test
    void testValidateTranslationSuccessWithApostrophe() {
        translator.validateTranslation("ім'я");
    }

    @Test
    void testValidateTranslationSeveralWords() {
        String excMess = "Only one word should be entered.";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.validateTranslation("пів кола");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateTranslationWrongLanguage() {
        String excMess = "Translation should be written using cyrillic alphabet!";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.validateTranslation("hello");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateTranslationWithAnotherCharacters() {
        String excMess = "Translation should be written using cyrillic alphabet!";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.validateTranslation("123привіт");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testTranslatePhraseOneWord() {
        String expected = "привіт";
        String actual = translator.translatePhrase("hello");

        assertEquals(expected, actual);
    }

    @Test
    void testTranslatePhraseOneWordWithFirstUpperCaseLetter() {
        String expected = "Привіт";
        String actual = translator.translatePhrase("Hello");

        assertEquals(expected, actual);
    }

    @Test
    void testTranslatePhraseSuccess() {
        String expected = "привіт світ";
        String actual = translator.translatePhrase("hello world");

        assertEquals(expected, actual);
    }

    @Test
    void testTranslatePhraseSuccessSentence() {
        String expected = "Привіт, Світ!";
        String actual = translator.translatePhrase("Hello, World!");

        assertEquals(expected, actual);
    }

    @Test
    void testTranslatePhraseSeveralSentences() {
        String expected = "Привіт! М'яч гра, будь-де.";
        String actual = translator.translatePhrase("Hello! Ball game, anywhere.");

        assertEquals(expected, actual);
    }

    @Test
    void testTranslatePhraseNoTranslation() {
        String excMess = "No such a word in a dictionary.";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.translatePhrase("jungle");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testTranslatePhraseNoTranslationInSentence() {
        String excMess = "No such a word in a dictionary.";

        Exception exc = assertThrows(InputMismatchException.class, () -> {
            translator.translatePhrase("Hello! Nice to meet you!");
        });

        assertEquals(excMess, exc.getMessage());
    }
}
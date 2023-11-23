package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testValidateInputSuccess() {
        String[] input = {
                "hello", "hi", "valid",
        };
        Main.validateInput(input);
    }

    @Test
    void testValidateInputEmptyString() {
        String excMess = "Please enter a non-empty string.";
        String[] input = {""};

        Exception exc = assertThrows(IllegalArgumentException.class, () -> {
            Main.validateInput(input);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateInputNonAlphabetCharacters() {
        String excMess = "Please use only alphabet characters.";
        String[] input = {
                "hello!", "hey", "oops"
        };

        Exception exc = assertThrows(IllegalArgumentException.class, () -> {
            Main.validateInput(input);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testValidateInputNumbers() {
        String excMess = "Please use only alphabet characters.";
        String[] input = {
                "hello", "hi11",
        };

        Exception exc = assertThrows(IllegalArgumentException.class, () -> {
            Main.validateInput(input);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testWordsWithUniqueCharsNoWords() {
        String[] input = {"hello", "good", "book"};
        String[] expectedResult = new String[0];
        String[] actualResult = Main.wordsWithUniqueChars(input);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testWordsWithUniqueCharsOneWord() {
        String[] input = {"hi", "hello"};
        String[] expectedResult = {"hi"};
        String[] actualResult = Main.wordsWithUniqueChars(input);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testWordsWithUniqueCharsAllWords() {
        String[] input = {"hi", "night", "magic", "code"};
        String[] expectedResult = {"hi", "night", "magic", "code"};
        String[] actualResult = Main.wordsWithUniqueChars(input);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testWordsWithUniqueCharsSeveralWords() {
        String[] input = {"mystery", "crime", "day", "funny", "night"};
        String[] expectedResult = {"crime", "day", "night"};
        String[] actualResult = Main.wordsWithUniqueChars(input);

        assertArrayEquals(expectedResult, actualResult);
    }
}
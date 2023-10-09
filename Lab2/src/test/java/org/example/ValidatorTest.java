package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Validator.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void validName() {
        assertTrue(isValid("Kate", "name"));
        assertTrue(isValid("White", "lastName"));
        assertFalse(isValid("123", "name"));
        assertFalse(isValid("Henry!", "lastName"));
    }

    @Test
    void validDate() {
        assertTrue(isValid("11.02.2004", "date"));
        assertFalse(isValid("30.02.2034", "date"));
        assertFalse(isValid("hello", "date"));
    }

    @Test
    void validNumber() {
        assertTrue(isValid("+380972342323", "number"));
        assertFalse(isValid("+3809887676561", "number"));
        assertFalse(isValid("zero-zero", "number"));
    }

    @Test
    void validAddress() {
        assertTrue(isValid("Blue River, 34/2", "address"));
        assertTrue(isValid("Blackbeard, 45", "address"));
        assertFalse(isValid("Billy 49, 12/3", "address"));
        assertFalse(isValid("1, Hello", "address"));
        assertFalse(isValid("Green Valley", "address"));
        assertFalse(isValid("Green Valley, 0/12", "address"));
        assertFalse(isValid("Green Valley, 12/0", "address"));
    }

    @Test
    void exceptionEmpty() {
        String errorMess = "Cannot be empty.";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            isEmpty("");
        });

        assertEquals(errorMess, exception.getMessage());

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            isEmpty(" ");
        });

        assertEquals(errorMess, exception1.getMessage());
    }

    @Test
    void exceptionName() {
        String errorName = "Please use only alphabet characters.";

        Exception excName = assertThrows(IllegalArgumentException.class, () -> {
            nameCheck("123");
        });

        assertEquals(errorName, excName.getMessage());
    }

    @Test
    void exceptionDate() {
        String errorDate = "Invalid date format.";

        Exception excName = assertThrows(IllegalArgumentException.class, () -> {
            dateCheck("123");
        });

        assertEquals(errorDate, excName.getMessage());
    }

    @Test
    void exceptionNumber() {
        String errorNumber = "Invalid input.";

        Exception excNumber = assertThrows(IllegalArgumentException.class, () -> {
            numberCheck("123");
        });

        assertEquals(errorNumber, excNumber.getMessage());
    }

    @Test
    void exceptionAddress() {
        String errorAddressArg = "Too many or too less arguments.";
        String errorAddressStreet = "Invalid street number.";
        String errorAddressApartment = "Invalid apartment number.";

        Exception exception0 = assertThrows(IllegalArgumentException.class, () -> {
            addressCheck("Hello");
        });

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            addressCheck("Street, 0/1");
        });

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            addressCheck("Street, 1/0");
        });

        assertEquals(errorAddressArg, exception0.getMessage());
        assertEquals(errorAddressStreet, exception1.getMessage());
        assertEquals(errorAddressApartment, exception2.getMessage());
    }
}
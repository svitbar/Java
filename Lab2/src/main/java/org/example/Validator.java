package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static Boolean isValid(String data, String str) {
        try {
            isEmpty(data);

            switch (str) {
                case "name", "lastName":
                    nameCheck(data);
                    break;
                case "date":
                    dateCheck(data);
                    break;
                case "number":
                    numberCheck(data);
                    break;
                case "address":
                    addressCheck(data);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return false;
        }

        return true;
    }

    public static void isEmpty(String data) {
        if (data.isEmpty() || data.isBlank()) {
            throw new IllegalArgumentException("Cannot be empty.");
        }
    }

    public static void nameCheck(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isLetter(data.charAt(i))) {
                throw new IllegalArgumentException("Please use only alphabet characters.");
            }
        }
    }

    public static void dateCheck(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            Date parsedDate = sdf.parse(data);

            sdf.format(parsedDate);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Invalid date format.");
        }
    }

    public static void numberCheck(String data) {
        if (!data.matches("^(\\+380)\\d{9}$")) {
            throw new IllegalArgumentException("Invalid input.");
        }
    }

    public static void addressCheck(String data) {
        String[] address = data.split(", |/");

        if (address.length > 3 || address.length < 2) {
            throw new IllegalArgumentException("Too many or too less arguments.");
        }

        String[] street = address[0].split(" ");

        for (String word: street) {
            nameCheck(word);
        }

        if (!address[1].matches("^\\d+$") || (Integer.parseInt(address[1]) == 0)) {
            throw new IllegalArgumentException("Invalid street number.");
        }

        if (address.length == 3) {
            if (!address[2].matches("^\\d+$") || (Integer.parseInt(address[2]) == 0)) {
                throw new IllegalArgumentException("Invalid apartment number.");
            }
        }

    }
}

package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CuratorJournal {
    static ArrayList<Person> students = new ArrayList<>();
    private static String input(String mess, Scanner in, String str) {
        String input;

        do {
            System.out.println(mess);

            if (Objects.equals(str, "address")) {
                in.nextLine();
                input = in.nextLine();
            } else input = in.next();

        } while (!Validator.isValid(input, str));

        return input;
    }

    public static void addRecord(Scanner in) {
        String name = input("Input a name: ", in, "name");
        String lastName = input("Input a lastName: ", in, "lastName");
        String date = input("Input a date of birth in dd.MM.yyyy format: ", in, "date");
        String number = input("Input a phone number in +380XXXXXXXXX format: ", in, "number");
        String address = input("Input an address in 'Street name, street number/apartment number' format: ", in, "address");

        students.add(new Person(name, lastName, date, number, address));
    }

    public static void showRecords() {
        if (students.isEmpty()) {
            System.out.println("Journal is empty.");
        } else {
            for (Person i: students) {
                System.out.print("\nStudent #" + (students.indexOf(i) + 1) +
                        "\n" + i.toString());
            }
        }
    }
}

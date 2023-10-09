package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    \nPlease enter:
                    - 'add' if you want to add new record;
                    - 'show' if you want to show all records;
                    - 'exit' if you want to finish the program.
                    """);

            String answer = in.next();

            switch (answer) {
                case "exit":
                    return;
                case "show":
                    CuratorJournal.showRecords();
                    break;
                case "add":
                    CuratorJournal.addRecord(in);
                    break;
                default:
                    System.out.println("Wrong command! Please try again.");
            }
        }
    }
}
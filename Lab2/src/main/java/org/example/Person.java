package org.example;

public class Person {
    private final String name;
    private final String lastName;
    private final String date;
    private final String number;
    private final String address;

    public Person(String name, String lastName, String date, String number, String address) {
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.number = number;
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nName: " + name +
                "\nLastname: " + lastName +
                "\nDate: " + date +
                "\nNumber: " + number +
                "\nAddress: " + address + "\n";
    }
}

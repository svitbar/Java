package org.example.models;

public class Book {
    private final String title;
    private final String author;
    private final String publisher;
    private final int year;
    private final int amountOfPages;
    private final int price;

    public Book(String title, String author, String publisher, int year, int amountOfPages, int price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.amountOfPages = amountOfPages;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nAuthor: " + author +
                "\nPublisher: " + publisher +
                "\nYear of publication: " + year +
                "\nAmount of pages: " + amountOfPages +
                "\nPrice: " + price +
                "\n*****************************************";
    }
}

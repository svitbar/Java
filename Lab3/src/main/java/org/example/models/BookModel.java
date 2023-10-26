package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class BookModel {
    private static final int NUM_BOOKS = 4;
    private static final String[] titles = {
            "Title 1", "Title 2", "Title 3", "Title 4"
    };
    private static final String[] authors = {
            "Author 1", "Author 2", "Author 3", "Author 4"
    };
    private static final String[] publishers = {
            "Publisher 1", "Publisher 2", "Publisher 3", "Publisher 4"
    };
    private static final int[] years = {2001, 2002, 2003, 2004};
    private static final int[] pages = {10, 20, 30, 40};
    private static final int[] prices = {100, 200, 300, 400};
    private final Book[] books;

    public BookModel() {
        books = new Book[NUM_BOOKS];
        getRandomDataset();
    }

    public Book[] getBooks() {
        return books;
    }

    private void getRandomDataset() {
        Random random = new Random();

        for (int i = 0; i < NUM_BOOKS; i ++) {
            books[i] = new Book(
                    titles[random.nextInt(NUM_BOOKS)],
                    authors[random.nextInt(NUM_BOOKS)],
                    publishers[random.nextInt(NUM_BOOKS)],
                    years[random.nextInt(NUM_BOOKS)],
                    pages[random.nextInt(NUM_BOOKS)],
                    prices[random.nextInt(NUM_BOOKS)]
            );
        }
    }

    public String getRandomAuthor() {
        Random random = new Random();
        return authors[random.nextInt(NUM_BOOKS)];
    }

    public String getRandomPublisher() {
        Random random = new Random();
        return publishers[random.nextInt(NUM_BOOKS)];
    }

    public int getRandomYear() {
        Random random = new Random();
        return years[random.nextInt(NUM_BOOKS)];
    }

    public Book[] getProcessedArrayAuthor(String req) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book: books) {
            if (Objects.equals(book.getAuthor(), req)) {
                res.add(book);
            }
        }

        return res.toArray(new Book[0]);
    }

    public Book[] getProcessedArrayPublisher(String req) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book: books) {
            if (Objects.equals(book.getPublisher(), req)) {
                res.add(book);
            }
        }

        return res.toArray(new Book[0]);
    }

    public Book[] getProcessedArrayYear(int req) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book: books) {
            if (book.getYear() > req) {
                res.add(book);
            }
        }

        return res.toArray(new Book[0]);
    }

    public Book[] sortByPublisher() {
        BookComparator comparator = new BookComparator();
        Book[] sortedArray = Arrays.copyOf(books, NUM_BOOKS);
        Arrays.sort(sortedArray, comparator);

        return sortedArray;
    }
}

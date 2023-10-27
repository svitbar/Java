package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class BookModel {
    private static final int NUM_BOOKS = 12;
    private static final String[] titles = {
            "Six of crows", "Throne of Glass", "Skyward", "A Study in Scarlet",
            "Half a King", "The Hunger Games", "A Murder is Announced", "Red Queen",
            "The Lord of the Rings", "Assassin's Apprentice", "The Surgeon", "The Witcher"
    };
    private static final String[] authors = {
            "Leigh Bardugo", "Sarah J. Maas", "Brandon Sanderson", "Sir Arthur Conan Doyle",
            "Joe Abercrombie", "Suzanne Collins", "Agatha Christie", "Victoria Aveyard",
            "J. R. R. Tolkien", "Robin Hobb", "Tess Gerritsen", "Andrzei Sapkowski"
    };
    private static final String[] publishers = {
            "Vivat", "Nebo Booklab Publishing", "Folio", "Scholastic", "KSD",
            "Nash Format", "Astroliabia"
    };
    private static final int[] years = {2016, 2021, 2023, 2018, 2011, 2017, 2022, 2010};
    private static final int[] pages = {
            542, 544, 472, 288, 296, 448, 304, 328, 704, 416
    };
    private static final int[] prices = {
            430, 370, 720, 55, 490, 381, 230, 156, 408, 320, 250, 208
    };
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
                    titles[random.nextInt(titles.length)],
                    authors[random.nextInt(authors.length)],
                    publishers[random.nextInt(publishers.length)],
                    years[random.nextInt(years.length)],
                    pages[random.nextInt(pages.length)],
                    prices[random.nextInt(prices.length)]
            );
        }
    }

    public String getRandomAuthor() {
        Random random = new Random();
        return authors[random.nextInt(authors.length)];
    }

    public String getRandomPublisher() {
        Random random = new Random();
        return publishers[random.nextInt(publishers.length)];
    }

    public int getRandomYear() {
        Random random = new Random();
        return years[random.nextInt(years.length)];
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

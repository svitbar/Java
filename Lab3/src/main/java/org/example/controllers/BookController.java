package org.example.controllers;

import org.example.models.Book;
import org.example.models.BookModel;
import org.example.utils.BookUtils;
import org.example.views.BookView;

public class BookController {
    private final BookModel model;
    private final BookView view;

    public BookController(BookModel model, BookView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.printMessage(BookView.MENU);
        while (true) {
            String cmd = BookUtils.getInput();

            switch (cmd) {
                case BookUtils.EXIT:
                    return;
                case BookUtils.MENU:
                    view.printMessage(BookView.MENU);
                    break;
                case BookUtils.SHOW:
                    showAllBooks();
                    break;
                case BookUtils.AUTHOR:
                    bookByAuthor();
                    break;
                case BookUtils.PUBLISHER:
                    bookByPublisher();
                    break;
                case BookUtils.YEAR:
                    bookAfterYear();
                    break;
                case BookUtils.SORT:
                    showSortedBook();
                    break;
                case BookUtils.SAVE:
                    saveIntoFile();
                    break;
                case BookUtils.READ:
                    readFromFile();
                    break;
                default:
                    System.out.println(BookView.WRONG_CMD);
            }
        }
    }

    public void showAllBooks() {
        view.printMessage(BookView.ALL_BOOKS);
        view.displayBooks(model.getBooks());
    }

    public void bookByAuthor() {
        String author = model.getRandomAuthor();
        Book[] books = model.getProcessedArrayAuthor(author);

        if (books.length == 0) {
            view.printMessage(BookView.NO_AUTHOR + author + ".");
        } else {
            view.printByRequestStr(BookView.BY_AUTHOR, author);
            view.displayBooks(books);
        }
    }

    public void bookByPublisher() {
        String publisher = model.getRandomPublisher();
        Book[] books = model.getProcessedArrayPublisher(publisher);

        if (books.length == 0) {
            view.printMessage(BookView.NO_PUBLISHER + publisher + ".");
        } else {
            view.printByRequestStr(BookView.BY_PUBLISHER, publisher);
            view.displayBooks(books);
        }
    }

    public void bookAfterYear() {
        int year = model.getRandomYear();
        Book[] books = model.getProcessedArrayYear(year);

        if (books.length == 0) {
            view.printMessage(BookView.NO_YEAR + year + " year.");
        } else {
            view.printByRequestStr(BookView.AFTER_YEAR, year + " year");
            view.displayBooks(books);
        }
    }

    public void showSortedBook() {
        view.printMessage(BookView.SORTED);
        view.displayBooks(model.sortByPublisher());
    }

    public void saveIntoFile() {
        String path = BookUtils.getFilePath();

        if (model.writeBooksIntoFile(path)) {
            view.printMessage(BookView.SUCCESS_SAVE + path + ".");
        } else {
            view.printMessage(BookView.FAIL_SAVE + path + ".");
        }
    }

    public void readFromFile() {
        String path = BookUtils.getFilePath();
        Book[] res = model.readBooksFromFile(path);

        if (res != null) {
            view.printMessage(BookView.SUCCESS_READ + path + ":");
            view.displayBooks(res);
        } else {
            view.printMessage(BookView.FAIL_READ + path + ".");
        }
    }
}

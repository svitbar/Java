package org.example;

import org.example.controllers.BookController;
import org.example.models.BookModel;
import org.example.views.BookView;

public class Main {
    public static void main(String[] args) {
        BookModel model = new BookModel();
        BookView view = new BookView();

        BookController controller = new BookController(model, view);

        controller.run();
    }
}
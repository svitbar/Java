package org.example;

import org.example.controllers.TranslatorController;
import org.example.models.Translator;
import org.example.views.TranslatorView;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        TranslatorView view = new TranslatorView();
        TranslatorController controller = new TranslatorController(translator, view);

        controller.run();
    }
}
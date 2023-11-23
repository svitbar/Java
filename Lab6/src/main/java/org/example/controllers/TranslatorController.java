package org.example.controllers;

import org.example.models.Translator;
import org.example.utils.TranslatorUtils;
import org.example.views.TranslatorView;

public class TranslatorController {
    private final Translator translator;
    private final TranslatorView view;

    public TranslatorController(Translator translator, TranslatorView view) {
        this.translator = translator;
        this.view = view;
    }

    public void run() {
        view.printMessage(TranslatorView.MENU);

        while (true) {
            try {
                String cmd = TranslatorUtils.getCommand(TranslatorView.ENTER_CMD);

                switch (cmd) {
                    case TranslatorUtils.EXIT:
                        return;
                    case TranslatorUtils.MENU:
                        view.printMessage(TranslatorView.MENU);
                        break;
                    case TranslatorUtils.SHOW:
                        showDictionary();
                        break;
                    case TranslatorUtils.ADD:
                        addRecord();
                        break;
                    case TranslatorUtils.TRANSLATE:
                        translateText();
                        break;
                    default:
                        view.printMessage(TranslatorView.WRONG_CMD);
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void addRecord() {
        String word = TranslatorUtils.getCommand(TranslatorView.ENTER_WORD);
        String translation = TranslatorUtils.getCommand(TranslatorView.ENTER_TR);

        translator.addNewRecord(word, translation);
    }

    public void translateText() {
        String text = TranslatorUtils.getCommand(TranslatorView.ENTER_TEXT);

        view.printMessage(translator.translatePhrase(text));
    }

    public void showDictionary() {
        view.printMessage(TranslatorView.DICTIONARY);
        view.displayDictionary(translator.getDictionary());
    }
}

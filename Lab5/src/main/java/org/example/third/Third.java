package org.example.third;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Third {
    private static final Logger logger = LogManager.getLogger(Third.class);
    private static ResourceBundle text;
    private static final Scanner sc = new Scanner(System.in);
    private static final char k = 'k';
    private static final String MENU = """
            Please select language:
            - en - English;
            - ua - Українська;
            - la - Latin.
            """;

    private static String getFileName() {
        logger.info(text.getString("enterFileName"));
        return sc.nextLine();
    }

    private static String getSymbolString() {
        logger.info(text.getString("enterStringToEncrypt"));
        return sc.nextLine();
    }

    public static void encryptStream() {
        String path = getFileName();
        String s = getSymbolString();
        logger.debug("path = " + path + ", s = " + s);
        try (Writer w = new Encryptor(new FileWriter(path), k)) {
            logger.debug(text.getString("startWriting"));
            w.write(s);
            logger.info(text.getString("successWriting"));
        } catch (IOException ex) {
           logger.fatal(text.getString("failedWriting") + ex.getMessage());
        }
    }

    public static void decryptStream() {
        String path = getFileName();
        StringBuilder str = new StringBuilder();
        logger.debug("path = " + path);
        try (Reader r = new Decryptor(new FileReader(path), k)) {
            logger.debug(text.getString("startReading"));
            while (true) {
                int c = r.read();
                if (c == -1) break;

                str.append((char) c);
            }

            logger.info(text.getString("successReading") + str);
        } catch (IOException ex) {
            logger.fatal(text.getString("failedReading") + ex.getMessage());
        }
    }

    private static void setLocale(String language) {
        Locale locale = new Locale(language);
        text = ResourceBundle.getBundle("location.text", locale);
    }

    public static void menu() {
        logger.info(MENU);
        String cmd = sc.nextLine();
        boolean con = true;

        do {
            switch (cmd) {
                case "en":
                    setLocale("en");
                    break;
                case "ua":
                    setLocale("ua");
                    break;
                case "la":
                    setLocale("la");
                    break;
                default:
                    con = false;
                    logger.error("Wrong command! Please try again.");
            }
        } while (!con);
    }

    public static void run() {
        try {
            menu();
            encryptStream();
            decryptStream();
        } catch (RuntimeException ex) {
            logger.fatal(ex.getMessage());
        } finally {
            sc.close();
        }
    }
}

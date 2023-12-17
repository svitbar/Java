package org.example.third;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Third {
    private static final Logger logger = LogManager.getLogger(Third.class);
    static char k = 'k';

    private static String getFileName() {
        logger.info("Please enter file name to save data in.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static String getSymbolString() {
        logger.info("Please enter a string to encrypt: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void encryptStream() {
        String path = getFileName();
        String s = getSymbolString();
        logger.debug("path = " + path + ", s = " + s);
        try (Writer w = new Encryptor(new FileWriter(path), k)) {
            logger.debug("Start writing...");
            w.write(s);
            logger.info("Successfully encrypted string and wrote it to file.");
        } catch (IOException ex) {
           logger.fatal("Failed to encrypt data: " + ex.getMessage());
        }
    }

    public static void decryptStream() {
        String path = getFileName();
        StringBuilder str = new StringBuilder();
        logger.debug("path = " + path);
        try (Reader r = new Decryptor(new FileReader(path), k)) {
            logger.debug("Start reading...");
            while (true) {
                int c = r.read();
                if (c == -1) break;

                str.append((char) c);
            }

            logger.info("Successfully decrypted string: " + str);
        } catch (IOException ex) {
            logger.fatal("Failed to decrypt data: " + ex.getMessage());
        }
    }
}

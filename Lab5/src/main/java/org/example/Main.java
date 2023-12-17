package org.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.first.First;
import org.example.fourth.Fourth;
import org.example.third.Third;

import java.io.IOException;

public class Main {
    public static final Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) throws IOException {
        Configurator.setRootLevel(Level.DEBUG);

        logger.info("Starting application...");
        // First.run();
        Third.encryptStream();
        Third.decryptStream();
        // Fourth.run();
        logger.info("Exit application...");
    }
}
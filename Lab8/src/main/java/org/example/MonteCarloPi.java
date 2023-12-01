package org.example;

import java.util.Random;

public class MonteCarloPi {
    public static int getPi(int totalPoints) {
        int insideCircle = 0;
        Random random = new Random();

        for (int i = 0; i < totalPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            double length = Math.sqrt(x * x + y * y);

            if (length <= 1) insideCircle++;
        }

        return insideCircle;
    }
}

package org.example.first;

import java.io.*;
import java.util.Scanner;

public class First {
    public static void run() {
        String path = getFileName();
        String result = readFile();
        writeFile(result, path);
    }

    private static String getFileName() {
        System.out.println("Please enter file name to save data in.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static String readFile() {
        String path = "input.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String s;
            String res = "";
            int count = 0;

            while((s = br.readLine()) != null) {
                String[] w = s.split(" ");
                if (w.length > count) {
                    count = w.length;
                    res = s;
                }
            }

            return res;
        }
        catch (IOException ex) {
            throw new RuntimeException("Failed to read from " + path + ": " + ex.getMessage());
        }
    }

    private static void writeFile(String str, String path) {
        try (BufferedWriter s = new BufferedWriter(new FileWriter(path)))
        {
            s.write(str);
        }
        catch (IOException ex) {
            throw new RuntimeException("Failed to write into " + path + ": " + ex.getMessage());
        }
    }
}

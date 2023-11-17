package org.example.third;

import java.io.*;
import java.util.Scanner;

    public class Third {
        static char k = 'k';
        private static String getFileName() {
            System.out.println("Please enter file name to save data in.");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }

        private static String getSymbolString() {
            System.out.println("Please enter a string to encrypt: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }

        public static void encryptStream() {
            String path = getFileName();
            String s = getSymbolString();
            try(Writer w = new Encryptor(new FileWriter(path), k))
            {
                w.write(s);
            }
            catch (IOException ex) {
                throw new RuntimeException("Failed to encrypt data: " + ex.getMessage());
            }
        }

        public static void decryptStream() {
            String path = getFileName();
            StringBuilder str = new StringBuilder();
            try(Reader r = new Decryptor(new FileReader(path), k))
            {
                while (true) {
                    int c = r.read();
                    if (c == -1) break;

                    str.append((char) c);
                }

                System.out.println(str);
            }
            catch (IOException ex) {
                throw new RuntimeException("Failed to decrypt data: " + ex.getMessage());
            }
        }
    }

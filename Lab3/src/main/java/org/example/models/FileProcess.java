package org.example.models;

import java.io.*;

public class FileProcess {
    public static boolean writeIntoFile(String path, Object o) {
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path)))
        {
            ous.writeObject(o);
            return true;
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static Object readFromFile(String path) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            return ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}

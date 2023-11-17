package org.example.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fourth {
    public static void run() {
        try {
            String urlStr = "https://uk.wikipedia.org/wiki/Java";
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            Map<String, Integer> tagCount = readURL(con);

            displayTags(tagCount);
            sortByFrequency(tagCount);
            sortByName(tagCount);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Map<String, Integer> readURL(URLConnection con) {
        Map<String, Integer> tagFrequency = new HashMap<>();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
        {
            String str;
            Pattern p = Pattern.compile("<\\s*([a-zA-Z]+)\\s*");

            while ((str = in.readLine()) != null) {
                Matcher m = p.matcher(str);
                while(m.find()) {
                    String tag = m.group(1);
                    tagFrequency.put(tag, tagFrequency.getOrDefault(tag, 0) + 1);
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tagFrequency;
    }

    public static void displayTags(Map<String, Integer> tags) {
        for (Map.Entry<String, Integer> entry : tags.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void sortByFrequency(Map<String, Integer> tags) {
        System.out.println("\nSorted by frequency:\n");
        tags.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void sortByName(Map<String, Integer> tags) {
        System.out.println("\nSorted by name:\n");
        tags.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

package org.example.third;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class Encryptor extends FilterWriter {
    private final char key;
    protected Encryptor(Writer out, char key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(String str) throws IOException {
        for (char c: str.toCharArray()) {
            write(c);
        }
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c + key);
    }
}

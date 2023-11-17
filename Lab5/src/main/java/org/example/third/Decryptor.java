package org.example.third;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class Decryptor extends FilterReader {

    private final char key;
    protected Decryptor(Reader in, char key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int s = super.read();
        return (s == -1)? -1 : s - key;
    }
}

package com.zachurchill.homework4;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class FileEncrypterTemplate {
    public FileEncrypterTemplate() {
    }

    public abstract String encrypt(String plaintext);
    public abstract String decrypt(String cyphertext);

    public void encrypt(InputStream inStream, OutputStream outStream) {
        // TODO
    }

    public void decrypt(InputStream inStream, OutputStream outStream) {
        // TODO
    }
}

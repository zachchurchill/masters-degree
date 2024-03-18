package com.zachurchill.homework4;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class FileEncrypter {
    public FileEncrypter() {
    }

    public abstract String encrypt(String plaintext);
    public abstract String decrypt(String cyphertext);

    private void algorithm(boolean encrypt, InputStream inStream, OutputStream outStream) {
        Scanner scanner = new Scanner(inStream);
        PrintWriter writer = new PrintWriter(outStream);

        while (scanner.hasNextLine()) {
            String text = encrypt
                ? this.encrypt(scanner.nextLine())
                : this.decrypt(scanner.nextLine());
            writer.write(text);
            writer.write("\n");
        }
        writer.flush();
        writer.close();
        scanner.close();
    }

    public void encrypt(InputStream inStream, OutputStream outStream) {
        algorithm(true, inStream, outStream);
    }

    public void decrypt(InputStream inStream, OutputStream outStream) {
        algorithm(false, inStream, outStream);
    }
}

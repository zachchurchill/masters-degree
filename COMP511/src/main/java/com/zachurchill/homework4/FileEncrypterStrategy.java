package com.zachurchill.homework4;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileEncrypterStrategy {

    private EncryptionStrategy strategy;

    public FileEncrypterStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    private void algorithm(boolean encrypt, InputStream inStream, OutputStream outStream) {
        Scanner scanner = new Scanner(inStream);
        PrintWriter writer = new PrintWriter(outStream);

        while (scanner.hasNextLine()) {
            String text = encrypt
                ? this.strategy.encrypt(scanner.nextLine())
                : this.strategy.decrypt(scanner.nextLine());
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

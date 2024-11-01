package com.zachurchill.homework4;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

class FileEncrypterStrategyTests {

    private OutputStream outStream;

    @BeforeEach
    void setUp() {
        this.outStream = new ByteArrayOutputStream();
    }

    @Test
    void testSubstitutionEncrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        InputStream plainTextStream = new ByteArrayInputStream(plainText.getBytes());
        SubstitutionCypher cipher = new SubstitutionCypher("nopqrstuvwxyzabcdefghijklm");
        String cipherText = "Uryyb, jbeyq.\nNggnpx ng qnja!\n";

        FileEncrypterStrategy fileEncrypter = new FileEncrypterStrategy(cipher);
        fileEncrypter.encrypt(plainTextStream, this.outStream);
        assertEquals(cipherText, this.outStream.toString());
    }

    @Test
    void testSubstitutionDecrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        SubstitutionCypher cipher = new SubstitutionCypher("nopqrstuvwxyzabcdefghijklm");
        String cipherText = "Uryyb, jbeyq.\nNggnpx ng qnja!\n";
        InputStream cipherTextStream = new ByteArrayInputStream(cipherText.getBytes());

        FileEncrypterStrategy fileEncrypter = new FileEncrypterStrategy(cipher);
        fileEncrypter.decrypt(cipherTextStream, this.outStream);
        assertEquals(plainText, this.outStream.toString());
    }

    @Test
    void testTranspositionEncrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        InputStream plainTextStream = new ByteArrayInputStream(plainText.getBytes());
        TranspositionCypher cipher = new TranspositionCypher(3, 5);
        String cipherText = "H,le dlw.lo or \nAkdt atawatnc !\n";

        FileEncrypterStrategy fileEncrypter = new FileEncrypterStrategy(cipher);
        fileEncrypter.encrypt(plainTextStream, this.outStream);
        System.out.println(cipherText);
        System.out.println(this.outStream.toString());
        assertEquals(cipherText, this.outStream.toString());
    }


    @Test
    void testTranspositionDecrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        TranspositionCypher cipher = new TranspositionCypher(3, 5);
        String cipherText = "H,le dlw.lo or \nAkdt atawatnc !\n";
        InputStream cipherTextStream = new ByteArrayInputStream(cipherText.getBytes());

        FileEncrypterStrategy fileEncrypter = new FileEncrypterStrategy(cipher);
        fileEncrypter.decrypt(cipherTextStream, this.outStream);
        assertEquals(plainText, this.outStream.toString());
    }
}

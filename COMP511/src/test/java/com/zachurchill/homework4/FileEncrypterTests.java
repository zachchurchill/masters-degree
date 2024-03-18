package com.zachurchill.homework4;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

class FileEncrypterTests {

    private OutputStream outStream;

    @BeforeEach
    void setUp() {
        this.outStream = new ByteArrayOutputStream();
    }

    @Test
    void testSubstitutionEncrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        InputStream plainTextStream = new ByteArrayInputStream(plainText.getBytes());
        String cipherText = "Uryyb, jbeyq.\nNggnpx ng qnja!\n";

        FileEncrypter fileEncrypter = new SubstitutionCypher("nopqrstuvwxyzabcdefghijklm");
        fileEncrypter.encrypt(plainTextStream, this.outStream);
        assertEquals(cipherText, this.outStream.toString());
    }

    @Test
    void testSubstitutionDecrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        String cipherText = "Uryyb, jbeyq.\nNggnpx ng qnja!\n";
        InputStream cipherTextStream = new ByteArrayInputStream(cipherText.getBytes());

        FileEncrypter fileEncrypter = new SubstitutionCypher("nopqrstuvwxyzabcdefghijklm");
        fileEncrypter.decrypt(cipherTextStream, this.outStream);
        assertEquals(plainText, this.outStream.toString());
    }

    @Test
    void testTranspositionEncrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        InputStream plainTextStream = new ByteArrayInputStream(plainText.getBytes());
        String cipherText = "H,le dlw.lo or \nAkdt atawatnc !\n";

        FileEncrypter fileEncrypter = new TranspositionCypher(3, 5);
        fileEncrypter.encrypt(plainTextStream, this.outStream);
        System.out.println(cipherText);
        System.out.println(this.outStream.toString());
        assertEquals(cipherText, this.outStream.toString());
    }


    @Test
    void testTranspositionDecrypt() {
        String plainText = "Hello, world.\nAttack at dawn!\n";
        String cipherText = "H,le dlw.lo or \nAkdt atawatnc !\n";
        InputStream cipherTextStream = new ByteArrayInputStream(cipherText.getBytes());

        FileEncrypter fileEncrypter = new TranspositionCypher(3, 5);
        fileEncrypter.decrypt(cipherTextStream, this.outStream);
        assertEquals(plainText, this.outStream.toString());
    }
}

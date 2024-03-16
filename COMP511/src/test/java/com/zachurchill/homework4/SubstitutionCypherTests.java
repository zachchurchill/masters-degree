package com.zachurchill.homework4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubstitutionCypherTests {

    @Test
    void testAttackAtDawn() {
        SubstitutionCypher cipher = new SubstitutionCypher("nopqrstuvwxyzabcdefghijklm");
        String plainText = "Attack at dawn!";
        String cipherText = "Nggnpx ng qnja!";
        assertEquals(cipherText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(cipherText));
    }

    @Test
    void testHelloWorld() {
        SubstitutionCypher cipher = new SubstitutionCypher("qwertyuiopasdfghjklzxcvbnm");
        String plainText = "Hello, world.";
        String cipherText = "Itssg, vgksr.";
        assertEquals(cipherText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(cipherText));
    }
}

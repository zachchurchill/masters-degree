package com.zachurchill.homework4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

class TranspositionCypherTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testThreeByFiveAttackAtDawn() {
        TranspositionCypher cipher = new TranspositionCypher(3, 5);
        String plainText = "Attack at dawn!";
        String cipherText = "Akdt atawatnc !";
        assertEquals(cipherText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(cipherText));
    }

    @Test
    void testFiveByThreeAttackAtDawn() {
        TranspositionCypher cipher = new TranspositionCypher(5, 3);
        String plainText = "Akdt atawatnc !";
        String cipherText = "Attack at dawn!";
        assertEquals(cipherText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(cipherText));
    }

    @Test
    void testNoEncryptTrans() {
        TranspositionCypher cipher = new TranspositionCypher(1, 1);
        String plainText = "Hello, world.";
        assertEquals(plainText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(plainText));
    }

    @Test
    void testPairSwapTrans() {
        TranspositionCypher cipher = new TranspositionCypher(2, 2);
        String plainText = "Hello, world.";
        String cipherText = "Hlelo ,wolrd.";
        assertEquals(cipherText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(cipherText));
    }

    @Test
    void testLongMessageTrans() {
        TranspositionCypher cipher = new TranspositionCypher(2, 2);
        String plainText = "Product models a product in a store. It has a name and a price and several methods to access those pieces of data.";
        String cipherText = "Pcdrteo ldmsuo adi unpc rtao  s.ht aoIsrt e a  ana anpmdre icdee r saaelnv md esat chtcooesoisse ect ehps a ot fa  . d";
        assertEquals(cipherText, cipher.encrypt(plainText));
        assertEquals(plainText, cipher.decrypt(cipherText));
    }
}

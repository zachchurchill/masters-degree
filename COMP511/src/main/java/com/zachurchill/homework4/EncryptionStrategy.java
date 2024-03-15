package com.zachurchill.homework4;

public interface EncryptionStrategy {
    String encrypt(String plaintext);
    String decrypt(String cyphertext);
}

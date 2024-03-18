package com.zachurchill.homework4;

class SubstitutionCypher extends FileEncrypter implements EncryptionStrategy {

    private String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String upperAlphabet = lowerAlphabet.toUpperCase();
    private String lowerCipher;
    private String upperCipher;

    public SubstitutionCypher(String key) {
        this.lowerCipher = key;
        this.upperCipher = key.toUpperCase();
    }

    public String encrypt(String plaintext) {
        StringBuffer cipherText = new StringBuffer();
        char ch;
        int idx;
        for (int i = 0; i < plaintext.length(); i++) {
            ch = plaintext.charAt(i);
            if (Character.isLowerCase(ch)) {
                idx = lowerAlphabet.indexOf(plaintext.charAt(i));
                cipherText.append(lowerCipher.charAt(idx));
            } else if (Character.isUpperCase(ch)) {
                idx = upperAlphabet.indexOf(plaintext.charAt(i));
                cipherText.append(upperCipher.charAt(idx));
            } else {
                cipherText.append(ch);
            }
        }
        return cipherText.toString();
    }

    public String decrypt(String cyphertext) {
        StringBuffer plaintext = new StringBuffer();
        char ch;
        int idx;
        for (int i = 0; i < cyphertext.length(); i++) {
            ch = cyphertext.charAt(i);
            if (Character.isLowerCase(ch)) {
                idx = lowerCipher.indexOf(cyphertext.charAt(i));
                plaintext.append(lowerAlphabet.charAt(idx));
            } else if (Character.isUpperCase(ch)) {
                idx = upperCipher.indexOf(cyphertext.charAt(i));
                plaintext.append(upperAlphabet.charAt(idx));
            } else {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }
}

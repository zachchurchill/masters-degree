package com.zachurchill.homework4;

class TranspositionCypher {

    private int rows;
    private int cols;

    public TranspositionCypher(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public String encrypt(String plaintext) {
        StringBuffer ciphertext = new StringBuffer();
        char[][] transpose = new char[this.rows][this.cols];
        int idx;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                idx = i * this.cols + j;
                if (idx < plaintext.length()) {
                    transpose[i][j] = plaintext.charAt(idx);
                }
            }
        }
        for (int j = 0; j < this.cols; j++) {
            for (int i = 0; i < this.rows; i++) {
                ciphertext.append(transpose[i][j]);
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String cyphertext) {
        StringBuffer plaintext = new StringBuffer();
        char[][] transpose = new char[this.cols][this.rows];
        int idx;
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                idx = i * this.rows + j;
                if (idx < cyphertext.length()) {
                    transpose[i][j] = cyphertext.charAt(idx);
                }
            }
        }
        for (int j = 0; j < this.rows; j++) {
            for (int i = 0; i < this.cols; i++) {
                plaintext.append(transpose[i][j]);
            }
        }
        return plaintext.toString();
    }
}

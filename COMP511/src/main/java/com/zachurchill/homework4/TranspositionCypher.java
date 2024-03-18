package com.zachurchill.homework4;

class TranspositionCypher extends FileEncrypter implements EncryptionStrategy {

    private int rows;
    private int cols;
    private int stepSize;

    public TranspositionCypher(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.stepSize = rows * cols;
    }

    private String transpose(String text, boolean encrypt) {
        int dim1 = encrypt ? this.rows : this.cols;
        int dim2 = encrypt ? this.cols : this.rows;
        StringBuffer transposedText = new StringBuffer();
        char[][] transpose = new char[dim1][dim2];
        int idx = 0;
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                idx = i * dim2 + j;
                if (idx < text.length()) {
                    transpose[i][j] = text.charAt(idx);
                } else {
                    transpose[i][j] = ' ';
                }
            }
        }
        for (int j = 0; j < dim2; j++) {
            for (int i = 0; i < dim1; i++) {
                if (!Character.isIdentifierIgnorable(transpose[i][j])) {
                    transposedText.append(transpose[i][j]);
                } 
            }
        }
        return transposedText.toString();
    }

    public String encrypt(String plaintext) {
        StringBuffer cyphertext = new StringBuffer();
        for (int i = 0; i < plaintext.length(); i += this.stepSize) {
            String chunk = plaintext.substring(i, Math.min(i + this.stepSize, plaintext.length()));
            cyphertext.append(transpose(chunk, true));
        }
        return cyphertext.toString();
    }

    public String decrypt(String cyphertext) {
        StringBuffer plaintext = new StringBuffer();
        for (int i = 0; i < cyphertext.length(); i += this.stepSize) {
            String chunk = cyphertext.substring(i, Math.min(i + this.stepSize, cyphertext.length()));
            plaintext.append(transpose(chunk, false));
        }
        return plaintext.toString().trim();
    }
}

package com.zachurchill.homework2;

public class Word {
    private String language;
    private String word;

    public Word(String language, String word) {
        this.language = language;
        this.word = word;
    }

    public String getLanguage() { return language; }
    public String getWord() { return word; }
}

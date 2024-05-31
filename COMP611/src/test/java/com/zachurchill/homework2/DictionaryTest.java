package com.zachurchill.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class DictionaryTest {

  private Dictionary dictionary;

  @BeforeEach
  public void setUp() {
    this.dictionary = new Dictionary();
  }

  @Test
  public void testEnglishToSpanishTranslation() {
    Word hello = new Word("EN", "hello");
    Word hola = new Word("SP", "hola");
    List<Word> translations = new ArrayList<>();
    translations.add(hello);
    translations.add(hola);
    this.dictionary.addTranslation(translations);
    assertEquals("hola", this.dictionary.translateWord(hello, "SP"));
    assertEquals("hello", this.dictionary.translateWord(hola, "EN"));
  }

  @Test
  public void testEnglishToSpanishToChineseTranslation() {
    Word hello = new Word("EN", "hello");
    Word hola = new Word("SP", "hola");
    Word nihao = new Word("CH", "ni hao");
    List<Word> translations = new ArrayList<>();
    translations.add(hello);
    translations.add(hola);
    translations.add(nihao);
    this.dictionary.addTranslation(translations);
    assertEquals("hola", this.dictionary.translateWord(hello, "SP"));
    assertEquals("hola", this.dictionary.translateWord(nihao, "SP"));
    assertEquals("hello", this.dictionary.translateWord(hola, "EN"));
    assertEquals("hello", this.dictionary.translateWord(nihao, "EN"));
    assertEquals("ni hao", this.dictionary.translateWord(hello, "CH"));
    assertEquals("ni hao", this.dictionary.translateWord(hola, "CH"));
  }
}

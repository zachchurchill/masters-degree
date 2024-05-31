package com.zachurchill.homework2;

import java.util.HashMap;
import java.util.List;

public class Dictionary {

  // we want to associate one word with multiple other words
  // ["hello", "hola", "ni hao"] with languages ["EN", "SP", "CH"]
  // hello => hola & ni hao; hola => hello & ni hao; ni hao => hello, hola
  private HashMap<Word, HashMap<String, String>> dictionary;
  
  public Dictionary() {
    this.dictionary = new HashMap<>();
  }

  /**
   * Adds a list of words that mean the same thing to the Dictionary.
   * Time complexity: O(n^2)
   */
  public void addTranslation(List<Word> words) {
    for (Word word : words) {
      HashMap<String, String> translations = new HashMap<>();
      for (Word w : words) {
        if (!w.equals(word)) {
          translations.put(w.getLanguage(), w.getWord());
        }
      }
      this.dictionary.put(word, translations);
    }
    System.out.println(this.dictionary.toString());
  }

  /**
   * Finds the translation of the given word in the Dictionary.
   * Time complexity: O(1)
   */
  public String translateWord(Word word, String destLanguage) {
    return this.dictionary.get(word).get(destLanguage);
  }

  public static void main(String[] args) {
  }
}

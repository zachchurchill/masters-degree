package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComparerTests {

  private Comparer comparer;

  @BeforeEach
  public void setUp() {
    this.comparer = new Comparer();
  }

  @Test
  public void testFalse() {
    assertFalse(this.comparer.compare("asdf", "qwerty"));
    assertFalse(this.comparer.compare("asdf qwerty", "asdff qwerty"));
    assertFalse(this.comparer.compare("", "asdf"));
    assertFalse(this.comparer.compare("asdf", ""));
    assertFalse(this.comparer.compare("aa", "a"));
  }

  @Test
  public void testTrue() {
    assertTrue(this.comparer.compare("asdf", "asdf"));
    assertTrue(this.comparer.compare("asdf qwerty", "asdf qwerty"));
    assertTrue(this.comparer.compare("", ""));
    assertTrue(this.comparer.compare("a bb ccc", "a bb ccc"));
  }
}

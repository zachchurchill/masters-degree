package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;

class CompareReversedTests {

  private CompareReversed checker;

  @BeforeEach
  public void setUp() {
    this.checker = new CompareReversed();
  }

  @Test
  public void testFalse() {
    assertFalse(this.checker.compareReversed("asdf", "dsa"));
    assertFalse(this.checker.compareReversed("asdf", "fdsa "));
    assertFalse(this.checker.compareReversed("", "asdf"));
    assertFalse(this.checker.compareReversed("asdf", ""));
  }

  @Test
  public void testTrue() {
    assertTrue(this.checker.compareReversed("asdf", "fdsa"));
    assertTrue(this.checker.compareReversed("asdf qwerty", "ytrewq fdsa"));
    assertTrue(this.checker.compareReversed("fdsasdf", "fdsasdf"));
    assertTrue(this.checker.compareReversed("", ""));
  }
}

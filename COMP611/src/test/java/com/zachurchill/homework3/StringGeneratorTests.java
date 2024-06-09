package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringGeneratorTests {

  private StringGenerator strings;

  @BeforeEach
  public void setUp() {
    this.strings = new StringGenerator();
  }

  @Test
  public void testBase2Length3() {
    ArrayList<String> expected = new ArrayList<>();
    expected.add("000");
    expected.add("010");
    expected.add("001");
    expected.add("100");
    expected.add("110");
    expected.add("101");
    expected.add("011");
    expected.add("111");
    List<String> actual = this.strings.generateAllStrings(3, 2);
    assertTrue(expected.containsAll(actual));
    assertTrue(actual.containsAll(expected));
  }

  @Test
  public void testBase4Length2() {
    ArrayList<String> expected = new ArrayList<>();
    expected.add("00");
    expected.add("01");
    expected.add("02");
    expected.add("03");
    expected.add("10");
    expected.add("11");
    expected.add("12");
    expected.add("13");
    expected.add("20");
    expected.add("21");
    expected.add("22");
    expected.add("23");
    expected.add("30");
    expected.add("31");
    expected.add("32");
    expected.add("33");
    List<String> actual = this.strings.generateAllStrings(2, 4);
    assertTrue(expected.containsAll(actual));
    assertTrue(actual.containsAll(expected));
  }
}

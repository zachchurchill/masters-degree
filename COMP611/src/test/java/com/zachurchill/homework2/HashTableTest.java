package com.zachurchill.homework2;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {

  private HashTable<Integer> hashTable;

  @BeforeEach
  public void setUp() {
    this.hashTable = new HashTable<>();
  }

  @Test
  public void testConstructionDefaultsToTenWithEmpty() {
    for (int i = 0; i < 10; ++i) {
      List<Integer> chain = this.hashTable.getChain(i);
      assertEquals(0, chain.size());
    }
    assertThrows(IndexOutOfBoundsException.class, () -> this.hashTable.getChain(10));
  }

  @Test
  public void testAddingElementToEachSlot() {
    for (int i = 0; i < 10; ++i) {
      assertTrue(this.hashTable.put(i));
    }
    // We know size is 10 & that the hash code of an integer is just the integer.
    // Thus, we know each slot should have 1 element.
    for (int i = 0; i < 10; ++i) {
      List<Integer> chain = this.hashTable.getChain(i);
      assertEquals(1, chain.size());
      assertEquals(i, chain.get(0));
    }
  }

  @Test
  public void testAddingDuplicateReturnsFalse() {
    assertTrue(this.hashTable.put(5));
    assertFalse(this.hashTable.put(5));
  }
}

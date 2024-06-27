package com.zachurchill.homework6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  public void testBinaryHeapAddToEmpty() {
    Heap heap = new Heap(2);
    assertEquals(0, heap.getData().size());
    heap.add(10);
    assertEquals(1, heap.getData().size());
    assertEquals(10, heap.getData().get(0));
  }

  @Test
  public void testBinaryHeapAddLargestValue() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);
    values.add(5);
    values.add(10);
    Heap heap = new Heap(2, values);
    assertEquals(3, heap.getData().size());
    Integer largestValue = Collections.max(values) + 1;
    heap.add(largestValue);
    assertEquals(4, heap.getData().size());
    assertEquals(largestValue, heap.getData().get(3));
  }

  @Test
  public void testBinaryHeapAddSmallestValue() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);
    values.add(5);
    values.add(10);
    Heap heap = new Heap(2, values);
    assertEquals(3, heap.getData().size());
    Integer smallestValue = Collections.min(values) - 1;
    heap.add(smallestValue);
    assertEquals(4, heap.getData().size());
    assertEquals(smallestValue, heap.getData().get(0));
  }

  @Test
  public void testBinaryHeapAddMiddleValue() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);
    values.add(5);
    values.add(10);
    Heap heap = new Heap(2, values);
    assertEquals(3, heap.getData().size());
    heap.add(3);
    assertEquals(4, heap.getData().size());
    assertEquals(3, heap.getData().get(1));
  }

  @Test
  public void testTernaryHeapAddMiddleValue() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);  // root
    values.add(5);
    values.add(10);
    values.add(7);
    values.add(13); // under 5, far left
    Heap heap = new Heap(3, values);
    assertEquals(5, heap.getData().size());
    heap.add(3);
    assertEquals(6, heap.getData().size());
    assertEquals(3, heap.getData().get(1));
  }

  @Test
  public void testValuesCorrectlyConstructedIsHeap() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);  // root            | root
    values.add(5);
    values.add(10);
    values.add(7);  // under 5, left
    values.add(13); // under 5, right  | under 5, left
    values.add(11); // under 10, left  | under 5, center
    Heap binaryHeap = new Heap(2, values);
    assertTrue(binaryHeap.isHeap());
    Heap ternaryHeap = new Heap(3, values);
    assertTrue(ternaryHeap.isHeap());
  }

  @Test
  public void testValuesIncorrectlyConstructedNotHeap() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);  // root            | root
    values.add(5);
    values.add(10);
    values.add(4);  // under 5, left
    values.add(13); // under 5, right  | under 5, left
    values.add(1); // under 10, left  | under 5, center
    Heap binaryHeap = new Heap(2, values);
    assertFalse(binaryHeap.isHeap());
    Heap ternaryHeap = new Heap(3, values);
    assertFalse(ternaryHeap.isHeap());
  }

  @Test
  public void testExtractMinBinaryHeap() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);  // root
    values.add(5);
    values.add(10);
    values.add(7);  // under 5, left
    values.add(13); // under 5, right
    values.add(11); // under 10, left
    Heap heap = new Heap(2, values);
    assertEquals(6, heap.getData().size());
    assertEquals(2, heap.extractMin());
    ArrayList<Integer> expected = new ArrayList<>();
    expected.add(5);
    expected.add(7);
    expected.add(10);
    expected.add(11);
    expected.add(13);
    assertEquals(expected, heap.getData());
  }

  @Test
  public void testExtractMinSingleValue() {
    ArrayList<Integer> values = new ArrayList<>();
    values.add(2);
    Heap heap = new Heap(2, values);
    assertEquals(2, heap.extractMin());
    assertEquals(0, heap.getData().size());
  }
}

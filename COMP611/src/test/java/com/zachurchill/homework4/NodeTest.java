package com.zachurchill.homework4;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

  @Test
  public void testHeightOne() {
    Node<Integer> root = new Node<>(10);
    assertEquals(1, root.getHeight());
  }

  @Test
  public void testHeightTwo() {
    Node<Integer> left = new Node<>(1000);
    Node<Integer> right = new Node<>(12);
    Node<Integer> root = new Node<>(3, left, right);
    assertEquals(2, root.getHeight());
    assertEquals(1, left.getHeight());
    assertEquals(1, right.getHeight());

    Node<Integer> oneChildRoot = new Node<>(140, left, null);
    assertEquals(2, oneChildRoot.getHeight());
  }

  @Test
  public void testHeightThree() {
    //     root
    //     /  \
    //   mid1 mid2
    //  /     /   \
    //leaf1  leaf2 leaf3
    Node<Integer> leaf1 = new Node<>(123);
    Node<Integer> leaf2 = new Node<>(234);
    Node<Integer> leaf3 = new Node<>(345);
    Node<Integer> mid1 = new Node<>(12, leaf1, null);
    Node<Integer> mid2 = new Node<>(57, leaf2, leaf3);
    Node<Integer> root = new Node<>(3, mid1, mid2);
    assertEquals(3, root.getHeight());
    assertEquals(2, mid1.getHeight());
    assertEquals(2, mid2.getHeight());
    assertEquals(1, leaf1.getHeight());
    assertEquals(1, leaf2.getHeight());
    assertEquals(1, leaf3.getHeight());
  }

  @Test
  public void testSingleNodeFull() {
    Node<Integer> root = new Node<>(12);
    assertTrue(root.isFull());
  }

  @Test
  public void testOneChildNotFull() {
    Node<Integer> left = new Node<>(1000);
    Node<Integer> oneChildRoot = new Node<>(140, left, null);
    assertFalse(oneChildRoot.isFull());
  }

  @Test
  public void testFullTreeIsFull() {
    //        root
    //     /        \
    //   mid1       mid2
    //  /    \     /    \
    //leaf1 leaf2 leaf3 leaf4
    Node<Integer> leaf1 = new Node<>(123);
    Node<Integer> leaf2 = new Node<>(234);
    Node<Integer> leaf3 = new Node<>(345);
    Node<Integer> leaf4 = new Node<>(567);
    Node<Integer> mid1 = new Node<>(12, leaf1, leaf2);
    Node<Integer> mid2 = new Node<>(57, leaf3, leaf4);
    Node<Integer> root = new Node<>(3, mid1, mid2);
    assertTrue(root.isFull());
    assertTrue(mid1.isFull());
    assertTrue(mid2.isFull());
  }

  @Test
  public void testAlmostFullTreeSometimesFull() {
    //         root
    //     /          \
    //   mid1         mid2
    //  /    \       /    \
    //leaf1 <null> leaf2 leaf3
    Node<Integer> leaf1 = new Node<>(123);
    Node<Integer> leaf2 = new Node<>(234);
    Node<Integer> leaf3 = new Node<>(345);
    Node<Integer> mid1 = new Node<>(12, leaf1, null);
    Node<Integer> mid2 = new Node<>(57, leaf2, leaf3);
    Node<Integer> root = new Node<>(3, mid1, mid2);
    assertFalse(root.isFull());
    assertFalse(mid1.isFull());
    assertTrue(mid2.isFull());
  }

  @Test
  public void testHeightOneInLevelOrder() {
    Node<Integer> root = new Node<>(23);
    ArrayList<Integer> inLevelOrder = new ArrayList<>();
    inLevelOrder.add(23);
    assertEquals(inLevelOrder, Node.valuesInLevelOrder(root));
  }

  @Test
  public void testHeightTwoInLevelOrder() {
    //        root
    //     /        \
    //   mid1       mid2
    Node<Integer> mid1 = new Node<>(12);
    Node<Integer> mid2 = new Node<>(57);
    Node<Integer> root = new Node<>(3, mid1, mid2);
    ArrayList<Integer> inLevelOrder = new ArrayList<>();
    inLevelOrder.add(3);
    inLevelOrder.add(12);
    inLevelOrder.add(57);
    assertEquals(inLevelOrder, Node.valuesInLevelOrder(root));
  }

  @Test
  public void testHeightThreeInLevelOrder() {
    //        root
    //     /        \
    //   mid1       mid2
    //  /    \     /    \
    //leaf1 leaf2 leaf3 leaf4
    Node<Integer> leaf1 = new Node<>(123);
    Node<Integer> leaf2 = new Node<>(234);
    Node<Integer> leaf3 = new Node<>(345);
    Node<Integer> leaf4 = new Node<>(567);
    Node<Integer> mid1 = new Node<>(12, leaf1, leaf2);
    Node<Integer> mid2 = new Node<>(57, leaf3, leaf4);
    Node<Integer> root = new Node<>(3, mid1, mid2);
    ArrayList<Integer> inLevelOrder = new ArrayList<>();
    inLevelOrder.add(3);
    inLevelOrder.add(12);
    inLevelOrder.add(57);
    inLevelOrder.add(123);
    inLevelOrder.add(234);
    inLevelOrder.add(345);
    inLevelOrder.add(567);
    assertEquals(inLevelOrder, Node.valuesInLevelOrder(root));
  }
}

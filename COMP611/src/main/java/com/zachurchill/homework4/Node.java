package com.zachurchill.homework4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node<E> {
  E data;
  Node<E> leftChild;
  Node<E> rightChild;

  public Node() {

  }

  public Node(E data) {
      this.data = data;
  }

  public Node(Node<E> left, Node<E> right) {
      this.leftChild = left;
      this.rightChild = right;
  }

  public Node(E data, Node<E> left, Node<E> right) {
      this.data = data;
      this.leftChild = left;
      this.rightChild = right;
  }

  public int getHeight() {
    // How do I know when I'm at the root and not mid?
    return 1 + Math.max(
      (this.leftChild != null ? this.leftChild.getHeight() : 0),
      (this.rightChild != null ? this.rightChild.getHeight() : 0)
    );

  }

  boolean isFull() {
    if (this.leftChild == null && this.rightChild == null) {
      return true;
    } else {
      return (this.leftChild != null ? this.leftChild.isFull() : false)
      && (this.rightChild != null ? this.rightChild.isFull() : false);
    }
  }

  public static List<Integer> valuesInLevelOrder(Node<Integer> root) {
    // Lists the tree in order by nodes at each depth
    ArrayList<Integer> inLevelOrder = new ArrayList<>();
    Queue<Node<Integer>> helperQueue = new LinkedList<>();
    helperQueue.add(root);
    while (!helperQueue.isEmpty()) {
      Node<Integer> node = helperQueue.remove();
      inLevelOrder.add(node.data);
      if (node.leftChild != null) {
        helperQueue.add(node.leftChild);
      }
      if (node.rightChild != null) {
        helperQueue.add(node.rightChild);
      }
    }
    return inLevelOrder;
  }

  public static void main(String [] args) {

  }
}

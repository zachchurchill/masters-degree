package com.zachurchill.homework5;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchVisitorTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  public void testEmptySearch() {
    Node leftChild = new Node("child1", null, null);
    Node rightChild = new Node("child2", null, null);
    Node root = new Node("root", leftChild, rightChild);
    SearchVisitor findNonExistent = new SearchVisitor("asdf");
    root.accept(findNonExistent);

    List<String> foundNodes = findNonExistent.getResult();
    assertEquals(0, foundNodes.size());
  }

  @Test
  public void testSearchChild1() {
    Node leftChild = new Node("child1", null, null);
    Node rightChild = new Node("child2", null, null);
    Node root = new Node("root", leftChild, rightChild);
    SearchVisitor findChild1 = new SearchVisitor("child1");
    root.accept(findChild1);

    List<String> foundNodes = findChild1.getResult();
    assertEquals(1, foundNodes.size());
    assertEquals("child1", foundNodes.get(0));
  }

  @Test
  public void testSearchRoot() {
    Node leftChild = new Node("child1", null, null);
    Node rightChild = new Node("child2", null, null);
    Node root = new Node("root", leftChild, rightChild);
    SearchVisitor findRoot = new SearchVisitor("root");
    root.accept(findRoot);

    List<String> foundNodes = findRoot.getResult();
    assertEquals(3, foundNodes.size());
    assertEquals("root", foundNodes.get(0));
    assertEquals("child1", foundNodes.get(1));
    assertEquals("child2", foundNodes.get(2));
  }

  @Test
  public void testSearchRootSlash() {
    Node leftChild = new Node("child1", null, null);
    Node rightChild = new Node("child2", null, null);
    Node root = new Node("root", leftChild, rightChild);
    SearchVisitor findRootSlash = new SearchVisitor("root/");
    root.accept(findRootSlash);

    List<String> foundNodes = findRootSlash.getResult();
    assertEquals(2, foundNodes.size());
    assertEquals("child1", foundNodes.get(0));
    assertEquals("child2", foundNodes.get(1));
  }

  @Test
  public void testSearchSlash() {
    Node leftChild = new Node("child1", null, null);
    Node rightChild = new Node("child2", null, null);
    Node root = new Node("root", leftChild, rightChild);
    SearchVisitor findRootSlash = new SearchVisitor("/");
    root.accept(findRootSlash);

    List<String> foundNodes = findRootSlash.getResult();
    assertEquals(3, foundNodes.size());
    assertEquals("root", foundNodes.get(0));
    assertEquals("child1", foundNodes.get(1));
    assertEquals("child2", foundNodes.get(2));
  }

  @Test
  public void testLargerTree() {
    Node timsCat = new Node("tCat", null, null);
    Node timsDog = new Node("tDog", null, null);
    Node tim = new Node("tim", timsCat, timsDog);
    Node nancysDog = new Node("nDog", null, null);
    Node nancy = new Node("nancy", nancysDog, null);
    Node williams = new Node("williams", tim, nancy);
    SearchVisitor findWilliamsSlash= new SearchVisitor("williams/");
    williams.accept(findWilliamsSlash);

    List<String> foundNodes = findWilliamsSlash.getResult();
    assertEquals(5, foundNodes.size());
    assertEquals("tim", foundNodes.get(0));
    assertEquals("tCat", foundNodes.get(1));
    assertEquals("tDog", foundNodes.get(2));
    assertEquals("nancy", foundNodes.get(3));
    assertEquals("nDog", foundNodes.get(4));
  }

  @Test
  public void testLargerTree2() {
    Node mouseToy = new Node("mouseToy", null, null); 
    Node milkBowl = new Node("milkBowl", null, null);
    Node catBaby = new Node("tCatBaby", mouseToy, milkBowl);
    Node timsCat = new Node("tCat", catBaby, null);
    Node timsDog = new Node("tDog", null, null);
    Node tim = new Node("tim", timsCat, timsDog);
    Node nancy = new Node("nancy", null, null);
    Node williams = new Node("williams", tim, nancy);
    SearchVisitor findTCat = new SearchVisitor("tCat");
    williams.accept(findTCat);

    List<String> foundNodes = findTCat.getResult();
    System.out.println(foundNodes);
    assertEquals(4, foundNodes.size());
    assertEquals("tCat", foundNodes.get(0));
    assertEquals("tCatBaby", foundNodes.get(1));
    assertEquals("mouseToy", foundNodes.get(2));
    assertEquals("milkBowl", foundNodes.get(3));
  }
}

package com.zachurchill.homework5;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DebugVisitorTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  public void testThreePlusFive() {
    ConstantExpression three = new ConstantExpression(3);
    ConstantExpression five = new ConstantExpression(5);
    BinaryExpression root = new AddExpression(three, five);
    DebugVisitor debug = new DebugVisitor();
    root.accept(debug);
    List<String> debugOutput = debug.getResult(); 
    System.out.println(debugOutput);
    assertEquals(5, debugOutput.size());
    assertEquals("preVisit AddExpression", debugOutput.get(0));
    assertEquals("visit ConstantExpression 3", debugOutput.get(1));
    assertEquals("visit AddExpression", debugOutput.get(2));
    assertEquals("visit ConstantExpression 5", debugOutput.get(3));
    assertEquals("postVisit AddExpression", debugOutput.get(4));
  }

  @Test
  public void testThreePlusFiveTimesTwo() {
    ConstantExpression three = new ConstantExpression(3);
    ConstantExpression five = new ConstantExpression(5);
    BinaryExpression plus = new AddExpression(three, five);
    ConstantExpression two = new ConstantExpression(2);
    BinaryExpression root = new MultiplyExpression(plus, two);

    DebugVisitor debug = new DebugVisitor();
    root.accept(debug);
    List<String> debugOutput = debug.getResult(); 
    System.out.println(debugOutput);
    assertEquals(9, debugOutput.size());
    assertEquals("preVisit MultiplyExpression", debugOutput.get(0));
    assertEquals("preVisit AddExpression", debugOutput.get(1));
    assertEquals("visit ConstantExpression 3", debugOutput.get(2));
    assertEquals("visit AddExpression", debugOutput.get(3));
    assertEquals("visit ConstantExpression 5", debugOutput.get(4));
    assertEquals("postVisit AddExpression", debugOutput.get(5));
    assertEquals("visit MultiplyExpression", debugOutput.get(6));
    assertEquals("visit ConstantExpression 2", debugOutput.get(7));
    assertEquals("postVisit MultiplyExpression", debugOutput.get(8));
  }
}

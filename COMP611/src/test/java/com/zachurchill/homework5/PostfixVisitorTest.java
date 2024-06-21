package com.zachurchill.homework5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostfixVisitorTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  public void testThreePlusFive() {
    ConstantExpression three = new ConstantExpression(3);
    ConstantExpression five = new ConstantExpression(5);
    BinaryExpression root = new AddExpression(three, five);

    PostfixVisitor postfix = new PostfixVisitor();
    root.accept(postfix);
    assertEquals("3 5 +", postfix.getResult());
  }

  @Test
  public void testThreePlusFiveTimesTwo() {
    ConstantExpression three = new ConstantExpression(3);
    ConstantExpression five = new ConstantExpression(5);
    BinaryExpression plus = new AddExpression(three, five);
    ConstantExpression two = new ConstantExpression(2);
    BinaryExpression root = new MultiplyExpression(plus, two);

    PostfixVisitor postfix = new PostfixVisitor();
    root.accept(postfix);
    assertEquals("3 5 + 2 *", postfix.getResult());
  }
}

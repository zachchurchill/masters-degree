package com.zachurchill.homework5;

public class PostfixVisitor implements Visitor {

    private String postfixOperation;

    public PostfixVisitor() {
      this.postfixOperation = "";
    }

    public String getResult() {
        return this.postfixOperation.trim();
    }

    @Override
    public void preVisit(BinaryExpression expr) {
    }

    @Override
    public void visit(BinaryExpression expr) {
    }

    @Override
    public void postVisit(BinaryExpression expr) {
      this.postfixOperation = String.format("%s%s ", this.postfixOperation, expr.getOperation().toString());
    }

    @Override
    public void visit(ConstantExpression expr) {
      this.postfixOperation = String.format("%s%d ", this.postfixOperation, expr.getValue());
    }
}

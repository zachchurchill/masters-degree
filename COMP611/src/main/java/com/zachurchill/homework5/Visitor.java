package com.zachurchill.homework5;

public interface Visitor
{
    public void preVisit(BinaryExpression expr);
    public void visit(BinaryExpression expr);
    public void postVisit(BinaryExpression expr);
    public void visit(ConstantExpression expr);
}

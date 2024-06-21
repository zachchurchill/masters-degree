package com.zachurchill.homework5;

public abstract class BinaryExpression extends Expression
{
    Expression leftChild;
    Expression rightChild;

    public BinaryExpression(Expression left, Expression right) {
        leftChild = left;
        rightChild = right;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.preVisit(this);
        leftChild.accept(visitor);
        visitor.visit(this);
        rightChild.accept(visitor);
        visitor.postVisit(this);
    }

    public abstract Operation getOperation();
}

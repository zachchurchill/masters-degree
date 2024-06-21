package com.zachurchill.homework5;

public class DivideExpression extends BinaryExpression
{
    public DivideExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public Operation getOperation()
    {
        return Operation.DIVIDE;
    }
}

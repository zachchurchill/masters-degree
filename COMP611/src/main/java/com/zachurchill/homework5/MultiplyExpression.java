package com.zachurchill.homework5;

public class MultiplyExpression extends BinaryExpression
{
    public MultiplyExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public Operation getOperation()
    {
        return Operation.MULTIPLY;
    }
}

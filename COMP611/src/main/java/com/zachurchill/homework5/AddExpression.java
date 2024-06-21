package com.zachurchill.homework5;

public class AddExpression extends BinaryExpression
{
    public AddExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public Operation getOperation()
    {
        return Operation.ADD;
    }
}

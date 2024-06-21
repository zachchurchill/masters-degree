package com.zachurchill.homework5;

public class SubtractExpression extends BinaryExpression
{
    public SubtractExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    @Override
    public Operation getOperation()
    {
        return Operation.SUBTRACT;
    }
}

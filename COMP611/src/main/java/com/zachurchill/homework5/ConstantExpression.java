package com.zachurchill.homework5;

public class ConstantExpression extends Expression
{
    Integer value;

    public ConstantExpression(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}

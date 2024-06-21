package com.zachurchill.homework5;

public abstract class Operation
{
    private String value;

    private Operation(String str)
    {
        this.value = str;
    }

    public abstract Integer apply(Integer left, Integer right);

    @Override
    public String toString()
    {
        return this.value;
    }

    public static final Operation ADD = new Operation("+") {
        @Override
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() + right.intValue();
        }
    };

    public static final Operation SUBTRACT = new Operation("-") {
        @Override
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() - right.intValue();
        }
    };

    public static final Operation MULTIPLY = new Operation("*") {
        @Override
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() * right.intValue();
        }
    };

    public static final Operation DIVIDE = new Operation("/") {
        @Override
        public Integer apply(Integer left, Integer right)
        {
            return left.intValue() / right.intValue();
        }
    };
}

package com.zachurchill.homework3;

public class ConstantExpression implements MathExpression {
    private int number;

    public ConstantExpression(int number) {
        this.number = number;
    }

    public String toString() {
        return Integer.toString(this.number);
    }

    public int apply() {
        return this.number;
    }
}

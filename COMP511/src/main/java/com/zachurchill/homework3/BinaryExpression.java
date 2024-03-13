package com.zachurchill.homework3;

public abstract class BinaryExpression implements MathExpression {
    protected MathExpression left;
    protected MathExpression right;

    public BinaryExpression(MathExpression left, MathExpression right) {
        this.left = left;
        this.right = right;
    }

    public abstract String getOperator();

    public String toString() {
        return String.format(
            "(%s %s %s)",
            this.left.toString(),
            this.getOperator(),
            this.right.toString()
        );
    }

    public abstract int apply();
}

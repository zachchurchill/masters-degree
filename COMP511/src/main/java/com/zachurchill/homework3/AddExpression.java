package com.zachurchill.homework3;

public class AddExpression extends BinaryExpression {
    public AddExpression(MathExpression left, MathExpression right) {
        super(left, right);
    }

    public String getOperator() {
        return "+";
    }

    public int apply() {
        return this.left.apply() + this.right.apply();
    }
}

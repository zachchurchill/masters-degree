package com.zachurchill.homework3;

public class SubtractExpression extends BinaryExpression {
    public SubtractExpression(MathExpression left, MathExpression right) {
        super(left, right);
    }

    public String getOperator() {
        return "-";
    }

    public int apply() {
        return this.left.apply() - this.right.apply();
    }
}

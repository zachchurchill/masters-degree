/**
 * Inheritance Programming
 * Consider the class diagram in etc/homework3/InheritanceImplementationClassDiagram.svg.
 * A MathExpression can render itself using toString() and produce a result using apply().
 * There are two subtypes of MathExpression: a BinaryExpression that has an operation and
 * two operands and a ConstantExpression that just represents a number with a value.
 * Further the two subtypes of BinaryExpression represent addition and subtraction
 * (AddExpression and SubtractExpression respectively).
 * The expressions can be used as follows:
 * ```java
 * MathExpression seven = new ConstantExpression(7);
 * MathExpression five = new ConstantExpression(5);
 * MathExpression three = new ConstantExpression(3);
 * AddExpression addExp = new AddExpression(seven, three);
 * SubtractExpression subExp = new SubtractExpression(five, addExp);
 *
 * // prints "(5 - (7 + 3)) = -5"
 * System.out.println(subExp + " = " + subExp.apply());
 * ```
 *
 * Write implementations of these expressions:
 * - For a `ConstantExpression`:
 *   - `toString` merely renders the integer as a String.
 *   - `apply()` merely returns the value passed into the constructor.
 * - For any `BinaryExpression` or subclass
 *   - `toString` will return parenthesis surrounding the toString of the left
 *      operator, the operand, and the toString of the right operator.
 *   - For `apply`, it will do the same thing as `toString`, but call the `apply`
 *     methods of the left and right operands and then perform the operation
 *     and return the result.
 * - Maximize the use of inheritance (thereby minimizing repeated code).
 */

package com.zachurchill.homework3;

class InheritanceProgramming {

    public static void main(String[] args) {
        System.out.println("Simple program to run given example");

        MathExpression seven = new ConstantExpression(7);
        MathExpression five = new ConstantExpression(5);
        MathExpression three = new ConstantExpression(3);
        AddExpression addExp = new AddExpression(seven, three);
        SubtractExpression subExp = new SubtractExpression(five, addExp);
        
        // prints "(5 - (7 + 3)) = -5"
        System.out.println(subExp + " = " + subExp.apply());
    }
}

package com.zachurchill.homework10;

import java.util.ArrayList;

/**
 * No changes to this file. It will be replaced
 * when the instructor tests run.
 */
public class Rail {
    private String name;
    private ArrayList<Car> stack;
    
    public Rail(String name) {
        this.name = name;
        this.stack = new ArrayList<Car>();
    }

    public boolean isEmpty() {
        return stack.size() <= 0;
    }

    public void push(Car c) {
        stack.add(stack.size(), c);
    }

    public Car pop() {
        checkForUnderflow();
        Car result = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return result;
    }

    public Car peek() {
        checkForUnderflow();
        return stack.get(stack.size() - 1);
    }

    public boolean containsCar(Car car) {
        return stack.contains(car);
    }
    
    private void checkForUnderflow() {
        if (stack.size() <= 0) {
            throw new RuntimeException("Track is empty");
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return stack.toString();
    }
}

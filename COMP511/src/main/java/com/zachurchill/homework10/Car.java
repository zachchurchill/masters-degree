package com.zachurchill.homework10;

/**
 * No changes to this file. It will be replaced
 * when the instructor tests run.
 */
public class Car implements Comparable<Car> {
    private int num;

    public Car(int num) {
        this.num = num;
    }

    public String toString() {
        return "Car #" + num;
    }

    public int compareTo(Car other) {
        return other.num - this.num;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }
        return this.compareTo((Car)o) == 0;
    }

}

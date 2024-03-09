package com.zachurchill.homework3;

public class MinMaxWorker implements Worker {

    private int min;
    private int max;
    private boolean firstCall = true;

    public void work(int number) {
        if (firstCall) {
            this.min = number;
            this.max = number;
            this.firstCall = false;
        }

        if (number < this.min) {
            this.min = number;
        }
        if (number > this.max) {
            this.max = number;
        }
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}

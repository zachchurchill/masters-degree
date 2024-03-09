package com.zachurchill.homework3;

public class AverageWorker implements Worker {

    private double sum = 0;
    private int count = 0;

    public void work(int number) {
        this.sum += number;
        this.count++;
    }

    public double getAverage() {
        if (this.count > 0) {
            return this.sum / this.count;
        } else {
            return 0;
        }
    }
}

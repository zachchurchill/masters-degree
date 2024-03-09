package com.zachurchill.homework3;

public class CountEqualsWorker implements Worker {

    private int matcher;
    private int count = 0;

    /**
     * Counts the numbers matching the parameter "matching".
     */
    public CountEqualsWorker(int matching) {
        this.matcher = matching;
    }

    public void work(int number) {
        if (this.matcher == number) {
            this.count++;
        }
    }

    public int getCount() {
        return this.count;
    }
}

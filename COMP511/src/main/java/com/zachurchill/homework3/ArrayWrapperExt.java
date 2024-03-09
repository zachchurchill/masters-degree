/**
 * Interfaces as callbacks
 * Interfaces are often used as "callbacks" -- we specify an interface as a
 * parameter type to a method, and the method uses the parameter to accomplish
 * its work. In this exercise you are extending the previous ArrayWrapper class,
 * but adding in a method that receives a Worker object. The Worker interface has
 * one method, work() that takes an integer as a parameter. This is a type of
 * the accumulator pattern where the Worker can accrue some kind of result
 * from each of the parameters passed in.
 *
 * Your tasks are to:
 * - Implement the method accumulate() in the ArrayWrapperExt class that receives
 *   the Worker, iterates through the array, and calls the work() method, passing
 *   in each element of the array in turn.
 * - Implement three instances of the Worker interface:
 *   - An AverageWorker that will allow someone to compute the average of all the elements in the array
 *   - A CountEqualsWorker that will compute the count of the data in the array matching with the value set up in the worker object.
 *   - A MinMaxWorker that will figure out the minimum and maximum values from within the array. 
 *
 * See the main function for the example code.
 */
package com.zachurchill.homework3;

import com.zachurchill.homework2.ArrayWrapper;

public class ArrayWrapperExt extends ArrayWrapper {
    public ArrayWrapperExt(int capacity) {
        super(capacity);
    }

    public void accumulate(Worker worker) {
        for (int i = 0; i < this.size(); i++) {
            worker.work(this.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayWrapperExt wrapper = new ArrayWrapperExt(50);

        // put some data in the wrapper
        int[] data = { 3, 7, 2, 19, 5, 8, 12 };
        for (int i = 0; i < data.length; ++i) {
            wrapper.add(data[i]);
        }

        // find the min and max
        Worker mm =  new MinMaxWorker();
        wrapper.accumulate(mm);

        // print results
        MinMaxWorker mm1 = (MinMaxWorker)mm;
        System.out.println(mm1.getMin());  // prints 2
        System.out.println(mm1.getMax());  // prints 19
    }
}

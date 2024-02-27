/* In this exercise you are writing a function that will rotate the values in an array of integers.
 * There are two parameters to the function: the array to rotate and the magnitude/direction to rotate.
 * If directional number is negative, then you are rotating the contents of the array left;
 * if it is positive, then to the right. The second parameter also indicates how far to rotate.
 * You will not modify the parameter array, but will instead return a new array with the elements rotated.
 * For example:
 * - rotateArray([1, 2, 3, 4, 5], -1) should return a new array [2, 3, 4, 5, 1],
 *   because the second parameter is -1, it rotates to the left by one position.
 * - rotateArray([-12, 55], -3) should return a new array [55, -12].
 *   Again, this is a left rotate three times.
 * - rotateArray([1, 1, 2, 3, 5, 8, 11], 2) should return a new array [8, 11, 1, 1, 2, 3, 5].
 *   The second number is positive indicating a right rotation by two positions.
 * - rotateArray([], 1) should return a new array [].
 *   There are no contents to rotate, so an empty array is returned.
 */
package com.zachurchill.homework1;

import java.util.Arrays;

public class Rotate {
    public static int[] rotateArray(int [] array, int amount) {
        // Short-circuit if `array` is empty
        if (array.length == 0) {
            return new int [0];
        }

        int preparedAmount = Math.abs(amount % array.length);
        int [] result = new int [array.length];
        if (amount == 0) {
            result = array.clone();
        } else if (amount < 0) {
            // Right
            for (int i = preparedAmount; i < array.length; i++) {
                result[i - preparedAmount] = array[i];
            }
            // Left
            for (int i = 0; i < preparedAmount; i++) {
                result[result.length - preparedAmount + i] = array[i];
            }
        } else {
            // Right
            for (int i = preparedAmount; i < array.length; i++) {
                result[i] = array[i - preparedAmount];
            }
            // Left
            for (int i = 0; i < preparedAmount; i++) {
                result[i] = array[array.length - preparedAmount + i];
            }
        }
        return result;
    }
}

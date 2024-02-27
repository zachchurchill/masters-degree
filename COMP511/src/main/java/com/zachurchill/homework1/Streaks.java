/* In this exercise you are writing a function that will count the number of "streaks" of consecutive numbers in an array of integers.
 *
 * For example
 * - countStreaks([1, 2, 2, 3, 3, 2, 4]) should return 2 because there of the streak of 2's and the streak of 3's.
 * - countStreaks([1, 1, 1, 1]) should return 1 because there is a single streak of 4 1's.
 * - countStreaks([1, 2, 1, 2]) should return 0 because there is no streak of consecutive same numbers.
 */
package com.zachurchill.homework1;

public class Streaks {
    public static int countStreaks(int [] array) {
        // short-circuit if empty
        if (array.length == 0) {
            return 0;
        }

        int [] diffs = new int[array.length - 1];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = array[i+1] - array[i];
        }
        int streaks = 0;
        boolean inStreak = false;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] == 0) {
                inStreak = true;
            } else {
                if (inStreak) {
                    streaks++;
                    inStreak = false;
                }
            }
        }
        // Capture if we end on a streak
        if (inStreak) {
            streaks++;
        }
        return streaks;
    }
}

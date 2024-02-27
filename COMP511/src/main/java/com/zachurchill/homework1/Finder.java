/* In this exercise you are writing a function that will take a string that has mixed characters and numbers in it.
 * Your task is to find all the numbers in the string and add them up,
 * returning the sum of the numbers extracted from the string.
 * Some helpful functions are the Character.isDigit(char) which will return true if the parameter character is a digit 0-9,
 * and Integer.parseInt(string) that will convert a string to an integer equivalent.
 * No negative numbers will appear in the input string.
 *
 * For example:
 *- findAndAdd("xyz432abc") should return 432.
 *- findAndAdd("xyz432abc444") should return 876.
 *- findAndAdd("123") should return 123.
 *- findAndAdd("1 1 2 3 5") should return 12.
 *- findAndAdd("abcxyz") should return 0.
 */
package com.zachurchill.homework1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Finder {
    public static int findAndAdd(String s) {
        Matcher digitsMatcher = Pattern.compile("\\d+").matcher(s);
        int sum = 0;
        while (digitsMatcher.find()) {
            Integer foundDigits = Integer.parseInt(digitsMatcher.group());
            sum += foundDigits;
        }
        return sum;
    }
}

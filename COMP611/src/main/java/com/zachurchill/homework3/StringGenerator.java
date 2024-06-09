package com.zachurchill.homework3;

import java.util.ArrayList;
import java.util.List;

public class StringGenerator {
    public List<String> generateAllStrings(int length, int base) {
        ArrayList<String> result = new ArrayList<>();
        // length = 2; base = 2 => { 00, 01, 10, 11 }
        // length = 3; base = 5 => { 000, 001, 002, 003, 004, ..., 440, 441, 442, 443, 444 }
        // what's the base case here?
        // can I do this without recursion first.
        for (int b = 0; b < base; b++) {
            result.add(String.valueOf(b));
        }
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            for (int b = 0; b < base; b++)  {
                for (String r : result) {
                    temp.add(String.format("%d%s", b, r));
                }
            }
            result.clear();
            result.addAll(temp);
            temp.clear();
        }
        return result;
    }

    public static void main(String[] args) {
    }
}

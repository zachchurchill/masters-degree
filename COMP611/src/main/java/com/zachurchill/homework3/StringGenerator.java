package com.zachurchill.homework3;

import java.util.ArrayList;
import java.util.List;

public class StringGenerator {
    public List<String> generateAllStrings(int length, int base) {
        ArrayList<String> result = new ArrayList<>();
        if (length == 1) {
            for (int b = 0; b < base; b++) {
                result.add(String.valueOf(b));
            }
            return result;
        } else {
            result.addAll(generateAllStrings(length - 1, base));
            ArrayList<String> temp = new ArrayList<>();
            for (int b = 0; b < base; b++) {
                for (String r : result) {
                    temp.add(String.format("%d%s", b, r));
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
    }
}

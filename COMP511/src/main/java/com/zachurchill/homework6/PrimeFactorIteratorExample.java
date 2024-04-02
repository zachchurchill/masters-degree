package com.zachurchill.homework6;

public class PrimeFactorIteratorExample {

    public static String primeFactorsOf(long num) {
        long factor = 2;
        StringBuffer sb = new StringBuffer();
        while (num > 1) {
            if (num % factor == 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(factor);
                num /= factor;
            } else {
                ++factor;
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        System.out.println("Given in prompt:");
        long num = 9699690;
        System.out.println(primeFactorsOf(num));

        System.out.println("Failed test case:");
        System.out.println(primeFactorsOf((long) 104053));
    }
}

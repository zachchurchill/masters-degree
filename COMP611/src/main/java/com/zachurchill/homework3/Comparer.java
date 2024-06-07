package com.zachurchill.homework3;

public class Comparer {
    public boolean compare(String s1, String s2) {
      if (s1.length() != s2.length()) {
        return false;
      } else if (s1.isEmpty() && s2.isEmpty()) {
        return true;
      } else {
        return (
            s1.charAt(0) == s2.charAt(0)
            && compare(s1.substring(1, s1.length()), s2.substring(1, s2.length()))
        );
      }
    }

    public static void main(String[] args) {
    }
}

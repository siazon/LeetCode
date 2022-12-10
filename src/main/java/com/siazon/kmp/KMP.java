package com.siazon.kmp;

public class KMP {
    public static void main(String[] args) {
        System.out.println(getsun(20) + "");
    }

    public static int getsun(int n) {


        if (n == 1 || n == 2)
            return 1;
        else {
            return getsun(n - 1) + getsun(n - 2);
        }

    }

    public static int KMP() {
        String sourceString = "abcabdacab";
        String patString = "cabdac";
        int[] next = Getnext(patString);
        int j = 0;
        for (int i = 0; i < sourceString.length(); i++) {
            while (j > 0 && sourceString.charAt(i) != patString.charAt(j)) {
                j = next[j - 1];
            }
            if (sourceString.charAt(i) == patString.charAt(j)) {
                j++;
            }
            if (j == patString.length()) {
                return i - patString.length() + 1;
            }
        }
        return -1;
    }

    public static int[] Getnext(String patString) {
        int[] next = new int[patString.length()];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < patString.length(); i++) {
            while (j > 0 && patString.charAt(i) != patString.charAt(j)) {
                j = next[j - 1];
            }
            if (patString.charAt(i) == patString.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

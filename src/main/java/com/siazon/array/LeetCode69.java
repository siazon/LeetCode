package com.siazon.array;

public class LeetCode69 {
    public static void main(String[] args) {

    }
    public int leetcode69() {
        int source = 101;

        int left = 0;
        int right = source/2;
        while (left < right) {
            int middle = left + ((right - left+1) >> 1);//left+1很重要
            if (middle  > source/middle) {
                right = middle - 1;
            } else {
                left = middle ;
            }
        }

        return left;
    }
}

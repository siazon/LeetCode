package com.siazon.array;

public class LeetCode34 {
    static int[] nums = new int[] { 5, 7, 8,  8, 8, 9, 10 };
    static int target = 8;
    public static void main(String[] args) {

    }
    public static int[] leetcode34() {
        int[] result = new int[] { -1, -1 };
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return result;
        } else {
            int left = findLeft();
            int right = findRight();
            if (left == -2 || right == -2) {
            } else {
                result[0] = left + 1;
                result[1] = right - 1;
            }
            return result;
        }
    }

    public static int findLeft() {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);// 右移位1等同/2
            if (nums[middle] >= target) {
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    private static int findRight() {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);// 右移位1等同/2
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }



    public int[] leetcode34_1() {
        int[] result = new int[] { -1, -1 };
        if (nums[0] > target || nums[nums.length - 1] < target)
            return result;
        int index = getIndex();
        if (index == -1)
            return result;
        else {
            int left = index;
            int right = index;
            while (left - 1 >= 0 && nums[index] == nums[left - 1]) {
                left--;
            }
            while (right + 1 < nums.length && nums[index] == nums[right + 1]) {
                right++;
            }
            return new int[] { left, right };
        }
    }

    private int getIndex() {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);// 右移位1等同/2
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}

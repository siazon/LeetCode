package com.siazon.array;
public class LeetCode35 {
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    //如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    static int[] nums = new int[] { 5, 7, 8,  8, 8, 9, 10 };
    static int target = 8;
    public static void main(String[] args) {
        leetcode35();
    }
    public static int leetcode35() {
        if (nums[0] > target)
            return 0;
        if (nums[nums.length - 1] < target)
            return nums.length - 1;
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
        return right + 1;
    }
}

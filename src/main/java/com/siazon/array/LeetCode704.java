package com.siazon.array;

/**
 * @author Xiasong Chen A00291322
 * @version 1.0
 * @date 2022831 4:28:16
 */
public class LeetCode704 {
    //	给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
//	写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    int[] nums = new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10};
    int target = 8;

    public int BinarySearchby() {// leetcode 704
        if (nums[0] > target || nums[nums.length - 1] < target)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(new LeetCode704().BinarySearchby());


    }

}

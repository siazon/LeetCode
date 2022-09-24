package com.siazon.array;

/**
 * @author Xiasong Chen A00291322
 * 
 * @date 2022831 4:28:16
 * @version 1.0
 */
public class LeetCode704 {

	int[] nums = new int[] { 5, 7, 8,  8, 8, 9, 10 };
	int target = 8;

	public int BinarySearchby() {// leetcode 704
		if (nums[0] > target || nums[nums.length - 1] < target)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;// left 防止溢出
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

	public static void main(String[] args) {
		 System.out.print(new LeetCode704().BinarySearchby());
	}

}

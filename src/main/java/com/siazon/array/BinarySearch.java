package com.siazon.array;

/**
 * @author Xiasong Chen A00291322
 * 
 * @date 2022831 4:28:16
 * @version 1.0
 */
public class BinarySearch {

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

	public int leetcode35() {
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

	public int[] leetcode34() {
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

	public int findLeft() {
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

	private int findRight() {
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

	public static void main(String[] args) {
		// System.out.print(new BinarySearch().BinarySearchby());
		// System.out.print(new BinarySearch().leetcode35());
		int[] list = new BinarySearch().leetcode34();
		// System.out.print(list[0] + "," + list[1]);
		// System.out.print(new BinarySearch().leetcode69());
	}

}

package com.siazon.array;

/**
 * @author Xiasong Chen A00291322
 * 
 * @date 2022年8月31日 下午4:28:16
 * @version 1.0
 */
public class DeleteNumber {

	int[] nums = new int[] { -9, 0, 5, 7, -1 };
	int target = 8;

	public int delete27() {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}

	public int delete26() {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				index++;
				nums[index] = nums[i];

			}
		}
		return index + 1;
	}

	public int leetcode283() {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, index, i);
				index++;
			}
		}
		return index;
	}

	private void swap(int[] nums, int L, int R) {
		int temp = nums[L];
		nums[L] = nums[R];
		nums[R] = temp;
	}

	public int leetcode997() {
		int[] nums = new int[] { -9, 0, 5, 7, 9 };
		int[] result = new int[nums.length];
		int L = 0;
		int R = nums.length - 1;
		int j = R;
		while (L <= R) {
			if (nums[L] * nums[L] > nums[R] * nums[R]) {
				result[j] = nums[L] * nums[L];
				j--;
				L++;
			} else {
				result[j] = nums[R] * nums[R];
				j--;
				R--;
			}
		}
		return 0;
	}

	public int leetcode209() {
		int[] nums = new int[] { 2, 3, 1, 2, 4, 2 };
		int result = Integer.MAX_VALUE;
		int subLenght = 0;
		int L = 0;
		int R = nums.length - 1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= 7) {
				subLenght = i - L + 1;
				result = result < subLenght ? result : subLenght;
				sum -= nums[L];
				L++;
			}
		}
		return result;
	}
	public void leetcode59(int n) {
		int x=0,y=0;
		int i=0;
		
	}
	public int born(int j, int amount) {
		if (j >= 5)
			return amount;
		else {
			while (j < 5) {
				
				amount++;
				if (j++ % 3 == 0) {
					amount += born(j, 0);
				}
			}

			return amount;
		}
	}

	public static void main(String[] args) {

		// System.out.println(new DeleteNumber().leetcode209());

		System.out.println(new DeleteNumber().born(3, 1));
	}

}

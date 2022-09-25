package com.siazon.array;

/**
 * @author Xiasong Chen A00291322
 * @version 1.0
 * @date 2022年8月31日 下午4:28:16
 */
public class DeleteNumber {
    static int[] nums = new int[]{-9, 0, 8, 5, 7, 8, 2, -1};
    static int target = 8;

    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    private static int delete27() {//快慢指针
        int slow = 0;
        for (int fast = 0; fast < DeleteNumber.nums.length; fast++)
            if (DeleteNumber.nums[fast] != DeleteNumber.target) {
                DeleteNumber.nums[slow] = DeleteNumber.nums[fast];
                slow++;
            }
        return slow;
    }

    //给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
    //返回删除后数组的新长度。元素的 相对顺序 应该保持 一致
    public int delete26() {
        int slow = 0;
        for (int i = 0; i < DeleteNumber.nums.length; i++)
            if (DeleteNumber.nums[i] != DeleteNumber.nums[slow]) {
                slow++;
                DeleteNumber.nums[slow] = DeleteNumber.nums[i];
            }
        return slow + 1;
    }

    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    public int leetcode283() {
        int slow = 0;
        for (int i = 0; i < DeleteNumber.nums.length; i++)
            if (DeleteNumber.nums[i] != 0) {
                swap(DeleteNumber.nums, slow, i);
                slow++;
            }
        return slow;
    }

    private void swap(int[] nums, int L, int R) {
        int temp = nums[L];
        nums[L] = nums[R];
        nums[R] = temp;
    }

    //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    public int[] leetcode997() {
        int[] nums = new int[]{-9, 0, 5, 7, 9};
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
        return result;
    }

    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
    //如果不存在符合条件的子数组，返回 0。
    //输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    public int leetcode209() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 2};
        int result = Integer.MAX_VALUE;
        int subLenght = 0;
        int L = 0;
        int R = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= 7) {
                subLenght = i - L + 1;
                result = Math.min(result, subLenght);
                sum -= nums[L];
                L++;
            }
        }
        return result;
    }

    public void leetcode59(int n) {
        int x = 0, y = 0;
        int i = 0;
    }

    public int born(int j, int amount) {
        if (j >= 5)
            return amount;
        else {
            while (j < 5) {
                amount++;
                if (j++ % 3 == 0) amount += born(j, 0);
            }

            return amount;
        }
    }

    public static void main(String[] args) {
        System.out.println(DeleteNumber.delete27());
        // System.out.println(new DeleteNumber().leetcode209());
//		System.out.println(new DeleteNumber().born(3, 1));
    }

}

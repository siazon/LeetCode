package com.siazon.array;


public class NSum {

    public int[] twoSum(int[] numbers, int target) {
        java.util.Arrays.sort(numbers);
        int slow = 0, fast = numbers.length - 1;

        while (slow < fast) {
            int sum = numbers[slow] + numbers[fast];
            if (sum == target)
                return new int[]{slow + 1, fast + 1};
            else if (sum > target)
                fast--;
            else if (sum < target)
                slow++;
        }
        return new int[2];
    }

    public int[] twoSum2(int[] numbers, int target) {
        int slow = 0, fast = numbers.length - 1;
        while (slow < fast) {
            int sum = numbers[slow] + numbers[fast];
            if (sum == target)
                return new int[]{slow + 1, fast + 1};
            else if (sum > target)
                fast--;
            else if (sum < target)
                slow++;
        }
        return new int[2];
    }
}

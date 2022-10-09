package com.siazon.array;


import java.util.HashMap;
import java.util.Map;

public class NSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        if (numbers == null || numbers.length == 0) return a;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                a[0] = map.get(temp);
                a[1] = i;
            }
            map.put(numbers[i], i);
        }
        return a;
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


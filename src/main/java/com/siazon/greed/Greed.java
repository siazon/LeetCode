package com.siazon.greed;

import java.util.Arrays;

public class Greed {
    //455.分发饼干
    public int getCookes(int[] arrs, int[] children) {
        Arrays.sort(arrs);
        Arrays.sort(children);
        int start = 0, count = 0;
        for (int i = 0; i < arrs.length && start < children.length; i++) {
            if (arrs[i] >= children[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    //376. 摆动序列
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int pre = 0, curr = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            curr = nums[i] - nums[i - 1];
            if ((curr > 0 && pre <= 0) || (curr <= 0 && pre > 0)) {
                res++;
                pre = curr;
            }
        }
        return res;
    }
}

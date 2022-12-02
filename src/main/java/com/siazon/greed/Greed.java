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

    public int wiggleMaxLengthDP(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度
        int dp[][] = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    // i 是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (nums[j] < nums[i]) {
                    // i 是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}

package com.siazon.greed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

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

    //53. 最大子序和 [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }

    //53. 最大子序和
    public int maxSum(int[] numbs) {
        if (numbs.length == 1) return numbs[0];
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int numb : numbs) {
            count += numb;
            result = result > count ? result : count;
            if (count < 0) count = 0;
        }
        return result;
    }

    //122.买卖股票的最佳时机II
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int gain = prices[i] - prices[i - 1];
            if (gain > 0)
                result += gain;
        }
        return result;
    }

    //55. 跳跃游戏
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1)
                return true;
        }
        return false;
    }

    //45.跳跃游戏II
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int count = 0, curr = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curr) {
                curr = max;
                count++;
            }

        }
        return count;
    }

    //1005.K次取反后最大化的数组和
    public int getAbsMaxSum(int[] nums, int k) {
        if (nums.length == 1) return k % 2 > 0 ? nums[0] : -nums[0];
        int idx = 0;
        AtomicInteger sum = new AtomicInteger();
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[idx] < 0) {
                nums[idx] = -nums[idx];
                if (nums[idx] >= nums[idx + 1]) idx++;
                continue;
            }
            nums[idx] = -nums[idx];
        }
        sum.set(Arrays.stream(nums).sum());

        return sum.get();
    }

    //134. 加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, currSum = 0, totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            currSum += rest;
            totalSum += rest;
            if (currSum < 0) {
                start = i + 1;
                currSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }

    //135. 分发糖果
    public int candy(int[] ratings) {
        int[] score = new int[ratings.length];
        score[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            score[i] = ratings[i] > ratings[i - 1] ? score[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                score[i] = Math.min(score[i], score[i] + 1);
            }
        }
        return Arrays.stream(score).sum();

    }

    //860.柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i : bills) {
            if (i == 5)
                five++;
            else if (i == 10) {
                if (five <= 0) return false;
                five--;
                ten++;
            } else if (i == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    twenty++;
                } else if (five >= 3) {
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    //406.根据身高重建队列
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1], p);
        }

        return que.toArray(new int[people.length][]);
    }

    //452. 用最少数量的箭引爆气球
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < points[i - 1][0]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}

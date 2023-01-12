package com.siazon.DP;

public class DP1 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    //62. 不同路径
    public int getPath(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }

    //96.不同的二叉搜索树
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");
        }
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        //dp[i][j]代表可装物品为0-i，背包容量为j的情况下，背包内容量的最大价值
        int[][] dp = new int[nums.length][target + 1];
        //初始化,dp[0][j]的最大价值nums[0](if j > weight[i])
        //dp[i][0]均为0，不用初始化
        for (int j = nums[0]; j <= target; j++) dp[0][j] = nums[0];
        //遍历物品，遍历背包
        //递推公式:
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                //背包容量可以容纳nums[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target] == target;
    }

    boolean canPartitionByBoolValue(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) return false;
        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    boolean canPartitionArray(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) return false;
        int n = nums.length;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];

        // base case
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }// got ill

    int knapsack(int W, int N, int[] wt, int[] val) {
        assert N == wt.length;
        // base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i - 1]] + val[i - 1],
                            dp[i - 1][w]
                    );
                }
            }
        }

        return dp[N][W];
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int target = sum / 2;
        //初始化，dp[i][j]为可以放0-i物品，背包容量为j的情况下背包中的最大价值
        int[][] dp = new int[stones.length][target + 1];
        //dp[i][0]默认初始化为0
        //dp[0][j]取决于stones[0]
        for (int j = stones[0]; j <= target; j++) {
            dp[0][j] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {//注意是等于
                if (j >= stones[i]) {
                    //不放:dp[i - 1][j] 放:dp[i - 1][j - stones[i]] + stones[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[stones.length - 1][target]);
        return (sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}

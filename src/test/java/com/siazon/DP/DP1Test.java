package com.siazon.DP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DP1Test {

    DP1 test;

    @BeforeEach
    void setUp() {
        test = new DP1();
    }

    @Test
    void minCostClimbingStairs() {
        int res = test.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(res);
    }

    @Test
    void uniquePathsWithObstaclesTest() {
        int[][] seq = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        test.uniquePathsWithObstacles(seq);
    }
}
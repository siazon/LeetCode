package com.siazon.greed;

import org.junit.jupiter.api.Test;

import java.util.List;

class GreedTest {
    Greed test = new Greed();

    @Test
    void getCookes() {
        for (int i = 0; i < 8; ++i) {
            System.out.println(i);
        }
        System.out.println("_______");
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
        }
    }

    @Test
    void wiggleMaxLength() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = test.wiggleMaxLength(nums);
        System.out.println(res);
    }

    @Test
    void wiggleMaxLengthDP() {
        int[] nums = new int[]{1, 2, 4, 3, 5, 6, 7, 8, 9};
        int res = test.wiggleMaxLengthDP(nums);
        System.out.println(res);
    }

    @Test
    void canCompleteCircuitTest() {
        int a = test.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

    @Test
    void reconstructQueueTest() {

        int[][] demo = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        test.reconstructQueue(demo);
    }

    @Test
    void findMinArrowShotsTest() {
        int[][] demo = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        demo = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        test.findMinArrowShots(demo);
    }

    @Test
    void eraseOverlapIntervalsTest() {
        int[][] demo = new int[][]{{10, 16}, {2, 8}, {1, 6}, {6, 7}, {7, 12}};
        test.eraseOverlapIntervals(demo);
    }

    @Test
    void partitionLabelsTest() {
        List<Integer> list = test.partitionLabels("abcade");
        list.forEach(System.out::println);
    }

    @Test
    void monotoneIncreasingDigitsTest() {
        test.monotoneIncreasingDigits(1977);
    }
}
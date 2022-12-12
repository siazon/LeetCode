package com.siazon.greed;

import org.junit.jupiter.api.Test;

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
}
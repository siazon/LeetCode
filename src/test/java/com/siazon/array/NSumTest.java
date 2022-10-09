package com.siazon.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NSumTest {
    NSum test;

    @BeforeEach
    void setUp() {
        test = new NSum();
    }

    @Test
    void twoSum() {
        int[] a = new int[]{1, 2, 3, 4, 6, 7};
        a = new int[]{7, 6, 3, 4, 2, 1};
        int[] b = test.twoSum(a, 5);
        System.out.println(b[0] + " : " + b[1]);
    }

    @Test
    void twoSum2() {
    }

}
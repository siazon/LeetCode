package com.siazon.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {
    Sort test;
    int[] a = new int[]{2, 3, 1, 4, 7, 0};

    @BeforeEach
    void setUp() {
        test = new Sort();
    }

    @Test
    void sort() {

        test.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    @Test
    void insertSortTest() {
        test.insertSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
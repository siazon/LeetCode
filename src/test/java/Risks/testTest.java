package Risks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testTest {
    RisksCodeTest test;

    @BeforeEach
    void setUp() {
        test = new RisksCodeTest();
    }

    @Test
    void getSunIndexTest() {
        int[] numbs = new int[]{3, 2, 4};
        int target = 6;
        int[] res = test.getSumIndex(numbs, target);
        for (int i : res)
            System.out.println(i);
    }

    @Test
    void isPalindromeTest() {
        String text = "A man, a plan, a canal: Panama3";
        boolean res = test.isPalindrome(text);
        System.out.println(res);
    }
}
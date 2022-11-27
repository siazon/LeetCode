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
}

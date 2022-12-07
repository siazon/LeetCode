package com.siazon;

import java.util.HashSet;
import java.util.Set;

public class Hash {
    //不存在的最小正整数
    public int solution(int[] A) {
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (i > 0) set.add(i);
        }
        for (int i = 1; i < A.length; i++) {
            if (!set.contains(i))
                return i;
        }
        return 1;
    }


}

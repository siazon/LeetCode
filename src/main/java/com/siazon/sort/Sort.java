package com.siazon.sort;

public class Sort {
    public int[] sort(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length - 1 - i; j++) {
                if (numbs[j + 1] < numbs[j]) {
                    int temp = numbs[j + 1];
                    numbs[j + 1] = numbs[j];
                    numbs[j] = temp;
                }
            }
        }
        return numbs;
    }

    public int[] insertSort(int[] numbs) {
        int curr;
        for (int i = 0; i < numbs.length - 1; i++) {
            curr = numbs[i + 1];
            int idx = i;
            while (idx >= 0 && curr < numbs[idx]) {
                numbs[idx + 1] = numbs[idx];
                idx--;
            }
            numbs[idx + 1] = curr;
        }
        return numbs;
    }

    public int[] shierSort(int[] numbs) {
        int len = numbs.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = numbs[i];
                int idx = i - gap;
                while (idx >= 0 && temp < numbs[idx]) {
                    numbs[idx + gap] = numbs[idx];
                    idx -= gap;
                }
                numbs[idx + gap] = temp;
            }
            gap /= 2;
        }
        return numbs;
    }


}

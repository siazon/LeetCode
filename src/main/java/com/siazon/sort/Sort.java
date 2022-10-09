package com.siazon.sort;

public class Sort {
    public void sort(int[] numbs) {
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = 0; j < numbs.length - 1 - i; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    numbs[j] = numbs[j + 1] + numbs[j];
                    numbs[j + 1] = numbs[j] - numbs[j + 1];
                    numbs[j] = numbs[j] - numbs[j + 1];
                }
            }
        }
    }
}

package com.siazon.sort;

import java.util.Arrays;

public class Sort {
    //冒泡：一步一步把大的往后移
    public int[] sort(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < numbs.length - 1; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    numbs[j] = numbs[j] + numbs[j + 1];
                    numbs[j + 1] = numbs[j] - numbs[j + 1];
                    numbs[j] = numbs[j] - numbs[j + 1];
                    flag = false;
                }
            }
            if (flag) break;
        }

        return numbs;
    }

    //选择 找到最小的，把最小的往前移
    public int[] choseSort(int[] numbs) {
        for (int i = 0; i < numbs.length; i++) {
            int min = i;
            for (int j = 0; j < numbs.length; j++) {
                if (numbs[j] < numbs[min])
                    min = j;
            }
            if (i != min) {
                numbs[min] = numbs[min] + numbs[i];
                numbs[i] = numbs[min] - numbs[i];
                numbs[min] = numbs[min] - numbs[i];
            }
        }
        return numbs;
    }

    //插入
    public int[] insertSort(int[] numbs) {
        for (int i = 1; i < numbs.length; i++) {
            int idx = i;
            int curr = numbs[i];
            while (idx > 0 && curr < numbs[idx - 1]) {
                numbs[idx] = numbs[idx - 1];
                idx--;
            }
            if (idx != i)
                numbs[idx] = curr;
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

    public void mergeSort(int[] array, int start, int end, int[] temp) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid, temp);
        mergeSort(array, mid + 1, end, temp);
        int f = start, s = mid + 1, t = 0;
        while (f <= mid && s <= end) {
            if (array[f] < array[s]) {
                temp[t++] = array[f++];
            } else {
                temp[t++] = array[s++];
            }
        }
        while (f <= mid) {
            temp[t++] = array[f++];
        }
        while (s <= end) {
            temp[t++] = array[s++];
        }
        for (int i = 0, j = start; i < t; i++) {
            array[j++] = temp[i];
        }
    }

    public int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }


}

package com.nokinori.research.sorts;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
class MergeSort extends AbstractSort {

    MergeSort(int[] array) {
        super(array);
    }

    /**
     * {@inheritDoc} for Insertion sort
     * Complexity ->
     * Worst case: O(n^2)
     * Average case: O(n logn)
     * Best case: O(n) - sorted array
     * Stable
     * Out of place
     */
    @Override
    int[] sortCustom() {
        return mergeSort(array, 0, length);
    }

    private int[] merge(int[] l, int[] r) {
        int lSize = l.length;
        int rSize = r.length;
        int lIndex = 0;
        int rIndex = 0;
        int[] merged = new int[lSize + rSize];
        int mIndex = 0;
        while (mIndex < merged.length && (lIndex < lSize && rIndex < rSize)) {

            if (l[lIndex] < r[rIndex]) {
                merged[mIndex] = l[lIndex];
                lIndex++;
            } else {
                merged[mIndex] = r[rIndex];
                rIndex++;
            }
            mIndex++;
        }

        while (rIndex < rSize) {
            merged[mIndex] = r[rIndex];
            mIndex++;
            rIndex++;
        }

        while (lIndex < lSize) {
            merged[mIndex] = l[lIndex];
            mIndex++;
            lIndex++;
        }
        return merged;
    }

    private int[] mergeSort(int[] arr, int from, int to) {
        int[] range = Arrays.copyOfRange(arr, from, to);
        if (range.length == 1 || range.length == 0) {
            return range;
        } else {
            int mid = (range.length) / 2;
            int[] l = mergeSort(range, 0, mid);
            int[] r = mergeSort(range, mid, range.length);

            return merge(l, r);
        }
    }

    @Override
    int[] sortClassic() {
        return sortMerge(array);
    }

    private int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return mergeC(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    private int[] mergeC(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1 + len2;
        // a, b - счетчики в массивах
        int a = 0;
        int b = 0;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (arr1[a] > arr2[b]) result[i] = arr2[b++];
                else result[i] = arr1[a++];
            } else if (b < len2) {
                result[i] = arr2[b++];
            } else {
                result[i] = arr1[a++];
            }
        }
        return result;
    }
}

package com.nokinori.research.sorts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertionSort extends AbstractSort {


    InsertionSort(int[] array) {
        super(array);
    }

    /**
     * {@inheritDoc} for Insertion sort
     * Complexity ->
     * Worst case: O(n^2)
     * Average case: O(n^2)
     * Best case: O(n) - sorted array
     * Stable
     * In place
     */
    @Override
    int[] sortCustom() {
        for (int cur = 1; cur < array.length; cur++) {
            int prev = cur - 1;
            if (array[cur] < array[prev]) {
                swap(cur, prev);
                reverseSort(cur, prev);
            }
        }
        return array;
    }

    private void reverseSort(int cur, int prev) {
        for (; prev >= 0; cur--, prev--) {
            if (array[prev] > array[cur]) {
                swap(prev, cur);
            }
        }
    }

    public int[] sortWithBreak() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1);
                } else {
                    break;
                }
            }
        }
        return array;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int[] sortClassic() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}

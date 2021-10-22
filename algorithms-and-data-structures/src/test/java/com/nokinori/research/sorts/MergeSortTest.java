package com.nokinori.research.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest extends AbstractSortTest {

    @Test
    void testSorts() {
        int[] sort = new MergeSort(ints).state(State.CUSTOM).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void testSortClassic() {
        int[] sort = new MergeSort(ints).state(State.CLASSIC).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void testSortJava() {
        int[] sort = new MergeSort(ints).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }
}
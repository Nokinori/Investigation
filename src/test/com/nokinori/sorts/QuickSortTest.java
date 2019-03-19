package com.nokinori.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest extends AbstractSortTest {

    @Test
    void testSorts() {
        int[] sort = new QuickSort(ints).state(State.CUSTOM).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void testSortClassic() {
        int[] sort = new QuickSort(ints).state(State.CLASSIC).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void testSortJava() {
        int[] sort = new QuickSort(ints).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

}
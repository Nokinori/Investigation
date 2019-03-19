package com.nokinori.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest extends AbstractSortTest {


    @Test
    void testSorts() {
        int[] sort = new BubbleSort(ints).state(State.CUSTOM).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void testSortClassic() {
        int[] sort = new BubbleSort(ints).state(State.CLASSIC).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void testSortJava() {
        int[] sort = new BubbleSort(ints).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

}
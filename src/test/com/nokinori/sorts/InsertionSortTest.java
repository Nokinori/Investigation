package com.nokinori.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest extends AbstractSortTest {

    @Test
    void testSorts() {
        int[] sort = new InsertionSort(ints).state(State.CUSTOM).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);

    }

    @Test
    void testClassic() {
        int[] sortC = new InsertionSort(ints).state(State.CLASSIC).sort();
        printArr(sortC);
        Assertions.assertArrayEquals(sortedArr, sortC);
    }

}
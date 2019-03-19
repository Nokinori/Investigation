package com.nokinori.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectionSortTest extends AbstractSortTest {

    @Test
    void sort() {
        int[] sort = new SelectionSort(ints).state(State.CUSTOM).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }

    @Test
    void sortClassic() {
        int[] sort = new SelectionSort(ints).state(State.CLASSIC).sort();
        printArr(sort);
        Assertions.assertArrayEquals(sortedArr, sort);
    }
}
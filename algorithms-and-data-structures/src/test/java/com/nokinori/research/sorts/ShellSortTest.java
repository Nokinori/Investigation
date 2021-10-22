package com.nokinori.research.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShellSortTest extends AbstractSortTest {

    @Test
    void sort() {
        int[] sort = new ShellSort(ints).state(State.CUSTOM).sort();
        assertArrayEquals(sortedArr, sort);
    }
}
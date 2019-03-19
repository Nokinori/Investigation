package com.nokinori.sorts;

import java.util.Arrays;
import java.util.Objects;

abstract class AbstractSort {


    /**
     * Initial array to be sorted
     */
    int[] array;
    int length;
    private State state = State.CUSTOM;


    AbstractSort(int[] array) {
        this.array = array;
        this.length = array.length;
    }

    /**
     * Execute sort
     *
     * @return sorted array
     */
    int[] sort() {
        switch (state) {
            case CUSTOM:
                return sortCustom();
            case CLASSIC:
                return sortClassic();
            default:
                return sortDefault();
        }
    }


    /**
     * My realization of sort algorithm
     *
     * @return sorted array
     */
    abstract int[] sortCustom();

    /**
     * Classic realization of sort algorithm
     *
     * @return sorted array
     */
    abstract int[] sortClassic();

    /**
     * Default realization of Java
     *
     * @return sorted array
     */
    private int[] sortDefault() {
        Arrays.sort(array);
        return array;
    }

    /**
     * Swap to elements in array
     *
     * @param from element
     * @param to   element
     */
    void swap(int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    /**
     * Sets the state
     *
     * @param state the state
     */
    AbstractSort state(State state) {
        Objects.requireNonNull(state);
        this.state = state;
        return this;
    }
}

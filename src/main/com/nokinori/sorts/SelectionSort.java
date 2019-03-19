package com.nokinori.sorts;

class SelectionSort extends AbstractSort {

    SelectionSort(int[] array) {
        super(array);
    }

    /**
     * {@inheritDoc} for Selection sort
     * Complexity ->
     * Worst case: O(n^2)
     * Average case: O(n^2)
     * Best case: O(n^2)
     * Stable
     * In place
     */
    @Override
    int[] sortCustom() {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minVal = array[minIndex];
            for (int j = i + 1; j < array.length; j++) {
                if (minVal > array[j]) {
                    minVal = array[j];
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
        return array;
    }

    @Override
    int[] sortClassic() {
        int inputLength = array.length;

        for (int i = 0; i < inputLength - 1; i++) {

            int min = i;

            // find the first, second, third, fourth... smallest value
            for (int j = i + 1; j < inputLength; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            // swaps the smallest value with the position 'i'
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

            //next pls
        }
        return array;
    }
}

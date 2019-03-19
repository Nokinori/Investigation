package com.nokinori.sorts;

class ShellSort extends AbstractSort {

    ShellSort(int[] array) {
        super(array);
    }

    /**
     * {@inheritDoc} for Insertion sort
     * Complexity ->
     * Worst case: O(n^2)
     * Average case: O(n^3/2) depends in the gap
     * Best case: O(n) - sorted array
     * Not stable
     * In place
     */
    @Override
    int[] sortCustom() {
        int gap = array.length / 2;
        while (gap > 0) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < array.length; i++) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int current = array[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                j = i;
                while (j >= gap && array[j - gap] > current) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                // put temp (the original a[i]) in its correct
                // location
                array[j] = current;
            }
            gap--;
        }
        return array;
    }

    @Override
    int[] sortClassic() {
        return array;
    }
}

package com.nokinori.sorts;

class BubbleSort extends AbstractSort {
    BubbleSort(int[] array) {
        super(array);
    }

    @Override
    int[] sortCustom() {

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }


        return array;
    }

    @Override
    int[] sortClassic() {
        return new int[0];
    }
}

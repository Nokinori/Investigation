package com.nokinori.sorts;

class QuickSort extends AbstractSort {

    QuickSort(int[] array) {
        super(array);
    }

    @Override
    int[] sortCustom() {
        return quickSort(array, 0, length - 1);
    }

    @Override
    int[] sortClassic() {
        quickSortC(array, 0, length - 1);
        return array;
    }

    private int[] quickSort(int[] arr, int begin, int end) {
        int i = begin;
        int j = end;
        int x = arr[begin + (end - begin) / 2];
        while (i <= j) {
            while (arr[i] < x) ++i;
            while (arr[j] > x) --j;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        //рекурсивные вызовы функции qSort
        if (begin < j) quickSort(arr, begin, j);
        if (i < end) quickSort(arr, i, end);
        return arr;
    }


    private void quickSortC(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
        this.array = array;
    }

}

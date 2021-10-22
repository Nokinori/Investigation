package com.nokinori.research.searches;

import java.util.Arrays;

public class BinarySearch {


    public int binarySearch(int[] list, int searched) {
        int found = -1;
        int length = list.length;
        int index = list.length / 2;

        int selected = list[index];
        if (selected > searched) {
            if (length == 1) {
                return found;
            }
            int[] subList = Arrays.copyOfRange(list, 0, index);
            found = binarySearch(subList, searched);
        } else if (selected < searched) {
            if (length == 1) {
                return found;
            }
            int[] subList = Arrays.copyOfRange(list, index + 1, length);
            found = binarySearch(subList, searched);
        } else {
            found = selected;
        }
        return found;
    }
}

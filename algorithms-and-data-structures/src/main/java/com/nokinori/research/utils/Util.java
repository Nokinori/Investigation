package com.nokinori.research.utils;

import java.util.List;

public class Util {

    private Util() {
    }

    public static int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}

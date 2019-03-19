package com.nokinori.sorts;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.nokinori.utils.Util.toArray;

@Slf4j
class AbstractSortTest {

    static int[] ints;

    static int[] sortedArr;

    private long time;

    @BeforeEach
    void init(TestInfo info) {
        log.info("STARTED {}.{}", info.getTestClass().orElse(AbstractSortTest.class).getName(), info.getDisplayName());
        sortedArr = new int[]{3, 4, 5, 7, 8, 9, 10, 12, 14, 25, 32, 33, 44, 45, 46, 58, 65, 66, 84};
        ints = new int[]{8, 7, 3, 5, 10, 12, 4, 9, 14, 58, 66, 84, 32, 45, 65, 25, 46, 44, 33};
//        ints = generateArray();
        printArr(ints);
        time = System.currentTimeMillis();

    }

    @AfterEach
    void tearDown(TestInfo info) {
        log.debug("TIME FOR {}.{} :{} nanoSec", info.getTestClass().orElse(AbstractSortTest.class).getName(),
                info.getDisplayName(),
                System.currentTimeMillis() - time);
    }

    void printArr(int[] arr) {
        log.info("Array: {}", arr);
    }


    int[] generateArray() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            arrayList.add(new Random().nextInt(100000));
        }
        return toArray(arrayList);
    }

    @Test
    void test() {
        Assertions.assertNotNull(generateArray());
    }
}
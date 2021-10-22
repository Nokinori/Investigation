package com.nokinori.research.searches;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.nokinori.research.utils.Util.toArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class BinarySearchTest {

    private static List<Integer> arrayList;

    @BeforeAll
    static void setUp() {
        arrayList = new ArrayList<>();
    }

    @BeforeEach
    void init() {
        arrayList.clear();
        for (int i = 0; i < 5000; i++) {
            arrayList.add(new Random().nextInt(100000));
        }
        log.info("List before {}", arrayList);

    }

    @Test
    void testBinarySearch() {
        int searchedElement = arrayList.get(new Random().nextInt(arrayList.size() - 1));
        log.info("searchedElement {}", searchedElement);
        Collections.sort(arrayList);
        log.info("Sorted array {}", arrayList);

        int search = new BinarySearch().binarySearch(toArray(arrayList), searchedElement);

        assertEquals(searchedElement, search);
    }

    @Test
    void testBinarySearchNotFound() {
        int searchedElement = arrayList.get(new Random().nextInt(arrayList.size() - 1));
        arrayList.remove(Integer.valueOf(searchedElement));
        Collections.sort(arrayList);

        int search = new BinarySearch().binarySearch(toArray(arrayList), searchedElement);
        assertEquals(-1, search);
    }
}

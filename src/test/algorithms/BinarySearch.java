package algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearch {

    private static ArrayList<Integer> arrayList;

    @BeforeAll
    static void setUp() {
        arrayList = new ArrayList<>();
    }

    @BeforeEach
    void init() {
        arrayList.add(1);
    }

    @Test
    void testBinarySearch() {
        assertEquals(1, arrayList.get(0));
    }
}

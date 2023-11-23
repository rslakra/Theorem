package com.devamatre.theorem.adts.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/17/23 6:00 PM
 */
public class HeapTest {

    private static Logger LOGGER = LoggerFactory.getLogger(HeapTest.class);

    public static int SIZE = 8;

    /**
     * @return
     */
    public static List<Integer> positiveIntListGenerator() {
        List<Integer> result = AlgoUtils.positiveIntListGenerator(SIZE);
        LOGGER.debug("result: {}", result);
        assertEquals(SIZE, result.size());
        assertEquals(result, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        result.forEach(item -> assertTrue(item < SIZE));

        return result;
    }


}

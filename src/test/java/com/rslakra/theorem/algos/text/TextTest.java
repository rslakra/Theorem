package com.rslakra.theorem.algos.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/29/24 9:41 AM
 */
public class TextTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextTest.class);

    @Test
    public void testListToString() {
        LOGGER.debug("testListToString()");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        LOGGER.debug("list:{}", list);
        assertNotNull(list);
        String listString = list.toString();
        LOGGER.debug("listString:{}", listString);
        listString = listString.replace(", ", "");
        assertNotNull(listString);
        listString = listString.substring(1, listString.length() - 1);
        LOGGER.debug("final listString:{}", listString);
        assertNotNull(listString);
        assertEquals("1234", listString);
    }

}

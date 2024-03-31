package com.devamatre.theorem.http;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/28/24 5:00 PM
 */
public class WebClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientTest.class);

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // <url, expected>
        inputs.add(new Object[]{"www.google.com", "<!doctype html>"});

        return inputs.iterator();
    }

    /**
     * Tests the <code>get()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testGetRequest(String input, String expected) {
        LOGGER.debug("testGetRequest({}, {})", input, expected);
        String result = WebClient.get(input);
        LOGGER.debug("result:{}", result);
        assertTrue(result.startsWith(expected));
    }

}

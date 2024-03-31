package com.devamatre.theorem.http;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/28/24 4:51 PM
 */
public class HttpMethodTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpMethodTest.class);

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{null, null});
        // CONNECT
        inputs.add(new Object[]{HttpMethod.CONNECT.name(), HttpMethod.CONNECT});
        inputs.add(new Object[]{"Connect", HttpMethod.CONNECT});
        inputs.add(new Object[]{"connect", HttpMethod.CONNECT});
        // DELETE
        inputs.add(new Object[]{HttpMethod.DELETE.name(), HttpMethod.DELETE});
        inputs.add(new Object[]{"Delete", HttpMethod.DELETE});
        inputs.add(new Object[]{"delete", HttpMethod.DELETE});
        // GET
        inputs.add(new Object[]{HttpMethod.GET.name(), HttpMethod.GET});
        inputs.add(new Object[]{"Get", HttpMethod.GET});
        inputs.add(new Object[]{"get", HttpMethod.GET});
        // HEAD
        inputs.add(new Object[]{HttpMethod.HEAD.name(), HttpMethod.HEAD});
        inputs.add(new Object[]{"Head", HttpMethod.HEAD});
        inputs.add(new Object[]{"head", HttpMethod.HEAD});
        // OPTIONS
        inputs.add(new Object[]{HttpMethod.OPTIONS.name(), HttpMethod.OPTIONS});
        inputs.add(new Object[]{"Options", HttpMethod.OPTIONS});
        inputs.add(new Object[]{"options", HttpMethod.OPTIONS});
        // PATCH
        inputs.add(new Object[]{HttpMethod.PATCH.name(), HttpMethod.PATCH});
        inputs.add(new Object[]{"Patch", HttpMethod.PATCH});
        inputs.add(new Object[]{"patch", HttpMethod.PATCH});
        // POST
        inputs.add(new Object[]{HttpMethod.POST.name(), HttpMethod.POST});
        inputs.add(new Object[]{"Post", HttpMethod.POST});
        inputs.add(new Object[]{"post", HttpMethod.POST});
        // PUT
        inputs.add(new Object[]{HttpMethod.PUT.name(), HttpMethod.PUT});
        inputs.add(new Object[]{"Put", HttpMethod.PUT});
        inputs.add(new Object[]{"put", HttpMethod.PUT});
        // TRACE
        inputs.add(new Object[]{HttpMethod.TRACE.name(), HttpMethod.TRACE});
        inputs.add(new Object[]{"Trace", HttpMethod.TRACE});
        inputs.add(new Object[]{"trace", HttpMethod.TRACE});

        return inputs.iterator();
    }

    /**
     * Tests the <code>ofString()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testOfString(String input, HttpMethod expected) {
        LOGGER.debug("testOfString({}, {})", input, expected);
        HttpMethod result = HttpMethod.ofString(input);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

}

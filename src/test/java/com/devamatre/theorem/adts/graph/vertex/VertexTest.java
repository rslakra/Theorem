package com.devamatre.theorem.adts.graph.vertex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/13/24 12:14 PM
 */
public class VertexTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(VertexTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // Input: [0,1,2,3,4,5]
        for (int i = 0; i < 5; i++) {
            inputs.add(new Object[]{i});
        }

        return inputs.iterator();
    }

    /**
     * Tests the <code>new Vertex()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testVertex(int inputData) {
        LOGGER.debug("testVertex({})", inputData);
        Vertex<Integer> vertex = new Vertex<>(inputData);
        assertNotNull(vertex);
        LOGGER.debug("vertex:{}", vertex);
        assertEquals(inputData, vertex.getLabel());
    }
}

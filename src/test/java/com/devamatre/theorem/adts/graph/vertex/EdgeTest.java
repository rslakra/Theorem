package com.devamatre.theorem.adts.graph.vertex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/13/24 12:14 PM
 */
public class EdgeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EdgeTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // Input: nums = [1,1,1,2,2,3], k = 2
        inputs.add(new Object[]{1, 2, null, false});
        inputs.add(new Object[]{1, 3, BigDecimal.ONE, false});
        inputs.add(new Object[]{1, 1, BigDecimal.TEN, false});
        inputs.add(new Object[]{1, 2, null, true});
        inputs.add(new Object[]{1, 3, BigDecimal.ONE, true});
        inputs.add(new Object[]{1, 1, BigDecimal.TEN, true});

        return inputs.iterator();
    }

    /**
     * Tests the <code>new Edge()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testEdge(int source, int target, BigDecimal weight, boolean direct) {
        LOGGER.debug("testEdge({}, {}, {}, {})", source, target, weight, direct);
        Vertex<Integer> sourceVertex = new Vertex<>(source);
        Vertex<Integer> targetVertex = new Vertex<>(target);
        Edge edge = new Edge(sourceVertex, targetVertex, weight, direct);
        assertNotNull(edge);
        LOGGER.debug("edge:{}", edge);
        assertEquals(source, edge.getSource().getData());
        assertEquals(target, edge.getTarget().getData());
        assertEquals(weight, edge.getWeight());
        assertEquals(direct, edge.isDirected());
    }
}

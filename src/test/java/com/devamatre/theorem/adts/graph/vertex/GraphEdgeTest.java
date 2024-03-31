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
public class GraphEdgeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphEdgeTest.class);

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
     * Tests the <code>new GraphEdge()</code> method.
     */
    @Test(dataProvider = "inputData")
    public void testGraphEdge(int source, int target, BigDecimal weight, boolean directed) {
        LOGGER.debug("testGraphEdge({}, {}, {}, {})", source, target, weight, directed);
        Vertex<Integer> sourceVertex = new Vertex<>(source);
        LOGGER.debug("sourceVertex:{}", sourceVertex);
        assertNotNull(sourceVertex);
        Vertex<Integer> targetVertex = new Vertex<>(target);
        LOGGER.debug("targetVertex:{}", targetVertex);
        assertNotNull(targetVertex);

        // create an edge
        GraphEdge edge = GraphEdge.of(sourceVertex, targetVertex, weight, directed);
        LOGGER.debug("edge:{}", edge);
        assertNotNull(edge);

        // validate source vertex
        assertEquals(source, edge.getSource().getLabel());
        assertEquals(target, edge.getTarget().getLabel());
        assertEquals(weight, edge.getWeight());
        assertEquals(directed, edge.isDirected());

        // validate target vertex
        assertEquals(source, edge.getSource().getLabel());
        assertEquals(target, edge.getTarget().getLabel());
        assertEquals(weight, edge.getWeight());
        assertEquals(directed, edge.isDirected());
    }
}

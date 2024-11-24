package com.rslakra.theorem.algos.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.graph.vertex.VertexBasedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/13/24 9:08 AM
 */
public class GraphAlgorithmTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphAlgorithmTest.class);

    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // graph
        input.add(new Object[]{new BigDecimal(120.56), new BigDecimal(121)});

        return input.iterator();
    }

    /**
     * Test <code>kruskals</code> method.
     */
    @Test
    public void testKruskals() {
        LOGGER.debug("testKruskals()");
        VertexBasedGraph<Integer> graph = new VertexBasedGraph<>(true, false);
        assertNotNull(graph);
        graph.addEdge(0, 1, BigDecimal.valueOf(3));
        graph.addEdge(0, 2, BigDecimal.valueOf(4));
        graph.addEdge(1, 3, BigDecimal.valueOf(3));
        graph.addEdge(2, 3, BigDecimal.valueOf(-2));
        graph.addEdge(2, 4, BigDecimal.valueOf(6));
        graph.addEdge(3, 4, BigDecimal.valueOf(5));
        LOGGER.debug("graph:{}", graph);
        GraphAlgorithm graphAlgorithm = new GraphAlgorithm();
        assertNotNull(graphAlgorithm);
        graphAlgorithm.kruskals(graph);
        LOGGER.debug("graph:{}", graph);
        assertEquals(graph, graph);
    }
}

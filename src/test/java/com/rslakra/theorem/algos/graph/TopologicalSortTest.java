package com.rslakra.theorem.algos.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.graph.GraphUtilsTest;
import com.rslakra.theorem.adts.graph.vertex.Vertex;
import com.rslakra.theorem.adts.graph.vertex.VertexBasedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 2/13/24 10:43 AM
 */
public class TopologicalSortTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopologicalSortTest.class);

    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // graph
        input.add(new Object[]{new BigDecimal(120.56), new BigDecimal(121)});

        return input.iterator();
    }

    /**
     * Test <code>topSort()</code> method.
     */
    @Test
    public void testTopSort() {
        LOGGER.debug("topSort()");
        VertexBasedGraph<Integer> graph = new VertexBasedGraph<>(false, true);
        assertNotNull(graph);
        GraphUtilsTest.fillGraph(graph, false);
        TopologicalSort<Integer> instance = new TopologicalSort<>();
        assertNotNull(instance);

        /*
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);

        graph.addEdge(3, 5);
        graph.addEdge(3, 4);

        graph.addEdge(4, 6);
         */

        Deque<Vertex<Integer>> graphSorted = instance.topSort(graph);
        while (!graphSorted.isEmpty()) {
            System.out.println(graphSorted.poll());
        }
        assertEquals(graph, graph);
    }
}

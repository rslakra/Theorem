package com.rslakra.theorem.adts.graph.vertex;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rslakra.theorem.adts.graph.AbstractGraphTest;
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
 * @created 2/12/24 3:55 PM
 */
public class VertexBasedGraphTest extends AbstractGraphTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(VertexBasedGraphTest.class);

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        // Input: [[1,2, null, false],[1,3, 1, false],[1,1, 10, false]]
        inputs.add(new Object[]{1, 2, null, false});
        inputs.add(new Object[]{1, 3, BigDecimal.ONE, false});
        inputs.add(new Object[]{1, 1, BigDecimal.TEN, false});

        // Input: [[1,2, null, true],[1,3, 1, true],[1,1, 10, true]]
        inputs.add(new Object[]{1, 2, null, true});
        inputs.add(new Object[]{1, 3, BigDecimal.ONE, true});
        inputs.add(new Object[]{1, 1, BigDecimal.TEN, true});

        return inputs.iterator();
    }

    /**
     * Fills the graph with data.
     *
     * @param graph
     */
    private void fillGraph(VertexBasedGraph<Integer> graph) {
        /**
         * <pre>
         *  0----------------2
         *  |                |
         *  |                |
         *  1----------------3
         * </pre>
         * 0----1
         *
         */
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
    }

    /**
     * Tests the <code>createGraph</code> method.
     */
    @Test
    @Override
    public void testBuildGraph() {
        VertexBasedGraph<Integer> graph = new VertexBasedGraph<>();
        assertNotNull(graph);
        fillGraph(graph);
        LOGGER.debug("graph:{}", graph);
    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testIsWeighted() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testIsDirected() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetSize() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetVertices() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetNeighbors() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testPrintGraph() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testFirstVertex() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testAddEdgeWithWeight() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testAddEdge() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testHasEdge() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testFindEdge() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testRemoveEdge() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetVerticesConnectedTo() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetInwardEdges() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetOutwardEdges() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetSortedVertices() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testHasCycle() {

    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testSearchEdge() {

    }
}

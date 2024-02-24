package com.devamatre.theorem.adts.graph.edgelist;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.devamatre.theorem.adts.PrettyPrinter;
import com.devamatre.theorem.adts.array.TablePrettyPrinter;
import com.devamatre.theorem.adts.graph.AbstractGraphTest;
import com.devamatre.theorem.adts.graph.GraphUtils;
import com.devamatre.theorem.adts.graph.GraphUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class GraphWithEdgeListTest extends AbstractGraphTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphWithEdgeListTest.class);

    /**
     * Tests the <code>createGraph</code> method.
     */
    @Override
    public void testBuildGraph() {
        LOGGER.debug("+testBuildGraph()");
        GraphWithEdgeList<Integer> graph = new GraphWithEdgeList();
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        graph.printGraph();

        // fill graph with data
        Integer[][] inputData = new Integer[][]{
            {0, 3, 4, 0, 1},
            {3, 0, 1, 2, 0},
            {4, 1, 0, 0, 0},
            {0, 2, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        GraphUtils.buildMatrixGraph(graph, inputData);
        assertNotNull(graph);
        LOGGER.debug("graph:{}", graph);
        graph.printGraph();
        LOGGER.debug("-testBuildGraph()");
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

    @Test
    public void testGraph() {
        GraphWithEdgeList<Integer> graph = new GraphWithEdgeList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();

        // // Search the given edge in the graph
        // graph.searchEdge(2, 1);
        // graph.searchEdge(0, 3);
    }
}

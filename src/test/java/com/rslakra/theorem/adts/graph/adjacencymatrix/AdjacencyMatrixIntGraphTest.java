package com.rslakra.theorem.adts.graph.adjacencymatrix;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.rslakra.theorem.adts.PrettyPrinter;
import com.rslakra.theorem.adts.array.ArrayUtils;
import com.rslakra.theorem.adts.array.TablePrettyPrinter;
import com.rslakra.theorem.adts.graph.AbstractGraphTest;
import com.rslakra.theorem.adts.graph.GraphUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class AdjacencyMatrixIntGraphTest extends AbstractGraphTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdjacencyMatrixIntGraphTest.class);

    /**
     * Tests the <code>buildGraphWithEdges()</code> method.
     */
    @Test
    @Override
    public void testBuildGraph() {
        LOGGER.debug("+testBuildGraph()");
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);

        // Print the adjacency list representation of the above graph
        graph.printGraph();
        LOGGER.debug("-testBuildGraph()");
    }

    /**
     * Tests the <code>isWeighted()</code> method.
     */
    @Test
    @Override
    public void testIsWeighted() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices, true);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isWeighted());
        assertFalse(graph.isDirected());
        // assertEquals(vertices, graph.getSize());
    }

    /**
     * Tests the <code>isDirected()</code> method.
     */
    @Test
    @Override
    public void testIsDirected() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices, true, true);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isWeighted());
        assertTrue(graph.isDirected());
        // assertEquals(vertices, graph.getSize());
    }

    /**
     * Tests the <code>getSize()</code> method.
     */
    @Test
    @Override
    public void testGetSize() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices, true, true);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isWeighted());
        assertTrue(graph.isDirected());

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
        // assertEquals(vertices, graph.getSize());
    }

    /**
     * Tests the <code>getVertices()</code> method.
     */
    @Test
    @Override
    public void testGetVertices() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices, true, true);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isWeighted());
        assertTrue(graph.isDirected());

        // fill graph with data
        Integer[][] inputData = new Integer[][]{
            {0, 3, 4, 0, 1},
            {3, 0, 1, 2, 0},
            {4, 1, 0, 0, 0},
            {0, 2, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        GraphUtils.buildMatrixGraph(graph, inputData);
        LOGGER.debug("graph:{}", graph);
        // assertEquals(vertices, graph.getSize());
        assertEquals(Set.of(0, 1, 2, 3, 4), graph.getVertices());
    }

    /**
     * Tests the <code>getNeighbors()</code> method.
     */
    @Test
    @Override
    public void testGetNeighbors() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices, true, true);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);

        // fill graph with data
        Integer[][] inputData = new Integer[][]{
            {0, 3, 4, 0, 1},
            {3, 0, 1, 2, 0},
            {4, 1, 0, 0, 0},
            {0, 2, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        GraphUtils.buildMatrixGraph(graph, inputData);
        LOGGER.debug("graph:{}", graph);
        assertEquals(vertices, graph.getSize());
//        assertEquals(Set.of(Edge.of(0, 1), Edge.of(0, 4)), graph.getNeighbors(0));
    }

    /**
     * Tests the <code>printGraph()</code> method.
     */
    @Test
    @Override
    public void testPrintGraph() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices, true, true);
        assertNotNull(graph);
        LOGGER.debug("graph:{}", graph);
        assertTrue(graph.isWeighted());
        assertTrue(graph.isDirected());

        // fill graph with data
        Integer[][] inputData = new Integer[][]{
            {0, 3, 4, 0, 1},
            {3, 0, 1, 2, 0},
            {4, 1, 0, 0, 0},
            {0, 2, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        GraphUtils.buildMatrixGraph(graph, inputData);
        LOGGER.debug("graph:{}", graph);
        // assertEquals(vertices, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
    }

    /**
     * Tests the <code>firstVertex()</code> method.
     */
    @Test
    @Override
    public void testFirstVertex() {
        int vertices = 5;
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertFalse(graph.isWeighted());
        assertFalse(graph.isDirected());

        // fill graph with data
        Integer[][] inputData = new Integer[][]{
            {0, 3, 4, 0, 1},
            {3, 0, 1, 2, 0},
            {4, 1, 0, 0, 0},
            {0, 2, 0, 0, 0},
            {1, 0, 0, 0, 0}
        };
        GraphUtils.buildMatrixGraph(graph, inputData);
        LOGGER.debug("graph:{}", graph);
        // assertEquals(vertices, graph.getSize());
        assertEquals(0, graph.firstVertex());
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
        LOGGER.debug("testGraph()");
    }

    /**
     *
     */
    @Test
    public void testGraph() {
        LOGGER.debug("testGraph()");
        int vertices = 4;
        int[][] inputData = new int[][]{{0, 4, 0, 8}, {0, 0, 6, 2}, {0, 6, 0, 1}, {8, 2, 1, 0},};
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        prettyPrinter.prettyPrint(ArrayUtils.asIntList(inputData));
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        GraphUtils.buildMatrixGraph(graph, ArrayUtils.asIntList(inputData));
        assertNotNull(graph);
        assertEquals(vertices, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();

        // Search the given edge in the graph
        graph.searchEdge(2, 1);
        graph.searchEdge(0, 3);
        graph.searchEdge(0, 2);
    }
}

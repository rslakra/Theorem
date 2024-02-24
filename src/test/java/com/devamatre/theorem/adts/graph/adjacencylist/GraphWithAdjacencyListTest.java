package com.devamatre.theorem.adts.graph.adjacencylist;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.devamatre.theorem.adts.graph.AbstractGraphTest;
import com.devamatre.theorem.adts.graph.Edge;
import com.devamatre.theorem.adts.graph.GraphUtilsTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class GraphWithAdjacencyListTest extends AbstractGraphTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphWithAdjacencyListTest.class);

    /**
     * Tests the <code>buildGraphWithEdges</code> method.
     */
    @Test
    @Override
    public void testBuildGraph() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
    }

    /**
     * Tests the <code>isWeighted()</code> method.
     */
    @Test
    @Override
    public void testIsWeighted() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(false, graph.isWeighted());

        graph = new GraphWithAdjacencyList<>(true, true);
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(true, graph.isWeighted());
    }

    /**
     * Tests the <code>isDirected()</code> method.
     */
    @Test
    @Override
    public void testIsDirected() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(false, graph.isDirected());

        graph = new GraphWithAdjacencyList<>(false, true);
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(true, graph.isDirected());
    }

    /**
     * Tests the <code>getSize()</code> method.
     */
    @Test
    @Override
    public void testGetSize() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());
    }

    /**
     * Tests the <code>getVertices()</code> method.
     */
    @Test
    @Override
    public void testGetVertices() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(Set.of(0, 1, 2, 3, 4), graph.getVertices());
    }

    /**
     * Tests the <code>getNeighbors()</code> method.
     */
    @Test
    @Override
    public void testGetNeighbors() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(Set.of(Edge.of(0, 1), Edge.of(0, 4)), graph.getNeighbors(0));
    }

    /**
     * Tests the <code></code> method.
     */
    @Test
    @Override
    public void testPrintGraph() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        graph.printGraph();
    }

    /**
     * Tests the <code>startNode</code> method.
     */
    @Test
    @Override
    public void testFirstVertex() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
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

    }

    @Test
    public void testGraph() {
        GraphWithAdjacencyList<Integer> graph = new GraphWithAdjacencyList<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        // assertEquals(0, graph.getSize());

        // Print the adjacency list representation of the above graph
        // graph.printGraph();

        // Search the given edge in the graph
        // graph.searchEdge(2, 1);
        //  graph.searchEdge(0, 3);
    }
}

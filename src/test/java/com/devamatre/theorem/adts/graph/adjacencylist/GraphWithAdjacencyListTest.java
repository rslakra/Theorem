package com.devamatre.theorem.adts.graph.adjacencylist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.devamatre.theorem.adts.graph.AbstractGraphTest;
import com.devamatre.theorem.adts.graph.Edge;
import com.devamatre.theorem.adts.graph.Graph;
import com.devamatre.theorem.adts.graph.GraphUtilsTest;
import org.junit.jupiter.api.Assertions;
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
     * Test <code>hasCycleInUndirectedGraph()</code> method.
     */
    @Test
    public void testHasCycleInUndirectedGraph() {
        LOGGER.debug("testHasCycleInUndirectedGraph()");
        // no cycle
        GraphWithAdjacencyList<Integer> graphNoCycle = new GraphWithAdjacencyList<>();
        Assertions.assertNotNull(graphNoCycle);
        GraphUtilsTest.fillGraph(graphNoCycle, false);
        assertFalse(graphNoCycle.hasCycleInUndirectedGraph());

        // with cycle
        GraphWithAdjacencyList<Integer> graphWithCycle = new GraphWithAdjacencyList<>();
        Assertions.assertNotNull(graphWithCycle);
        GraphUtilsTest.fillGraph(graphWithCycle, true);
        assertTrue(graphWithCycle.hasCycleInUndirectedGraph());
    }

    /**
     * Test <code>hasCycleInDirectedGraph()</code> method.
     */
    @Test
    public void testHasCycleInDirectedGraph() {
        LOGGER.debug("testHasCycleInDirectedGraph()");
        // no cycle data
        GraphWithAdjacencyList<Integer> graphNoCycle = new GraphWithAdjacencyList<>(false, true);
        Assertions.assertNotNull(graphNoCycle);
        GraphUtilsTest.fillGraph(graphNoCycle, false);
        assertFalse(graphNoCycle.hasCycleInDirectedGraph());

        // with cycle data
        GraphWithAdjacencyList<Integer> graphWithCycle = new GraphWithAdjacencyList<>(false, true);
        Assertions.assertNotNull(graphWithCycle);
        GraphUtilsTest.fillGraph(graphWithCycle, true);
        assertTrue(graphWithCycle.hasCycleInDirectedGraph());
    }

    /**
     * Test <code>hasCycle()</code> method.
     */
    @Test
    public void testHasCycle() {
        LOGGER.debug("testHasCycle()");
        // no cycle data
        GraphWithAdjacencyList<Integer> graphNoCycle = new GraphWithAdjacencyList<>();
        Assertions.assertNotNull(graphNoCycle);
        GraphUtilsTest.fillGraph(graphNoCycle, false);
        assertFalse(graphNoCycle.hasCycle());

        // no cycle data
        graphNoCycle = new GraphWithAdjacencyList<>(false, true);
        Assertions.assertNotNull(graphNoCycle);
        GraphUtilsTest.fillGraph(graphNoCycle, false);
        assertFalse(graphNoCycle.hasCycle());

        // with cycle data
        GraphWithAdjacencyList<Integer> graphWithCycle = new GraphWithAdjacencyList<>();
        Assertions.assertNotNull(graphWithCycle);
        GraphUtilsTest.fillGraph(graphWithCycle, true);
        assertTrue(graphWithCycle.hasCycle());

        // with cycle data
        graphWithCycle = new GraphWithAdjacencyList<>(false, true);
        Assertions.assertNotNull(graphWithCycle);
        GraphUtilsTest.fillGraph(graphWithCycle, true);
        assertTrue(graphWithCycle.hasCycle());
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

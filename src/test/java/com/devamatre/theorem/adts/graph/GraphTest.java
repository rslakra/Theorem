package com.devamatre.theorem.adts.graph;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.devamatre.appsuite.core.Sets;
import com.devamatre.theorem.adts.lang.Maths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:40 PM
 */
public class GraphTest extends AbstractGraphTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphTest.class);

    /**
     * Tests the <code>buildGraphWithEdges()</code> method.
     */
    @Test
    @Override
    public void testBuildGraph() {
        Graph<Integer> graph = new Graph<>();
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
        Graph<Integer> graph = new Graph<>(true, false);
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isWeighted());
    }

    /**
     * Tests the <code>isDirected()</code> method.
     */
    @Test
    @Override
    public void testIsDirected() {
        Graph<Integer> graph = new Graph<>(true, true);
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isDirected());
    }

    /**
     * Tests the <code>getSize()</code> method.
     */
    @Test
    @Override
    public void testGetSize() {
        Graph<Integer> graph = new Graph<>(true, true);
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
        Graph<Integer> graph = new Graph<>();
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
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(Set.of(Edge.of(0, 1), Edge.of(0, 4)), graph.getNeighbors(0));
    }

    /**
     * Tests the <code>printGraph()</code> method.
     */
    @Test
    @Override
    public void testPrintGraph() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
    }

    /**
     * Tests the <code>firstVertex()</code> method.
     */
    @Test
    @Override
    public void testFirstVertex() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(0, graph.firstVertex());
    }

    /**
     * Tests the <code>addEdge()</code> method.
     */
    @Test
    @Override
    public void testAddEdgeWithWeight() {
        Graph<Integer> graph = new Graph<>(true, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        graph.addEdge(0, 1, BigDecimal.ONE);
        assertEquals(Set.of(0, 1), graph.getVertices());
        assertEquals(Set.of(Edge.of(0, 1, BigDecimal.ONE)), graph.getNeighbors(graph.firstVertex()));
        assertEquals(BigDecimal.ONE, graph.getNeighbors(graph.firstVertex()).iterator().next().getWeight());
    }

    /**
     * Tests the <code>addEdge()</code> method.
     */
    @Test
    @Override
    public void testAddEdge() {
        Graph<Integer> graph = new Graph<>();
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        graph.addEdge(0, 1);
        assertEquals(Set.of(0, 1), graph.getVertices());
        assertEquals(Set.of(Edge.of(0, 1)), graph.getNeighbors(graph.firstVertex()));
        assertEquals(BigDecimal.ZERO, graph.getNeighbors(graph.firstVertex()).iterator().next().getWeight());
    }

    /**
     * Tests the <code>hasEdge()</code> method.
     */
    @Override
    public void testHasEdge() {
        Graph<Integer> graph = new Graph<>();
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        GraphUtilsTest.fillGraph(graph, false);
        assertTrue(graph.hasEdge(0, 1));
        assertFalse(graph.hasEdge(0, 2));
    }

    /**
     * Tests the <code>findEdge()</code> method.
     */
    @Test
    @Override
    public void testFindEdge() {
        Graph<Integer> graph = new Graph<>();
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        GraphUtilsTest.fillGraph(graph, false);
        assertEquals(Edge.of(0, 1), graph.findEdge(0, 1));
        assertNull(graph.findEdge(0, 2));
    }

    /**
     * Tests the <code>removeEdge()</code> method.
     */
    @Test
    @Override
    public void testRemoveEdge() {
        Graph<Integer> graph = new Graph<>();
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        // remove edge
        graph.removeEdge(0, 1);
        LOGGER.debug("After removing edge(0 --> 1) graph:{}", graph);
        assertFalse(graph.hasEdge(0, 1));

        // remove edge
        graph.removeEdge(0, 1);
        LOGGER.debug("graph:{}", graph);
        assertFalse(graph.hasEdge(0, 1));
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
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();

        // Search the given edge in the graph
        graph.searchEdge(2, 1);
        graph.searchEdge(0, 3);
    }

    @Test
    public void testDfs() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
        graph.dfs();
    }

    @Test
    public void testBfs() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
        graph.bfs(0);
    }

    @Test
    public void testBfsRecursively() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, false);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();

        Queue<Edge> queue = new LinkedList<>();
        Set<Edge> visited = new HashSet<>();
        graph.bfsRecursively(queue, visited);
        LOGGER.debug("queue:{}", queue);
        LOGGER.debug("visited:{}", visited);
    }

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> cycleDetectionUndirectedData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{true, true});
        inputs.add(new Object[]{false, false});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param expected
     */
    @Test(dataProvider = "cycleDetectionUndirectedData")
    public void testCycleDetectionUndirected(boolean input, boolean expected) {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.fillGraph(graph, input);
        LOGGER.debug("Undirected Graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
        assertEquals(expected, graph.hasCycleInUndirectedGraph());
    }

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> cycleDetectionDirectedData() {
        List<Object[]> inputs = new ArrayList<>();
        // directed graph
        inputs.add(new Object[]{true, true});
        inputs.add(new Object[]{false, false});

        return inputs.iterator();
    }

    /**
     * @param input
     * @param expected
     */
    @Test(dataProvider = "cycleDetectionDirectedData")
    public void testCycleDetectionDirected(boolean input, boolean expected) {
        Graph<Integer> graph = new Graph<>(false, true);
        GraphUtilsTest.fillGraph(graph, input);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // if (graph.isDirected()) {
        //  assertEquals(3, graph.getSize());
        //  } else {
        //  assertEquals(2, graph.getSize());
        //  }
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        assertEquals(expected, graph.cycleDetectionDirected());
    }

    @Test
    public void testTopSort() {
        Graph<Integer> graph = new Graph<>(false, true);
        GraphUtilsTest.fillDirectedTopologicalGraph(graph);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        assertEquals(stack, graph.topSort());
    }

    @Test
    public void testTopSorts() {
        Graph<Integer> graph = new Graph<>(false, true);
        GraphUtilsTest.fillDirectedTopologicalGraph(graph);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        assertEquals(Arrays.asList(Arrays.asList(5, 4, 2, 3, 1, 0)), graph.topSorts());
    }

    @Test
    public void testShortPathWithDijkstraAlgorithm() {
        Graph<Integer> graph = new Graph<>(true, true);
        GraphUtilsTest.createDirectedWeightedGraph(graph);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
//  graph.shortPathWithDijkstraAlgorithm();
        Map<Integer, BigDecimal> results = new HashMap<>();
        results.put(0, BigDecimal.ZERO);
        results.put(1, Maths.TWO);
        results.put(2, Maths.THREE);
        results.put(3, Maths.EIGHT);
        results.put(4, Maths.SIX);
        results.put(5, Maths.NINE);

        assertEquals(results, graph.shortPathWithDijkstraAlgorithm());
    }

    @Test
    public void testShortPathWithBellmanFordAlgorithm() {
        Graph<Integer> graph = new Graph<>(true, true);
        GraphUtilsTest.createDirectedNegativeWeightedGraph(graph);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Map<Integer, BigDecimal> results = new HashMap<>();
        results.put(0, BigDecimal.ZERO);
        results.put(1, Maths.TWO);
        results.put(2, Maths.TWO.negate());
        results.put(3, BigDecimal.ONE);
        results.put(4, BigDecimal.ONE);
        results.put(5, BigDecimal.ONE.negate());
        assertEquals(results, graph.shortPathWithBellmanFordAlgorithm());
    }

    @Test
    public void testShortPathWithBellmanFordAlgorithmWithNegativeWeightCycle() {
        Graph<Integer> graph = new Graph<>(true, true);
        GraphUtilsTest.createDirectedNegativeWeightedGraphWithNegativeWeightCycle(graph, false);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Map<Integer, BigDecimal> results = new HashMap<>();
        results.put(0, BigDecimal.ZERO);
        results.put(1, Maths.TWO);
        results.put(2, Maths.TWO.negate());
        results.put(3, Maths.ZERO);
        results.put(4, Maths.THREE);

        assertEquals(results, graph.shortPathWithBellmanFordAlgorithmWithNegativeWeightCycle());

        LOGGER.debug("---------------- ---------------- ---------------- ----------------");
        GraphUtilsTest.createDirectedNegativeWeightedGraphWithNegativeWeightCycle(graph, true);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        results.put(1, Maths.SEVEN.negate()); // negative weight cycle
        assertEquals(results, graph.shortPathWithBellmanFordAlgorithmWithNegativeWeightCycle());
    }

    @Test
    public void testMstEdges() {
        Graph<Integer> graph = new Graph<>(true, false);
        GraphUtilsTest.createWeightedGraph(graph, false);
        LOGGER.debug("Undirected Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Set<Edge<Integer>> mstEdges = graph.mstEdges();
        assertNotNull(mstEdges);
        LOGGER.debug("mstEdges:{}", mstEdges);
        assertEquals(4, mstEdges.size());
        assertEquals(60, mstEdges.stream().map(edge -> edge.getWeight()).mapToInt(BigDecimal::intValue).sum());
    }

    /**
     *
     */
    @Test
    public void testMSTCost() {
        Graph<Integer> graph = new Graph<>(true, false);
        GraphUtilsTest.createWeightedGraph(graph, false);
        LOGGER.debug("Undirected Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        BigDecimal mstCost = graph.mstCost();
        LOGGER.debug("mstCost:{}", mstCost);
        assertEquals(BigDecimal.valueOf(60), mstCost);
    }

    @Test
    public void testMSTCostTree() {
        Graph<Integer> graph = new Graph<>(true, false);
        GraphUtilsTest.createWeightedGraph(graph, false);
        LOGGER.debug("Undirected Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        assertEquals(Sets.asSet(0, 1, 2, 3, 4), graph.mstCostTree());
    }

    @Test
    public void testTransposeDirectedGraph() {
        Graph<Integer> graph = new Graph<>(true, true);
        GraphUtilsTest.createDirectedGraph(graph);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Graph<Integer> transposeDirectedGraph = graph.transposeDirectedGraph();
        assertNotNull(transposeDirectedGraph);
        LOGGER.debug("Transposed Directed Graph:{}", transposeDirectedGraph);
        transposeDirectedGraph.printGraph();
    }

    @Test
    public void testKosarajuAlgorithm() {
        Graph<Integer> graph = new Graph<>(true, true);
        GraphUtilsTest.createDirectedGraph(graph);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Set<Set<Integer>> stronglyConnectedComponents = graph.kosarajuAlgorithm();
        assertNotNull(stronglyConnectedComponents);
        LOGGER.debug("Strongly Connected Components:{}", stronglyConnectedComponents);
        Set<Set<Integer>> expected = new HashSet<>();
        expected.add(Sets.asSet(0, 1, 2));
        expected.add(Sets.asSet(3));
        expected.add(Sets.asSet(4));
        assertEquals(3, stronglyConnectedComponents.size());
        assertEquals(expected, stronglyConnectedComponents);
    }

    @Test
    public void testTarjanAlgorithm() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.createBridgeGraph(graph, false);
        LOGGER.debug("Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Set<Edge<Integer>> bridgesInGraph = graph.tarjanAlgorithm();
        assertNotNull(bridgesInGraph);
        LOGGER.debug("Bridges in Graph:{}", bridgesInGraph);
        Set<Edge<Integer>> expected = new HashSet<>();
        expected.add(new Edge<>(0, 3));
        assertEquals(1, bridgesInGraph.size());
        assertEquals(expected, bridgesInGraph);

        LOGGER.debug("---------------- ---------------- ---------------- ----------------");
        graph = new Graph<>();
        GraphUtilsTest.createBridgeGraph(graph, true);
        LOGGER.debug("Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        bridgesInGraph = graph.tarjanAlgorithm();
        assertNotNull(bridgesInGraph);
        LOGGER.debug("Bridges in Graph:{}", bridgesInGraph);
        expected = new HashSet<>();
        expected.add(new Edge<>(0, 3));
        expected.add(new Edge<>(3, 4));
        assertEquals(2, bridgesInGraph.size());
        assertEquals(expected, bridgesInGraph);
    }

    @Test
    public void testArticulationPointsTarjanAlgorithm() {
        Graph<Integer> graph = new Graph<>();
        GraphUtilsTest.createArticulationPointsGraph(graph, false);
        LOGGER.debug("Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        Set<Integer> graphArticulationPoints = graph.articulationPointsTarjanAlgorithm();
        assertNotNull(graphArticulationPoints);
        LOGGER.debug("Graph Articulation Points:{}", graphArticulationPoints);
        Set<Integer> expected = new HashSet<>();
        expected.add(0);
        expected.add(3);
        assertEquals(2, graphArticulationPoints.size());
        assertEquals(expected, graphArticulationPoints);

        LOGGER.debug("---------------- ---------------- ---------------- ----------------");
        graph = new Graph<>();
        GraphUtilsTest.createArticulationPointsGraph(graph, true);
        LOGGER.debug("Graph:{}", graph);
        assertNotNull(graph);
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        graphArticulationPoints = graph.articulationPointsTarjanAlgorithm();
        assertNotNull(graphArticulationPoints);
        LOGGER.debug("Graph Articulation Points:{}", graphArticulationPoints);
        expected = new HashSet<>();
        expected.add(0);
        assertEquals(1, graphArticulationPoints.size());
        assertEquals(expected, graphArticulationPoints);
    }

}

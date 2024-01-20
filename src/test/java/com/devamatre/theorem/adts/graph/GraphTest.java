package com.devamatre.theorem.adts.graph;

import static org.testng.Assert.assertEquals;
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
     * @param graph
     * @param withCycle
     */
    @Override
    public void createGraph(AbstractGraph<Integer> graph, boolean withCycle) {
        super.createGraph(graph, withCycle);
    }

    /**
     * Tests the <code>createGraph</code> method.
     */
    @Override
    public void testCreateGraph() {
        Graph<Integer> graph = new Graph<>();
        createGraph(graph);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testIsWeighted() {
        Graph<Integer> graph = new Graph<>(true, false);
        createGraph(graph);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isWeighted());
    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testIsDirected() {
        Graph<Integer> graph = new Graph<>(true, true);
        createGraph(graph);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertTrue(graph.isDirected());
    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testGetSize() {
        Graph<Integer> graph = new Graph<>(true, true);
        createGraph(graph);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());
    }

    /**
     * Tests the <code></code> method.
     */
    @Override
    public void testStartNode() {

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
    public void testGetNeighbors() {

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
    public void testPrintGraph() {
        Graph<Integer> graph = new Graph<>();
        createGraph(graph);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
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
        createGraph(graph);
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
        GraphUtilsTest.createGraph(graph);
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
        GraphUtilsTest.createGraph(graph);
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
        GraphUtilsTest.createGraph(graph);
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
        GraphUtilsTest.createGraph(graph, input);
        LOGGER.debug("Undirected Graph:{}", graph);
        assertNotNull(graph);
        assertEquals(5, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
        assertEquals(expected, graph.cycleDetectionUndirected());
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
        GraphUtilsTest.createGraph(graph, input);
        LOGGER.debug("Directed Graph:{}", graph);
        assertNotNull(graph);
//        if (graph.isDirected()) {
//            assertEquals(3, graph.getSize());
//        } else {
//            assertEquals(2, graph.getSize());
//        }
        // Print the adjacency list representation of the above graph
        graph.printGraph();
        assertEquals(expected, graph.cycleDetectionDirected());
    }

    @Test
    public void testTopSort() {
        Graph<Integer> graph = new Graph<>(false, true);
        GraphUtilsTest.createTopologicalGraph(graph);
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
        GraphUtilsTest.createTopologicalGraph(graph);
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
//        graph.shortPathWithDijkstraAlgorithm();
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

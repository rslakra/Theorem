package com.devamatre.theorem.adts.graph;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.devamatre.theorem.adts.PrettyPrinter;
import com.devamatre.theorem.adts.array.TablePrettyPrinter;
import com.devamatre.theorem.adts.graph.adjacencymatrix.AdjacencyMatrixIntGraph;
import com.devamatre.theorem.adts.lang.Maths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 11/6/23 10:50 AM
 */
public class GraphUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphUtilsTest.class);

    /**
     * Fills the graph with the data. If <code>withCycle</code> is set to be true, the cyclic data is used.
     * <p>
     * Creates the following graph:
     * <p>
     * No Cycle
     * <pre>
     *           0 --------- 4
     *         /
     *       /
     *     1 ------ 2
     *      \
     *       \
     *        3
     * </pre>
     * <p>
     * With Cycle (Undirected)
     * <pre>
     *           0 --------- 4
     *         /
     *       /
     *     1 ------ 2
     *      \      /
     *       \   /
     *        3
     * </pre>
     * <p>
     * With Cycle (Directed)
     * <pre>
     *           0 --------- 4
     *         /  \
     *       /     \
     *     1 ------ 2
     *      \
     *       \
     *        3
     * </pre>
     *
     * @param graph
     * @param withCycle
     */
    public static void fillGraph(AbstractGraph<Integer> graph, boolean withCycle) {
        LOGGER.debug("+fillGraph({}, {})", graph, withCycle);
        // add edges
        List<Edge<Integer>> edges = new ArrayList<>();
        // add edges
        edges.add(Edge.of(0, 1));
        edges.add(Edge.of(0, 4));
        edges.add(Edge.of(1, 2));
        edges.add(Edge.of(1, 3));

        // cyclic edges
        if (withCycle) {
            if (graph.isDirected()) {
                // cyclic edges for directed graph
                edges.add(Edge.of(2, 0));
            } else {
                // cyclic edges for undirected graph
                edges.add(Edge.of(2, 3));
            }
        }
        // build graph with data
        GraphUtils.buildGraph(graph, edges);

        LOGGER.debug("-fillGraph(), graph:{}", graph);
    }

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> inputData() {
        List<Object[]> inputs = new ArrayList<>();
        return inputs.iterator();
    }

    /**
     * Tests the <code>fillGraph()</code> method.
     * <p>
     * Creates the following graph:
     * <p>
     * No Cycle
     * <pre>
     *           0 --------- 4
     *         /
     *       /
     *     1 ------ 2
     *      \
     *       \
     *        3
     * </pre>
     */
    @Test
    public void testFillGraph() {
        Graph<Integer> graph = new Graph<>();
        fillGraph(graph, false);
        assertEquals(5, graph.getSize());
        assertEquals(false, graph.isWeighted());
        assertEquals(false, graph.isDirected());
        graph.printGraph();
    }

    /**
     *
     */
    @Test
    public void testBuildMatrixGraph() {
        LOGGER.debug("testGraph()");
        int vertices = 4;
        Integer[][] inputData = new Integer[][]{{0, 4, 0, 8}, {0, 0, 6, 2}, {0, 6, 0, 1}, {8, 2, 1, 0},};
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        prettyPrinter.prettyPrint(inputData);
        AdjacencyMatrixIntGraph graph = new AdjacencyMatrixIntGraph(vertices);
        LOGGER.debug("graph:{}", graph);
        assertNotNull(graph);
        GraphUtils.buildMatrixGraph(graph, inputData);
        assertNotNull(graph);
//         assertEquals(vertices, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();
    }

    /**
     * @param graph
     */
    public static void fillDirectedTopologicalGraph(Graph<Integer> graph) {
        LOGGER.debug("+fillDirectedTopologicalGraph()");
        graph.setDirected(true);
        // add edges
        List<Edge<Integer>>
            edges =
            Arrays.asList(Edge.of(0, null), Edge.of(1, null), Edge.of(5, 0), Edge.of(4, 0), Edge.of(5, 2),
                          Edge.of(2, 3), Edge.of(3, 1), Edge.of(4, 1));
        // build graph with data
        GraphUtils.buildGraph(graph, edges);

        // add edges
        LOGGER.debug("-fillDirectedTopologicalGraph(), graph:{}", graph);
    }

    /**
     * Tests the <code>fillGraph()</code> method.
     */
    @Test
    public void testFillCyclicGraph() {
        Graph<Integer> graph = new Graph<>();
        List<Edge<Integer>>
            edges =
            Arrays.asList(Edge.of(0, 1), Edge.of(0, 4), Edge.of(1, 2), Edge.of(1, 3), Edge.of(2, 3));
        GraphUtils.buildGraph(graph, edges);
        assertEquals(5, graph.getSize());
        assertEquals(false, graph.isWeighted());
        assertEquals(false, graph.isDirected());
        graph.printGraph();
    }

    /**
     * Tests the <code>fillGraph()</code> method.
     */
    @Test
    public void testFillDirectedCyclicGraph() {
        Graph<Integer> graph = new Graph<>(false, true);
        List<Edge<Integer>>
            edges =
            Arrays.asList(Edge.of(0, 1), Edge.of(0, 4), Edge.of(1, 2), Edge.of(1, 3), Edge.of(2, 0));
        GraphUtils.buildGraph(graph, edges);
        assertEquals(5, graph.getSize());
        assertEquals(false, graph.isWeighted());
        assertEquals(true, graph.isDirected());
        graph.printGraph();
    }

    /**
     * @return
     */
    public static void createDirectedWeightedGraph(Graph<Integer> graph) {
        LOGGER.debug("+createDirectedWeightedGraph()");
        graph.setWeighted(true);
        graph.setDirected(true);
        // add edges
        graph.addEdge(0, 1, Maths.TWO);
        graph.addEdge(0, 2, Maths.FOUR);
        graph.addEdge(1, 2, Maths.ONE);
        graph.addEdge(1, 3, Maths.SEVEN);
        graph.addEdge(2, 4, Maths.THREE);
        graph.addEdge(4, 3, Maths.TWO);
        graph.addEdge(3, 5, Maths.ONE);
        graph.addEdge(4, 5, Maths.FIVE);
        graph.addEdge(5, null);
        LOGGER.debug("-createDirectedWeightedGraph(), graph:{}", graph);
    }

    /**
     * @return
     */
    public static void createDirectedNegativeWeightedGraph(Graph<Integer> graph) {
        LOGGER.debug("+createDirectedNegativeWeightedGraph()");
        graph.setWeighted(true);
        graph.setDirected(true);
        // add edges
        graph.addEdge(0, 1, Maths.TWO);
        graph.addEdge(0, 2, Maths.FOUR);
        graph.addEdge(1, 2, Maths.FOUR.negate());
        graph.addEdge(1, 3, Maths.ONE.negate());
        graph.addEdge(2, 4, Maths.THREE);
        graph.addEdge(4, 3, Maths.TWO);
        graph.addEdge(3, 5, Maths.ONE);
        graph.addEdge(4, 5, Maths.TWO.negate());
        graph.addEdge(5, null, Maths.ZERO);
        LOGGER.debug("-createDirectedNegativeWeightedGraph(), graph:{}", graph);
    }

    /**
     * @return
     */
    public static void createDirectedNegativeWeightedGraphWithNegativeWeightCycle(Graph<Integer> graph,
                                                                                  boolean negWeightCycle) {
        LOGGER.debug("+createDirectedNegativeWeightedGraphWithNegativeWeightCycle()");
        graph.setWeighted(true);
        graph.setDirected(true);
        // add edges
        graph.addEdge(0, 1, Maths.TWO);
        graph.addEdge(0, 2, Maths.FOUR);
        graph.addEdge(1, 2, Maths.FOUR.negate());
        graph.addEdge(2, 3, Maths.TWO);
        graph.addEdge(3, 4, Maths.THREE);
        if (negWeightCycle) {
            graph.addEdge(4, 1, Maths.TEN.negate());
        } else {
            graph.addEdge(4, 1, Maths.ONE.negate());
        }
        LOGGER.debug("-createDirectedNegativeWeightedGraphWithNegativeWeightCycle(), graph:{}", graph);
    }


    /**
     * @return
     */
    public static void createWeightedGraph(Graph<Integer> graph, boolean withCycle) {
        LOGGER.debug("+createWeightedGraph({}, {})", graph, withCycle);
        graph.setWeighted(true);
        if (graph.isDirected()) {
            graph.setDirected(false);
        }
        // add edges
        graph.addEdge(0, 1, Maths.TEN);
        graph.addEdge(0, 2, Maths.FIFTEEN);
        graph.addEdge(0, 3, Maths.TWENTY);
        graph.addEdge(0, 4, Maths.TWENTY_FIVE);

        graph.addEdge(1, 3, Maths.THIRTY);
        graph.addEdge(1, 4, Maths.SIXTY);

        graph.addEdge(2, 3, Maths.TEN);
        graph.addEdge(2, 4, Maths.FORTY);

        graph.addEdge(3, 4, Maths.FIFTY);
        LOGGER.debug("-createWeightedGraph(), graph:{}", graph);
    }

    /**
     * @return
     */
    public static void createDirectedGraph(Graph<Integer> graph) {
        LOGGER.debug("+createDirectedGraph()");
        graph.setDirected(true);
        // add edges
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(2, 1);

        graph.addEdge(1, 0);

        graph.addEdge(3, 4);

        graph.addEdge(4, null);
        LOGGER.debug("-createDirectedGraph(), graph:{}", graph);
    }

    /**
     * @return
     */
    public static void createBridgeGraph(Graph<Integer> graph, boolean multiBridge) {
        LOGGER.debug("+createBridgeGraph({}, {})", graph);
        // add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(1, 2);

        graph.addEdge(3, 4);
        if (!multiBridge) {
            graph.addEdge(3, 5);
            graph.addEdge(4, 5);
        }
        LOGGER.debug("-createBridgeGraph(), graph:{}", graph);
    }

    /**
     * @return
     */
    public static void createArticulationPointsGraph(Graph<Integer> graph, boolean singleBridge) {
        LOGGER.debug("+createArticulationPointsGraph({}, {})", graph);
        // add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        if (singleBridge) {
            graph.addEdge(0, 3);
            graph.addEdge(0, 4);
        } else {
            graph.addEdge(1, 2);

            graph.addEdge(3, 4);
        }
        LOGGER.debug("-createArticulationPointsGraph(), graph:{}", graph);
    }

    /**
     * Tests the <code>convertStackToList()</code> method.
     */
    @Test
    public void testConvertStackToList() {
        LOGGER.debug("testConvertStackToList()");
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> result = new ArrayList<>();
        GraphUtils.convertStackToList(stack, result);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }


    /**
     * Tests the <code>topSort()</code> method.
     */
    @Test
    public void testTopSort() {
        LOGGER.debug("testTopSort()");
        Graph<Integer> graph = new Graph<>();
        fillGraph(graph, false);
        assertEquals(5, graph.getSize());
        assertEquals(false, graph.isWeighted());
        assertEquals(false, graph.isDirected());
        graph.printGraph();
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> result = GraphUtils.topSort(graph);
        LOGGER.debug("result:{}", result);
        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }

}

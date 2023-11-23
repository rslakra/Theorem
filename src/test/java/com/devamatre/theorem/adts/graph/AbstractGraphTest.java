package com.devamatre.theorem.adts.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 11/21/23 5:17 PM
 */
public abstract class AbstractGraphTest {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractGraphTest.class);

    /**
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
     *         3
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
     *         3
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
     *         3
     * </pre>
     *
     * @return
     */
    public void createGraph(AbstractGraph<Integer> graph, boolean withCycle) {
        LOGGER.debug("+createGraph({}, {})", graph, withCycle);
        // add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        if (withCycle) {
            if (graph.isDirected()) {
                graph.addEdge(2, 0);
            } else {
                graph.addEdge(2, 3);
            }
        }

        LOGGER.debug("-createGraph(), graph:{}", graph);
    }

    /**
     * @param graph
     */
    public void createGraph(AbstractGraph<Integer> graph) {
        createGraph(graph, false);
    }

    /**
     * Tests the <code>createGraph</code> method.
     */
    public abstract void testCreateGraph();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testIsWeighted();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testIsDirected();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetSize();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testStartNode();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testAddEdgeWithWeight();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testAddEdge();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testHasEdge();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testFindEdge();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testRemoveEdge();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetNeighbors();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetVerticesConnectedTo();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testPrintGraph();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetInwardEdges();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetOutwardEdges();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetSortedVertices();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testHasCycle();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testSearchEdge();

}

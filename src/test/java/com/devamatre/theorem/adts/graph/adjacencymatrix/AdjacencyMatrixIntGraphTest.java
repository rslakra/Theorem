package com.devamatre.theorem.adts.graph.adjacencymatrix;

import static org.testng.Assert.assertNotNull;

import com.devamatre.theorem.adts.PrettyPrinter;
import com.devamatre.theorem.adts.array.ArrayUtils;
import com.devamatre.theorem.adts.array.TablePrettyPrinter;
import com.devamatre.theorem.adts.graph.AbstractGraphTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class AdjacencyMatrixIntGraphTest extends AbstractGraphTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdjacencyMatrixIntGraphTest.class);

    /**
     * Tests the <code>createGraph</code> method.
     */
    @Override
    public void testCreateGraph() {

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
        fillGraph(graph, ArrayUtils.asIntList(inputData));
        assertNotNull(graph);
//        assertEquals(vertices, graph.getSize());

        // Print the adjacency list representation of the above graph
        graph.printGraph();

        // Search the given edge in the graph
        graph.searchEdge(2, 1);
        graph.searchEdge(0, 3);
        graph.searchEdge(0, 2);
    }
}

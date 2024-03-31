package com.devamatre.theorem.algos.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 3/6/24 3:40 PM
 */
public class DetectGraphCycleTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetectGraphCycleTest.class);

    /**
     * @return
     */
    private DetectGraphCycle buildDetectGraphCycle() {
        /**
         * Let us create following graph
         *
         * <pre>
         *    0
         *   / \
         *  /   \
         * 1-----2
         * </pre>
         */
        DetectGraphCycle graph = new DetectGraphCycle(3, 3);
        // add edge 0-1
        graph.addEdge(0, 0, 1);
        // add edge 0-2
        graph.addEdge(1, 0, 2);
        // add edge 1-2
        graph.addEdge(2, 1, 2);
        LOGGER.debug("graph:{}", graph);

        return graph;
    }

    /**
     * Test <code>addEdge()</code> method.
     */
    @Test
    public void testAddEdge() {
        DetectGraphCycle graph = buildDetectGraphCycle();
        LOGGER.debug("graph:{}", graph);
    }

    /**
     * Test <code>hasCycleInUndirectedGraph()</code> method.
     */
    @Test
    public void testHasCycleInUndirectedGraph() {
        LOGGER.debug("testHasCycleInUndirectedGraph()");
        DetectGraphCycle graph = buildDetectGraphCycle();
        if (graph.hasCycleInUndirectedGraph()) {
            LOGGER.debug("graph contains cycle");
        } else {
            LOGGER.debug("graph doesn't contain cycle");
        }
    }

    /**
     * Test <code>hasCycleByPathCompression()</code> method.
     */
    @Test
    public void testHasCycleByPathCompression() {
        LOGGER.debug("testHasCycleByPathCompression()");
        DetectGraphCycle graph = buildDetectGraphCycle();
        if (graph.hasCycleByPathCompression()) {
            LOGGER.debug("graph contains cycle");
        } else {
            LOGGER.debug("graph doesn't contain cycle");
        }
    }


    /**
     * Test <code>union()</code> method.
     */
    @Test
    public void testUnionFind() {
        LOGGER.debug("testUnionFind()");
        // union-find
        DetectGraphCycle graph = new DetectGraphCycle(5, 3);
        graph.markSets(false);

        // 0 is a friend of 2
        graph.union(0, 2);
        // 4 is a friend of 2
        graph.union(4, 2);
        // 3 is a friend of 1
        graph.union(3, 1);

        // Check if 4 is a friend of 0
        if (graph.find(4) == graph.find(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // Check if 1 is a friend of 0
        if (graph.find(1) == graph.find(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}

package com.devamatre.theorem.adts.graph;

import com.devamatre.theorem.adts.Maths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 11/6/23 10:50 AM
 */
public enum GraphUtilsTest {
    INSTANCE;

    private static Logger LOGGER = LoggerFactory.getLogger(GraphUtilsTest.class);

    /**
     * @return
     */
    public static void createGraph(Graph<Integer> graph, boolean withCycle) {
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
     * @return
     */
    public static void createTopologicalGraph(Graph<Integer> graph) {
        LOGGER.debug("+createTopologicalGraph()");
        graph.setDirected(true);
        // add edges
        graph.addEdge(0, null);
        graph.addEdge(1, null);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(5, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        LOGGER.debug("-createTopologicalGraph(), graph:{}", graph);
    }

    /**
     * @param graph
     */
    public static void createGraph(Graph<Integer> graph) {
        createGraph(graph, false);
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
        graph.addEdge(2, 4, Maths.FOURTY);

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

}

package com.rslakra.theorem.adts.graph.adjacencymatrix;

import com.rslakra.theorem.adts.NumberUtils;
import com.rslakra.theorem.adts.graph.Edge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * In computer science, a graph is an abstract data type that is meant to implement the undirected graph and directed
 * graph concepts from the field of graph theory within mathematics.
 *
 * <url>https://en.wikipedia.org/wiki/Graph_(abstract_data_type)</url>
 *
 * <b></b>Adjacency matrix</b>
 * <p>
 * A two-dimensional matrix, in which the rows represent source vertices and columns represent destination vertices.
 * Data on edges and vertices must be stored externally. Only the cost for one edge can be stored between each pair of
 * vertices.
 *
 * <pre>
 *  inputData:
 *  {
 *   {0, 4, 0, 8},
 *   {0, 0, 6, 2},
 *   {0, 6, 0, 1},
 *   {8, 2, 1, 0},
 *  }
 *
 *  Graph Representation:
 *  +-+-+-+-+
 *  |0|4|0|8|
 *  +-+-+-+-+
 *  |0|0|6|2|
 *  +-+-+-+-+
 *  |0|6|0|1|
 *  +-+-+-+-+
 *  |8|2|1|0|
 *  +-+-+-+-+
 * </pre>
 * <p>
 *
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class AdjacencyMatrixIntGraph extends AdjacencyMatrixGraph<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdjacencyMatrixIntGraph.class);

    /**
     * @param vertices
     * @param weighted
     * @param directed
     */
    public AdjacencyMatrixIntGraph(int vertices, boolean weighted, boolean directed) {
        super(vertices, weighted, directed);
    }

    /**
     * @param vertices
     * @param weighted
     */
    public AdjacencyMatrixIntGraph(int vertices, boolean weighted) {
        super(vertices, weighted);
    }

    /**
     * @param vertices
     */
    public AdjacencyMatrixIntGraph(int vertices) {
        super(vertices);
    }

    /**
     * Adds the edge between the <code>source</code> and <code>target</code> vertices of the edge with the
     * <code>weight</code> between them.
     *
     * @param source
     * @param target
     * @param weight
     */
    @Override
    public void addEdge(Integer source, Integer target, BigDecimal weight) {
        LOGGER.debug("addEdge({}, {}, {})", source, target, weight);
        checkIndices(source, target);
        weight = NumberUtils.nullSafeGet(weight);
        adjMatrix.get(source).add(Edge.of(source, target, weight));
        // adjMatrix[source][target] = weight;
        // increaseSize();
        // if not directed graph
        if (!isDirected()) {
            adjMatrix.get(target).add(Edge.of(target, source, weight));
            // adjMatrix[target][source] = weight;
            // increaseSize();
        }
    }

    /**
     * @param source
     * @param target
     * @return
     */
    private boolean hasWeight(Integer source, Integer target) {
        return adjMatrix.get(source).stream()
            .filter(edge -> edge.getTarget().compareTo(target) == 0 && Objects.nonNull(edge.getWeight()))
            .findFirst()
            .isPresent();
        // return BigDecimal.ZERO.compareTo(NumberUtils.toBigDecimal(getVertex(source, target))) == 0;
    }

    /**
     * Returns true if there is an edge between the <code>source</code> and <code>target</code> vertices otherwise
     * false.
     *
     * @param source
     * @param target
     * @return
     */
    @Override
    public boolean hasEdge(Integer source, Integer target) {
        checkIndices(source, target);
        if (isDirected()) {
            return hasWeight(source, target);
        } else {
            return hasWeight(source, target) || hasWeight(target, source);
        }
    }

}

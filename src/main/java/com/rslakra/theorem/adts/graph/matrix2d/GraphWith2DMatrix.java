package com.rslakra.theorem.adts.graph.matrix2d;

import com.rslakra.theorem.adts.graph.AbstractGraph;
import com.rslakra.theorem.adts.graph.Edge;
import com.rslakra.theorem.adts.graph.vertex.Vertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Graph with the adjacency matrix needs <code>O(1)</code> time and <code>O(N ^ 2)</code> space to handle the
 * operations.
 *
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class GraphWith2DMatrix<E extends Comparable<? super E>> extends AbstractGraph<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphWith2DMatrix.class);

    private List<Vertex> vertices;

    // A list of lists to represent an adjacency list
    private final Map<E, Set<E>> adjList;

    /**
     * @param weighted
     * @param directed
     */
    public GraphWith2DMatrix(boolean weighted, boolean directed) {
        super(weighted, directed);
        LOGGER.debug("GraphWith2DMatrix({}, {})", weighted, directed);
        this.vertices = new ArrayList<>();
        this.adjList = new HashMap<>();
    }

    /**
     *
     */
    public GraphWith2DMatrix() {
        this(false, false);
    }

    /**
     * Returns the <code>keySet</code> of the graph.
     *
     * @return
     */
    @Override
    public Set<E> getVertices() {
        return vertices.stream()
            .map(vertex -> (E) vertex.getLabel())
            .collect(Collectors.toSet());
    }

    /**
     * Returns true if the graph contains the <code>vertex</code> otherwise false.
     *
     * @param vertex
     * @return
     */
    @Override
    public boolean hasVertex(E vertex) {
        return vertices.stream()
            .filter(entry -> entry.getLabel().compareTo(vertex) == 0)
            .findFirst()
            .isPresent();
    }

    /**
     * Returns the edges/neighbors of the <code>vertex</code> of the <code>graph</code>.
     *
     * @param vertex
     * @return
     */
    @Override
    public Set<Edge<E>> getNeighbors(E vertex) {
        return null;
    }

    /**
     * Prints the graph.
     */
    @Override
    public void printGraph() {

    }

    /**
     * Returns the <code>firstNode</code> of the graph.
     *
     * @return
     */
    @Override
    public E firstVertex() {
        return null;
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
    public void addEdge(E source, E target, BigDecimal weight) {

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
    public boolean hasEdge(E source, E target) {
        return false;
    }

    /**
     * Returns an edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public Edge<E> findEdge(E source, E target) {
        return null;
    }

    /**
     * Removes the edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public void removeEdge(E source, E target) {

    }

    /**
     * Get all vertices connected to the specified vertex.
     *
     * @param vertex
     * @return
     */
    @Override
    public Set<E> getVerticesConnectedTo(E vertex) {
        return null;
    }

    /**
     * Returns the set of vertices that connects to the provided <code>vertex</code>.
     *
     * @param vertex
     * @return
     */
    @Override
    public Set<E> getInwardEdges(E vertex) {
        return null;
    }

    /**
     * Returns the set of vertices that the provided <code>vertex</code> connects to.
     *
     * @param vertex
     * @return
     */
    @Override
    public Set<E> getOutwardEdges(E vertex) {
        return null;
    }

    /**
     * Get an ordered list of vertices, sorted such that for any given vertex A with a directed edge to vertex B,
     * index(B) < index(A).
     *
     * @return
     */
    @Override
    public List<E> getSortedVertices() {
        return null;
    }

    /**
     * Get an ordered list of vertices, sorted such that for any given vertex A with a directed edge to vertex B,
     * index(B) < index(A).
     *
     * @param startVertex
     * @return
     */
    @Override
    public List<E> getSortedVertices(E startVertex) {
        return null;
    }
}

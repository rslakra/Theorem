package com.devamatre.theorem.adts.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public abstract class AbstractGraph<E extends Comparable<? super E>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGraph.class);

    public static final BigDecimal INFINITY = BigDecimal.valueOf(Double.MAX_VALUE);

    private boolean weighted;
    private boolean directed;
    private int size;

    /**
     * @param weighted
     * @param directed
     */
    public AbstractGraph(boolean weighted, boolean directed) {
        this.weighted = weighted;
        this.directed = directed;
    }

    /**
     *
     */
    public AbstractGraph() {
        this(false, false);
    }

    /**
     * Returns the <code>weighted</code> property value.
     *
     * @return
     */
    public boolean isWeighted() {
        return this.weighted;
    }

    /**
     * The <code>weighted</code> property to be set.
     *
     * @param weighted
     */
    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }

    /**
     * Returns the <code>directed</code> property value.
     *
     * @return
     */
    public boolean isDirected() {
        return this.directed;
    }

    /**
     * The <code>directed</code> property to be set.
     *
     * @param directed
     */
    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    /**
     * Returns the size of the graph.
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the <code>firstNode</code> of the graph.
     *
     * @return
     */
    public abstract E startNode();

    /**
     * Adds the edge between the <code>source</code> and <code>target</code> vertices of the edge with the
     * <code>weight</code> between them.
     *
     * @param source
     * @param target
     * @param weight
     */
    public abstract void addEdge(E source, E target, BigDecimal weight);

    /**
     * Adds the edge between the <code>source</code> and <code>target</code> vertices of the edge.
     *
     * @param source
     * @param target
     */
    public void addEdge(E source, E target) {
        addEdge(source, target, null);
    }

    /**
     * Returns true if there is an edge between the <code>source</code> and <code>target</code> vertices otherwise
     * false.
     *
     * @param source
     * @param target
     * @return
     */
    public abstract boolean hasEdge(E source, E target);

    /**
     * Returns an edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    public abstract Edge<E> findEdge(E source, E target);

    /**
     * Returns the edges/neighbors of the <code>vertex</code> of the <code>graph</code>.
     *
     * @param vertex
     * @return
     */
    public abstract Set<Edge<E>> getNeighbors(E vertex);

    /**
     * Removes the edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    public abstract void removeEdge(E source, E target);

    /**
     * Prints the graph.
     */
    public abstract void printGraph();

    /**
     * Returns true if the graph has cycle otherwise false.
     *
     * @return
     */
    public abstract boolean hasCycle();


    /**
     * Get all vertices connected to the specified vertex.
     *
     * @param vertex
     * @return
     */
    public abstract Set<E> getVerticesConnectedTo(E vertex);

    /**
     * Returns the set of vertices that connects to the provided <code>vertex</code>.
     *
     * @param vertex
     * @return
     */
    public abstract Set<E> getInwardEdges(E vertex);

    /**
     * Returns the set of vertices that the provided <code>vertex</code> connects to.
     *
     * @param vertex
     * @return
     */
    public abstract Set<E> getOutwardEdges(E vertex);

    /**
     * Get an ordered list of vertices, sorted such that for any given vertex A with a directed edge to vertex B,
     * index(B) < index(A).
     *
     * @return
     */
    public abstract List<E> getSortedVertices();

    /**
     * Get an ordered list of vertices, sorted such that for any given vertex A with a directed edge to vertex B,
     * index(B) < index(A).
     *
     * @param startVertex
     * @return
     */
    public abstract List<E> getSortedVertices(E startVertex);


    /**
     * @param source
     * @param target
     */
    public void searchEdge(E source, E target) {
        if (hasEdge(source, target)) {
            LOGGER.debug("Edge from:{} to:{} found.", source, target);
        } else {
            LOGGER.debug("Edge from:{} to:{} not found!", source, target);
        }
    }

    /**
     * @param vertex
     */
    public void bfs(E vertex) {
    }

    /**
     * @param queue
     * @param visited
     */
    public void bfsRecursively(Queue<Edge> queue, Set<Edge> visited) {
        // create a queue for doing BFS
//        Queue<E> queue = new ArrayDeque<>();
        if (queue.isEmpty()) {
            return;
        }
    }
}
package com.devamatre.theorem.adts.graph.adjacencymatrix;

import com.devamatre.theorem.adts.PrettyPrinter;
import com.devamatre.theorem.adts.array.ArrayUtils;
import com.devamatre.theorem.adts.array.TablePrettyPrinter;
import com.devamatre.theorem.adts.graph.AbstractGraph;
import com.devamatre.theorem.adts.graph.Edge;
import com.devamatre.theorem.adts.graph.vertex.Vertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
 * {
 *     { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
 *     { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
 *     { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
 *     { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
 *     { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
 *     { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
 *     { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
 *     { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
 *     { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
 * }
 * </pre>
 * <p>
 *
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class AdjacencyMatrixGraph<E extends Comparable<? super E>> extends AbstractGraph<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdjacencyMatrixGraph.class);

    /**
     * <pre>
     * {
     *     { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
     *     { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
     *     { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
     *     { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
     *     { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
     *     { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
     *     { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
     *     { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
     *     { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
     * }
     * </pre>
     */
    private int vertices;
    protected Object[][] adjMatrix;

    /**
     * @param weighted
     * @param directed
     */
    public AdjacencyMatrixGraph(int vertices, boolean weighted, boolean directed) {
        super(weighted, directed);
        LOGGER.debug("AdjacencyMatrixGraph({}, {}, {})", vertices, weighted, directed);
        this.vertices = vertices;
        this.adjMatrix = new Object[vertices][vertices];
    }

    /**
     * @param vertices
     * @param weighted
     */
    public AdjacencyMatrixGraph(int vertices, boolean weighted) {
        this(vertices, weighted, false);
    }

    /**
     * @param vertices
     */
    public AdjacencyMatrixGraph(int vertices) {
        this(vertices, false, false);
    }

    /**
     * Returns the <code>firstNode</code> of the graph.
     *
     * @return
     */
    @Override
    public E startNode() {
        return null;
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
     * Removes the edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public void removeEdge(E source, E target) {

    }

    /**
     * Prints the graph.
     */
    @Override
    public void printGraph() {

    }

    /**
     * Returns true if the graph has cycle otherwise false.
     *
     * @return
     */
    @Override
    public boolean hasCycle() {
        return false;
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

    /**
     * Adds the edge between the <code>source</code> and <code>target</code> vertices of the edge with the
     * <code>weight</code> between them.
     *
     * @param source
     * @param target
     * @param weight
     */
    public void addEdge(E source, E target, BigDecimal weight) {

    }

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
     * Checks if the <code>source</code> or <code>target</code> indices are valid or not. If not throws an error.
     *
     * @param source
     * @param target
     */
    protected void checkIndices(Integer source, Integer target) {
        if (source < 0 || source >= vertices || target < 0 || target >= vertices) {
            throw new ArrayIndexOutOfBoundsException("Invalid source:" + source + ", or target:" + target + " index!");
        }
    }

    /**
     * Adds the vertex for the provided <code>data</code>.
     *
     * @param data
     * @return
     */
    public Vertex addVertex(E data) {
        return null;
    }

    /**
     * Removes the provided <code>vertex</code>.
     *
     * @param vertex
     * @return
     */
    public void removeVertex(Vertex vertex) {
    }

    /**
     * Adds an edge between the <code>source</code> vertex and the <code>target</code> vertex.
     *
     * @param source
     * @param target
     */
    public void addEdge(Vertex source, Vertex target, BigDecimal weight) {
        if (!isWeighted()) {
            weight = null;
        }

        source.addEdge(target, weight);
        if (!isDirected()) {
            target.addEdge(source, weight);
        }
    }

    /**
     * Removes an edge between the <code>source</code> vertex and the <code>target</code> vertex.
     *
     * @param source
     * @param target
     */
    public void removeEdge(Vertex source, Vertex target) {
        source.removeEdge(target);
        if (!isDirected()) {
            target.removeEdge(source);
        }
    }

    /**
     * @param vertex
     */
    public void bfs(E vertex) {
        Set<E> visited = new HashSet<>();
        // create a queue for doing BFS
        Queue<E> queue = new ArrayDeque<>();
        // mark the source vertex as discovered
        visited.add(vertex);

        // enqueue source vertex
        queue.add(vertex);

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node and print it
            vertex = queue.poll();
            LOGGER.debug(vertex + " ");

//            // do for every edge (v, u)
//            adjList.get(vertex).forEach(edge -> {
//                if (!visited.contains(edge)) {
//                    // mark it as discovered and enqueue it
//                    visited.add(edge);
//                    queue.add(edge);
//                }
//            });
        }
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        PrettyPrinter<Integer> prettyPrinter = TablePrettyPrinter.buildPrettyPrinter();
        prettyPrinter.prettyPrint(ArrayUtils.asList(adjMatrix));
        return prettyPrinter.toString();
    }

}

package com.rslakra.theorem.adts.graph;

import com.rslakra.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * In computer science, a graph is an abstract data type that is meant to implement the undirected graph and directed
 * graph concepts from the field of graph theory within mathematics.
 * <p>
 * A graph data structure consists of a finite (and possibly mutable) set of vertices (also called nodes or points),
 * together with a set of unordered pairs of these vertices for an undirected graph or a set of ordered pairs for a
 * directed graph. These pairs are known as edges (also called links or lines), and for a directed graph are also known
 * as edges but also sometimes arrows or arcs. The vertices may be part of the graph structure, or may be external
 * entities represented by integer indices or references.
 * <p>
 * A graph data structure may also associate to each edge some edge value, such as a symbolic label or a numeric
 * attribute (cost, capacity, length, etc.).
 * <p>
 *
 * <b>Operations</b>
 * <p>
 * The basic operations provided by a graph data structure G usually include:
 * <pre>
 * adjacent(G, x, y): tests whether there is an edge from the vertex x to the vertex y;
 * neighbors(G, x): lists all vertices y such that there is an edge from the vertex x to the vertex y;
 * add_vertex(G, x): adds the vertex x, if it is not there;
 * remove_vertex(G, x): removes the vertex x, if it is there;
 * add_edge(G, x, y, z): adds the edge z from the vertex x to the vertex y, if it is not there;
 * remove_edge(G, x, y): removes the edge from the vertex x to the vertex y, if it is there;
 * get_vertex_value(G, x): returns the value associated with the vertex x;
 * set_vertex_value(G, x, v): sets the value associated with the vertex x to v.
 *
 * Structures that associate values to the edges usually also provide:
 * get_edge_value(G, x, y): returns the value associated with the edge (x, y);
 * set_edge_value(G, x, y, v): sets the value associated with the edge (x, y) to v.
 * </pre>
 *
 * <url>https://en.wikipedia.org/wiki/Graph_(abstract_data_type)</url>
 *
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
     * Increases the size of the vertices;
     */
    protected void increaseSize() {
        size++;
    }

    /**
     * Decreases the size of the vertices;
     */
    protected void decreaseSize() {
        size--;
        if (size < 0) {
            size = 0;
        }
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
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Returns the <code>keySet</code> of the graph.
     *
     * @return
     */
    public abstract Set<E> getVertices();

    /**
     * Returns true if the graph contains the <code>vertex</code> otherwise false.
     *
     * @param vertex
     * @return
     */
    public abstract boolean hasVertex(E vertex);

    /**
     * Returns the edges/neighbors of the <code>vertex</code> of the <code>graph</code>.
     *
     * @param vertex
     * @return
     */
    public abstract Set<Edge<E>> getNeighbors(E vertex);

    /**
     * Returns the <code>firstNode</code> of the graph.
     *
     * @return
     */
    public abstract E firstVertex();

    /**
     * Prints the graph.
     */
    public abstract void printGraph();

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
     * Removes the edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    public abstract void removeEdge(E source, E target);

    /**
     * Returns true if the directed graph has cycle otherwise false.
     *
     * @param root
     * @param visited
     * @param path
     * @return
     */
    private boolean hasCycleInDirectedGraph(E root, Set<E> visited, Set<E> path) {
        // Case 1: Target Already in Recursion Stack or traversal path
        // root is visited and is in the traversal path of the root node, it means there is cycle
        if (visited.contains(root) && path.contains(root)) {
            return true;
        }

        // mark the root node visited
        visited.add(root);
        // add the root node in traversal path
        path.add(root);
        // visit neighbors of root vertex
        Set<Edge<E>> neighbors = getNeighbors(root);
        for (Edge<E> edge : neighbors) {
            // if neighbor is already visited
            if (visited.contains(edge.getTarget())) {
                // Case 1: Target Already in Recursion Stack or traversal path
                // neighbor is visited and is parent of the root node, it means there is cycle
                if (path.contains(edge.getTarget())) {
                    return true;
                }

                // Case 2: Target Already Visited and Parent == Target (Nothing to do for this case)
            } else {
                // Case 3: Target Not Already Visited
                if (hasCycleInDirectedGraph(edge.getTarget(), visited, path)) {
                    return true;
                }
            }
        }

        // remove the root node from traversal path while back-tracking
        path.remove(root);

        return false;
    }

    /**
     * Returns true if the directed graph has cycle otherwise false.
     *
     * @return
     */
    public boolean hasCycleInDirectedGraph() {
        // track visited vertices
        Set<E> visited = new HashSet<>();
        Set<E> path = new HashSet<>();
        // traverse all neighbors of the current node
        for (E root : getVertices()) {
            // if the child node is not visited
            if (!visited.contains(root)) {
                if (hasCycleInDirectedGraph(root, visited, path)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if the undirected graph has cycle otherwise false.
     * <p>
     * Back-Edge/Cycle detection criteria
     *
     * @param vertex
     * @param visited
     * @param parent
     * @return
     */
    private boolean hasCycleInUndirectedGraph(E vertex, Set<E> visited, E parent) {
        // mark the vertex visited
        visited.add(vertex);
        // visit neighbors of current vertex
        Set<Edge<E>> neighbors = getNeighbors(vertex);
        for (Edge<E> edge : neighbors) {
            // if neighbor is already visited
            if (visited.contains(edge.getTarget())) {
                // Case 1: Target Already Visited and Parent != Target (back-edge)
                // neighbor is visited and is not parent of the vertex node, it means there is cycle
                if (edge.getTarget().compareTo(parent) != 0) {
                    return true;
                }

                // Case 2: Target Already Visited and Parent == Target (Nothing to do for this case)
            } else {
                // Case 3: Target Not Already Visited
                if (hasCycleInUndirectedGraph(edge.getTarget(), visited, edge.getSource())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if the undirected graph has cycle otherwise false.
     *
     * @return
     */
    public boolean hasCycleInUndirectedGraph() {
        Set<E> visited = new HashSet<>();
        // traverse all vertices of the graph
        for (E root : getVertices()) {
            // if the child node is not visited
            if (!visited.contains(root)) {
                if (hasCycleInUndirectedGraph(root, visited, null)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if the graph has cycle otherwise false.
     *
     * @return
     */
    public boolean hasCycle() {
        return isDirected() ? hasCycleInDirectedGraph() : hasCycleInUndirectedGraph();
    }

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
        // Queue<E> queue = new ArrayDeque<>();
        if (queue.isEmpty()) {
            return;
        }
    }

    /**
     * Only Used for DAG (Directed Acyclic Graph)
     * <p>
     * Linear order of vertices such that every directed edge u -> v, the vertex u comes before vertex v, in the order.
     * <p>
     * When to use:
     * <p>
     * - for dependency resolution in builds.
     *
     * @return
     */
    protected void topSort(E vertex, Set<E> visited, Stack<E> stack) {
        LOGGER.trace("+topSort({}, {}, {})", vertex, visited, stack);
        // mark the current vertex visited
        visited.add(vertex);
        // mark the current vertex visited
        if (hasVertex(vertex)) {
            // visit all neighbors of the vertex
            for (Edge<E> edge : getNeighbors(vertex)) {
                if (!visited.contains(edge.getTarget())) {
                    topSort(edge.getTarget(), visited, stack);
                }
            }

            // after visiting all neighbors, push vertex to stack
            stack.push(vertex);
        }
        LOGGER.trace("-topSort()");
    }

    /**
     * Only Used for DAG (Directed Acyclic Graph)
     * <p>
     * Linear order of vertices such that every directed edge u -> v, the vertex u comes before vertex v, in the order.
     * <p>
     * When to use: for dependencies.
     *
     * @return
     */
    protected List<E> topSort() {
        LOGGER.debug("+topSort()");
        List<E> topSort = new ArrayList<>();
        final Set<E> visited = new HashSet<>();
        final Stack<E> stack = new Stack<>();
        // traverse each vertex of the graph
        for (E vertex : getVertices()) {
            if (!visited.contains(vertex)) {
                topSort(vertex, visited, stack);
            }
        }
        // convert stack to list
        AlgoUtils.stackAsList(stack, topSort);

        LOGGER.debug("-topSort(), topSort:{}", topSort);
        return topSort;
    }

}

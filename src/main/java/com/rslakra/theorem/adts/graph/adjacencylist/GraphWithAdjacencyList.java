package com.rslakra.theorem.adts.graph.adjacencylist;

import com.rslakra.theorem.adts.graph.AbstractGraph;
import com.rslakra.theorem.adts.graph.Edge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * In computer science, a graph is an abstract data type that is meant to implement the undirected graph and directed
 * graph concepts from the field of graph theory within mathematics.
 *
 * <url>https://en.wikipedia.org/wiki/Graph_(abstract_data_type)</url> *
 * <p>
 * Graph with the adjacency list needs <code>n</code> time and space to handle the operations.
 *
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class GraphWithAdjacencyList<E extends Comparable<? super E>> extends AbstractGraph<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphWithAdjacencyList.class);

    /**
     * A list of lists to represent an adjacency list
     * <p>
     * There are multiple ways to implement the adjacency-list like:
     * <pre>
     *   - Using <code>List<Edge>[]</code>, or
     *   - Using <code>List<List<Edge>></code>, or
     *   - <code>Map<E, Set<Edge<E>>></code>
     *  </pre>
     * <p>
     * I'm using the <code>Map<E, Set<Edge<E>>></code> approach which is auto-resizable.
     */
    private final Map<E, Set<Edge<E>>> adjList;

    /**
     * @param weighted
     * @param directed
     */
    public GraphWithAdjacencyList(boolean weighted, boolean directed) {
        super(weighted, directed);
        LOGGER.debug("GraphWithAdjacencyList({}, {})", weighted, directed);
        adjList = new HashMap<>();
    }

    /**
     *
     */
    public GraphWithAdjacencyList() {
        this(false, false);
    }

    /**
     * Returns the <code>adjList</code> of the graph.
     *
     * @return
     */
    protected Map<E, Set<Edge<E>>> getAdjList() {
        return adjList;
    }

    /**
     * Overridden Methods.
     */

    /**
     * Returns the size of the graph.
     *
     * @return
     */
    @Override
    public int getSize() {
        return adjList.size();
    }

    /**
     * The string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        Set<Edge<E>> edges = new LinkedHashSet<>();
        adjList.keySet().forEach(vertex -> {
            Iterator<Edge<E>> itr = getNeighbors(vertex).iterator();
            while (itr.hasNext()) {
                edges.add(itr.next());
            }
        });

        return edges.toString();
    }

    /**
     * Returns the <code>keySet</code> of the graph.
     *
     * @return
     */
    public Set<E> getVertices() {
        return adjList.keySet();
    }

    /**
     * Returns true if the graph contains the <code>vertex</code> otherwise false.
     *
     * @param vertex
     * @return
     */
    @Override
    public boolean hasVertex(E vertex) {
        return adjList.containsKey(vertex);
    }

    /**
     * Returns the edges/neighbors of the <code>vertex</code> of the <code>graph</code>.
     *
     * @param vertex
     * @return
     */
    @Override
    public Set<Edge<E>> getNeighbors(E vertex) {
        // to avoid NullPointer in the code, returning empty set.
        return adjList.getOrDefault(vertex, Collections.emptySet());
    }

    /**
     * Returns the <code>startNode</code> of the graph.
     *
     * @return
     */
    @Override
    public E firstVertex() {
        return getVertices().iterator().next();
    }

    /**
     * Adds the edge between the <code>source</code> and <code>target</code> vertices of the edge.
     *
     * @param edge
     */
    protected void addEdge(final Edge<E> edge) {
        if (!isWeighted()) {
            edge.setWeight(BigDecimal.ZERO);
        }

        if (Objects.isNull(edge.getSource())) {
            return;
        }

        // Add the source and target vertices
        adjList.putIfAbsent(edge.getSource(), new HashSet<>());
        if (Objects.nonNull(edge.getTarget())) {
            adjList.putIfAbsent(edge.getTarget(), new HashSet<>());
        }
        // Add an edge from source to target into the set
        adjList.get(edge.getSource()).add(edge);

        // If it's undirected graph, add an edge from target to source into the set
        if (!isDirected()) {
            if (Objects.nonNull(edge.getTarget())) {
                adjList.get(edge.getTarget()).add(edge.reverseEdge());
            }
        }
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
        addEdge(Edge.of(source, target, weight, isDirected()));
    }

    /**
     * @param source
     * @param target
     */
    @Override
    public void addEdge(E source, E target) {
        addEdge(Edge.of(source, target, isDirected()));
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
        return getNeighbors(source).stream()
            .filter(edge -> edge.getTarget().equals(target))
            .findFirst()
            .isPresent();
    }

    /**
     * Returns an edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public Edge<E> findEdge(E source, E target) {
        return getNeighbors(source).stream()
            .filter(edge -> edge.getTarget().equals(target))
            .findFirst()
            .orElse(null);
    }

    /**
     * Removes the edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public void removeEdge(E source, E target) {
        // remove an edge from source to target
        if (hasVertex(source)) {
            getNeighbors(source).removeIf(edge -> edge.getTarget().compareTo(target) == 0);
        }

        // If it's undirected graph, add an edge from target to source into the set
        if (!isDirected()) {
            if (hasVertex(target)) {
                getNeighbors(target).removeIf(edge -> edge.getSource().compareTo(source) == 0);
            }
        }
    }

    /**
     * Prints the graph.
     */
    @Override
    public void printGraph() {
        adjList.keySet().forEach(vertex -> {
            // LOGGER.debug(vertex.toString());
            Iterator<Edge<E>> itr = getNeighbors(vertex).iterator();
            while (itr.hasNext()) {
                LOGGER.debug(itr.next().toString());
            }
        });
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
     * DFS helper
     *
     * @param current
     * @param visited
     * @param hashSet
     */
    public void dfs(E current, Set<E> visited, Set<E> hashSet) {
        LOGGER.debug(current.toString());
        visited.add(current);
        // push current to hashSet as it's visited.
        hashSet.add(current);
        if (adjList.containsKey(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = adjList.get(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    dfs(edge.getTarget(), visited, hashSet);
                }
            }
        }
    }

    /**
     * DFS
     */
    public void dfs() {
        final Set<E> visited = new HashSet<>();
        final Set<E> hashSet = new HashSet<>();
        // traverse each vertex of the graph
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                dfs(current, visited, hashSet);
            }
        }

        LOGGER.debug("{}", hashSet);
    }

    /**
     * @param vertex
     */
    public void bfs(E vertex) {
        final Set<E> visited = new HashSet<>();
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
            LOGGER.debug("{}", vertex);

            // do for every edge (u, v)
            adjList.get(vertex).forEach(edge -> {
                if (!visited.contains(edge.getTarget())) {
                    // mark it as discovered and enqueue it
                    visited.add(edge.getTarget());
                    queue.add(edge.getTarget());
                }
            });
        }
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

        // dequeue front node and print it
        Edge vertex = queue.poll();
        LOGGER.debug(vertex.toString());

        // do for every edge (v, u)
        adjList.get(vertex).forEach(edge -> {
            if (!visited.contains(edge)) {
                // mark it as discovered and enqueue it
                visited.add(edge);
                queue.add(edge);
            }
        });

        bfsRecursively(queue, visited);
    }

}

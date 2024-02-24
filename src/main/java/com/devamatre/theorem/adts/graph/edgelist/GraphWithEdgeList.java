package com.devamatre.theorem.adts.graph.edgelist;

import com.devamatre.theorem.adts.graph.AbstractGraph;
import com.devamatre.theorem.adts.graph.Edge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Graph with the list of edge needs <code>n ^ 2</code> time and space to handle the operations.
 *
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class GraphWithEdgeList<E extends Comparable<? super E>> extends AbstractGraph<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphWithEdgeList.class);

    // A list of lists to represent an adjacency list
    private final Set<Edge<E>> edges;

    /**
     * @param weighted
     * @param directed
     */
    public GraphWithEdgeList(boolean weighted, boolean directed) {
        super(weighted, directed);
        LOGGER.debug("GraphWithEdgeList({}, {})", weighted, directed);
        this.edges = new LinkedHashSet<>();
    }

    /**
     *
     */
    public GraphWithEdgeList() {
        this(false, false);
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
        return (isDirected() ? edges.size() / 2 : edges.size());
    }

    /**
     * Returns the <code>keySet</code> of the graph.
     *
     * @return
     */
    @Override
    public Set<E> getVertices() {
        return edges.stream()
            .map(edge -> edge.getSource())
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
        return edges.stream()
            .filter(edge -> edge.getSource().compareTo(vertex) == 0)
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
        return edges.stream()
            .filter(edge -> edge.getSource() == vertex)
            .collect(Collectors.toSet());
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
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        final Set<Edge<E>> edges = new LinkedHashSet<>();
        getVertices().forEach(vertex -> {
            Iterator<Edge<E>> itr = getNeighbors(vertex).iterator();
            while (itr.hasNext()) {
                edges.add(itr.next());
            }
        });

        return edges.toString();
    }

    /**
     * Finds the <code>Edge<E></code> for the provided <code>vertex</code>. If the <code>isTargetVertex</code> is set to
     * be true, then the target vertex is search otherwise source.
     *
     * @param vertex
     * @param isTargetVertex
     * @return
     */
    private Edge<E> findEdge(E vertex, boolean isTargetVertex) {
        if (isTargetVertex) {
            return edges.stream().filter(edge -> edge.getTarget().compareTo(vertex) == 0).findFirst().orElse(null);
        } else {
            return edges.stream().filter(edge -> edge.getSource().compareTo(vertex) == 0).findFirst().orElse(null);
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
        // if not weighted graph, set weight to null
        if (!isWeighted()) {
            weight = null;
        }

        Edge<E> edge = findEdge(source, false);
        if (Objects.isNull(edge)) {
            edges.add(Edge.of(source, target, weight));
        } else if (Objects.isNull(edge.getTarget())) {
            edge = Edge.of(source, target, weight);
            edges.add(edge);
        }

        // add not a directed graph, add source vertex in the target as well.
        if (isDirected()) {
            if (Objects.nonNull(target)) {
                edges.add(Edge.of(target, null));
            }
        } else {
            edges.add(Edge.of(target, source, weight));
        }
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
        final Set<Edge<E>> neighbors = getNeighbors(source);
        return neighbors.stream()
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
        Edge<E> srcEdge = findEdge(source, target);
        edges.remove(srcEdge);
        // remove the source vertex from the target vertex
        if (!isDirected()) {
            Edge<E> targetEdge = findEdge(target, source);
            edges.remove(targetEdge);
        }
    }

    /**
     * Prints the graph.
     */
    @Override
    public void printGraph() {
        LOGGER.debug(toString());
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
        return getNeighbors(vertex).stream().map(edge -> edge.getTarget()).collect(Collectors.toSet());
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

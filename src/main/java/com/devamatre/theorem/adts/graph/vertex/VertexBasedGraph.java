package com.devamatre.theorem.adts.graph.vertex;

import com.devamatre.appsuite.core.ToString;
import com.devamatre.theorem.adts.graph.AbstractGraph;
import com.devamatre.theorem.adts.graph.Edge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class VertexBasedGraph<E extends Comparable<? super E>> extends AbstractGraph<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VertexBasedGraph.class);

    // list of vertices
    private Set<Vertex> vertices;

    /**
     * @param weighted
     * @param directed
     */
    public VertexBasedGraph(boolean weighted, boolean directed) {
        super(weighted, directed);
        LOGGER.debug("VertexBasedGraph({}, {})", weighted, directed);
        this.vertices = new LinkedHashSet<>();
    }

    /**
     *
     */
    public VertexBasedGraph() {
        this(false, false);
    }

    /**
     * @return
     */
    public Set<Vertex> getAllVertices() {
        return vertices;
    }

    /**
     * Returns the <code>keySet</code> of the graph.
     *
     * @return
     */
    @Override
    public Set<E> getVertices() {
        return vertices.stream()
            .map(vertex -> (E) vertex.getData())
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
            .filter(entry -> entry.getData().compareTo(vertex) == 0)
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
        Vertex<E> graphVertex = findVertex(vertex);
        Set<Edge<E>> edges = new HashSet<>();
        for (com.devamatre.theorem.adts.graph.vertex.Edge edge : graphVertex.getEdges()) {
            edges.add(Edge.of(edge.getSource().getData(), edge.getTarget().getData(), edge.getWeight(), isDirected()));
        }

        return edges;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(VertexBasedGraph.class, true)
            .add("vertices", getAllVertices())
            .toString();
    }

    /**
     * Returns the <code>firstNode</code> of the graph.
     *
     * @return
     */
    @Override
    public E firstVertex() {
        // pick the first vertex and return its data.
        return (E) vertices.iterator().next().getData();
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

        // find source vertex if exists
        Vertex sourceVertex = findVertex(source);
        if (Objects.isNull(sourceVertex)) {
            sourceVertex = new Vertex<>(source);
        }

        // find target vertex if exists
        Vertex targetVertex = findVertex(target);
        if (Objects.isNull(targetVertex)) {
            targetVertex = new Vertex<>(target);
        }

        // add an edge between source and target vertex
        sourceVertex.addEdge(targetVertex, weight);
        vertices.add(sourceVertex);
        vertices.add(targetVertex);

        // add not a directed graph, add source vertex in the target as well.
        if (!isDirected()) {
            // add an edge between target and source vertex
            targetVertex.addEdge(sourceVertex, weight);
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
     * Returns the <code>Vertex<E></code> for the provided <code>source</code>.
     *
     * @param source
     * @return
     */
    protected Vertex<E> findVertex(E source) {
        for (Vertex<E> vertex : vertices) {
            if (vertex.getData().compareTo(source) == 0) {
                return vertex;
            }
        }

        return null;
    }

    /**
     * Returns an edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public Edge<E> findEdge(E source, E target) {
        final Set<Edge<E>> neighbors = getNeighbors(source);
        return neighbors.stream()
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
        Vertex<E> sourceVertex = findVertex(source);
        Vertex<E> targetVertex = findVertex(target);
        // remove the target vertex from the source vertex
        if (Objects.nonNull(sourceVertex)) {
            sourceVertex.removeEdge(targetVertex);
        }

        // remove the source vertex from the target vertex
        if (!isDirected() && Objects.nonNull(targetVertex)) {
            targetVertex.removeEdge(sourceVertex);
        }
    }

    /**
     * Prints the graph.
     */
    @Override
    public void printGraph() {
        getVertices().forEach(vertex -> vertex.toString());
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
        return getNeighbors(vertex).stream()
            .map(edge -> edge.getSource())
            .collect(Collectors.toSet());
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

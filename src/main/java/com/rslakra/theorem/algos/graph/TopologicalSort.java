package com.rslakra.theorem.algos.graph;

import com.rslakra.theorem.adts.graph.vertex.Vertex;
import com.rslakra.theorem.adts.graph.vertex.VertexBasedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 13, 2019 8:12:20 PM
 */
public class TopologicalSort<E extends Comparable<? super E>> {

    private static Logger LOGGER = LoggerFactory.getLogger(TopologicalSort.class);

    public TopologicalSort() {
    }

    /**
     * @param vertex
     * @param stack
     * @param visited
     */
    private void topSort(Vertex<E> vertex, Deque<Vertex<E>> stack, Set<Vertex<E>> visited) {
        visited.add(vertex);

        // find all children of the current node.
        for (Vertex<E> neighbor : vertex.getNeighbors()) {
            // if not visited, explore it.
            if (!visited.contains(neighbor)) {
                topSort(neighbor, stack, visited);
            }
        }

        stack.offerFirst(vertex);
    }

    /**
     * @param graph
     * @return
     */
    public Deque<Vertex<E>> topSort(VertexBasedGraph<E> graph) {
        final Deque<Vertex<E>> stack = new ArrayDeque<>();
        final Set<Vertex<E>> visited = new HashSet<>();

        // visit all vertices of the graph
        for (Vertex<E> vertex : graph.getAllVertices()) {
            // if not visited, visit the vertex
            if (!visited.contains(vertex)) {
                topSort(vertex, stack, visited);
            }
        }

        return stack;
    }

}

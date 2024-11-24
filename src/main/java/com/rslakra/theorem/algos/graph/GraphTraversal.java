package com.rslakra.theorem.algos.graph;

import com.rslakra.theorem.adts.graph.Graph;
import com.rslakra.theorem.adts.graph.vertex.Vertex;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Nov 21, 2020 16:32:27
 */
public class GraphTraversal<E extends Comparable<? super E>> {

    private E data;
    private Map<Vertex<E>, Boolean> visited;
    private Map<Vertex<E>, Vertex<E>> edgeTo;
    private Map<Vertex<E>, Vertex<E>> pathTo;

    public GraphTraversal() {
    }

    /**
     * Returns true if the <code>vertex</code> is visited otherwise false.
     *
     * @param vertex
     * @return
     */
    public boolean isVisited(Vertex<E> vertex) {
        return visited.getOrDefault(vertex, false);
    }

    /**
     * Returns true if the current vertex has path to the <code>targetVertex</code> otherwise false.
     *
     * @param targetVertex
     * @return
     */
    public boolean hasPathTo(Vertex<E> targetVertex) {
        return false;
    }

    /**
     * @param graph
     * @param source
     */
    public void bfs(Graph graph, Vertex<E> source) {
        Queue<Vertex<E>> queue = new LinkedList<>();
        queue.offer(source);
        visited.putIfAbsent(source, Boolean.TRUE);
        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();
            for (Vertex<E> neighbor : vertex.getNeighbors()) {
                if (!isVisited(neighbor)) {
                    visited.putIfAbsent(neighbor, Boolean.TRUE);
                    pathTo.putIfAbsent(neighbor, vertex);
                }
            }
        }
    }

}

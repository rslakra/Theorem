package com.devamatre.theorem.algos.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Nov 21, 2020 16:32:27
 */
public class GraphBFS<T> {

    private T data;
    private Map<Vertex<T>, Boolean> marked;
    private Map<Vertex<T>, Vertex<T>> edgeTo;
    private Map<Vertex<T>, Vertex<T>> pathTo;

    public GraphBFS() {
    }

    /**
     * Returns true if the key is marked otherwise false.
     *
     * @param key
     * @return
     */
    public boolean isMarked(Vertex<T> key) {
        return marked.getOrDefault(key, false);
    }

    public boolean hasPathTo(Vertex<T> vertex) {
        return false;
    }

    /**
     * @param graph
     * @param source
     */
    public void bfs(Graph graph, Vertex<T> source) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.offer(source);
        marked.putIfAbsent(source, Boolean.TRUE);
        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.poll();
            /*
            for (Vertex<T> nextVertex : vertex.getAdjacentVertices()) {
                if (!isMarked(nextVertex)) {
                    marked.putIfAbsent(nextVertex, Boolean.TRUE);
                    pathTo.putIfAbsent(nextVertex, vertex);
                }
            }
             */
        }
    }


}

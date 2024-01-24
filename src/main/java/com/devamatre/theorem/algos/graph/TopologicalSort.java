package com.devamatre.theorem.algos.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 13, 2019 8:12:20 PM
 */
public class TopologicalSort<T> {

    public TopologicalSort() {
    }

    /**
     * @param graph
     * @return
     */
    public Deque<Vertex<T>> topSort(Graph<T> graph) {
        final Deque<Vertex<T>> stack = new ArrayDeque<>();
        final Set<Vertex<T>> visited = new HashSet<>();

        /*
        // visit all vertices of the graph
        for (Vertex<T> vertix : graph.getVertices()) {
            // if not visited, visit the vertix
            if (!visited.contains(vertix)) {
                topSort(vertix, stack, visited);
            }
        }
         */

        return stack;
    }

    /**
     * @param vertex
     * @param stack
     * @param visited
     */
    private final void topSort(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
        visited.add(vertex);

        /*
        // find all children of the current node.
        for (Vertex<T> child : vertex.getAdjacentVertices()) {
            // if not visited, explore it.
            if (!visited.contains(child)) {
                topSort(child, stack, visited);
            }
        }
         */

        stack.offerFirst(vertex);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(true);
        /*
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);

        graph.addEdge(3, 5);
        graph.addEdge(3, 4);

        graph.addEdge(4, 6);
         */

        TopologicalSort<Integer> tSort = new TopologicalSort<>();
        Deque<Vertex<Integer>> graphSorted = tSort.topSort(graph);
        while (!graphSorted.isEmpty()) {
            System.out.println(graphSorted.poll());
        }
    }

}

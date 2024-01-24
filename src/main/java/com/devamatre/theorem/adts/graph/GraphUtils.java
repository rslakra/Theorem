package com.devamatre.theorem.adts.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 11/6/23 10:50 AM
 */
public enum GraphUtils {
    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphUtils.class);

    /**
     * Run DFS on the <code>graph</code>.
     *
     * @param graph
     * @param current
     * @param visited
     * @param stack
     */
    public static <E extends Comparable<? super E>> void dfs(Graph<E> graph, E current, Set<E> visited, Set<E> stack) {
        LOGGER.debug("+dfs({}, {}, {}, {})", graph, current, visited, stack);
        LOGGER.debug(current.toString());
        visited.add(current);
        // push current to stack as it's visited.
        stack.add(current);
        if (graph.getAdjList().containsKey(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = graph.getNeighbors(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    dfs(graph, edge.getTarget(), visited, stack);
                }
            }
        }
        LOGGER.debug("-dfs(), visited:{}, stack:{}", visited, stack);
    }

    /**
     * Run DFS on the <code>graph</code>.
     */
    public static <E extends Comparable<? super E>> Set<E> dfs(Graph<E> graph) {
        LOGGER.debug("+dfs({})", graph);
        final Set<E> visited = new HashSet<>();
        final Set<E> stack = new HashSet<>();
        // traverse each vertex of the graph
        Iterator<E> itr = graph.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                dfs(graph, current, visited, stack);
            }
        }

        LOGGER.debug("-dfs(), stack:{}", stack);
        return stack;
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
    public static <E extends Comparable<? super E>> void topSort(Graph<E> graph, E current, Set<E> visited,
                                                                 Stack<E> stack) {
        visited.add(current);
        if (graph.getAdjList().containsKey(current)) {
            // visit all neighbors of the current vertex
            Iterator<Edge<E>> itr = graph.getAdjList().get(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    topSort(graph, edge.getTarget(), visited, stack);
                }
            }

            // after visiting neighbors, push current to stack
            stack.push(current);
        }
    }

    /**
     * Only Used for DAG (Directed Acyclic Graph)
     * <p>
     * Linear order of vertices such that every directed edge u -> v, the vertex u comes before vertex v, in the order.
     * <p>
     * When to use: for dependencies.
     *
     * @param graph
     * @return
     */
    public static <E extends Comparable<? super E>> List<E> topSort(Graph<E> graph) {
        List<E> topSort = new ArrayList<>();
        final Set<E> visited = new HashSet<>();
        final Stack<E> stack = new Stack<>();
        // traverse each vertex of the graph
        Iterator<E> itr = graph.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                topSort(graph, current, visited, stack);
            }
        }

        // convert stack to list.
        while (!stack.isEmpty()) {
            topSort.add(stack.pop());
        }

        LOGGER.debug("topSort:{}", topSort);
        return topSort;
    }

}

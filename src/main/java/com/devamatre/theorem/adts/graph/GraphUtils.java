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
    public static <T extends Comparable> void dfs(Graph<T> graph, T current, Set<T> visited, Set<T> stack) {
        LOGGER.debug("+dfs({}, {}, {}, {})", graph, current, visited, stack);
        LOGGER.debug(current.toString());
        visited.add(current);
        // push current to stack as it's visited.
        stack.add(current);
        if (graph.getAdjList().containsKey(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<T>> itr = graph.getNeighbors(current).iterator();
            while (itr.hasNext()) {
                Edge<T> edge = itr.next();
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
    public static <T extends Comparable> Set<T> dfs(Graph<T> graph) {
        LOGGER.debug("+dfs({})", graph);
        final Set<T> visited = new HashSet<>();
        final Set<T> stack = new HashSet<>();
        // traverse each vertex of the graph
        Iterator<T> itr = graph.keySet().iterator();
        while (itr.hasNext()) {
            T current = itr.next();
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
    public static <T extends Comparable> void topSort(Graph<T> graph, T current, Set<T> visited, Stack<T> stack) {
        visited.add(current);
        if (graph.getAdjList().containsKey(current)) {
            // visit all neighbors of the current vertex
            Iterator<Edge<T>> itr = graph.getAdjList().get(current).iterator();
            while (itr.hasNext()) {
                Edge<T> edge = itr.next();
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
    public static <T extends Comparable> List<T> topSort(Graph<T> graph) {
        List<T> topSort = new ArrayList<>();
        final Set<T> visited = new HashSet<>();
        final Stack<T> stack = new Stack<>();
        // traverse each vertex of the graph
        Iterator<T> itr = graph.keySet().iterator();
        while (itr.hasNext()) {
            T current = itr.next();
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

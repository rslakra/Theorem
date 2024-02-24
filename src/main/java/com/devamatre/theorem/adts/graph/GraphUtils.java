package com.devamatre.theorem.adts.graph;

import com.devamatre.theorem.adts.array.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
     * Builds the <code>Graph<E></code> with the provided <code>List<Edge<E>></code>.
     *
     * @param graph
     * @param edges
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void buildGraph(AbstractGraph<E> graph, List<Edge<E>> edges) {
        if (Objects.nonNull(edges)) {
            edges.forEach(edge -> graph.addEdge(edge.getSource(), edge.getTarget(), edge.getWeight()));
        }
    }

    /**
     * Builds the <code>Graph<E></code> with the provided <code>List<Edge<E>></code>.
     *
     * @param graph
     * @param edges
     */
    public static void buildMatrixGraph(AbstractGraph<Integer> graph, List<List<Integer>> edges) {
        LOGGER.debug("+buildGraph({}, {})", graph, edges);
        if (Objects.nonNull(edges)) {
            for (int row = 0; row < edges.size(); row++) {
                List<Integer> adjListData = edges.get(row);
                for (int column = 0; column < adjListData.size(); column++) {
                    graph.addEdge(row, column, BigDecimal.valueOf(adjListData.get(column)));
                }
            }
        }
        LOGGER.debug("-buildGraph(), graph:{}", graph);
    }

    /**
     * Builds the <code>Graph<E></code> with the provided <code>List<Edge<E>></code>.
     *
     * @param graph
     * @param edges
     */
    public static void buildMatrixGraph(AbstractGraph<Integer> graph, Integer[][] edges) {
        buildMatrixGraph(graph, ArrayUtils.asList(edges));
    }

    /**
     * Run DFS on the <code>graph</code>.
     *
     * @param graph
     * @param current
     * @param visited
     * @param hashSet
     */
    public static <E extends Comparable<? super E>> void dfs(Graph<E> graph, E current, Set<E> visited,
                                                             Set<E> hashSet) {
        LOGGER.debug("+dfs({}, {}, {}, {})", graph, current, visited, hashSet);
        LOGGER.debug(current.toString());
        visited.add(current);
        // push current to hashSet as it's visited.
        hashSet.add(current);
        if (graph.hasVertex(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = graph.getNeighbors(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    dfs(graph, edge.getTarget(), visited, hashSet);
                }
            }
        }
        LOGGER.debug("-dfs(), visited:{}, hashSet:{}", visited, hashSet);
    }

    /**
     * Run DFS on the <code>graph</code>.
     */
    public static <E extends Comparable<? super E>> Set<E> dfs(Graph<E> graph) {
        LOGGER.debug("+dfs({})", graph);
        final Set<E> visited = new HashSet<>();
        final Set<E> hashSet = new HashSet<>();
        // traverse each vertex of the graph
        Iterator<E> itr = graph.getVertices().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                dfs(graph, current, visited, hashSet);
            }
        }

        LOGGER.debug("-dfs(), hashSet:{}", hashSet);
        return hashSet;
    }

    /**
     * Converts the <code>Stack<E></code> into <code>List<E></code>.
     *
     * @param stack
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> List<E> convertStackToList(Stack<E> stack, List<E> list) {
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }

        // convert stack to list.
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

    /**
     * Converts the <code>Stack<E></code> into <code>List<E></code>.
     *
     * @param stack
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> List<E> convertStackToList(Stack<E> stack) {
        return convertStackToList(stack, new ArrayList<>());
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
        if (graph.hasVertex(current)) {
            // visit all neighbors of the current vertex
            Iterator<Edge<E>> itr = graph.getNeighbors(current).iterator();
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
        Iterator<E> itr = graph.getVertices().iterator();
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

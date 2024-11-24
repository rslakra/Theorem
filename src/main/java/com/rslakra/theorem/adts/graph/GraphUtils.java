package com.rslakra.theorem.adts.graph;

import com.rslakra.theorem.adts.array.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
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
     * Runs DFS on the <code>graph</code>.
     *
     * @param graph
     * @param current
     * @param visited
     */
    private <E extends Comparable<? super E>> void dfs(Graph<E> graph, E current, Set<E> visited) {
        LOGGER.debug("+dfs({}, {}, {})", graph, current, visited);
        // push current to result as it's visited.
        visited.add(current);
        if (graph.hasVertex(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = graph.getNeighbors(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    dfs(graph, edge.getTarget(), visited);
                }
            }
        }
        LOGGER.debug("-dfs(), visited:{}", visited);
    }

    /**
     * Runs DFS on the <code>graph</code>.
     */
    public static <E extends Comparable<? super E>> Set<E> dfs(Graph<E> graph) {
        LOGGER.debug("+dfs({})", graph);
        final Set<E> visited = new LinkedHashSet<>();
        // traverse each vertex of the graph
        Iterator<E> itr = graph.getVertices().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                INSTANCE.dfs(graph, current, visited);
            }
        }

        LOGGER.debug("-dfs(), visited:{}", visited);
        return visited;
    }

    /**
     * Runs BFS on the <code>graph</code>.
     *
     * @param graph
     * @param current
     * @param visited
     */
    private <E extends Comparable<? super E>> void bfs(Graph<E> graph, E current, Set<E> visited) {
        LOGGER.debug("+bfs({}, {}, {})", graph, current, visited);
        Queue<E> queue = new LinkedList<>();
        queue.add(current);
        // push current to result as it's visited.
        visited.add(current);
        while (!queue.isEmpty()) {
            E node = queue.remove();
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = graph.getNeighbors(node).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    queue.add(edge.getTarget());
                    // mark neighbor as visited
                    visited.add(edge.getTarget());
                }
            }
        }

        LOGGER.debug("-bfs(), visited:{}", visited);
    }

    /**
     * Runs DFS on the <code>graph</code>.
     */
    public static <E extends Comparable<? super E>> Set<E> bfs(Graph<E> graph) {
        LOGGER.debug("+bfs({})", graph);
        // contains traversed vertices
        final Set<E> visited = new LinkedHashSet<>();
        // traverse each vertex of the graph
        Iterator<E> itr = graph.getVertices().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                INSTANCE.bfs(graph, current, visited);
            }
        }

        LOGGER.debug("-bfs(), visited:{}", visited);
        return visited;
    }

    /**
     * Run DFS on the <code>graph</code>.
     *
     * @param graph
     * @param root
     * @return
     */
    public static <E extends Comparable<? super E>> Set<E> depthFirstTraversal(Graph<E> graph, E root) {
        Set<E> visited = new LinkedHashSet<>();
        Stack<E> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            E vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Edge<E> edge : graph.getNeighbors(vertex)) {
                    stack.push(edge.getTarget());
                }
            }
        }

        return visited;
    }

    /**
     * Run DFS on the <code>graph</code>.
     *
     * @param graph
     * @return
     */
    public static <E extends Comparable<? super E>> Set<E> depthFirstTraversal(Graph<E> graph) {
        return depthFirstTraversal(graph, graph.firstVertex());
    }

    /**
     * Runs DFS on the <code>adjMatrix</code>.
     *
     * @param adjMatrix
     * @param root
     * @param visited
     * @param result
     */
    private static void depthFirstTraversal(int[][] adjMatrix, int root, boolean[] visited, Set<Integer> result) {
        result.add(root);
        visited[root] = true;
        for (int i = 0; i < adjMatrix[0].length; i++) {
            if (!visited[i] && adjMatrix[root][i] != 0) {
                depthFirstTraversal(adjMatrix, i, visited, result);
            }
        }
    }

    /**
     * Runs DFS on the <code>adjMatrix</code>.
     *
     * @param adjMatrix
     * @return
     */
    public static Set<Integer> depthFirstTraversal(int[][] adjMatrix) {
        Set<Integer> result = new LinkedHashSet<>();
        boolean[] visited = new boolean[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visited[i]) {
                depthFirstTraversal(adjMatrix, i, visited, result);
            }
        }

        return result;
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
    public static <E extends Comparable<? super E>> void topSort(AbstractGraph<E> graph, E current, Set<E> visited,
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
    public static <E extends Comparable<? super E>> List<E> topSort(AbstractGraph<E> graph) {
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

    /**
     * Returns the count of the number of vertices of the provided <code>graph</code>.
     *
     * @param graph
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> int countVertices(AbstractGraph<E> graph) {
        return graph.getVertices().size();
    }

    /**
     * Returns the count of the number of edges of the provided <code>graph</code>.
     *
     * @param graph
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> int countEdges(AbstractGraph<E> graph) {
        return 0;
    }

    /**
     * Returns the count of the degree per vertex of the provided <code>graph</code>.
     *
     * @param graph
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Map<E, Integer> countDegree(AbstractGraph<E> graph) {
        return null;
    }

    /**
     * Returns the count of the in-degree per vertex of the provided <code>graph</code>.
     *
     * @param graph
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Map<E, Integer> countInDegree(AbstractGraph<E> graph) {
        return null;
    }

    /**
     * Returns the count of the in-degree per vertex of the provided <code>graph</code>.
     *
     * @param graph
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Map<E, Integer> countOutDegree(AbstractGraph<E> graph) {
        return null;
    }

}

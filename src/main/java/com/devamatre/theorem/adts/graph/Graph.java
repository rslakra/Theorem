package com.devamatre.theorem.adts.graph;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 5:01 PM
 */
public class Graph<E extends Comparable> extends AbstractGraph<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Graph.class);

    /**
     * A list of lists to represent an adjacency list
     * <p>
     * There are multiple ways to implement the adjacency-list like:
     * <pre>
     *   - Using <code>List<Edge>[]</code>, or
     *   - Using <code>List<List<Edge>></code>, or
     *   - <code>Map<E, Set<Edge<E>>></code>
     *  </pre>
     * <p>
     * I'm using the <code>Map<E, Set<Edge<E>>></code> approach which is auto-resizable.
     */
    private final Map<E, Set<Edge<E>>> adjList;

    /**
     * @param weighted
     * @param directed
     */
    public Graph(boolean weighted, boolean directed) {
        super(weighted, directed);
        adjList = new HashMap<>();
    }

    /**
     *
     */
    public Graph() {
        this(false, false);
    }

    /**
     * Returns the <code>adjList</code> of the graph.
     *
     * @return
     */
    protected Map<E, Set<Edge<E>>> getAdjList() {
        return adjList;
    }

    /**
     * Returns the <code>keySet</code> of the graph.
     *
     * @return
     */
    protected Set<E> keySet() {
        return adjList.keySet();
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
        return adjList.size();
    }

    /**
     * Returns the <code>startNode</code> of the graph.
     *
     * @return
     */
    @Override
    public E startNode() {
        return keySet().iterator().next();
    }

    /**
     * Adds the edge between the <code>source</code> and <code>target</code> vertices of the edge.
     *
     * @param edge
     */
    private void addEdge(final Edge<E> edge) {
        if (!isWeighted()) {
            edge.setWeight(BigDecimal.ZERO);
        }

        if (BeanUtils.isNull(edge.getSource())) {
            return;
        }

        // Add an edge from source to target into the set
        adjList.putIfAbsent(edge.getSource(), new HashSet<>());
        adjList.get(edge.getSource()).add(edge);

        // If it's undirected graph, add an edge from target to source into the set
        if (!isDirected()) {
            if (BeanUtils.isNotNull(edge.getTarget())) {
                adjList.putIfAbsent(edge.getTarget(), new HashSet<>());
                adjList.get(edge.getTarget()).add(edge.reverseEdge());
            }
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
        addEdge(new Edge<>(source, target, weight, isDirected()));
    }

    /**
     * @param source
     * @param target
     */
    @Override
    public void addEdge(E source, E target) {
        addEdge(new Edge<>(source, target, BigDecimal.ZERO, isDirected()));
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
        return neighbors.stream().filter(edge -> edge.getTarget().equals(target)).findFirst().isPresent();
    }

    /**
     * Returns an edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public Edge<E> findEdge(E source, E target) {
        return null;
    }

    /**
     * Returns the edges/neighbors of the <code>vertex</code> of the <code>graph</code>.
     *
     * @param vertex
     * @return
     */
    @Override
    public Set<Edge<E>> getNeighbors(E vertex) {
        // to avoid NullPointer in the code, returning empty set.
        return adjList.getOrDefault(vertex, Collections.emptySet());
    }

    /**
     * Removes the edge between the <code>source</code> and <code>target</code> vertices.
     *
     * @param source
     * @param target
     */
    @Override
    public void removeEdge(E source, E target) {
        // remove an edge from source to target
        if (adjList.containsKey(source)) {
            adjList.get(source).remove(target);
        }

        // If it's undirected graph, add an edge from target to source into the set
        if (!isDirected()) {
            if (adjList.containsKey(target)) {
                adjList.get(target).remove(source);
            }
        }
    }

    /**
     * Prints the graph.
     */
    @Override
    public void printGraph() {
        adjList.keySet().forEach(key -> {
            Iterator<Edge<E>> itr = getNeighbors(key).iterator();
            while (itr.hasNext()) {
                LOGGER.debug(itr.next().toString());
            }
        });
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
        return null;
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

    /**
     * The string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        final Set<Edge<E>> edges = new LinkedHashSet<>();
        adjList.keySet().forEach(key -> {
            Iterator<Edge<E>> itr = getNeighbors(key).iterator();
            while (itr.hasNext()) {
                edges.add(itr.next());
            }
        });
        return edges.toString();
    }

    /**
     * @param current
     * @param visited
     */
    public void dfs(E current, Set<E> visited, Set<E> stack) {
        LOGGER.debug(current.toString());
        visited.add(current);
        // push current to stack as it's visited.
        stack.add(current);
        if (adjList.containsKey(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = adjList.get(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    dfs(edge.getTarget(), visited, stack);
                }
            }
        }
    }

    /**
     * DFS
     */
    public void dfs() {
        final Set<E> visited = new HashSet<>();
        final Set<E> stack = new HashSet<>();
        // traverse each vertex of the graph
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                dfs(current, visited, stack);
            }
        }

        LOGGER.debug("{}", stack);
    }

    /**
     * @param vertex
     */
    public void bfs(E vertex) {
        final Set<E> visited = new HashSet<>();
        // create a queue for doing BFS
        Queue<E> queue = new ArrayDeque<>();
        // mark the source vertex as discovered
        visited.add(vertex);
        // enqueue source vertex
        queue.add(vertex);

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node and print it
            vertex = queue.poll();
            LOGGER.debug(vertex + " ");

            // do for every edge (u, v)
            adjList.get(vertex).forEach(edge -> {
                if (!visited.contains(edge.getTarget())) {
                    // mark it as discovered and enqueue it
                    visited.add(edge.getTarget());
                    queue.add(edge.getTarget());
                }
            });
        }
    }

    /**
     * @param queue
     * @param visited
     */
    public void bfsRecursively(Queue<Edge> queue, Set<Edge> visited) {
        // create a queue for doing BFS
//        Queue<E> queue = new ArrayDeque<>();
        if (queue.isEmpty()) {
            return;
        }

        // dequeue front node and print it
        Edge vertex = queue.poll();
        LOGGER.debug(vertex.toString());

        // do for every edge (v, u)
        adjList.get(vertex).forEach(edge -> {
            if (!visited.contains(edge)) {
                // mark it as discovered and enqueue it
                visited.add(edge);
                queue.add(edge);
            }
        });

        bfsRecursively(queue, visited);
    }

    /**
     * Cycle Detection Methods:
     *
     * Directed Graph
     * <pre>
     *  - DFS
     *  - BFS
     *  - Topological Sort (Kahn's Algorithm)
     *  - Graph Coloring
     * </pre>
     *
     * Undirected Graph
     * <pre>
     *  - DFS
     *  - BFS
     *  - Disjoint Sets (Union-Find)
     * </pre>
     *
     */

    /**
     * Back-Edge/Cycle detection criteria
     *
     * @param current
     * @param visited
     * @param parent
     * @return
     */
    public boolean hasCycleUndirected(E current, Set<E> visited, E parent) {
        visited.add(current);
        // visit neighbors of current vertex
        Iterator<Edge<E>> itr = adjList.get(current).iterator();
        while (itr.hasNext()) {
            Edge<E> edge = itr.next();
            if (visited.contains(edge.getTarget())
                && edge.getTarget() != parent) { // Case 1: Target Already Visited and Parent != Target (back-edge)
                return true;
            } else if (!visited.contains(edge.getTarget())) { // Case 3: Target Not Already Visited
                if (hasCycleUndirected(edge.getTarget(), visited, current)) {
                    return true;
                }
            }
            // Case 2: Target Already Visited and Parent == Target (Nothing to do for this case)
        }

        return false;
    }

    /**
     * @return
     */
    public boolean cycleDetectionUndirected() {
        Set<E> visited = new HashSet<>();
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                if (hasCycleUndirected(current, visited, null)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param current
     * @param visited
     * @param stack
     * @return
     */
    public boolean hasCycleDirected(E current, Set<E> visited, Set<E> stack) {
        visited.add(current);
        stack.add(current);
        // visit neighbors of current vertex
        if (adjList.containsKey(current)) {
            Iterator<Edge<E>> itr = adjList.get(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (stack.contains(edge.getTarget())) { // Case 1: Target Already in Recursion Stack
                    return true;
                } else if (!visited.contains(edge.getTarget())) { // Case 3: Target Not Already Visited
                    if (hasCycleDirected(edge.getTarget(), visited, stack)) {
                        return true;
                    }
                }
                // Case 2: Target Already Visited and Parent == Target (Nothing to do for this case)
            }

            // remove while back-tracking
            stack.remove(current);
        }

        return false;
    }

    /**
     * @return
     */
    public boolean cycleDetectionDirected() {
        Set<E> visited = new HashSet<>();
        Set<E> stack = new HashSet<>();
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                if (hasCycleDirected(current, visited, stack)) {
                    return true;
                }
            }
        }

        return false;
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
    public void topSort(E current, Set<E> visited, Stack<E> stack) {
        visited.add(current);
        if (adjList.containsKey(current)) {
            // visit all neighbors of the current vertex
            Iterator<Edge<E>> itr = adjList.get(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                if (!visited.contains(edge.getTarget())) {
                    topSort(edge.getTarget(), visited, stack);
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
     * @return
     */
    public Stack<E> topSort() {
        final Set<E> visited = new HashSet<>();
        final Stack<E> topSort = new Stack<>();
        // traverse each vertex of the graph
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                topSort(current, visited, topSort);
            }
        }

        LOGGER.debug("topSort:{}", topSort);
        return topSort;
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
    public List<E> topSortList() {
        List<E> topSort = new ArrayList<>();
        final Stack<E> stack = topSort();
        // convert stack to list.
        while (!stack.isEmpty()) {
            topSort.add(stack.pop());
        }

        LOGGER.debug("topSort:{}", topSort);
        return topSort;
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
    public List<List<E>> topSorts() {
        List<List<E>> topSorts = new ArrayList<>();
        List<E> topSort = topSortList();
        topSorts.add(topSort);
        LOGGER.debug("topSorts:{}", topSorts);
        return topSorts;
    }

    /**
     * Shortest Path of Weighted Graph.
     * <p>
     * BFS
     * <p>
     * Time Complexity: O(E + E log V)
     */
    public Map<E, BigDecimal> shortPathWithDijkstraAlgorithm() {
        Map<E, BigDecimal> distances = new HashMap<>();
        Set<E> visited = new HashSet<>();
        PriorityQueue<Pair<E>> queue = new PriorityQueue<>();
        // traverse each vertex of the graph
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            // add all edges cost as infinity.
            distances.put(itr.next(), INFINITY);
        }

        // add first vertex to visit
        Edge<E> first = adjList.get(startNode()).iterator().next();
        // for self, it should always be zero.
        distances.put(first.getSource(), BigDecimal.ZERO);
        // add first vertex to start with.
        queue.add(new Pair(first.getSource(), BigDecimal.ZERO));
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            if (!visited.contains(pair.getSource())) {
                visited.add((E) pair.getSource());
                if (adjList.containsKey(pair.getSource())) {
                    // visit neighbors of current vertex
                    Iterator<Edge<E>> neighbors = adjList.get(pair.getSource()).iterator();
                    while (neighbors.hasNext()) {
                        Edge<E> edgeNeighbor = neighbors.next();
                        E u = edgeNeighbor.getSource();
                        E v = edgeNeighbor.getTarget();
                        BigDecimal newDistance = distances.get(u).add(edgeNeighbor.getWeight());
                        if (v != null && newDistance.compareTo(distances.get(v)) < 0) {
                            distances.put(v, newDistance);
                            queue.add(new Pair<>(v, distances.get(v)));
                        }
                    }
                }
            }
        }

        LOGGER.debug("distances:{}", distances);
        return distances;
    }

    /**
     * Shortest Path of Weighted Graph and weight can be +/- (both).
     * <p>
     * BFS
     * <p>
     * Time Complexity: O(E + E log V)
     */
    public Map<E, BigDecimal> shortPathWithBellmanFordAlgorithm() {
        Map<E, BigDecimal> distances = new HashMap<>();
        // traverse each vertex of the graph
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            distances.put(itr.next(), INFINITY);
        }
        // mark first vertex with 0
        distances.put(startNode(), BigDecimal.ZERO);

        // iterate over all vertices - 1
        for (int i = 0; i < adjList.keySet().size() - 1; i++) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> neighbors = adjList.get(i).iterator();
            while (neighbors.hasNext()) {
                Edge<E> edgeNeighbor = neighbors.next();
                E u = edgeNeighbor.getSource();
                E v = edgeNeighbor.getTarget();
                BigDecimal newDistance = distances.get(u).add(edgeNeighbor.getWeight());
                if (v != null && distances.get(u).compareTo(INFINITY) != 0
                    && newDistance.compareTo(distances.get(v)) < 0) {
                    distances.put(v, newDistance);
                }
            }
        }

        LOGGER.debug("distances:{}", distances);
        return distances;
    }


    /**
     * Shortest Path of Weighted Graph and weight can be +/- (both).
     * <p>
     * BFS
     * <p>
     * Time Complexity: O(E + E log V)
     */
    public Map<E, BigDecimal> shortPathWithBellmanFordAlgorithmWithNegativeWeightCycle() {
        Map<E, BigDecimal> distances = new HashMap<>();
        // traverse each vertex of the graph
        Iterator<E> itr = adjList.keySet().iterator();
        while (itr.hasNext()) {
            distances.put(itr.next(), INFINITY);
        }
        // mark first vertex with 0
        distances.put(startNode(), BigDecimal.ZERO);

        // iterate over all vertices - 1
        for (int i = 0; i < adjList.keySet().size(); i++) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> neighbors = adjList.get(i).iterator();
            while (neighbors.hasNext()) {
                Edge<E> edgeNeighbor = neighbors.next();
                E u = edgeNeighbor.getSource();
                E v = edgeNeighbor.getTarget();
                BigDecimal newDistance = distances.get(u).add(edgeNeighbor.getWeight());
                if (v != null && distances.get(u).compareTo(INFINITY) != 0
                    && newDistance.compareTo(distances.get(v)) < 0) {
                    distances.put(v, newDistance);
                }
            }
        }

        // reiterate over all vertices - 1 to detect the negative weight cycle
        for (int i = 0; i < adjList.keySet().size(); i++) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> neighbors = adjList.get(i).iterator();
            while (neighbors.hasNext()) {
                Edge<E> edgeNeighbor = neighbors.next();
                E u = edgeNeighbor.getSource();
                E v = edgeNeighbor.getTarget();
                BigDecimal newDistance = distances.get(u).add(edgeNeighbor.getWeight());
                if (v != null && distances.get(u).compareTo(INFINITY) != 0
                    && newDistance.compareTo(distances.get(v)) < 0) {
                    LOGGER.debug("Negative Weight Cycle Detected!");
                }
            }
        }

        LOGGER.debug("distances:{}", distances);
        return distances;
    }

    /**
     * Prim's Algorithm (minimum spanning tree)
     * <p>
     * MST Qualities
     * <pre>
     *     1. Includes all vertices
     *     2. No cycles
     *     3. Minimum weight of edges
     * </pre>
     *
     * <p>
     * Time Complexity: O(E log E)
     *
     * @return
     */
    public Set<Edge<E>> mstEdges() {
        Set<Edge<E>> mstEdges = new LinkedHashSet<>();
        Set<E> visited = new HashSet<>();
        PriorityQueue<Edge<E>> queue = new PriorityQueue<>(new Edge.EdgeComparator());
        // add first node of the graph into the queue.
        E source = startNode();
        queue.add(new Edge(source, source, BigDecimal.ZERO));
        while (!queue.isEmpty()) {
            Edge<E> edge = queue.remove();
            if (!visited.contains(edge.getTarget())) {
                visited.add(edge.getTarget());
                if (!edge.getSource().equals(edge.getTarget())) {
                    mstEdges.add(edge);
                }
                // visit neighbors of current vertex
                Iterator<Edge<E>> neighbors = adjList.get(edge.getTarget()).iterator();
                while (neighbors.hasNext()) {
                    Edge<E> edgeNeighbor = neighbors.next();
                    // if neighbor is not already visited, then only move that to MST
                    if (!visited.contains(edgeNeighbor.getTarget())) {
                        queue.add(edgeNeighbor);
                    }
                }
            }
        }

        LOGGER.debug("mstEdges:{}", mstEdges);
        return mstEdges;
    }

    /**
     * Time Complexity: O(E log E)
     *
     * @return
     */
    public BigDecimal mstCost() {
//        return minSpanningTree().stream().map(edge -> edge.getWeight()).mapToInt(Integer::intValue).sum();
        BigDecimal mstCost = BigDecimal.ZERO;
        Set<Edge<E>> mst = new HashSet<>();
        Set<E> visited = new HashSet<>();
        PriorityQueue<Pair<E>> queue = new PriorityQueue<>();
        // add first node of the graph into the queue.
        queue.add(new Pair<>(startNode(), BigDecimal.ZERO));
        while (!queue.isEmpty()) {
            Pair<E> pair = queue.remove();
            if (!visited.contains(pair.getSource())) {
                visited.add(pair.getSource());
                mstCost = mstCost.add(pair.getWeight());
                // visit neighbors of current vertex
                Iterator<Edge<E>> neighbors = adjList.get(pair.getSource()).iterator();
                while (neighbors.hasNext()) {
                    Edge<E> edgeNeighbor = neighbors.next();
                    // if neighbor is not already visited, then only move that to MST
                    if (!visited.contains(edgeNeighbor.getTarget())) {
                        mst.add(edgeNeighbor);
                        queue.add(new Pair<>(edgeNeighbor.getTarget(), edgeNeighbor.getWeight()));
                    }
                }
            }
        }

        return mstCost;
    }

    /**
     * @return
     */
    public Set<E> mstCostTree() {
//        return minSpanningTree().stream().map(edge -> edge.getTarget()).collect(Collectors.toSet());
        Set<E> mst = new HashSet<>();
        Set<E> visited = new HashSet<>();
        PriorityQueue<Pair<E>> queue = new PriorityQueue<>();
        // add first node of the graph into the queue.
        queue.add(new Pair<>(startNode(), BigDecimal.ZERO));
        while (!queue.isEmpty()) {
            Pair<E> pair = queue.remove();
            if (!visited.contains(pair.getSource())) {
                visited.add(pair.getSource());
                mst.add(pair.getSource());
                // visit neighbors of current vertex
                Iterator<Edge<E>> neighbors = adjList.get(pair.getSource()).iterator();
                while (neighbors.hasNext()) {
                    Edge<E> edgeNeighbor = neighbors.next();
                    // if neighbor is not already visited, then only move that to MST
                    if (!visited.contains(edgeNeighbor.getTarget())) {
                        queue.add(new Pair<>(edgeNeighbor.getTarget(), edgeNeighbor.getWeight()));
                    }
                }
            }
        }

        return mst;
    }

    /**
     * Transpose directed graph means reverse the direction of the edges of the graph.
     *
     * @param graph
     * @return
     */
    public Graph<E> transposeDirectedGraph(Graph<E> graph) {
        final Graph<E> graphTransposed = new Graph<>(graph.isWeighted(), graph.isDirected());
        if (graph.isDirected()) {
            graph.getAdjList().keySet().forEach(vertex -> {
                Set<Edge<E>> edges = graph.getNeighbors(vertex);
                edges.forEach(edge -> graphTransposed.addEdge(edge.reverseEdge()));
            });
        }

        return graphTransposed;
    }


    /**
     * Transpose directed graph means reverse the direction of the edges of the graph.
     *
     * @return
     */
    public Graph<E> transposeDirectedGraph() {
        final Graph<E> graphTransposed = new Graph<>(false, true);
        if (isDirected()) {
            adjList.keySet().forEach(vertex -> {
                Set<Edge<E>> edges = getNeighbors(vertex);
                edges.forEach(edge -> graphTransposed.addEdge(edge.reverseEdge()));
            });
        }

        return graphTransposed;
    }

    /**
     * Kosaraju's Algorithm
     * <p>
     * Steps:
     * <pre>
     *  1. Get nodes in stack (Topological Sort) - O(V+E)
     *  2. Transpose the graph - O(V+E)
     *  3. Do DFS according to stack nodes on the transposed graph. - O(V+E)
     * </pre>
     * <p>
     * Time Complexity: O(V+E)
     *
     * @return
     */
    public Set<Set<E>> kosarajuAlgorithm() {
        Set<Set<E>> stronglyConnectedComponents = new LinkedHashSet<>();
        // Step 1: Get nodes in stack (Topological Sort)
        Stack<E> topSort = topSort();
        // Step 2: Transpose the graph
        final Graph<E> graphTransposed = transposeDirectedGraph();
        // Step 3: Do DFS according to stack nodes on the transposed graph
        final Set<E> visited = new HashSet<>();
        while (!topSort.isEmpty()) {
            E current = topSort.pop();
            Set<E> stack = new HashSet<>();
            if (!visited.contains(current)) {
                graphTransposed.dfs(current, visited, stack);
                LOGGER.debug("stack:{}", stack);
                stronglyConnectedComponents.add(stack);
            }
        }

        LOGGER.debug("stronglyConnectedComponents:{}", stronglyConnectedComponents);
        return stronglyConnectedComponents;
    }

    /**
     * @param current
     * @param visited
     * @param parent
     * @param time
     * @param discoveryTime
     * @param lowestDiscoveryTime
     * @param bridgesInGraph
     */
    public void dfsGraphBridges(E current, Set<E> visited, E parent, int time, Map<E, Integer> discoveryTime,
                                Map<E, Integer> lowestDiscoveryTime, Set<Edge<E>> bridgesInGraph) {
        LOGGER.debug("+dfsGraphBridges({}, {}, {}, {}, {}, {})", current, visited, parent, time, discoveryTime,
                     lowestDiscoveryTime);
        visited.add(current);
        time++;
        // set discovery time and lowest discovery time of the current node.
        discoveryTime.put(current, time);
        lowestDiscoveryTime.put(current, time);
        if (getAdjList().containsKey(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = getNeighbors(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                // if the neighbor is equal to parent, continue (nothing to do)
                if (edge.getTarget().equals(parent)) {
                    // nothing to do here.
                    continue;
                } else if (!visited.contains(edge.getTarget())) {
                    // visit neighbors
                    dfsGraphBridges(edge.getTarget(), visited, current, time, discoveryTime, lowestDiscoveryTime,
                                    bridgesInGraph);
                    // then update the lowest discovery time of the current node
                    int
                        minDiscoveryTime =
                        Math.min(lowestDiscoveryTime.get(current), lowestDiscoveryTime.get(edge.getTarget()));
                    LOGGER.debug("Not Visited - minDiscoveryTime:{}", minDiscoveryTime);
                    lowestDiscoveryTime.put(current, minDiscoveryTime);
                    // bridge exists, if the current node's discovery time < target node's lowest discovery time
                    if (discoveryTime.get(current) < lowestDiscoveryTime.get(edge.getTarget())) {
                        LOGGER.info("Bridged Edge:{}", edge);
                        bridgesInGraph.add(edge);
                    }
                } else if (visited.contains(edge.getTarget())) {
                    // then update the lowest discovery time of the current node with neighbors discovery time.
                    int
                        minDiscoveryTime =
                        Math.min(lowestDiscoveryTime.get(current), discoveryTime.get(edge.getTarget()));
                    LOGGER.debug("Visited - minDiscoveryTime:{}", minDiscoveryTime);
                    lowestDiscoveryTime.put(current, minDiscoveryTime);
                }
            }
        }

        LOGGER.debug("-dfsGraphBridges()");
    }

    /**
     * Bridge is an edge who deletion increases the graph's number of connected components.
     * <p>
     * Tarjan's Algorithm
     * <p>
     * Usage:
     * <pre>
     *  1. Find Bridges
     *  2. Find Articulation Points
     *  3. Topological Sorting
     *  4. Strongly Connected Components
     * </pre>
     *
     * @return - Returns the set of bridges in the graph.
     */
    public Set<Edge<E>> tarjanAlgorithm() {
        Set<Edge<E>> bridgesInGraph = new HashSet<>();
        Map<E, Integer> discoveryTime = new HashMap<>();
        Map<E, Integer> lowestDiscoveryTime = new HashMap<>();
        Set<E> visited = new HashSet<>();
        int time = 0;
        // traverse each vertex of the graph
        Iterator<E> itr = keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                dfsGraphBridges(current, visited, null, time, discoveryTime, lowestDiscoveryTime, bridgesInGraph);
            }
        }

        return bridgesInGraph;
    }

    /**
     * @param current
     * @param visited
     * @param parent
     * @param time
     * @param discoveryTime
     * @param lowestDiscoveryTime
     * @param graphArticulationPoints
     */
    public void dfsArticulationPoints(E current, Set<E> visited, E parent, int time, Map<E, Integer> discoveryTime,
                                      Map<E, Integer> lowestDiscoveryTime, Set<E> graphArticulationPoints) {
        LOGGER.debug("+dfsArticulationPoints({}, {}, {}, {}, {}, {})", current, visited, parent, time, discoveryTime,
                     lowestDiscoveryTime);
        visited.add(current);
        time++;
        // set discovery time and lowest discovery time of the current node.
        discoveryTime.put(current, time);
        lowestDiscoveryTime.put(current, time);
        int children = 0;
        if (getAdjList().containsKey(current)) {
            // visit neighbors of current vertex
            Iterator<Edge<E>> itr = getNeighbors(current).iterator();
            while (itr.hasNext()) {
                Edge<E> edge = itr.next();
                // if the neighbor is equal to parent, continue (nothing to do)
                if (edge.getTarget().equals(parent)) {
                    // nothing to do here.
                    continue;
                } else if (!visited.contains(edge.getTarget())) {
                    // visit neighbors
                    dfsArticulationPoints(edge.getTarget(), visited, current, time, discoveryTime, lowestDiscoveryTime,
                                          graphArticulationPoints);
                    // then update the lowest discovery time of the current node
                    int
                        minDiscoveryTime =
                        Math.min(lowestDiscoveryTime.get(current), lowestDiscoveryTime.get(edge.getTarget()));
                    LOGGER.debug("Not Visited - minDiscoveryTime:{}", minDiscoveryTime);
                    lowestDiscoveryTime.put(current, minDiscoveryTime);
                    // bridge exists, if the current node's discovery time < target node's lowest discovery time
                    if (discoveryTime.get(current) <= lowestDiscoveryTime.get(edge.getTarget()) && parent != null) {
                        LOGGER.info("Articulation Point: {}", current);
                        graphArticulationPoints.add(current);
                    }
                    children++;
                } else if (visited.contains(edge.getTarget())) {
                    // then update the lowest discovery time of the current node with neighbors discovery time.
                    int
                        minDiscoveryTime =
                        Math.min(lowestDiscoveryTime.get(current), discoveryTime.get(edge.getTarget()));
                    LOGGER.debug("Visited - minDiscoveryTime:{}", minDiscoveryTime);
                    lowestDiscoveryTime.put(current, minDiscoveryTime);
                }
            }

            // at the end, before back-tracking, check if current node is an articulation point or not.
            if (parent == null && children > 1) {
                LOGGER.info("Articulation Point ({}): {}", children, current);
                graphArticulationPoints.add(current);
            }
        }

        LOGGER.debug("-dfsArticulationPoints()");
    }

    /**
     * Bridge is an edge who deletion increases the graph's number of connected components.
     * <p>
     * Tarjan's Algorithm
     * <p>
     * Usage:
     * <pre>
     *  1. Find Bridges
     *  2. Find Articulation Points
     *  3. Topological Sorting
     *  4. Strongly Connected Components
     * </pre>
     *
     * @return - Returns the set of bridges in the graph.
     */
    public Set<E> articulationPointsTarjanAlgorithm() {
        Set<E> graphArticulationPoints = new HashSet<>();
        Map<E, Integer> discoveryTime = new HashMap<>();
        Map<E, Integer> lowestDiscoveryTime = new HashMap<>();
        Set<E> visited = new HashSet<>();
        int time = 0;
        // traverse each vertex of the graph
        Iterator<E> itr = keySet().iterator();
        while (itr.hasNext()) {
            E current = itr.next();
            if (!visited.contains(current)) {
                dfsArticulationPoints(current, visited, null, time, discoveryTime, lowestDiscoveryTime,
                                      graphArticulationPoints);
            }
        }

        return graphArticulationPoints;
    }

    /**
     * @return
     */
    public E[] shortDistanceAllVertices() {
        return null;
    }

    /**
     *
     */
    public void shortestPathAlgos() {

    }
}

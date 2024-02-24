/**
 *
 */
package com.devamatre.theorem.algos.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 13, 2019 8:59:08 PM
 */
public class GraphCycle {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphCycle.class);

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @Created Jul 17, 2019 11:33:45 AM
     */
    static class Edge implements Comparable<Edge> {

        int source;
        int target;
        int weight;

        /**
         * @param source
         * @param target
         * @param weight
         */
        Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }

        Edge() {
        }

        /**
         * Sort by edge.
         *
         * @param edge the object to be compared.
         * @return
         */
        @Override
        public int compareTo(Edge edge) {
            return weight - edge.weight;
        }
    }

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @Created Jul 17, 2019 11:33:40 AM
     */
    private class SubSet {

        int parent;
        int rank;

        SubSet(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public void incrementRank() {
            rank++;
        }
    }

    private int vertexCount, edgeCount;
    private Edge[] edges;
    private int[] parents;
    private int[] ranks;
    private boolean directedGraph;
    private SubSet[] subSets;

    /**
     * @param vertexCount
     * @param edgeCount
     * @param directedGraph
     */
    public GraphCycle(int vertexCount, int edgeCount, boolean directedGraph) {
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        this.directedGraph = directedGraph;
        this.initEdges();
    }

    /**
     * @param vertexCount
     * @param edgeCount
     */
    public GraphCycle(int vertexCount, int edgeCount) {
        this(vertexCount, edgeCount, false);
    }

    /**
     * @return
     */
    public int getVertices() {
        return vertexCount;
    }

    /**
     * @return
     */
    public int getEdges() {
        return edgeCount;
    }

    /**
     * Returns the <code>directedGraph</code> value;
     *
     * @return directedGraph
     */
    public boolean isDirectedGraph() {
        return directedGraph;
    }

    /**
     * Initialize edges.
     */
    protected void initEdges() {
        edges = new Edge[getEdges()];
        for (int i = 0; i < getEdges(); i++) {
            edges[i] = new Edge();
        }
    }

    /**
     * Creates n sets with single item in each.
     *
     * @param initWithSingleValue
     */
    protected void markSets(boolean initWithSingleValue) {
        ranks = new int[getVertices()];
        parents = new int[getVertices()];
        for (int i = 0; i < getVertices(); i++) {
            if (initWithSingleValue) {
                // Initialize all subset with single value
                parents[i] = -1;
            } else {
                // Initially, all elements are in their own set.
                parents[i] = i;
            }
        }
    }

    /**
     *
     */
    protected void initSubSets() {
        subSets = new SubSet[getVertices()];
        for (int i = 0; i < getVertices(); i++) {
            subSets[i] = new SubSet(i, 0);
        }
    }

    /**
     * @param index
     * @param source
     * @param target
     */
    protected void addEdge(int index, int source, int target) {
        edges[index].source = source;
        edges[index].target = target;
    }

    /**
     * @param vertex
     * @return
     */
    protected int find(int vertex) {
        // Finds the representative of the set that vertex is an element of
        if (parents[vertex] != vertex) {
            // if x is not the parent of itself, then x is not the representative of his set,
            parents[vertex] = find(parents[vertex]);
            // so we recursively call Find on its parent
            // and move i's node directly under the representative of this set
        }

        return parents[vertex];
    }

    /**
     * Do union of two sets represented by source and target.
     *
     * @param source
     * @param target
     */
    protected void union(int source, int target) {
        LOGGER.debug("+union({}, {})", source, target);
        // Find representatives of two sets
        int sourceParent = find(source);
        int targetParent = find(target);
        LOGGER.debug("source:{}, sourceParent:{}, target:{}, targetParent:{}", source, sourceParent, target,
                     targetParent);

        // Elements are in the same set, no need to unite them.
        if (sourceParent == targetParent) {
            return;
        }

        LOGGER.debug("parents:{}", Arrays.toString(parents));
        LOGGER.debug("ranks:{}", Arrays.toString(ranks));

        // If sourceParent's rank is less than targetParent's rank
        if (ranks[sourceParent] < ranks[targetParent]) {
            // Then move x under y so that depth of tree remains less
            parents[sourceParent] = targetParent;
        } else if (ranks[sourceParent] > ranks[targetParent]) {  // Else if y's rank is less than x's rank
            // Then move y under x so that depth of tree remains less
            parents[targetParent] = sourceParent;
        } else { // if ranks are the same
            // Then move y under x (doesn't matter which one goes where)
            parents[targetParent] = sourceParent;

            // And increment the result tree's rank by 1
            ranks[sourceParent]++;
        }
    }

    /**
     * @return
     */
    public boolean hasCycle() {
        markSets(false);
        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < getEdges(); i++) {
            int sourceParent = find(edges[i].source);
            int targetParent = find(edges[i].target);
            if (sourceParent == targetParent) {
                return true;
            }

            union(edges[i].source, edges[i].target);
        }

        return false;
    }

    /*
     * Union by Rank and Path Compression.
     */

    /**
     * @param parent
     * @param value
     * @return
     */
    public int find(int[] parent, int value) {
        if (parent[value] == -1) {
            return value;
        }

        return find(parent, parent[value]);
    }

    /**
     * Do union of two sets represented by left and right.
     *
     * @param parent
     * @param left
     * @param right
     */
    public void union(int[] parent, int left, int right) {
        int leftParent = find(parent, left);
        int rightParent = find(parent, right);
        parent[leftParent] = rightParent;
    }

    /**
     * @return
     */
    public boolean hasCycleInUndirectGraph() {
        markSets(true);

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < getEdges(); i++) {
            int leftParent = find(parents, edges[i].source);
            int rightParent = find(parents, edges[i].target);
            if (leftParent == rightParent) {
                return true;
            }

            union(parents, edges[i].source, edges[i].target);
        }

        return false;
    }

    /*
     * Union by Rank and Path Compression.
     */

    /**
     * A utility function to find set of an element i (uses path compression technique)
     *
     * @param subsets
     * @param value
     * @return
     */
    protected int find(SubSet[] subsets, int value) {
        if (subsets[value].parent != value) {
            subsets[value].parent = find(subsets, subsets[value].parent);
        }

        return subsets[value].parent;
    }

    /**
     * A function that does union of two sets of source and target (uses union by rank)
     *
     * @param subsets
     * @param source
     * @param target
     */
    protected void union(SubSet[] subsets, int source, int target) {
        int sourceParent = find(subsets, source);
        int targetParent = find(subsets, target);
        if (subsets[sourceParent].rank < subsets[targetParent].rank) {
            subsets[sourceParent].parent = targetParent;
        } else if (subsets[sourceParent].rank > subsets[targetParent].rank) {
            subsets[targetParent].parent = sourceParent;
        } else {
            subsets[targetParent].parent = targetParent;
            subsets[targetParent].incrementRank();
        }
    }

    /**
     * @param graph
     * @return
     */
    public boolean hasCycleByPathCompression(GraphCycle graph) {
        if (graph != null) {
            initSubSets();

            // Iterate through all edges of graph, find subset of both
            // vertices of every edge, if both subsets are same, then
            // there is cycle in graph.
            for (int i = 0; i < graph.getEdges(); i++) {
                int leftParent = graph.find(subSets, graph.edges[i].source);
                int rightParent = graph.find(subSets, graph.edges[i].target);
                if (leftParent == rightParent) {
                    return true;
                }

                graph.union(subSets, graph.edges[i].source, graph.edges[i].target);
            }

        }

        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Let us create following graph
         *
         * <pre>
         *    0
         *   / \
         *  /   \
         * 1-----2
         * </pre>
         */
        int vertices = 5;
        int edges = 3;
        GraphCycle graph = new GraphCycle(vertices, edges);
        // init
        graph.markSets(false);

        // 0 is a friend of 2
        graph.union(0, 2);

        // 4 is a friend of 2
        graph.union(4, 2);

        // 3 is a friend of 1
        graph.union(3, 1);

        // Check if 4 is a friend of 0
        if (graph.find(4) == graph.find(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // Check if 1 is a friend of 0
        if (graph.find(1) == graph.find(0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        /**
         * Let us create following graph
         *
         * <pre>
         *    0
         *   / \
         *  /   \
         * 1-----2
         * </pre>
         */
        graph = new GraphCycle(3, edges);
        // add edge 0-1
        graph.addEdge(0, 0, 1);
        // add edge 1-2
        graph.addEdge(1, 1, 2);
        // add edge 0-2
        graph.addEdge(2, 0, 2);

        if (graph.hasCycleInUndirectGraph()) {
            System.out.println("graph contains cycle");
        } else {
            System.out.println("graph doesn't contain cycle");
        }

        if (graph.hasCycleByPathCompression(graph)) {
            System.out.println("graph contains cycle");
        } else {
            System.out.println("graph doesn't contain cycle");
        }

    }

}

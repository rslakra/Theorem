/**
 *
 */
package com.devamatre.theorem.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 13, 2019 8:59:08 PM
 */
public class GraphCycle {

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @Created Jul 17, 2019 11:33:45 AM
     */
    static class Edge {

        int left;
        int right;
    }

    static class Vertex {

        private List<Edge> vertices = new ArrayList<Edge>();

        /**
         * @param vertex
         * @return
         */
        public Vertex[] getNeighbours(GraphCycle.Vertex vertex) {
            return null;
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

        /**
         * Returns the parent value;
         *
         * @return parent
         */
        public int getParent() {
            return parent;
        }

        /**
         * The parent to be set.
         *
         * @param parent
         */
        public void setParent(int parent) {
            this.parent = parent;
        }

        /**
         * Returns the rank value;
         *
         * @return rank
         */
        public int getRank() {
            return rank;
        }

        /**
         * The rank to be set.
         *
         * @param rank
         */
        public void setRank(int rank) {
            this.rank = rank;
        }

        public void incrementRank() {
            rank++;
        }
    }

    private int v, e;
    private Edge[] edges;
    private int[] parents;
    private int[] ranks;
    private boolean directedGraph;
    private SubSet[] subSets;

    /**
     * @param v
     * @param e
     * @param directedGraph
     */
    public GraphCycle(final int v, final int e, boolean directedGraph) {
        this.v = v;
        this.e = e;
        this.directedGraph = directedGraph;
        this.initEdges();
    }

    /**
     * @param v
     * @param e
     */
    public GraphCycle(final int v, final int e) {
        this(v, e, false);
    }

    /**
     * @return
     */
    public int getVertices() {
        return v;
    }

    /**
     * @return
     */
    public int getEdges() {
        return e;
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
            subSets[i] = new SubSet();
            subSets[i].setParent(i);
            subSets[i].setRank(0);
        }
    }

    /**
     * @param index
     * @param left
     * @param right
     */
    protected void setEdges(int index, int left, int right) {
        edges[index].left = left;
        edges[index].right = right;
    }

    /**
     * @param value
     * @return
     */
    protected int find(int value) {
        // Finds the representative of the set
        // that value is an element of
        if (parents[value] != value) {

            // if x is not the parent of itself
            // Then x is not the representative of
            // his set,
            parents[value] = find(parents[value]);

            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
        }

        return parents[value];
    }

    /**
     * Do union of two sets represented by left and right.
     *
     * @param left
     * @param right
     */
    protected void union(int left, int right) {
        // Find representatives of two sets
        int leftParent = find(left);
        int rightParent = find(right);
        System.out.println(
            "left:" + left + ", leftParent:" + leftParent + ", right:" + right + ", rightParent:" + rightParent);

        // Elements are in the same set, no need
        // to unite anything.
        if (leftParent == rightParent) {
            return;
        }

        System.out.println("parents:" + Arrays.toString(parents));
        System.out.println("ranks:" + Arrays.toString(ranks));

        // If leftParent's rank is less than rightParent's rank
        if (ranks[leftParent] < ranks[rightParent]) {
            // Then move x under y so that depth
            // of tree remains less
            parents[leftParent] = rightParent;
        } else if (ranks[leftParent] > ranks[rightParent]) {  // Else if y's rank is less than x's rank
            // Then move y under x so that depth of
            // tree remains less
            parents[rightParent] = leftParent;
        } else { // if ranks are the same
            // Then move y under x (doesn't matter
            // which one goes where)
            parents[rightParent] = leftParent;

            // And increment the the result tree's
            // rank by 1
            parents[leftParent]++;
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
            int leftParent = find(edges[i].left);
            int rightParent = find(edges[i].right);
            if (leftParent == rightParent) {
                return true;
            }

            union(edges[i].left, edges[i].right);
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
    public boolean hasCycleUndirectGraph() {
        markSets(true);

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < getEdges(); i++) {
            int leftParent = find(parents, edges[i].left);
            int rightParent = find(parents, edges[i].right);
            if (leftParent == rightParent) {
                return true;
            }

            union(parents, edges[i].left, edges[i].right);
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
        if (subsets[value].getParent() != value) {
            subsets[value].setParent(find(subsets, subsets[value].getParent()));
        }

        return subsets[value].getParent();
    }

    /**
     * A function that does union of two sets of left and right (uses union by rank)
     *
     * @param subsets
     * @param left
     * @param right
     */
    protected void union(SubSet[] subsets, int left, int right) {
        int leftParent = find(subsets, left);
        int rightParent = find(subsets, right);

        if (subsets[leftParent].getRank() < subsets[rightParent].getRank()) {
            subsets[leftParent].setParent(rightParent);
        } else if (subsets[leftParent].getRank() > subsets[rightParent].getRank()) {
            subsets[rightParent].setParent(leftParent);
        } else {
            subsets[leftParent].setParent(rightParent);
            subsets[rightParent].incrementRank();
        }
    }

    /**
     * @param graph
     * @return
     */
    public boolean hasCycleByPathCompression(GraphCycle graph) {
        if (graph != null) {
            {
                initSubSets();
            }

            // Iterate through all edges of graph, find subset of both
            // vertices of every edge, if both subsets are same, then
            // there is cycle in graph.
            for (int i = 0; i < graph.getEdges(); i++) {
                int leftParent = graph.find(subSets, graph.edges[i].left);
                int rightParent = graph.find(subSets, graph.edges[i].right);
                if (leftParent == rightParent) {
                    return true;
                }

                graph.union(subSets, graph.edges[i].left, graph.edges[i].right);
            }

        }

        return false;
    }

    /**
     * @param left
     * @param right
     */
    public void addEdge(int left, int right) {

    }

    /**
     * @return
     */
    public Vertex[] getAllVertices() {
        return null;
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
        int e = 3;
        GraphCycle graph = new GraphCycle(5, e);
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
        graph = new GraphCycle(3, e);
        // add edge 0-1
        graph.setEdges(0, 0, 1);

        // add edge 1-2
        graph.setEdges(1, 1, 2);

        // add edge 0-2
        graph.setEdges(2, 0, 2);

        if (graph.hasCycleUndirectGraph()) {
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

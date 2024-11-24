package com.rslakra.theorem.adts.graph;

/**
 * @author Rohtash Lakra
 * @created 11/21/23 5:17 PM
 */
public abstract class AbstractGraphTest {

    /**
     * Tests the <code>buildGraphWithEdges()</code> method.
     */
    public abstract void testBuildGraph();

    /**
     * Tests the <code>isWeighted()</code> method.
     */
    public abstract void testIsWeighted();

    /**
     * Tests the <code>isDirected()</code> method.
     */
    public abstract void testIsDirected();

    /**
     * Tests the <code>getSize()</code> method.
     */
    public abstract void testGetSize();

    /**
     * Tests the <code>getVertices()</code> method.
     */
    public abstract void testGetVertices();

    /**
     * Tests the <code>getNeighbors()</code> method.
     */
    public abstract void testGetNeighbors();

    /**
     * Tests the <code>printGraph()</code> method.
     */
    public abstract void testPrintGraph();

    /**
     * Tests the <code>firstVertex()</code> method.
     */
    public abstract void testFirstVertex();

    /**
     * Tests the <code>addEdge()</code> method.
     */
    public abstract void testAddEdgeWithWeight();

    /**
     * Tests the <code>addEdge()</code> method.
     */
    public abstract void testAddEdge();

    /**
     * Tests the <code>hasEdge()</code> method.
     */
    public abstract void testHasEdge();

    /**
     * Tests the <code>findEdge()</code> method.
     */
    public abstract void testFindEdge();

    /**
     * Tests the <code>removeEdge()</code> method.
     */
    public abstract void testRemoveEdge();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetVerticesConnectedTo();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetInwardEdges();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetOutwardEdges();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testGetSortedVertices();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testHasCycle();

    /**
     * Tests the <code></code> method.
     */
    public abstract void testSearchEdge();

}

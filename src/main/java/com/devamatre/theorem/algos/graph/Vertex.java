package com.devamatre.theorem.algos.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Dec 28, 2020 18:34:19
 */
public class Vertex<T> implements Comparable<Vertex<T>> {

    private final T data;
    private final List<Edge<T>> edges = new ArrayList<>();
    private final List<Vertex<T>> adjacents = new ArrayList<>();

    /**
     * @param data
     */
    public Vertex(final T data) {
        this.data = data;
    }

    /**
     * Returns the data value;
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Returns the edges value;
     *
     * @return edges
     */
    public List<Edge<T>> getEdges() {
        return this.edges;
    }

    /**
     * Returns the adjacentVertices value;
     *
     * @return adjacents
     */
    public List<Vertex<T>> getAdjacents() {
        return this.adjacents;
    }

    /**
     * @param edge
     * @param vertex
     */
    public void addAdjacent(Edge<T> edge, Vertex<T> vertex) {
        this.edges.add(edge);
        this.adjacents.add(vertex);
    }

    /**
     * @return
     */
    public int getDegree() {
        return this.edges.size();
    }

    /**
     * Returns the string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return (getData() == null ? "" : getData().toString());
    }

    /**
     * Returns the hash-code of this object.
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(getData());
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (getClass() != other.getClass()) {
            return false;
        }

        if (this != other) {
            return getData().equals(((Vertex<?>) other).getData());
        }

        return true;
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This implies that <tt>x.compareTo(y)</tt> must
     * throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates this condition should clearly indicate this
     * fact.  The recommended language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Vertex<T> other) {
        return ((Comparable) getData()).compareTo(other.getData());
    }
}

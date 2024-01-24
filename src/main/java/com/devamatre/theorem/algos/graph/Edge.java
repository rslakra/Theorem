package com.devamatre.theorem.algos.graph;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Dec 28, 2020 18:33:18
 */
public class Edge<T> implements Comparable<Edge<T>> {

    private boolean directed;
    private Vertex<T> source;
    private Vertex<T> target;
    private int weight;

    /**
     * @param source
     * @param target
     * @param directed
     * @param weight
     */
    public Edge(final Vertex<T> source, final Vertex<T> target, final boolean directed, final int weight) {
        this.source = source;
        this.target = target;
        this.directed = directed;
        this.weight = weight;
    }

    /**
     * @param source
     * @param target
     * @param directed
     */
    public Edge(final Vertex<T> source, final Vertex<T> target, final boolean directed) {
        this(source, target, directed, 0);
    }

    /**
     * @param source
     * @param target
     */
    public Edge(final Vertex<T> source, final Vertex<T> target) {
        this(source, target, false, 0);
    }

    /**
     * Returns the <code>directed</code> value;
     *
     * @return directed
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * The <code>directed</code> to be set.
     *
     * @param directed
     */
    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    /**
     * Returns the <code>source</code> value;
     *
     * @return xVertex
     */
    public Vertex<T> getSource() {
        return source;
    }

    /**
     * Returns true if the <code>source</code> vertex is not null otherwise false.
     *
     * @return
     */
    public boolean hasSource() {
        return (getSource() != null);
    }

    /**
     * Returns the <code>target</code> value;
     *
     * @return yVertex
     */
    public Vertex<T> getTarget() {
        return target;
    }

    /**
     * Returns true if the <code>target</code> vertex is not null otherwise false.
     *
     * @return
     */
    public boolean hasTarget() {
        return (getTarget() != null);
    }

    /**
     * Returns the <code>weight</code> value;
     *
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * The <code>weight</code> to be set.
     *
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns the string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("Edge <");
        sBuilder.append("source:").append(getSource());
        sBuilder.append(", target:").append(getTarget());
        sBuilder.append(", directed:").append(isDirected());
        sBuilder.append(", weight:").append(getWeight());
        sBuilder.append(">");
        return sBuilder.toString();
    }

    /**
     * Returns the hash-code of this object.
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return (Objects.hash(getSource(), getTarget()));
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
            Edge<?> theEdge = (Edge<?>) other;
            if (getSource() == null && theEdge.getSource() != null) {
                return false;
            }

            if (!getSource().equals(theEdge.getSource())) {
                return false;
            }

            if (getTarget() == null && theEdge.getTarget() != null) {
                return false;
            }

            if (!getTarget().equals(theEdge.getTarget())) {
                return false;
            }
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
    public int compareTo(Edge<T> other) {
        int result = getWeight() - other.getWeight();
        if (result == 0) {
        }

        return result;
    }
}

package com.devamatre.theorem.adts.graph.vertex;

import com.devamatre.appsuite.core.ToString;
import com.devamatre.theorem.adts.NumberUtils;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
@Getter
public class Edge implements Comparable<Edge> {

    private Vertex source;
    private Vertex target;
    private BigDecimal weight;
    private boolean directed;

    /**
     * @param source
     * @param target
     * @param weight
     */
    public Edge(Vertex source, Vertex target, BigDecimal weight, boolean directed) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.directed = directed;
    }

    /**
     * @param source
     * @param target
     * @param weight
     */
    public Edge(Vertex source, Vertex target, BigDecimal weight) {
        this(source, target, weight, false);
    }

    /**
     * @param source
     * @param target
     * @param directed
     */
    public Edge(Vertex source, Vertex target, boolean directed) {
        this(source, target, BigDecimal.ZERO, directed);
    }

    /**
     * @param source
     * @param target
     */
    public Edge(Vertex source, Vertex target) {
        this(source, target, null);
    }

    /**
     * @param weight
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        ToString strBuilder = ToString.of(Edge.class, true);
        // Note: - Don't add vertex, because it will create the recursion loop
        if (Objects.nonNull(getSource())) {
            strBuilder.add("source", getSource().getData());
        }
        if (Objects.nonNull(getTarget())) {
            strBuilder.add("target", getTarget().getData());
        }
        strBuilder.add("weight", getWeight());
        strBuilder.add("directed", isDirected());

        return strBuilder.toString();
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getTarget(), getWeight(), isDirected());
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Edge edge = (Edge) object;
        return Objects.equals(getSource(), edge.getSource()) && Objects.equals(getTarget(), edge.getTarget())
               && Objects.equals(getWeight(), edge.getWeight()) && Objects.equals(isDirected(), edge.isDirected());
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Edge other) {
        return NumberUtils.nullSafeGet(getWeight()).compareTo(other.getWeight());
    }

    /**
     * Returns the new <code>Edge<E></E></code> object by swapping the source and target values.
     *
     * @return
     */
    public Edge reverseEdge() {
        return new Edge(getTarget(), getSource(), getWeight(), isDirected());
    }
}

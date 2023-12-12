package com.devamatre.theorem.adts.graph;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.appsuite.core.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
@NoArgsConstructor
@Getter
@Setter
public class Edge<E extends Comparable<? super E>> implements Comparable<Edge<E>> {

    public static final EdgeComparator SORT_BY_WEIGHT = new EdgeComparator();

    private E source;
    private E target;
    private BigDecimal weight;
    private boolean directed;

    /**
     * @param source
     * @param target
     * @param weight
     */
    public Edge(E source, E target, BigDecimal weight, boolean directed) {
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
    public Edge(E source, E target, BigDecimal weight) {
        this(source, target, weight, false);
    }

    /**
     * @param source
     * @param target
     */
    public Edge(E source, E target) {
        this(source, target, BigDecimal.ZERO, false);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getTarget(), getWeight());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Edge<E> that = (Edge<E>) object;
        return Objects.equals(getSource(), that.getSource())
               && Objects.equals(getTarget(), that.getTarget())
               && Objects.equals(getWeight(), that.getWeight());
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Edge.class, true)
            .add("source", getSource())
            .add("target", getTarget())
            .add("weight", getWeight())
            .add("directed", isDirected())
            .toString();
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
     * @param edge the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Edge<E> edge) {
        int result = getSource().compareTo(edge.getSource());
        if (result == 0) {
            result = getTarget().compareTo(edge.getTarget());
            if (result == 0 && BeanUtils.isNotNull(getWeight())) {
                result = getWeight().subtract(edge.getWeight()).intValue();
            }
        }

        return result;
    }

    /**
     * Returns the new <code>Edge<E></E></code> object by swapping the source and target values.
     *
     * @return
     */
    protected Edge<E> reverseEdge() {
        return new Edge<>(getTarget(), getSource(), getWeight(), isDirected());
    }

    /**
     *
     */
    static class EdgeComparator implements Comparator<Edge> {

        /**
         * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer as the first
         * argument is less than, equal to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@code sgn(compare(x, y)) == -sgn(compare(y, x))} for all {@code x} and
         * {@code y}. (This implies that {@code compare(x, y)} must throw an exception if and only if
         * {@code compare(y, x)} throws an exception.)<p>
         * <p>
         * The implementor must also ensure that the relation is transitive:
         * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies {@code compare(x, z)>0}.<p>
         * <p>
         * Finally, the implementor must ensure that {@code compare(x, y)==0} implies that
         * {@code sgn(compare(x, z))==sgn(compare(y, z))} for all {@code z}.<p>
         * <p>
         * It is generally the case, but <i>not</i> strictly required that {@code (compare(x, y)==0) == (x.equals(y))}.
         * Generally speaking, any comparator that violates this condition should clearly indicate this fact.  The
         * recommended language is "Note: this comparator imposes orderings that are inconsistent with equals."<p>
         * <p>
         * In the foregoing description, the notation {@code sgn(}<i>expression</i>{@code )} designates the
         * mathematical
         * <i>signum</i> function, which is defined to return one of {@code -1},
         * {@code 0}, or {@code 1} according to whether the value of
         * <i>expression</i> is negative, zero, or positive, respectively.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
         * greater than the second.
         * @throws NullPointerException if an argument is null and this comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from being compared by this comparator.
         */
        @Override
        public int compare(Edge o1, Edge o2) {
            return (Objects.nonNull(o1.getWeight()) ? o1.getWeight().subtract(o2.getWeight()).intValue()
                                                    : Objects.nonNull(o2.getWeight()) ? o2.getWeight().intValue() : 0);
        }
    }
}

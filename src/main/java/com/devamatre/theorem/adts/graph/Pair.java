package com.devamatre.theorem.adts.graph;

import com.devamatre.appsuite.core.ToString;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
public class Pair<T extends Comparable> implements Comparable<Pair> {

    private T source;
    private BigDecimal weight;

    /**
     * @param source
     * @param weight
     */
    public Pair(T source, BigDecimal weight) {
        this.source = source;
        this.weight = weight;
    }

    /**
     * @return
     */
    public T getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(T source) {
        this.source = source;
    }

    /**
     * @return
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getWeight());
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

        Pair<T> that = (Pair<T>) object;
        return Objects.equals(getSource(), that.getSource()) && Objects.equals(getWeight(), that.getWeight());
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Pair.class, true)
            .add("source", getSource())
            .add("weight", Objects.toString(getWeight()))
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
     * @param pair the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Pair pair) {
        return (Objects.nonNull(getWeight()) ? getWeight().subtract(pair.getWeight()).intValue() : 0);
    }
}

package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.ToString;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 8/17/20 3:32 PM
 */
@Getter
public class PairNode<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<PairNode<K, V>> {

    private PairNode<K, V> parent;
    private K key;
    private V value;
    private PairNode<K, V> left;
    private PairNode<K, V> right;

    /**
     * @param key
     * @param value
     */
    public PairNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     *
     * @param parent
     */
    public void setParent(PairNode<K, V> parent) {
        this.parent = parent;
    }

    /**
     *
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     *
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     *
     * @param left
     */
    public void setLeft(PairNode<K, V> left) {
        this.left = left;
    }

    /**
     *
     * @param right
     */
    public void setRight(PairNode<K, V> right) {
        this.right = right;
    }

    /**
     * @return
     */
    public boolean hasLeft() {
        return Objects.nonNull(getLeft());
    }

    /**
     * @return
     */
    public boolean hasRight() {
        return Objects.nonNull(getRight());
    }

    /**
     * @return
     */
    public boolean isLeafNode() {
        return (Objects.isNull(getLeft()) && Objects.isNull(getRight()));
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(PairNode.class, true)
            .add("key", getKey())
            .add("value", getValue())
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
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(PairNode<K, V> other) {
        return (Objects.nonNull(getKey()) ? getKey().compareTo(other.getKey()) == 0 ? getValue().compareTo(
            other.getValue()) : getKey().compareTo(other.getKey()) : getValue().compareTo(other.getValue()));
    }

    /**
     * Returns true if the node value is greater than the <code>other</code> node's value otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isGreaterThan(PairNode other) {
        return (this.compareTo(other) > 0);
    }

    /**
     * Returns true if the node value is less than the <code>other</code> node's value otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isLessThan(PairNode other) {
        return (this.compareTo(other) < 0);
    }

    /**
     * Returns true if the node value is equals to the <code>other</code> node's value otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isEquals(PairNode other) {
        return (this.compareTo(other) == 0);
    }
}

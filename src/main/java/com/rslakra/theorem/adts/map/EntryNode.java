package com.rslakra.theorem.adts.map;

import lombok.Getter;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 10/16/23 3:51 PM
 */
@Getter
public class EntryNode<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<EntryNode<K, V>> {

    private EntryNode<K, V> previous;
    private K key;
    private V value;
    private EntryNode<K, V> next;

    /**
     * @param key
     * @param value
     * @param next
     */
    public EntryNode(EntryNode<K, V> previous, K key, V value, EntryNode<K, V> next) {
        this.previous = previous;
        this.key = key;
        this.value = value;
        setNext(next);
    }

    /**
     * @param key
     * @param value
     */
    public EntryNode(K key, V value) {
        this(null, key, value, null);
    }

    /**
     * @return
     */
    public boolean hasPrevious() {
        return Objects.nonNull(previous);
    }

    /**
     * @param previous
     */
    public void setPrevious(EntryNode<K, V> previous) {
        this.previous = previous;
    }

    /**
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * @return
     */
    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    /**
     * @param next
     */
    public void setNext(EntryNode<K, V> next) {
        this.next = next;
        if (Objects.nonNull(next)) {
            next.setPrevious(this);
        }
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
    public int compareTo(EntryNode<K, V> other) {
        return (Objects.nonNull(getKey()) ? getKey().compareTo(other.getKey()) == 0 ? getValue().compareTo(
            other.getValue()) : getKey().compareTo(other.getKey()) : getValue().compareTo(other.getValue()));
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s=%s", getKey(), getValue());
    }

    /**
     * Returns the string representation of this object.
     *
     * @param headNode
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<K>, V extends Comparable<V>> String toString(EntryNode<K, V> headNode) {
        StringBuilder sBuilder = new StringBuilder("[");
        EntryNode<K, V> tempNode = headNode;
        while (tempNode != null) {
            sBuilder.append(tempNode);
            if (tempNode.hasNext()) {
                sBuilder.append(", ");
            }
            tempNode = tempNode.getNext();
        }
        sBuilder.append("]");
        return sBuilder.toString();
    }
}

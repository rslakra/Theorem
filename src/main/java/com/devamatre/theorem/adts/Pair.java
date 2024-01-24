package com.devamatre.theorem.adts;

import com.devamatre.appsuite.core.ToString;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 4:59 PM
 */
public class Pair<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Comparable<Pair<K, V>> {

    private K key;
    private V value;

    /**
     * The <code>Pair</code> constructor.
     *
     * @param key
     * @param value
     */
    protected Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return
     */
    public K getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @return
     */
    public V getValue() {
        return value;
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
    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
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

        Pair<K, V> that = (Pair<K, V>) object;
        return Objects.equals(getKey(), that.getKey()) && Objects.equals(getValue(), that.getValue());
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Pair.class, true)
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
     * @param pair the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Pair<K, V> pair) {
        int result = getKey().compareTo(pair.getKey());
        return (result == 0 ? getValue().compareTo(pair.getValue()) : result);
    }

    /**
     * Returns the object of the <code>Pair</code> build of <code>K</code> and <code>V</code>.
     *
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Pair<K, V> of(K key, V value) {
        return new Pair(key, value);
    }

    /**
     * Returns the object of the <code>Pair</code> build of <code>K</code> and <code>V</code>.
     *
     * @param element
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Pair<E, E> of(E element) {
        return of(element, element);
    }

    /**
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Comparator<Pair<K, V>> naturalOrder() {
        return new PairComparator<>();
    }

    /**
     * Compares the <code>pair</code> object. The <code>keyComparator</code> and <code>valueComparator</code> are set to
     * be true by default. If either <code>keyComparator</code> or <code>valueComparator</code> is to be set, then the
     * <code>pair</code> is compared based on that property.
     */
    private static class PairComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
        implements Comparator<Pair<K, V>> {

        private boolean keyComparator;
        private boolean valueComparator;

        /**
         * @param keyComparator
         * @param valueComparator
         */
        public PairComparator(boolean keyComparator, boolean valueComparator) {
            this.keyComparator = keyComparator;
            this.valueComparator = valueComparator;
        }

        /**
         * Default Constructor.
         */
        public PairComparator() {
            this(true, true);
        }

        /**
         * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer as the first
         * argument is less than, equal to, or greater than the second.<p>
         * <p>
         * The implementor must ensure that {@code sgn(compare(x, y)) == -sgn(compare(y, x))} for all {@code x} and
         * {@code y}.  (This implies that {@code compare(x, y)} must throw an exception if and only if
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
         * @param left  the first object to be compared.
         * @param right the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
         * greater than the second.
         * @throws NullPointerException if an argument is null and this comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from being compared by this comparator.
         */
        @Override
        public int compare(Pair<K, V> left, Pair<K, V> right) {
            if (keyComparator && valueComparator && Objects.nonNull(left) && Objects.nonNull(right)) {
                int result = left.getKey().compareTo(right.getKey());
                return (result == 0 ? left.getValue().compareTo(right.getValue()) : result);
            } else if (keyComparator && Objects.nonNull(left) && Objects.nonNull(right)) {
                return left.getKey().compareTo(right.getKey());
            } else if (valueComparator && Objects.nonNull(left) && Objects.nonNull(right)) {
                return left.getValue().compareTo(right.getValue());
            } else {
                return Objects.nonNull(left) ? 1 : -1;
            }
        }
    }

    /**
     * Key Comparator of <code>left</code> and <code>right</code> values.
     */
    public static final Comparator KEY_COMPARATOR = new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> left, Pair<Integer, Integer> right) {
            return left.getKey().compareTo(right.getKey());
        }
    };

    /**
     *
     */
    public static final Comparator VALUE_COMPARATOR = new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> left, Pair<Integer, Integer> right) {
            return left.getValue().compareTo(right.getValue());
        }
    };

}

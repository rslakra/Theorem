package com.devamatre.theorem.adts.heap;

import com.devamatre.appsuite.core.ArrayIterator;
import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.AlgoUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @created 5/17/22 2:16 PM
 */
public abstract class Heap<E extends Comparable<? super E>> implements Comparable<Heap> {

    private static int DEFAULT_CAPACITY = 16;
    private Comparator<? super E> comparator;
    private int capacity;
    private Object[] data;
    private int size;

    /**
     * Creates a <code>Heap</code> with the default initial capacity (11) that orders its elements according to their
     * natural ordering.
     */
    public Heap() {
        this(DEFAULT_CAPACITY, null);
    }

    /**
     * Creates a <code>Heap</code> with the specified initial capacity that orders its elements according to their
     * natural ordering.
     *
     * @param initialCapacity
     */
    public Heap(int initialCapacity) {
        this(initialCapacity, null);
    }

    /**
     * Creates a <code>Heap</code> with the specified initial capacity that orders its elements according to the
     * specified comparator.
     *
     * @param initialCapacity
     * @param comparator
     */
    public Heap(int initialCapacity, Comparator<? super E> comparator) {
        this.capacity = initialCapacity;
        this.comparator = comparator;
        this.data = new Object[this.capacity];
        this.size = 0;
    }

    /**
     * Creates a <code>Heap</code> containing the elements in the specified collection.
     *
     * @param c
     */
    public Heap(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * Creates a <code>Heap</code> with the default initial capacity and whose elements are ordered according to the
     * specified comparator.
     *
     * @param comparator
     */
    public Heap(Comparator<? super E> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    /**
     * Creates a <code>Heap</code> containing the elements in the specified priority queue.
     *
     * @param c
     */
    public Heap(Heap<? extends E> c) {
        this();
        addAll(Arrays.stream(c.getData()).map(item -> (E) item).collect(Collectors.toList()));
    }

    /**
     * Creates a <code>Heap</code> containing the elements in the specified sorted set.
     *
     * @param c
     */
    public Heap(SortedSet<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * Returns the <code>capacity</code> of the heap.
     *
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the <code>data</code> of the <code>E[]</code>.
     *
     * @return
     */
    public Object[] getData() {
        return this.data;
    }

    /**
     * Returns the <code>size</code> of the heap.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Increases the <code>size</code> count.
     */
    protected final void increase() {
        size++;
    }

    /**
     * Decreases the <code>size</code> count.
     */
    protected final void decrease() {
        size--;
    }

    /**
     * Returns true if the size of the heap is 0 otherwise false.
     *
     * @return
     */
    public boolean isEmpty() {
        return (getSize() == 0);
    }

    /**
     *
     */
    public void checkCapacity() {
        if (getSize() >= capacity) {

        }
    }

    /**
     * Sorts the heap.
     */
    public abstract void sort();

    /**
     * Inserts the specified element into this priority queue.
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        return false;
    }

    /**
     * Adds all of the elements in the specified collection to this queue.
     *
     * @param elements
     * @return
     */
    public boolean addAll(Collection<? extends E> elements) {
        if (BeanUtils.isEmpty(elements)) {
            return false;
        }

        Object[] newElements = elements.toArray();
        final int newSize = newElements.length;
        if (newSize == 0) {
            return false;
        }

        Object[] oldElements = this.data;
        final int oldSize = getSize();
        if (elements.size() > (getCapacity() - oldSize)) {
            oldElements = AlgoUtils.growCapacity(oldElements, oldSize + newSize);
        }
        System.arraycopy(newElements, 0, oldElements, oldSize, newSize);
        size = oldSize + newSize;
        return true;
    }


    /**
     * Removes all elements from this priority queue.
     */
    public void clear() {
        final Object[] oldElements = getData();
        for (int to = size, i = size = 0; i < to; i++) {
            oldElements[i] = null;
        }
    }

    /**
     * Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the
     * natural ordering of its elements.
     *
     * @return
     */
    public Comparator<? super E> comparator() {
        return comparator;
    }

    /**
     * Returns true if this queue contains the specified element.
     *
     * @param object
     * @return
     */
    public boolean contains(E object) {
        return false;
    }

    /**
     * Performs the given action for each element of the Iterable until all elements have been processed or the action
     * throws an exception.
     *
     * @param action
     */
    public void forEach(Consumer<? super E> action) {
//        Arrays.stream(getData()).forEach(action);
    }

    /**
     * Returns an iterator over the elements in this queue.
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new ArrayIterator<>(data);
    }

    /**
     * Returns the maximum/minimum element from the queue.
     * <p>
     * The maximum/minimum (root) element resides at index 1.
     * <p>
     * Time Complexity: O(1)
     *
     * @return
     */
    public E peek() {
        return (E) getData()[0];
    }

    /**
     * Removes a single instance of the specified element from this queue, if it is present.
     *
     * @param object
     * @return
     */
    public boolean remove(E object) {
        return false;
    }

    /**
     * Removes all of this collection's elements that are also contained in the specified collection (optional
     * operation).
     *
     * @param c
     * @return
     */
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Removes all of the elements of this collection that satisfy the given predicate.
     *
     * @param filter
     * @return
     */
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    /**
     * Retains only the elements in this collection that are contained in the specified collection (optional
     * operation).
     *
     * @param c
     * @return
     */
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Returns an array containing all of the elements in this queue.
     *
     * @return
     */
    public Object[] toArray() {
        return data;
    }

    /**
     * Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of
     * the specified array.
     *
     * @param arr
     * @param <T>
     * @return
     */
    public <T> T[] toArray(T[] arr) {
        return arr;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return Arrays.toString(getData());
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
    public int compareTo(Heap other) {
        if (comparator() != null) {
            return comparator().compare((E) this, (E) other);
        }

        return ((E) this).compareTo((E) other);
    }
}

package com.devamatre.theorem.adts.heap;

import com.devamatre.appsuite.core.ArrayIterator;
import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.AlgoUtils;
import com.devamatre.theorem.adts.tree.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <url>https://www.educative.io/blog/data-structure-heaps-guide</url>
 *
 * @author Rohtash Lakra
 * @created 5/17/22 2:16 PM
 */
public abstract class Heap<E extends Comparable<? super E>> implements Comparable<E> {

    private static int DEFAULT_CAPACITY = 16;
    private Comparator<E> comparator;
    private int capacity;
    private transient Object[] queue;
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
    public Heap(int initialCapacity, Comparator<E> comparator) {
        this.capacity = initialCapacity;
        this.comparator = comparator;
        this.queue = new Object[this.capacity];
        this.size = 0;
    }

    /**
     * Creates a <code>Heap</code> containing the elements in the specified priority queue and orders its elements
     * according to the specified <code>comparator</code>.
     *
     * @param elements
     * @param comparator
     */
    private Heap(Collection<? extends E> elements, Comparator<E> comparator) {
        this(BeanUtils.isNotEmpty(elements) ? elements.size() : DEFAULT_CAPACITY, comparator);
        addAll(elements);
    }

    /**
     * Creates a <code>Heap</code> containing the elements in the specified collection.
     *
     * @param elements
     */
    public Heap(Collection<? extends E> elements) {
        this(elements, null);
    }

    /**
     * Creates a <code>Heap</code> with the default initial capacity and whose elements are ordered according to the
     * specified comparator.
     *
     * @param comparator
     */
    public Heap(Comparator<E> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    /**
     * Creates a <code>Heap</code> containing the heap in the specified priority queue.
     *
     * @param heap
     */
    public Heap(Heap<? extends E> heap) {
        initFromHeap(heap);
    }

    /**
     * Creates a <code>Heap</code> containing the elements in the specified sorted set.
     *
     * @param elements
     */
    public Heap(SortedSet<? extends E> elements) {
        this(elements, null);
    }

    /**
     * Ensures that queue[0] exists, helping peek() and poll().
     */
    private static Object[] checkNonEmpty(Object[] objects) {
        return (objects.length > 0) ? objects : new Object[1];
    }

    /**
     * Initializes the queue array from the provided collection.
     *
     * @param items
     */
    private void initFromCollection(Collection<? extends E> items, boolean heapify) {
        Object[] newQueue = items.toArray();
        int newSize = newQueue.length;
        if (items.getClass() != ArrayList.class) {
            newQueue = Arrays.copyOf(newQueue, newSize, Object[].class);
        }

        // validate the items in the new queue are non-null values
        if (newSize == 1 || Objects.nonNull(getComparator())) {
            for (Object element : newQueue) {
                if (Objects.isNull(element)) {
                    throw new NullPointerException();
                }
            }
        }

        this.queue = checkNonEmpty(newQueue);
        this.size = newSize;

        // force to heapify, when needed
        if (heapify) {
            heapify();
        }
    }

    /**
     * @param items
     */
    private void initFromCollection(Collection<? extends E> items) {
        initFromCollection(items, false);
    }

    /**
     * Initializes the queue from the heap.
     *
     * @param heap
     */
    private void initFromHeap(Heap<? extends E> heap) {
        if (heap.getClass() == Heap.class) {
            this.comparator = (Comparator<E>) heap.getComparator();
            this.queue = checkNonEmpty(heap.toArray());
            this.size = heap.getSize();
        } else {
            final List<E>
                elements =
                Arrays.stream(heap.getQueue()).map(entry -> (E) entry).collect(Collectors.toList());
            initFromCollection(elements);
        }
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
    public Object[] getQueue() {
        return this.queue;
    }

    /**
     * Returns the object at <code>index</code>.
     *
     * @param index
     * @return
     */
    private E getDataAt(int index) {
        return (E) getQueue()[index];
    }

    /**
     * The <code>E</code> element to be set at <code>index</code>.
     *
     * @param index
     * @param element
     */
    private void setDataAt(int index, E element) {
        if (isValidIndex(index)) {
            queue[index] = element;
        }
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
     * Inserts the specified <code>element</code> into this priority queue.
     *
     * @param element
     * @return
     */
    public boolean add(E element) {
        return addAll(Arrays.asList(element));
    }

    /**
     * Adds all elements in the specified collection to this queue.
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

        Object[] oldElements = this.queue;
        final int oldSize = getSize();
        if (elements.size() > (getCapacity() - oldSize)) {
            oldElements = AlgoUtils.growCapacity(oldElements, oldSize + newSize);
        }
        System.arraycopy(newElements, 0, oldElements, oldSize, newSize);
        size = oldSize + newSize;

        heapify();

        return true;
    }

    /**
     * Builds the min or max heap based on the comparator.
     */
    private void heapify() {
        if (Objects.isNull(getComparator())) {
            buildMinHeap();
        } else {
            buildMaxHeap();
        }
    }

    /**
     * Removes all elements from this priority queue.
     */
    public void clear() {
        final Object[] oldElements = getQueue();
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
    public Comparator<? super E> getComparator() {
        return comparator;
    }

    /**
     * Returns true if this queue contains the specified <code>element</code>.
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return false;
    }

    /**
     * Performs the given action for each element of the Iterable until all elements have been processed or the action
     * throws an exception.
     *
     * @param action
     */
    public void forEach(Consumer<? super E> action) {
// Arrays.stream(getData()).forEach(action);
    }

    /**
     * Returns an iterator over the elements in this queue.
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new ArrayIterator<>(queue);
    }

    /**
     * Returns the maximum/minimum <code>element</code> from the queue.
     * <p>
     * The maximum/minimum (root) <code>element</code> resides at index 1.
     * <p>
     * Time Complexity: O(1)
     *
     * @return
     */
    public E peek() {
        return (E) (isEmpty() ? null : getQueue()[0]);
    }

    /**
     * Removes a single instance of the specified <code>element</code> from this queue, if it is present.
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
     * @param elements
     * @return
     */
    public boolean removeAll(Collection<?> elements) {
        return false;
    }

    /**
     * Removes all the elements of this collection that satisfy the given predicate.
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
     * @param elements
     * @return
     */
    public boolean retainAll(Collection<?> elements) {
        return false;
    }

    /**
     * Returns an array containing all the elements in this queue.
     *
     * @return
     */
    public Object[] toArray() {
        return queue;
    }

    /**
     * Returns an array containing all the elements in this queue; the runtime type of the returned array is that of the
     * specified array.
     *
     * @param elements
     * @param <T>
     * @return
     */
    public <T> T[] toArray(T[] elements) {
        return elements;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return Arrays.toString(getQueue());
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
    public int compareTo(E other) {
        if (Objects.nonNull(getComparator())) {
            return getComparator().compare((E) this, other);
        }

        return ((E) this).compareTo(other);
    }

    /**
     * Utility Methods
     */

    /**
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private int compareIndices(int leftIndex, int rightIndex) {
        if (Objects.isNull(getComparator())) {
            return getDataAt(leftIndex).compareTo(getDataAt(rightIndex));
        } else {
            return getComparator().compare(getDataAt(leftIndex), getDataAt(rightIndex));
        }
    }

    /**
     * Returns true if the index is valid for the <code>data</code> array.
     *
     * @param index
     * @return
     */
    private boolean isValidIndex(int index) {
        return (index >= 0 && index < getSize());
    }

    /**
     * Swaps the <code>source</code> index value with the <code>target</code> index value.
     *
     * @param source
     * @param target
     */
    protected void swapElements(int source, int target) {
        if (isValidIndex(source) && isValidIndex(target)) {
            E temp = getDataAt(source);
            setDataAt(source, getDataAt(target));
            setDataAt(target, temp);
        }
    }

    /**
     * Max Heap Utility Methods
     */

    /**
     * It maintains the property of max heap (i.e. each element value should be greater than or equal to any of its
     * child and smaller than or equal to its parent)
     * <p>
     * Time Complexity: O(log N)
     * <p>
     * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial
     * <p>
     * Steps:
     * <pre>
     *  1. Shift down A[i] in A[1 .. N]
     *  2. Get Left node index
     *  3. Get Right node index
     *  4. max key index equals to current index
     *  5. if leftIndex < size and leftIndex > index, assign largest = leftIndex
     *  5. if rightIndex < size and rightIndex < largest, assign largest = rightIndex
     *  6. if largest != index, then
     *  6.1. Swap A[index] with A[largest]
     *  6.2. maxHeapify(A, largest, size)
     * </pre>
     * <p>
     *
     * @param index
     * @param size
     */
    protected void maxHeapify(int index, int size) {
        int leftIndex = TreeUtils.leftNodeIndex(index);     // left child
        int rightIndex = TreeUtils.rightNodeIndex(index);   // right child
        int largest = index;    // largest/max key index
        // check left child
        if (leftIndex <= size && compareIndices(leftIndex, largest) == 1) {
            largest = leftIndex;
        }

        // check right child
        if (rightIndex <= size && compareIndices(rightIndex, largest) == 1) {
            largest = rightIndex;
        }

        //swap elements, if needed
        if (largest != index) {
            swapElements(index, largest);
            maxHeapify(largest, size);
        }
    }

    /**
     * Note: An array can be used to simulate a tree in the following way.
     * <p>
     * If we are storing one element at index ```i``` in array ```arr```,then its parent will be stored at index
     * ```i/2``` (unless it's a root, as root has no parent) and can be accessed by arr[i/2], and its left child can be
     * accessed by arr[2 * i] and its right child can be accessed by arr[2 * i + 1]. Index of root will be 1 in an
     * array.
     * <p>
     * Time Complexity: <code>O(N)</code>
     */
    protected void buildMaxHeap() {
        for (int i = getSize() / 2; i >= 0; i--) {
            maxHeapify(i, getSize() - 1);
        }
    }

    /**
     * Initially we will build a max heap of elements in an ```arr```.
     * <p>
     * Now the root element that is ```arr[1]``` contains maximum element of ```arr```. After that, we will exchange
     * this element with the last element of and will again build a max heap excluding the last element which is already
     * in its correct position and will decrease the length of heap by one.
     * <p>
     * We will repeat the step 2, until we get all the elements in their correct position.
     * <p>
     * We will get a sorted array.
     * <p>
     * Time Complexity: O(N log N)
     */
    protected void heapSortAsc() {
        int heapSize = getSize() - 1;
        buildMaxHeap();
        for (int i = heapSize; i >= 1; i--) {
            swapElements(0, i);
            heapSize--;
            maxHeapify(0, heapSize);
        }
    }

    /**
     * Min Heap Utility Methods
     */

    /**
     * It maintains the property of max heap (i.e. each element value should be less than or equal to any of its child
     * and larger than or equal to its parent)
     * <p>
     * Time Complexity: O(log N)
     * <p>
     * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial
     *
     * @param index
     * @param size
     */
    protected void minHeapify(int index, int size) {
        int leftIndex = TreeUtils.leftNodeIndex(index);     // left child
        int rightIndex = TreeUtils.rightNodeIndex(index);   // right child
        int smallest = index;    // smallest/min key index

        // check left child
        if (leftIndex <= size && compareIndices(leftIndex, smallest) == -1) {
            smallest = leftIndex;
        }

        // check right child
        if (rightIndex <= size && compareIndices(rightIndex, smallest) == -1) {
            smallest = rightIndex;
        }

        //swap elements, if needed
        if (smallest != index) {
            swapElements(index, smallest);
            minHeapify(smallest, size);
        }
    }

    /**
     * Note: An array can be used to simulate a tree in the following way.
     * <p>
     * If we are storing one element at index ```i``` in array ```arr```,then its parent will be stored at index
     * ```i/2``` (unless it's a root, as root has no parent) and can be accessed by arr[i/2], and its left child can be
     * accessed by arr[2 * i] and its right child can be accessed by arr[2 * i + 1]. Index of root will be 1 in an
     * array.
     * <p>
     * Time Complexity: <code>O(N)</code>
     */
    protected void buildMinHeap() {
        for (int i = getSize() / 2; i >= 0; i--) {
            minHeapify(i, getSize() - 1);
        }
    }

    /**
     * Initially we will build a max heap of elements in an ```arr```.
     * <p>
     * Now the root element that is ```arr[1]``` contains maximum element of ```arr```. After that, we will exchange
     * this element with the last element of and will again build a max heap excluding the last element which is already
     * in its correct position and will decrease the length of heap by one.
     * <p>
     * We will repeat the step 2, until we get all the elements in their correct position.
     * <p>
     * We will get a sorted array.
     * <p>
     * Time Complexity: O(N log N)
     */
    protected void heapSortDesc() {
        int heapSize = getSize() - 1;
        buildMinHeap();
        for (int i = heapSize; i >= 1; i--) {
            swapElements(0, i);
            heapSize--;
            minHeapify(0, heapSize);
        }
    }

}

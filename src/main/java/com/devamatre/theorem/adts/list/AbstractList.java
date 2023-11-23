package com.devamatre.theorem.adts.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Rohtash Lakra
 * @created 5/20/22 11:53 AM
 */
public abstract class AbstractList<E extends Comparable<? super E>> implements List<E>, Comparable<E> {

    private int size;

    /**
     * Returns the number of elements in this list.  If this list contains more than {@code Integer.MAX_VALUE} elements,
     * returns {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the number of elements in this list.  If this list contains more than {@code Integer.MAX_VALUE} elements,
     * returns {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return getSize();
    }

    /**
     * Increments the size of the list by 1.
     */
    protected void incrementSize() {
        size++;
    }

    /**
     * Decrements the size of the list by 1.
     */
    protected void decrementSize() {
        size--;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return (getSize() == 0);
    }

    /**
     * Returns {@code true} if this list contains the specified element. More formally, returns {@code true} if and only
     * if this list contains at least one element {@code e} such that {@code Objects.equals(object, e)}.
     *
     * @param other element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element is incompatible with this list (<a
     *                              href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this list does not permit null elements (<a
     *                              href="Collection.html#optional-restrictions">optional</a>)
     */
    public boolean contains(Object other) {
        return false;
    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some lists will refuse to add null elements, and others will
     * impose restrictions on the type of elements that may be added.  List classes should clearly specify in their
     * documentation any restrictions on what elements may be added.
     *
     * @param t element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the {@code add} operation is not supported by this list
     * @throws ClassCastException            if the class of the specified element prevents it from being added to this
     *                                       list
     * @throws NullPointerException          if the specified element is null and this list does not permit null
     *                                       elements
     * @throws IllegalArgumentException      if some property of this element prevents it from being added to this list
     */
    public boolean add(E t) {
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present (optional operation).  If
     * this list does not contain the element, it is unchanged.  More formally, removes the element with the lowest
     * index {@code i} such that {@code Objects.equals(object, get(i))} (if such an element exists).  Returns
     * {@code true} if this list contained the specified element (or equivalently, if this list changed as a result of
     * the call).
     *
     * @param object element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element is incompatible with this list (<a
     *                                       href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified element is null and this list does not permit null
     *                                       elements (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the {@code remove} operation is not supported by this list
     */
    public boolean remove(Object object) {
        return false;
    }

    /**
     * Returns {@code true} if this list contains all the elements of the specified collection.
     *
     * @param objects collection to be checked for containment in this list
     * @return {@code true} if this list contains all the elements of the specified collection
     * @throws ClassCastException   if the types of one or more elements in the specified collection are incompatible
     *                              with this list (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one or more null elements and this list does
     *                              not permit null elements (<a
     *                              href="Collection.html#optional-restrictions">optional</a>), or if the specified
     *                              collection is null
     * @see #contains(Object)
     */
    public boolean containsAll(Collection<?> objects) {
        return false;
    }

    /**
     * Appends all the elements in the specified collection to the end of this list, in the order that they are returned
     * by the specified collection's iterator (optional operation).  The behavior of this operation is undefined if the
     * specified collection is modified while the operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param collection collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified collection prevents it from
     *                                       being added to this list
     * @throws NullPointerException          if the specified collection contains one or more null elements and this
     *                                       list does not permit null elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the specified collection prevents it from
     *                                       being added to this list
     * @see #addAll(Collection)
     */
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    /**
     * Inserts all the elements in the specified collection into this list at the specified position (optional
     * operation).  Shifts the element currently at that position (if any) and any subsequent elements to the right
     * (increases their indices).  The new elements will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is undefined if the specified collection is
     * modified while the operation is in progress.  (Note that this will occur if the specified collection is this
     * list, and it's nonempty.)
     *
     * @param index index at which to insert the first element from the specified collection
     * @param c     collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code addAll} operation is not supported by this list
     * @throws ClassCastException            if the class of an element of the specified collection prevents it from
     *                                       being added to this list
     * @throws NullPointerException          if the specified collection contains one or more null elements and this
     *                                       list does not permit null elements, or if the specified collection is null
     * @throws IllegalArgumentException      if some property of an element of the specified collection prevents it from
     *                                       being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index > size()})
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code removeAll} operation is not supported by this list
     * @throws ClassCastException            if the class of an element of this list is incompatible with the specified
     *                                       collection (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the specified collection does not
     *                                       permit null elements (<a
     *                                       href="Collection.html#optional-restrictions">optional</a>), or if the
     *                                       specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Removes all the elements from this list (optional operation). The list will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation is not supported by this list
     */
    public void clear() {
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >= size()})
     */
    public E get(int index) {
        return null;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code set} operation is not supported by this list
     * @throws ClassCastException            if the class of the specified element prevents it from being added to this
     *                                       list
     * @throws NullPointerException          if the specified element is null and this list does not permit null
     *                                       elements
     * @throws IllegalArgumentException      if some property of the specified element prevents it from being added to
     *                                       this list
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index >= size()})
     */
    public E set(int index, E element) {
        return null;
    }

    /**
     * Inserts the specified element at the specified position in this list (optional operation).  Shifts the element
     * currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws UnsupportedOperationException if the {@code add} operation is not supported by this list
     * @throws ClassCastException            if the class of the specified element prevents it from being added to this
     *                                       list
     * @throws NullPointerException          if the specified element is null and this list does not permit null
     *                                       elements
     * @throws IllegalArgumentException      if some property of the specified element prevents it from being added to
     *                                       this list
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index > size()})
     */
    public void add(int index, E element) {

    }

    /**
     * Removes the element at the specified position in this list (optional operation).  Shifts any subsequent elements
     * to the left (subtracts one from their indices).  Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the {@code remove} operation is not supported by this list
     * @throws IndexOutOfBoundsException     if the index is out of range ({@code index < 0 || index >= size()})
     */
    public E remove(int index) {
        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not
     * contain the element. More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(object, get(i))}, or -1 if there is no such index.
     *
     * @param object element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not
     * contain the element
     * @throws ClassCastException   if the type of the specified element is incompatible with this list (<a
     *                              href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this list does not permit null elements (<a
     *                              href="Collection.html#optional-restrictions">optional</a>)
     */
    public int indexOf(Object object) {
        return 0;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not
     * contain the element. More formally, returns the highest index {@code i} such that
     * {@code Objects.equals(object, get(i))}, or -1 if there is no such index.
     *
     * @param object element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not
     * contain the element
     * @throws ClassCastException   if the type of the specified element is incompatible with this list (<a
     *                              href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this list does not permit null elements (<a
     *                              href="Collection.html#optional-restrictions">optional</a>)
     */
    public int lastIndexOf(Object object) {
        return 0;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a list iterator over the elements in this list (in proper sequence)
     */
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position
     * in the list. The specified index indicates the first element that would be returned by an initial call to
     * {@link ListIterator#next next}. An initial call to {@link ListIterator#previous previous} would return the
     * element with the specified index minus one.
     *
     * @param index index of the first element to be returned from the list iterator (by a call to
     *              {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper sequence), starting at the specified position
     * in the list
     * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index > size()})
     */
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * Returns a view of the portion of this list between the specified {@code fromIndex}, inclusive, and
     * {@code toIndex}, exclusive.  (If {@code fromIndex} and {@code toIndex} are equal, the returned list is empty.)
     * The returned list is backed by this list, so non-structural changes in the returned list are reflected in this
     * list, and vice-versa. The returned list supports all the optional list operations supported by this list.<p>
     * <p>
     * This method eliminates the need for explicit range operations (of the sort that commonly exist for arrays).  Any
     * operation that expects a list can be used as a range operation by passing a subList view instead of a whole list.
     * For example, the following idiom removes a range of elements from a list:
     * <pre>{@code
     *      list.subList(from, to).clear();
     * }</pre>
     * Similar idioms may be constructed for {@code indexOf} and {@code lastIndexOf}, and all the algorithms in the
     * {@code Collections} class can be applied to a subList.<p>
     * <p>
     * The semantics of the list returned by this method become undefined if the backing list (i.e., this list) is
     * <i>structurally modified</i> in any way other than via the returned list.  (Structural modifications are those
     * that change the size of this list, or otherwise perturb it in such a fashion that iterations in progress may
     * yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *                                   ({@code fromIndex < 0 || toIndex > size || fromIndex > toIndex})
     */
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
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
        return 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate a new array even if this list is backed by
     * an array). The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all the elements in this list in proper sequence
     * @see java.util.Arrays#asList(Object[])
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence (from first to last element); the
     * runtime type of the returned array is that of the specified array.  If the list fits in the specified array, it
     * is returned therein.  Otherwise, a new array is allocated with the runtime type of the specified array and the
     * size of this list.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array immediately following the end of the list is
     * set to {@code null}. (This is useful in determining the length of the list <i>only</i> if the caller knows that
     * the list does not contain any null elements.)
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows precise control over the runtime type of the
     * output array, and may, under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose {@code x} is a list known to contain only strings.
     * The following code can be used to dump the list into a newly allocated array of {@code String}:
     *
     * <pre>{@code
     *     String[] y = x.toArray(new String[0]);
     * }</pre>
     * <p>
     * Note that {@code toArray(new Object[0])} is identical in function to {@code toArray()}.
     *
     * @param a the array into which the elements of this list are to be stored, if it is big enough; otherwise, a new
     *          array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     * @throws ArrayStoreException  if the runtime type of the specified array is not a supertype of the runtime type of
     *                              every element in this list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection (optional operation).  In
     * other words, removes from this list all of its elements that are not contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws UnsupportedOperationException if the {@code retainAll} operation is not supported by this list
     * @throws ClassCastException            if the class of an element of this list is incompatible with the specified
     *                                       collection (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the specified collection does not
     *                                       permit null elements (<a
     *                                       href="Collection.html#optional-restrictions">optional</a>), or if the
     *                                       specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


}

package com.devamatre.theorem.adts.iterator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Rohtash Lakra
 * @created 3/25/21 3:44 PM
 */
public final class UniqueIterator<E> implements Iterator<E> {

    private final Iterator<E> delegate;
    private final Set<E> visited;
    private boolean exhausted;
    private E next;

    /**
     * @param delegate
     * @param comparator
     */
    private UniqueIterator(final Iterator<E> delegate, final Comparator<E> comparator) {
        this.delegate = delegate;
        this.visited = new TreeSet(comparator);
        this.moveToNext();
    }

    /**
     * @return
     */
    public boolean isExhausted() {
        return exhausted;
    }

    /**
     *
     */
    private void moveToNext() {
        boolean hasNext = false;
        while (!hasNext && hasNext()) {
            this.exhausted = !this.delegate.hasNext();
            if (hasNext()) {
                this.next = this.delegate.next();
                hasNext = this.visited.add(this.next);
            }
        }
    }

    /**
     * Returns true if the <code>exhausted</code> is set to be false otherwise false.
     *
     * @return
     */
    public boolean hasNext() {
        return !this.exhausted;
    }

    /**
     * Return the next element if available otherwise throws the <code>NoSuchElementException</code> exception.
     *
     * @return
     */
    public E next() {
        if (hasNext()) {
            E result = this.next;
            this.moveToNext();
            return result;
        }

        throw new NoSuchElementException();
    }

    /**
     * Removes the element if available otherwise throws the <code>NoSuchElementException</code> exception.
     */
    public void remove() {
        if (hasNext()) {
            this.delegate.remove();
        }

        throw new NoSuchElementException();
    }
}

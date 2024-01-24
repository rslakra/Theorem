package com.devamatre.theorem.adts.time;

import com.devamatre.appsuite.core.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 6:55 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interval<E extends Comparable<? super E>> implements Comparable<Interval<E>> {

    private E start;
    private E end;


    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
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

        Interval<E> that = (Interval<E>) object;
        return Objects.equals(getStart(), that.getStart()) && Objects.equals(getEnd(), that.getEnd());
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(Interval.class, true).add("start", getStart()).add("end", getEnd()).toString();
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
     * @param interval the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(Interval<E> interval) {
        int result = getStart().compareTo(interval.getStart());
        return (result == 0 ? getEnd().compareTo(interval.getEnd()) : result);
    }

    /**
     * @param start
     * @param end
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Interval<E> of(E start, E end) {
        return new Interval<>(start, end);
    }

    /**
     * Returns true if the <code>left</code> interval overlaps with the <code>right</code> interval otherwise false.
     *
     * @param left
     * @param right
     * @return
     */
    public boolean overlaps(final Interval left, final Interval right) {
        // it covers the coordinates [(2,5), (3,6)] and [(2,5), (3,4)]
        if (right.getStart().compareTo(left.getStart()) > 0 && (left.getEnd().compareTo(right.getStart()) > 0
                                                                || left.getEnd().compareTo(right.getEnd()) > 0)) {
            return true;
        } else if (left.getStart().compareTo(right.getStart()) > 0 && (right.getEnd().compareTo(left.getStart()) > 0
                                                                       || right.getEnd().compareTo(left.getEnd())
                                                                          > 0)) {
            // it covers the coordinates [(2,5), (3,6)] and [(2,5), (3,4)]
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if the current interval overlaps with the <code>other</code> interval otherwise false.
     *
     * @param other
     * @return
     */
    public boolean overlaps(final Interval other) {
        return overlaps(this, other);
    }

    /**
     * Returns the merged interval if the <code>left</code> interval overlaps with the <code>right</code> interval.
     * Otherwise returns the <code>right</code> interval.
     *
     * @param left
     * @param right
     * @return
     */
    public final Interval merge(final Interval left, final Interval right) {
        // it covers the coordinates [(1,3),(2,4),(5,8), (6,9)]
        final Interval merged = new Interval();
        merged.setStart(left.getStart().compareTo(right.getStart()) < 0 ? left.getStart() : right.getStart());
        merged.setEnd(left.getEnd().compareTo(right.getEnd()) < 0 ? right.getEnd() : left.getEnd());
        return merged;
    }

    /**
     * Merges the coordinates [(1,3),(2,4)]
     *
     * @param other
     * @return
     */
    public Interval merge(final Interval other) {
        return merge(this, other);
    }

    /**
     * @param intervals
     */
    public void checkOverlaps(final List<Interval<Integer>> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval<Integer> node = intervals.get(i);
                Interval<Integer> next = intervals.get(j);
                System.out.println("node:" + node + ", next:" + next + ", overlaps:" + node.overlaps(next));
            }
        }
    }

    /**
     * Merge interval
     */
    public static void checkMerged() {
        Interval<Integer> left = Interval.of(1, 4);
        Interval<Integer> right = Interval.of(2, 5);
        Interval<Integer> merged = left.merge(right);
        System.out.println("merged: " + merged + " from left:" + left + ", right: " + right);
        System.out.println();

        left = Interval.of(1, 6);
        right = Interval.of(3, 4);
        merged = left.merge(right);
        System.out.println("merged: " + merged + " from left:" + left + ", right: " + right);
        System.out.println();

        left = Interval.of(2, 4);
        right = Interval.of(1, 5);
        merged = left.merge(right);
        System.out.println("merged: " + merged + " from left:" + left + ", right: " + right);
        System.out.println();

        left = Interval.of(2, 7);
        right = Interval.of(1, 5);
        merged = left.merge(right);
        System.out.println("merged: " + merged + " from left:" + left + ", right: " + right);
        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
// // [[6, 7],[2, 4],[8, 12]]
// List<Interval<Integer>> intervals = Arrays.asList(Interval.of(6, 7), Interval.of(2, 4), Interval.of(7, 8));
// intervals.forEach(System.out::println);
// checkOverlaps(intervals);
// System.out.println();
//
// // [[1, 4],[2, 5],[7, 9]]
// intervals = Arrays.asList(Interval.of(1, 4), Interval.of(2, 5), Interval.of(7, 8), Interval.of(6, 8), Interval.of(8, 9));
// intervals.forEach(System.out::println);
// checkOverlaps(intervals);
        checkMerged();
    }
}

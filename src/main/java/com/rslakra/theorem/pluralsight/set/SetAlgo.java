/**
 *
 */
package com.rslakra.theorem.pluralsight.set;

import java.util.HashSet;

/**
 * Set theory begins with a fundamental binary relation between an object o and a set A. If o is a member (or element)
 * of A, the notation o ∈ A is used. Since sets are objects, the membership relation can relate sets as well.
 * <p>
 * A derived binary relation between two sets is the subset relation, also called set inclusion. If all the members of
 * set A are also members of set B, then A is a subset of B, denoted A ⊆ B. For example, {1, 2} is a subset of {1, 2, 3}
 * , and so is {2} but {1, 4} is not. As insinuated from this definition, a set is a subset of itself. For cases where
 * this possibility is unsuitable or would make sense to be rejected, the term proper subset is defined. A is called a
 * proper subset of B if and only if A is a subset of B, but A is not equal to B. Note also that 1, 2, and 3 are members
 * (elements) of the set {1, 2, 3} but are not subsets of it; and in turn, the subsets, such as {1}, are not members of
 * the set {1, 2, 3}.
 *
 * @author Rohtash Lakra
 */
public final class SetAlgo<E> extends HashSet<E> {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public SetAlgo() {
        super();
    }

    /**
     * @param other
     */
    public SetAlgo(SetAlgo<E> other) {
        super(other);
    }

    /**
     * Returns the list of items, which are unique in 2 sets.
     * <p>
     * For example: [1, 2, 3] union [3, 4, 5] results to [1, 2, 3, 4, 5]
     * <p>
     * Union of the sets A and B, denoted A ∪ B, is the set of all objects that are a member of A, or B, or both. The
     * union of {1, 2, 3} and {2, 3, 4} is the set {1, 2, 3, 4} .
     *
     * @param other
     * @return
     */
    public SetAlgo<E> union(SetAlgo<E> other) {
        SetAlgo<E> allItems = new SetAlgo<>(this);
        allItems.addAll(other);
        return allItems;
    }

    /**
     * Returns the list of items, which are common in 2 sets.
     * <p>
     * For example: [1, 2, 3] union [3, 4, 5] results to [3]
     * <p>
     * <p>
     * Intersection of the sets A and B, denoted A ∩ B, is the set of all objects that are members of both A and B. The
     * intersection of {1, 2, 3} and {2, 3, 4} is the set {2, 3} .
     *
     * @param other
     * @return
     */
    public SetAlgo<E> intersection(SetAlgo<E> other) {
        SetAlgo<E> allItems = new SetAlgo<>();
        for (E item : other) {
            if (this.contains(item)) {
                allItems.add(item);
            }
        }

        return allItems;
    }

    /**
     * Returns the list of items of 1st set, which are not in 2nd sets.
     * <p>
     * For example: [1, 2, 3] union [3, 4, 5] results to [1, 2]
     * <p>
     * Set difference of U and A, denoted U \ A, is the set of all members of U that are not members of A. The set
     * difference {1, 2, 3} \ {2, 3, 4} is {1} , while, conversely, the set difference {2, 3, 4} \ {1, 2, 3} is {4} .
     * When A is a subset of U, the set difference U \ A is also called the complement of A in U. In this case, if the
     * choice of U is clear from the context, the notation Ac is sometimes used instead of U \ A, particularly if U is a
     * universal set as in the study of Venn diagrams.
     *
     * @param other
     * @return
     */
    public SetAlgo<E> setDifference(SetAlgo<E> other) {
        SetAlgo<E> allItems = new SetAlgo<>(this);
        for (E item : other) {
            if (allItems.contains(item)) {
                allItems.remove(item);
            }
        }

        return allItems;
    }

    /**
     * Returns the list of items, which are not common in 2 sets, say difference of union and intersection.
     * <p>
     * For example: [1, 2, 3] union [2, 3, 4] results to [1, 4]
     *
     * <pre>
     * Symmetric Difference = Union - Intersection
     * [1, 4] = [1, 2, 3, 4] - [2, 3]
     *
     * </pre>
     * <p>
     * <p>
     * Symmetric difference of sets A and B, denoted A △ B or A ⊖ B, is the set of all objects that are a member of
     * exactly one of A and B (elements which are in one of the sets, but not in both). For instance, for the sets {1,
     * 2, 3} and {2, 3, 4} , the symmetric difference set is {1, 4} . It is the set difference of the union and the
     * intersection, (A ∪ B) \ (A ∩ B) or (A \ B) ∪ (B \ A).
     *
     * @param other
     * @return
     * @see https://en.wikipedia.org/wiki/Set_theory
     */
    public SetAlgo<E> symmetricDifference(SetAlgo<E> other) {
        SetAlgo<E> allItems = union(other);
        SetAlgo<E> commonItems = intersection(other);
        return allItems.setDifference(commonItems);
    }

    /**
     * Cartesian product of A and B, denoted A × B, is the set whose members are all possible ordered pairs (a, b) where
     * a is a member of A and b is a member of B. The cartesian product of {1, 2} and {red, white} is {(1, red), (1,
     * white), (2, red), (2, white)}.
     *
     * @param other
     * @return
     */
    public SetAlgo<E> cartesionProduct(SetAlgo<E> other) {
        return other;
    }

    /**
     * Power set of a set A is the set whose members are all of the possible subsets of A. For example, the power set of
     * {1, 2} is { {}, {1}, {2}, {1, 2} } .
     *
     * @param other
     * @return
     */
    public SetAlgo<E> powerSet() {
        return this;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SetAlgo<String> menSet = new SetAlgo<>();
        menSet.add("Rohtash");
        menSet.add("Harsh");
        menSet.add("Anuj");
        menSet.add("Ankit");
        menSet.add("Sandeep");
        System.out.println("Men Set: " + menSet);
        System.out.println();

        SetAlgo<String> womenSet = new SetAlgo<>();
        womenSet.add("Sangita");
        womenSet.add("Anju");
        womenSet.add("Anitha");
        womenSet.add("Meenu");
        womenSet.add("Sandy");
        System.out.println("Women Set: " + womenSet);
        System.out.println();

        SetAlgo<String> readingSet = new SetAlgo<>();
        readingSet.add("Rohtash");
        readingSet.add("Harsh");
        readingSet.add("Anuj");
        readingSet.add("Sangita");
        readingSet.add("Anju");
        readingSet.add("Anitha");
        System.out.println("Reading Set: " + readingSet);
        System.out.println();

        SetAlgo<String> writingSet = new SetAlgo<>();
        writingSet.add("Anuj");
        writingSet.add("Ankit");
        writingSet.add("Sandeep");
        writingSet.add("Meenu");
        writingSet.add("Sandy");
        System.out.println("Writing Set: " + writingSet);
        System.out.println();

        SetAlgo<String> mathSet = new SetAlgo<>();
        mathSet.add("Harsh");
        mathSet.add("Rohtash");
        mathSet.add("Anitha");
        mathSet.add("Anju");
        System.out.println("Math Set: " + mathSet);
        System.out.println();

        System.out.println("All Students:" + menSet.union(womenSet));
        System.out.println("Women, who takes math:" + womenSet.intersection(mathSet));
        System.out.println("Men, who are taking reading:" + menSet.intersection(readingSet));
        System.out.println("Women, who are taking reading:" + womenSet.intersection(readingSet));
        System.out.println("Who are taking reading and writing:" + readingSet.intersection(writingSet));
        System.out.println(
            "Who are taking reading or writing, but not the both:" + readingSet.symmetricDifference(writingSet));
        System.out.println("Who are taking reading but not writing:" + readingSet.setDifference(writingSet));

    }

}

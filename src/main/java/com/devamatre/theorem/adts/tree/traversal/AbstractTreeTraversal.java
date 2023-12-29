package com.devamatre.theorem.adts.tree.traversal;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeTraversal;
import com.devamatre.theorem.adts.tree.TreeType;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Iterator is the API interface. A class which implements Iterator should implement three methods
 * <p>
 * boolean hasNext() - Returns true if the iteration has more elements. Object next() - Returns the next element in the
 * iteration. void remove() - (optional operation) Removes from the underlying collection the last element returned by
 * next().
 * <p>
 * We implement a pre-order traversal by adding a new method iterator to the BSTree class. This method returns an
 * iterator over the nodes of a binary tree in pre-order.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public abstract class AbstractTreeTraversal<E extends Comparable<? super E>> implements TreeTraversal<E> {

    private TraversalMode traversalMode;
    // node to be iterated.
    protected Node<E> rootNode;
    // stack
    protected Stack<Node<E>> stack = new Stack<>();

    /**
     * @param rootNode
     */
    protected AbstractTreeTraversal(TraversalMode traversalMode, Node<E> rootNode) {
        this.traversalMode = traversalMode;
        this.rootNode = rootNode;
        // in case of BFS no need to fill the stack
        if (Objects.nonNull(this.rootNode) && !TraversalMode.isLevelOrderTraversal(traversalMode)) {
            pushLeft(this.rootNode);
        }
    }

    /**
     * Returns the <code>TraversalMode</code> of the tree parser.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @return
     */
    @Override
    public TraversalMode getTraversalMode() {
        return traversalMode;
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return
     */
    protected boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes the left nodes to stack.
     *
     * @param node
     */
    public abstract void pushLeft(Node<E> node);

    /**
     * Traverses the tree in the <code>TraversalMode</code> traversal.
     *
     * @param rootNode
     * @param includeNullLeafs
     * @return
     */
    public abstract List<Node<E>> traverseNodes(Node<E> rootNode, boolean includeNullLeafs);

    /**
     * Traverses the <code>treeType</code> tree with the provided <code>includeNullLeafs</code> in the
     * <code>TraversalMode</code> traversal.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @param includeNullLeafs
     * @return
     */
    @Override
    public List<Node<E>> traverseNodes(boolean includeNullLeafs) {
        return traverseNodes(rootNode, includeNullLeafs);
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return traverseNodes(false).toString();
    }
}

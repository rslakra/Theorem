package com.rslakra.theorem.adts.tree;

import com.rslakra.theorem.adts.tree.iterator.InOrderIterator;
import com.rslakra.theorem.adts.tree.iterator.LevelOrderIterator;
import com.rslakra.theorem.adts.tree.iterator.PostOrderIterator;
import com.rslakra.theorem.adts.tree.iterator.PreOrderIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 5/17/22 2:05 PM
 */
public abstract class AbstractTree<E extends Comparable<? super E>>
    implements TreeIterator<E>, Iterable<E>, Comparable<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTree.class);

    private final boolean allowDuplicates;
    private Node<E> root;
    private int size;

    /**
     * Helps to handle if the binary tree allows duplicates or not.
     * <p>
     * By default, this binary search tree allows duplicates.
     *
     * @param allowDuplicates
     */
    public AbstractTree(boolean allowDuplicates) {
        super();
        this.allowDuplicates = allowDuplicates;
        clear();
    }

    /**
     * Helps to handle if the binary tree allows duplicates or not.
     * <p>
     * By default, this binary search tree allows duplicates.
     */
    public AbstractTree() {
        this(true);
    }

    /**
     * Return the <code>allowDuplicates</code> value.
     *
     * @return
     */
    public boolean isAllowDuplicates() {
        return allowDuplicates;
    }

    /**
     * Returns the <code>root</code> node.
     *
     * @return
     */
    public Node<E> getRoot() {
        return root;
    }

    /**
     * The <code>root</code> to be set.
     *
     * @param root
     */
    protected final void setRoot(Node<E> root) {
        this.root = root;
        if (root != null) {
            this.root.setParent(null);
        }
    }

    /**
     * Decreases the size by 1.
     */
    protected void increaseSize(int size) {
        LOGGER.debug("+increaseSize({})", size);
        this.size += size;
        LOGGER.debug("-increaseSize(), size:{}", getSize());
    }

    /**
     * Increases the size by 1.
     */
    protected void increaseSize() {
        increaseSize(1);
    }

    /**
     * Decreases the size by 1.
     */
    protected void decreaseSize(int size) {
        if ((this.size - size) >= 0) {
            this.size -= size;
        }
    }

    /**
     * Decreases the size by 1.
     */
    protected void decreaseSize() {
        decreaseSize(1);
    }

    /**
     * The <code>root</code> node to be set.
     *
     * @return
     */
    protected final void setSize(int size) {
        this.size = size;
        if (this.size < 0) {
            this.size = 0;
        }
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the parent index.
     * <p>
     * The <code>index</code> should be greater than or equal to 1.
     * <p>
     * * Parent(r) = ⌊(r−1)/2⌋ if r≠0.
     *
     * @param index
     * @return
     */
    protected int parentIndex(int index) {
        return TreeUtils.parentIndex(index);
    }

    /**
     * Returns the index of the left child.
     * <p>
     * The <code>index</code> should be greater than or equal to 0.
     * <p>
     * Left child(r) = 2r+1 if 2r+1<n.
     *
     * @param index
     * @return
     */
    protected int leftNodeIndex(int index) {
        return TreeUtils.leftNodeIndex(index);
    }

    /**
     * Returns the right index.
     * <p>
     * The <code>index</code> should be greater than or equal to 0.
     * <p>
     * Right child(r) = 2r+2 if 2r+2<n.
     *
     * @param index
     * @return
     */
    protected int rightNodeIndex(int index) {
        return TreeUtils.rightNodeIndex(index);
    }

    /**
     * Removes all items from the tree
     */
    public void clear() {

    }

    /**
     * Adds the <code>childNode</code> node as the child node of the <code>rootNode</code> node.
     * <p>
     * By default, tree allows duplicate values, so a binary tree should handle it separately if it doesn't allow
     * duplicate values.
     *
     * @param rootNode
     * @param childNode
     * @return
     */
    public abstract Node<E> addNode(Node<E> rootNode, Node<E> childNode);

    /**
     * Adds the <code>data</code> node as the child node of the <code>rootNode</code> node.
     * <p>
     * By default, tree allows duplicate values, so a binary tree should handle it separately if it doesn't allow
     * duplicate values.
     *
     * @param rootNode
     * @param data
     */
    public Node<E> addNode(Node<E> rootNode, E data) {
        Node<E> newNode = addNode(rootNode, new Node<>(data));
        if (Objects.isNull(getRoot())) {
            setRoot(newNode);
        }

        return newNode;
    }

    /**
     * Adds the <code>data</code> node to the <code>root</code> node at its respective position.
     * <p>
     * By default, tree allows duplicate values, so a binary tree should handle it separately if it doesn't allow
     * duplicate values.
     *
     * @param data
     */
    public void addNode(E data) {
        root = addNode(getRoot(), data);
    }

//    /**
//     * Builds the tree with <code>preOrderData</code>.
//     *
//     * @param preOrderData
//     */
//    public void buildPreOrderTree(E[] preOrderData) {
// if (BeanUtils.isNotEmpty(preOrderData)) {
//            AbstractTreeParser treeHandler = new PreOrderTreeParser<>();
//            root = treeHandler.buildTree(preOrderData);
//            size = treeHandler.getSize();
// }
//    }

    /**
     * Finds the node with the provided <code>data</code>. If exists return node otherwise null.
     * <p>
     * On most machines, the iterative version is found to be more efficient.
     *
     * @param rootNode
     * @param data
     * @return
     */
    protected Node<E> findIteratively(Node<E> rootNode, E data) {
        LOGGER.debug("+findIteratively({}, {})", rootNode, data);
        // base case, check if rootNode is not null otherwise return null.
        while (Objects.nonNull(rootNode) && !rootNode.isEquals(data)) {
            if (rootNode.isGreaterThan(data)) {
                rootNode = rootNode.getLeft();
            } else {
                rootNode = rootNode.getRight();
            }
        }

        LOGGER.debug("-findIteratively(), rootNode:{}", rootNode);
        return rootNode;
    }

    /**
     * Returns the node of the provided <code>data</code> if exists in the tree otherwise null. It finds the node using
     * recursive approach.
     *
     * @param rootNode
     * @param data
     * @return
     */
    protected Node<E> findRecursively(Node<E> rootNode, E data) {
        // if data is null or rootNode is null, return null;
        if (Objects.nonNull(rootNode)) {
            // find a match, so return it
            if (rootNode.isEquals(data)) {
                return rootNode;
            } else if (rootNode.isGreaterThan(data)) {
                // if the current node is greater than data, find in left.
                return findRecursively(rootNode.getLeft(), data);
            } else if (rootNode.isLessThan(data)) {
                // if the current node is less than data, find in right.
                return findRecursively(rootNode.getRight(), data);
            }
        }

        return null;
    }

    /**
     * Returns the node of the provided <code>data</code> if exists in the tree otherwise null.
     *
     * @param rootNode
     * @param data
     * @return
     */
    protected Node<E> findNode(Node<E> rootNode, E data) {
        return (Objects.isNull(rootNode) ? null : rootNode.findNode(data));
    }

    /**
     * Returns the node of the provided <code>data</code> if exists in the tree otherwise null. It finds the node using
     * iterative approach.
     *
     * @param data
     * @return
     */
    public Node<E> findNode(E data) {
// return findIteratively(data);
        return findNode(getRoot(), data);
    }

    /**
     * Returns true if the node contain otherwise false.
     *
     * @param rootNode
     * @param data
     * @return
     */
    public boolean contains(Node<E> rootNode, E data) {
        return Objects.nonNull(findNode(rootNode, data));
    }

    /**
     * Returns true if the node contain otherwise false.
     *
     * @param data
     * @return
     */
    public boolean contains(E data) {
        return contains(getRoot(), data);
    }

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param rootNode
     * @param data
     * @return
     */
    public abstract Node<E> removeNode(Node<E> rootNode, E data);

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param data
     * @return
     */
    public void removeNode(E data) {
        removeNode(getRoot(), data);
    }

    /**
     * Returns the string representation of this object.
     */
    public String toString() {
        return inOrderTraversal().toString();
// return TreeUtils.inOrder(root).toString();
// return inOrderIterator().toString();
    }

    /**
     * Prints the pretty tree.
     */
    public void printPrettyTree(boolean showDetails) {
        TreeUtils.printPrettyTree(getRoot(), showDetails);
    }

    /**
     * Prints the pretty tree.
     */
    public void printPrettyTree() {
        printPrettyTree(false);
    }

    /**
     * Returns the <code>Iterator<E></code> based on the provided <code>traversalMode</code>.
     *
     * @return
     */
    public Iterator<E> treeIterator(TraversalMode traversalMode) {
        switch (traversalMode) {
            case PRE_ORDER_TRAVERSAL:
                return new PreOrderIterator<>(getRoot());

            case POST_ORDER_TRAVERSAL:
                return new PostOrderIterator<>(getRoot());

            case LEVEL_ORDER_TRAVERSAL:
                return new LevelOrderIterator<>(getRoot());

            default:
                return new InOrderIterator<>(getRoot());
        }
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> inOrderIterator() {
        return treeIterator(TraversalMode.IN_ORDER_TRAVERSAL);
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> preOrderIterator() {
        return treeIterator(TraversalMode.PRE_ORDER_TRAVERSAL);
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> postOrderIterator() {
        return treeIterator(TraversalMode.POST_ORDER_TRAVERSAL);
    }

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * @return
     */
    @Override
    public Iterator<E> levelOrderIterator() {
        return treeIterator(TraversalMode.LEVEL_ORDER_TRAVERSAL);
    }

    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true} if {@link #next}
     * would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return iterator().hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        return iterator().next();
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
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return treeIterator(TraversalMode.IN_ORDER_TRAVERSAL);
    }

    /**
     * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed:
     * <pre>
     * Step 1 − Visit root node.
     * Step 2 − Recursively traverse left subtree.
     * Step 3 − Recursively traverse right subtree.
     *
     * Push root node in the stack. Iterate until stack is empty.
     * Pop all items one by one.
     *
     * Do the following for every popped item:
     * a) print it
     * b) push its right child
     * c) push its left child
     *
     * Note that right child is pushed first so that left child is processed first.
     * </pre>
     */
    public List<E> preOrderTraversal() {
        TreeTraversal<E> treeTraversal = TreeFactory.treeTraverser(getRoot(), TraversalMode.PRE_ORDER_TRAVERSAL);
        List<E> preOrderTraversal = treeTraversal.traverse(false);
        return preOrderTraversal;
    }

    /**
     * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed:
     * <pre>
     * Step 1 − Recursively traverse left subtree.
     * Step 2 − Visit root node.
     * Step 3 − Recursively traverse right subtree.
     * </pre>
     */
    public List<E> inOrderTraversal() {
        TreeTraversal<E> treeTraversal = TreeFactory.treeTraverser(getRoot(), TraversalMode.IN_ORDER_TRAVERSAL);
        List<E> preOrderTraversal = treeTraversal.traverse(false);
        return preOrderTraversal;
    }

    /**
     * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
     * <p>
     * Until all nodes are traversed:
     * <pre>
     * Step 1 − Recursively traverse left subtree.
     * Step 2 − Recursively traverse right subtree.
     * Step 3 − Visit root node.
     * </pre>
     */
    public List<E> postOrderTraversal() {
        TreeTraversal<E> treeTraversal = TreeFactory.treeTraverser(getRoot(), TraversalMode.POST_ORDER_TRAVERSAL);
        List<E> preOrderTraversal = treeTraversal.traverse(false);
        return preOrderTraversal;
    }

    /**
     * Prints the level order traversal order manner. Traverses a tree in the level order manner, like:
     * <pre>
     *  Level 0 (Root Level)
     *  Level n-1 (Child Level)
     *  Level n (Leaf Level)
     * </pre>
     * <p>
     * Until all nodes are traversed:
     * <pre>
     * Step 1 − Visit root node.
     * Step 2 − Traverse root.
     * Step 3 − Traverse next level children
     * </pre>
     */
    public List<E> levelOrderTraversal() {
        TreeTraversal<E> treeTraversal = TreeFactory.treeTraverser(getRoot(), TraversalMode.LEVEL_ORDER_TRAVERSAL);
        List<E> preOrderTraversal = treeTraversal.traverse(false);
        return preOrderTraversal;
    }

    /**
     * @return
     */
    public List<E> treeViewTraversal() {
// LOGGER.debug(TreeUtils.treeViewTraversal(root, true));
        return null;
    }

    /**
     * @return
     */
    public List<E> treeBottomViewTraversal() {
// LOGGER.debug(TreeUtils.treeBottomViewTraversal(root, true));
        return null;
    }

    /**
     * @return
     */
    public List<E> treeLeftViewTraversal() {
// LOGGER.debug(TreeUtils.treeLeftViewTraversal(root, true));
        return null;
    }

    /**
     * @return
     */
    public List<E> treeRightViewTraversal() {
// LOGGER.debug(TreeUtils.treeRightViewTraversal(root, true));
        return null;
    }

}

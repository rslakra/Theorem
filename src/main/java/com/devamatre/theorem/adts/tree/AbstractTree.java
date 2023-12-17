package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.tree.handler.PreOrderHandler;
import com.devamatre.theorem.adts.tree.iterator.InOrderIterator;
import com.devamatre.theorem.adts.tree.iterator.LevelOrderIterator;
import com.devamatre.theorem.adts.tree.iterator.PostOrderIterator;
import com.devamatre.theorem.adts.tree.iterator.PreOrderIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 * @created 5/17/22 2:05 PM
 */
public abstract class AbstractTree<E extends Comparable<? super E>>
    implements TreeIterator<E>, Iterable<E>, Comparable<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTree.class);

    protected Node<E> root;
    private int size;

    public AbstractTree() {
        clear();
    }

    /**
     * Removes all items from the tree
     */
    protected void clear() {
        root = null;
        size = 0;
    }

    /**
     * The <code>root</code> node to be set.
     *
     * @return
     */
    protected final void setRoot(Node<E> root) {
        this.root = root;
        if (this.root != null) {
            root.setParent(null);
        }
    }

    /**
     * The <code>root</code> node to be set.
     *
     * @return
     */
    protected final void setSize(int size) {
        this.size = size;
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
     * Increases the size by 1.
     */
    protected void incrementSize() {
        size++;
    }

    /**
     * Decreases the size by 1.
     */
    protected void decrementSize() {
        size--;
        if (size < 0) {
            size = 0;
        }
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * The tree can have duplicate values. If it's binary tree, it should handle separately.
     *
     * @param parent
     * @param child
     * @return
     */
    protected void insert(Node<E> parent, Node<E> child) {
        // if parent's value is greater than or equal to child, add left node
        if (parent.compareTo(child) >= 0) {
            // if there is no left node of the child node, add a left node to the child.
            if (child.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                incrementSize();
            } else {
                // if child has left node, add a left node to the child's left node.
                insert(child.getLeft(), child);
            }
        } else if (parent.compareTo(parent) < 0) { // if parent's value is less than child, add right node
            // if there is no right node of the child node, add a right node to the child.
            if (child.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                incrementSize();
            } else {
                // if child has right node, add a right node to the child's right node.
                insert(child.getRight(), child);
            }
        }
    }

    /**
     * @param data
     */
    public void addNode(E data) {
        Node<E> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            incrementSize();
        } else {
            insert(root, newNode);
        }
    }

    /**
     * @param preOrderData
     */
    public void buildPreOrderTree(E[] preOrderData) {
        if (BeanUtils.isNotEmpty(preOrderData)) {
            PreOrderHandler treeHandler = new PreOrderHandler<>();
            root = treeHandler.buildTree(preOrderData);
            size = treeHandler.getSize();
        }
    }

    /**
     * Returns the node of the provided <code>data</code> if exists in the tree otherwise null.
     *
     * @param data
     * @return
     */
    protected Node<E> findNode(E data) {
        if (data != null) {
            Node<E> current = root;
            while (current != null) {
                int result = current.getData().compareTo(data);
                if (result >= 0) {  // check node on the left size
                    current = current.getLeft();
                } else if (result < 0) {
                    current = current.getRight();
                } else {
                    return current;
                }
            }
        }

        return null;
    }

    /**
     * Returns true if the node contain otherwise false.
     *
     * @param data
     * @return
     */
    public boolean contain(E data) {
        return (findNode(data) != null);
    }

    /**
     * @param current
     * @param newNode
     */
    protected void unlink(Node<E> current, Node<E> newNode) {
        if (root == current) {
            if (newNode != null) {
                newNode.setLeft(current.getLeft());
                newNode.setRight(current.getRight());
                root = newNode;
            }
        } else if (current.getParent().getRight() == current) {
            current.getParent().setRight(newNode);
        } else if (current.getParent().getLeft() == current) {
            current.getParent().setLeft(newNode);
        }
    }

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param data
     * @return
     */
    protected boolean delete(E data) {
        boolean deleted = false;

        // if not empty, check which node to delete.
        if (root != null) {
            Node<E> delNode = findNode(data);

            // if node exists, delete it.
            if (delNode != null) {
                // check, if it's a leaf node
                if (delNode.isLeafNode()) {
                    unlink(delNode, null);
                    deleted = true;
                } else if (delNode.hasLeft()) {
                    // check if it only has right child.
                    unlink(delNode, delNode.getRight());
                    deleted = true;
                } else if (delNode.hasLeft()) {
                    // check if it only has left child.
                    unlink(delNode, delNode.getLeft());
                    deleted = true;
                } else {
                    // node has both children
                    Node<E> child = delNode;
                    // find right most child
                    if (child.hasRight() && child.hasLeft()) {
                        child = child.getRight();
                    }

                    // now replace it's right node.
                    child.getParent().setRight(null);

                    child.setLeft(delNode.getLeft());
                    child.setRight(delNode.getRight());

                    unlink(delNode, child);
                    deleted = true;
                }
            }

            delNode = null;
        }

        if (deleted) {
            size--;
        }

        return deleted;
    }

    /**
     * Returns the string representation of this object.
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if (root != null) {
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<E> node = queue.poll();
                sBuilder.append(node.getData().toString());
                if (node.hasLeft()) {
                    queue.add(node.getLeft());
                }

                if (node.hasRight()) {
                    queue.add(node.getRight());
                }

                if (!queue.isEmpty()) {
                    sBuilder.append(", ");
                }
            }
        }

        return sBuilder.append("]").toString();
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node<E>> inOrderIterator() {
        return new InOrderIterator(root);
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node<E>> preOrderIterator() {
        return new PreOrderIterator(root);
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node<E>> postOrderIterator() {
        return new PostOrderIterator(root);
    }

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * @return
     */
    @Override
    public Iterator<Node<E>> levelOrderIterator() {
        return new LevelOrderIterator(root);
    }

    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true} if {@link #next}
     * would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return inOrderIterator().hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Node<E> next() {
        return inOrderIterator().next();
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
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(E o) {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Visit root node. Step 2 − Recursively traverse left subtree. Step 3 −
     * Recursively traverse right subtree.
     */
    public void preOrderTraversal() {
        LOGGER.debug(TreeUtils.preOrderTraversal(root, true));
    }

    /**
     * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Recursively traverse left subtree. Step 2 − Visit root node. Step 3 −
     * Recursively traverse right subtree.
     */
    public void inOrderTraversal() {
        LOGGER.debug(TreeUtils.inOrderTraversal(root, true));
    }

    /**
     * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Recursively traverse left subtree. Step 2 − Recursively traverse right
     * subtree. Step 3 − Visit root node.
     */
    public void postOrderTraversal() {
        LOGGER.debug(TreeUtils.postOrderTraversal(root, true));
    }

    /**
     * Prints the level order traversal order manner.
     */
    public void levelOrderTraversal() {
        LOGGER.debug(TreeUtils.levelOrderTraversal(root, true));
    }

    /**
     * @return
     */
    public void treeViewTraversal() {
        LOGGER.debug(TreeUtils.treeViewTraversal(root, true));
    }

    /**
     * @return
     */
    public void treeBottomViewTraversal() {
        LOGGER.debug(TreeUtils.treeBottomViewTraversal(root, true));
    }

    /**
     * @return
     */
    public void treeLeftViewTraversal() {
        LOGGER.debug(TreeUtils.treeLeftViewTraversal(root, true));
    }

    /**
     * @return
     */
    public void treeRightViewTraversal() {
        LOGGER.debug(TreeUtils.treeRightViewTraversal(root, true));
    }

}

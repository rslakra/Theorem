package com.devamatre.theorem.adts.tree;

import com.devamatre.theorem.adts.tree.traversal.InOrderIterator;
import com.devamatre.theorem.adts.tree.traversal.PostOrderIterator;
import com.devamatre.theorem.adts.tree.traversal.PreOrderIterator;
import com.devamatre.theorem.adts.tree.traversal.LevelOrderIterator;

import java.util.Iterator;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 */
public class Tree<E extends Comparable<E>> implements TreeIterator {

    private Node<E> root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            size++;
        } else {
            insert(root, newNode);
        }
    }

    /**
     * @param parent
     * @param child
     * @return
     */
    private void insert(Node<E> parent, Node<E> child) {
        // check, if node need to add in left side.
        if (child.getValue().compareTo(parent.getValue()) < 0) {
            if (child.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                size++;
            } else {
                insert(child.getLeft(), child);
            }
        } else if (child.getValue().compareTo(parent.getValue()) > 0) {
            if (child.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                size++;
            } else {
                insert(child.getRight(), child);
            }
        } else {
            // same data, don't allow duplicates in binary tree.
        }
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
     * Returns the node for the given data.
     *
     * @param data
     * @return
     */
    private Node<E> findNode(E data) {
        if (data != null) {
            Node<E> current = root;
            while (current != null) {
                int result = data.compareTo(current.getValue());
                if (result < 0) {
                    current = current.getLeft();
                } else if (result > 0) {
                    current = current.getRight();
                } else {
                    return current;
                }
            }
        }

        return null;
    }

    /**
     * @param current
     * @param newNode
     */
    private void unlink(Node<E> current, Node<E> newNode) {
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
    public boolean delete(E data) {
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
            Queue<Node<E>> queue = new java.util.LinkedList<Node<E>>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<E> node = queue.poll();
                sBuilder.append(node.getValue().toString());
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
    public Iterator<Node> inOrderIterator() {
        return new InOrderIterator(root);
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node> preOrderIterator() {
        return new PreOrderIterator(root);
    }

    /**
     * @return
     */
    @Override
    public Iterator<Node> postOrderIterator() {
        return new PostOrderIterator(root);
    }

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * @return
     */
    @Override
    public Iterator<Node> levelOrderIterator() {
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
    public Node next() {
        return inOrderIterator().next();
    }
}

package com.devamatre.theorem.adts.tree;

import java.util.Queue;

/**
 * @author Rohtash Singh Lakra
 */
public class NaryTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public NaryTree() {
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
        if (child.getData().compareTo(parent.getData()) < 0) {
            if (child.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                size++;
            } else {
                insert(child.getLeft(), child);
            }
        } else if (child.getData().compareTo(parent.getData()) > 0) {
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
                int result = data.compareTo(current.getData());
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
                }
                // check if it only has right child.
                else if (delNode.hasLeft()) {
                    unlink(delNode, delNode.getRight());
                    deleted = true;
                }
                // check if it only has left child.
                else if (delNode.hasLeft()) {
                    unlink(delNode, delNode.getLeft());
                    deleted = true;
                }
                // node has both children
                else {
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

}

package com.devamatre.theorem.adts.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-30 08:28:16 PM
 * @since 1.0.0
 */
public class IntBinaryTree {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntBinaryTree.class);

    private Node<Integer> rootNode;

    /**
     * Adds the node as the child of the parent node. the position.
     *
     * @param parentNode
     * @param currentNode
     */
    protected void insertNode(Node<Integer> parentNode, Node<Integer> currentNode, boolean isLeft) {
        if (isLeft) {
            parentNode.setLeft(currentNode);
        } else {
            parentNode.setRight(currentNode);
        }
    }

    /**
     * Inserts an element in a tree/create a tree.
     *
     * @param data
     */
    public void insertNode(int data) {
        Node<Integer> tempNode = new Node<Integer>(data);
        if (rootNode == null) {
            rootNode = tempNode;
        } else {
            Node<Integer> parentNode = rootNode;
            Node<Integer> currentNode = rootNode;
            if (currentNode.getData() != data) {
                while (currentNode != null) {
                    if (data < currentNode.getData()) {
                        // goto left subtree
                        if (currentNode.hasLeft()) {
                            parentNode = currentNode.getLeft();
                        }
                        currentNode = currentNode.getLeft();
                        // add new node
                        if (currentNode == null) {
                            insertNode(parentNode, tempNode, true);
                        }
                    } else if (data > currentNode.getData()) {
                        // goto right subtree
                        if (currentNode.hasRight()) {
                            parentNode = currentNode.getRight();
                        }
                        currentNode = currentNode.getRight();
                        // add new node
                        if (currentNode == null) {
                            insertNode(parentNode, tempNode, false);
                        }
                    }
                }
            }
        }
    }

    /**
     * Searches an element in a tree.
     *
     * @param findWhat
     */
    public Node<Integer> searchNode(final Integer findWhat) {
        Node<Integer> currentNode = rootNode;
        while (currentNode != null) {
            if (findWhat < currentNode.getData()) {
                // goto left subtree
                currentNode = currentNode.getLeft();
            } else if (findWhat > currentNode.getData()) {
                // goto right subtree
                currentNode = currentNode.getRight();
            } else {
                break;
            }
        }

        return currentNode;
    }

    /**
     * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Visit root node. Step 2 − Recursively traverse left subtree. Step 3 −
     * Recursively traverse right subtree.
     */
    public void preOrderTraversal() {
        LOGGER.debug(TreeUtils.preOrderTraversal(rootNode, true));
    }

    /**
     * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Recursively traverse left subtree. Step 2 − Visit root node. Step 3 −
     * Recursively traverse right subtree.
     */
    public void inOrderTraversal() {
        LOGGER.debug(TreeUtils.inOrderTraversal(rootNode, true));
    }

    /**
     * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Recursively traverse left subtree. Step 2 − Recursively traverse right
     * subtree. Step 3 − Visit root node.
     */
    public void postOrderTraversal() {
        LOGGER.debug(TreeUtils.postOrderTraversal(rootNode, true));
    }

    /**
     * Prints the level order traversal order manner.
     */
    public void levelOrderTraversal() {
        LOGGER.debug(TreeUtils.levelOrderTraversal(rootNode, true));
    }

    /**
     * @return
     */
    public void treeViewTraversal() {
        LOGGER.debug(TreeUtils.treeViewTraversal(rootNode, true));
    }

    /**
     * @return
     */
    public void treeBottomViewTraversal() {
        LOGGER.debug(TreeUtils.treeBottomViewTraversal(rootNode, true));
    }

    /**
     * @return
     */
    public void treeLeftViewTraversal() {
        LOGGER.debug(TreeUtils.treeLeftViewTraversal(rootNode, true));
    }

    /**
     * @return
     */
    public void treeRightViewTraversal() {
        LOGGER.debug(TreeUtils.treeRightViewTraversal(rootNode, true));
    }

    /**
     * Removes the node of the tree.
     *
     * @param node
     */
    public void removeNode(Node<Integer> node) {
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    public String toString() {
        return "[" + Objects.toString(rootNode) + "]";
    }

    /**
     * @param parent
     * @param newNode
     */
    private void pushNode(Node parent, Node newNode) {
        if (parent.compareTo(newNode) <= 0) {
            if (parent.hasLeft()) {
                pushNode(parent.getLeft(), newNode);
            } else {
                parent.setLeft(newNode);
            }
        } else if (parent.compareTo(newNode) > 0) {
            if (parent.hasRight()) {
                pushNode(parent.getRight(), newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    /**
     * @param data
     */
    public void addNode(int data) {
        final Node newNode = new Node(data);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            pushNode(rootNode, newNode);
        }
    }

    /**
     * @param data
     * @return
     */
    public Node<Integer> findNode(Integer data) {
        return (rootNode == null ? null : rootNode.findNode(data));
    }

    /**
     * Removes the given node recursively.
     *
     * @param parent
     * @param current
     * @param data
     */
    private void removeNode(Node<Integer> parent, Node<Integer> current, Integer data) {
        if (data < current.getData() && current.hasLeft()) {
            removeNode(current, current.getLeft(), data);
        } else if (data > current.getData() && current.hasRight()) {
            removeNode(current, current.getRight(), data);
        } else if (current.getData() == data) {
            // Case 1 - PairNode has no child.
            if (parent != null) {
                if (current.isLeftOf(parent)) {
                    // case has both parents.
                    if (current.hasChildren()) {
                        parent.setLeft(current.getRight());
                        pushNode(current.getRight(), current.getLeft());
                    } else if (current.hasLeft()) {
                        // Case 2 - PairNode has only 1 child
                        parent.setLeft(current.getLeft());
                    } else if (current.hasRight()) {
                        parent.setLeft(current.getRight());
                    } else {
                        // PairNode has no child
                        parent.setLeft(null);
                    }
                } else if (current.isRightOf(parent)) {
                    // Case 3 - PairNode has both children
                    if (current.hasChildren()) {
                        parent.setRight( current.getRight());
                        pushNode(current.getRight(), current.getLeft());
                    } else if (current.hasLeft()) {
                        // Case 2 - PairNode has only 1 child
                        parent.setRight(current.getLeft());
                    } else if (current.hasRight()) {
                        parent.setRight(current.getRight());
                    } else {
                        // PairNode has no child
                        parent.setRight(null);
                    }
                }
            } else {
                // Case 3 - PairNode has both children
                if (current.hasChildren()) {
                    pushNode(current.getRight(), current.getLeft());
                    rootNode = current.getRight();
                } else if (current.hasLeft()) {
                    // Case 2 - PairNode has only 1 child
                    if (current.getLeft().hasChildren()) {
                        rootNode = current.getLeft().getRight();
                        current.getLeft().setRight(null);
                        pushNode(rootNode, current.getLeft());
                    } else if (current.getLeft().hasLeft()) {
                        rootNode = current.getLeft().getLeft();
                    } else if (current.getLeft().hasRight()) {
                        rootNode = current.getLeft().getRight();
                    }
                } else if (current.hasRight()) {
                    rootNode = current.getRight();
                } else {
                    // PairNode has no child
                    rootNode = null;
                }
            }
        }
    }

    /**
     * Removes the given node.
     *
     * @param data
     */
    public void removeNode(int data) {
        if (rootNode != null) {
            removeNode(null, rootNode, data);
        }
    }

    /**
     * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Visit root node. Step 2 − Recursively traverse left subtree. Step 3 −
     * Recursively traverse right subtree.
     *
     * @param addBrackets
     * @return
     */
    public String preOrderTraversal(final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Push root node in the stack. Iterate until stack is empty.
         * Pop all items one by one. Do following for every popped item:
         * a) print it
         * b) push its right child
         * c) push its left child
         * Note that right child is pushed first so that left is processed
         * first.
         */
        if (rootNode != null) {
            final Stack<Node> stack = new Stack<>();
            stack.push(rootNode);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                // append root node
                nodeBuilder.append(node.getData()).append(" ");

                // push right node
                if (node.hasRight()) {
                    stack.push(node.getRight());
                }

                // push left node
                if (node.hasLeft()) {
                    stack.push(node.getLeft());
                }
            }

            // remove last white space.
            int lastIndex = nodeBuilder.lastIndexOf(" ");
            if (lastIndex != -1) {
                nodeBuilder.deleteCharAt(lastIndex);
            }
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @return
     */
    public Iterator<Node> preOrderIterator() {
        return new PreOrderIterator();
    }

    /**
     * @return
     */
    public Iterator<Node> inOrderIterator() {
        return new InOrderIterator();
    }

    /**
     * @return
     */
    public Iterator<Node> postOrderIterator() {
        return new PostOrderIterator();
    }

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-09-13 09:46:28 PM
     * @since 1.0.0
     */
    private abstract class BSTIterator implements Iterator<Node> {

        // stack
        protected Stack<Node> stack = new Stack<>();

        /**
         *
         */
        public BSTIterator() {

        }

        /**
         * @return
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return (!stack.isEmpty());
        }

        /**
         * We shall leave the method remove() unimplemented. Since a binary tree has a nonlinear structure, removing a
         * node might cause the major tree rearrangement, which will lead to incorrect output from next():
         *
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class InOrderIterator extends BSTIterator {

        public InOrderIterator() {
            if (rootNode != null) {
                pushLeft(rootNode);
            }
        }

        /**
         * Pushes the left nodes to the stack.
         *
         * @param node
         */
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }

        /**
         * If there is a left child, we push the child on a stack and return a parent node. If there is no left child,
         * we check for a right child. If there is a right child, we push the right child on a stack and return a parent
         * node. If there is no right child, we move back up the tree (while-loop) until we find a node with a right
         * child.
         *
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node current = stack.pop();
            pushLeft(current.getRight());
            return current;
        }
    }

    /**
     * Iterator is the API interface. A class which implements Iterator should implement three methods
     * <p>
     * boolean hasNext() - Returns true if the iteration has more elements. Object next() - Returns the next element in
     * the iteration. void remove() - (optional operation) Removes from the underlying collection the last element
     * returned by next().
     * <p>
     * We implement a pre-order traversal by ading a new method iterator to the BSTree class. This method returns an
     * iterator over the nodes of a binary tree in pre-order.
     *
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-09-11 10:02:18 PM
     * @since 1.0.0
     */
    private class PreOrderIterator extends BSTIterator {

        public PreOrderIterator() {
            if (rootNode != null) {
                stack.push(rootNode);
            }
        }

        /**
         * If there is a left child, we push the child on a stack and return a parent node. If there is no left child,
         * we check for a right child. If there is a right child, we push the right child on a stack and return a parent
         * node. If there is no right child, we move back up the tree (while-loop) until we find a node with a right
         * child.
         *
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node current = stack.peek();
            if (current != null) {
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                } else {
                    Node node = stack.pop();
                    while (node.getRight() == null) {
                        if (stack.isEmpty()) {
                            return current;
                        }
                        node = stack.pop();
                    }

                    stack.push(node.getRight());
                }
            }

            return current;
        }
    }

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-09-13 09:38:14 PM
     * @since 1.0.0
     */
    private class PostOrderIterator extends BSTIterator {

        public PostOrderIterator() {
            if (rootNode != null) {
                pushLeft(rootNode);
            }
        }

        /**
         * Pushes the left nodes to the stack.
         *
         * @param node
         */
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            if (stack.isEmpty()) {
                return;
            }

            node = stack.peek();
            if (node.getRight() != null) {
                pushLeft(node.getRight());
            }
        }

        /**
         * If there is a left child, we push the child on a stack and return a parent node. If there is no left child,
         * we check for a right child. If there is a right child, we push the right child on a stack and return a parent
         * node. If there is no right child, we move back up the tree (while-loop) until we find a node with a right
         * child.
         *
         * @return
         * @see java.util.Iterator#next()
         */
        @Override
        public Node next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            Node current = stack.pop();
            if (hasNext()) {
                Node node = stack.peek();
                if (current != node.getRight()) {
                    pushLeft(node.getRight());
                }
            }

            return current;
        }
    }

}

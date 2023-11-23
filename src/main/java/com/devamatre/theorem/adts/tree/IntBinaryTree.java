package com.devamatre.theorem.adts.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 11/16/23 9:17 PM
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
     *
     */
    public String toString() {
        return "[" + (rootNode == null ? "" : rootNode.toString()) + "]";
    }
}

package com.devamatre.theorem.adts.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-30 08:28:16 PM
 * @since 1.0.0
 */
public class IntBinaryTree extends BinaryTree<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntBinaryTree.class);

    /**
     * Finds the node with the provided <code>data</code>. If exists return node otherwise null.
     *
     * @param data
     * @return
     */
    public Node<Integer> findNode(Integer data) {
        return (root == null ? null : root.findNode(data));
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
        final StringBuilder strBuilder = new StringBuilder();
        if (addBrackets) {
            strBuilder.append("[");
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
        if (root != null) {
            final Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                // append root node
                strBuilder.append(node.getData()).append(" ");

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
            int lastIndex = strBuilder.lastIndexOf(" ");
            if (lastIndex != -1) {
                strBuilder.deleteCharAt(lastIndex);
            }
        }

        if (addBrackets) {
            strBuilder.append("]");
        }

        return strBuilder.toString();
    }

}

package com.rslakra.theorem.adts.tree.print;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeUtils;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/17/2023 1:51 PM
 */
public class PrintPrettyTreeHorizontally<E extends Comparable<? super E>> extends AbstractPrintPrintPrettyTree<E> {

    /**
     * Prints the pretty tree of the <code>rootNode</code>.
     *
     * @param rootNode
     */
    @Override
    public void printPrettyTree(Node<E> rootNode) {
//        TreeUtils.printPrettyTree(rootNode);
        TreeUtils.printPrettyTreeHorizontally(rootNode);
    }

    /**
     * Prints the pretty tree of the <code>rootNode</code>.
     *
     * @param rootNode
     */
    @Override
    public void printBinaryPrettyTree(Node<E> rootNode) {
        TreeUtils.printBinaryTree(rootNode);
    }
}

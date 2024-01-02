package com.devamatre.theorem.adts.tree.print;

import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TreeUtils;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/17/2023 1:50 PM
 */
public class PrintPrettyTreeVertically<E extends Comparable<? super E>> extends AbstractPrintPrintPrettyTree<E> {

    /**
     * Prints the pretty tree of the <code>rootNode</code>.
     *
     * @param rootNode
     */
    @Override
    public void printPrettyTree(Node<E> rootNode) {
        TreeUtils.printPrettyTreeVertically(rootNode);
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

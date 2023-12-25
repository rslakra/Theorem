package com.devamatre.theorem.adts.tree.print;

import com.devamatre.theorem.adts.tree.AbstractTreeTest;
import com.devamatre.theorem.adts.tree.BinaryTree;

import java.util.List;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/17/2023 1:32 PM
 */
public class PrintPrettyTreeTest extends AbstractTreeTest {

    /**
     * Builds the <code>BinaryTree</code>.
     *
     * @param inputData
     * @param <E>
     * @return
     */
    @Override
    public <E extends Comparable<? super E>> BinaryTree<E> buildTree(List<E> inputData) {
        BinaryTree<E> tree = new BinaryTree<>(true);
        fillTree(tree, inputData);
        return tree;
    }
}

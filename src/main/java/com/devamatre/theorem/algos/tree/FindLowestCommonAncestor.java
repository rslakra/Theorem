package com.devamatre.theorem.algos.tree;

import com.devamatre.theorem.adts.tree.BinaryTree;
import com.devamatre.theorem.adts.tree.Node;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/30/2023 5:57 PM
 */
public class FindLowestCommonAncestor extends BinaryTree<Integer> {

    public boolean treeContains(Node<Integer> rootNode, Integer findWhat) {
        if (rootNode == null) {
            return false;
        }

        if (rootNode.isEquals(findWhat)) {
            return true;
        } else {
            return treeContains(rootNode.getLeft(), findWhat) || treeContains(rootNode.getRight(), findWhat);
        }
    }

    public int getHeight(Node<Integer> rootNode, Integer findWhat) {
        if (rootNode == null) {
            return 0;
        } else if (rootNode.isEquals(findWhat)) {
            return 1;
        } else {
            return Math.max(getHeight(rootNode.getLeft(), findWhat), getHeight(rootNode.getRight(), findWhat)) + 1;
        }
    }

    /**
     * <pre>
     *               10
     *             /   \
     *           /      \
     *         /         \
     *        6          16
     *      /  \        /  \
     *     /    \      /    \
     *    4     8     14    20
     *  /  \        /      /  \
     * 3   5      12     18   21
     *           /  \
     *         11   13
     * </pre>
     *
     * @param rootNode
     * @return
     */
    public Node<Integer> findLowestCommonAncestor(Node<Integer> rootNode, Integer source, Integer target) {
        if (Objects.isNull(rootNode)) {
            return null;
        }

        // check if the left tree contains, source and right tree contains target
        if (treeContains(rootNode.getLeft(), source) && treeContains(rootNode.getLeft(), target)) {
            return findLowestCommonAncestor(rootNode.getLeft(), source, target);
        } else if (treeContains(rootNode.getLeft(), source) && treeContains(rootNode.getLeft(), target)) {
            return findLowestCommonAncestor(rootNode.getRight(), source, target);
        } else {
            if (getHeight(rootNode.getLeft(), source) > getHeight(rootNode.getRight(), target)) {
                return findLowestCommonAncestor(rootNode.getLeft(), source, target);
            } else if (getHeight(rootNode.getLeft(), source) < getHeight(rootNode.getRight(), target)) {
                return findLowestCommonAncestor(rootNode.getRight(), source, target);
            } else {
                return rootNode;
            }
        }
    }

}

package com.devamatre.theorem.algos.tree;

import com.devamatre.theorem.adts.tree.BinarySearchTree;
import com.devamatre.theorem.adts.tree.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/30/2023 4:18 PM
 */
public class PrintInRange extends BinarySearchTree<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintInRange.class);

    /**
     * @param rootNode
     * @param start
     * @param end
     * @return
     */
    public List<Integer> findInRange(Node<Integer> rootNode, Integer start, Integer end) {
        List<Integer> findInRange = new LinkedList<>();
        if (Objects.nonNull(rootNode)) {
            // base case
            if (rootNode.isGreaterThanEqualTo(start) && rootNode.isLessThanEqualTo(end)) {
                findInRange.addAll(findInRange(rootNode.getLeft(), start, end));
                findInRange.add(rootNode.getData());
                findInRange.addAll(findInRange(rootNode.getRight(), start, end));
            } else if (rootNode.isGreaterThan(end)) {
                findInRange.addAll(findInRange(rootNode.getLeft(), start, end));
            } else if (rootNode.isLessThan(start)) {
                findInRange.addAll(findInRange(rootNode.getRight(), start, end));
            }
        }

        return findInRange;
    }

    /**
     * Prints the nodes in the range.
     *
     * @param rootNode
     */
    public void printInRange(Node<Integer> rootNode, Integer start, Integer end) {
        LOGGER.debug("{}", findInRange(rootNode, start, end));
    }

}

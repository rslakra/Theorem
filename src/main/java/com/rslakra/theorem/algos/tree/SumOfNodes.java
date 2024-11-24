package com.rslakra.theorem.algos.tree;

import com.rslakra.theorem.adts.tree.BinaryTree;
import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.data.NodeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 * @created 11/28/23 10:55 AM
 */
public class SumOfNodes extends BinaryTree<Integer> {

    /**
     * Returns the sum of nodes at the Kth level.
     *
     * @param rootNode
     * @param level
     */
    public int sumOfNodesAtKthLevel(Node<Integer> rootNode, int level) {
        int sumOfNodes = 0;
        if (rootNode != null) {
            Queue<NodeInfo<Integer>> queue = new LinkedList<>();
            queue.add(new NodeInfo<>(rootNode, 0));

            // until queue is empty
            while (!queue.isEmpty()) {
                NodeInfo<Integer> nodeInfo = queue.poll();
                if (nodeInfo.getLevel() == level - 1) {
                    sumOfNodes += nodeInfo.getNode().getData();
                }

                // no need to add extra level info in queue.
                if (nodeInfo.getLevel() < level) {
                    // add left node in the queue
                    if (nodeInfo.getNode().hasLeft()) {
                        queue.add(new NodeInfo<>(nodeInfo.getNode().getLeft(), nodeInfo.getLevel() + 1));
                    }
                    // add right node in the queue
                    if (nodeInfo.getNode().hasRight()) {
                        queue.add(new NodeInfo<>(nodeInfo.getNode().getRight(), nodeInfo.getLevel() + 1));
                    }
                }
            }
        }

        return sumOfNodes;
    }

}

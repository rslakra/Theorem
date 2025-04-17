package com.rslakra.theorem.interview;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeQuestion.class);

    /**
     * Returns the list of nodes that are at K distance from the target node.
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> findNodesUnderWithDistanceK(Node<Integer> root, int target, int K) {
        List<Integer> nodes = new ArrayList<>();
        if (root != null) {
            Set<Integer> visited = new HashSet<>();
            Node<Integer> targetNode = findTarget(root, target);
            LOGGER.debug("targetNode={}", targetNode);
            if (targetNode != null) {
                visited.add(targetNode.getData());
                // find nodes under the target's left side
                findNodesUnderWithDistanceK(targetNode.getLeft(), 1, K, visited, nodes);
                // find nodes under the target's right side
                findNodesUnderWithDistanceK(targetNode.getRight(), 1, K, visited, nodes);
                // find nodes in the direction of target's parent and its children
                findNodesAboveWithDistanceK(targetNode.getParent(), 1, K, visited, nodes);
            }
        }

        return nodes;
    }

    /**
     * @param root
     * @param target
     * @return
     */
    public Node findTarget(Node<Integer> root, Integer target) {
        if (root != null) {
            if (root.getData().compareTo(target) == 0) {
                return root;
            }

            Node left = findTarget(root.getLeft(), target);
            if (left != null) {
                return left;
            }

            Node right = findTarget(root.getRight(), target);
            if (right != null) {
                return right;
            }
        }

        return null;
    }

    /**
     * Finds nodes above the root node.
     *
     * @param root
     * @param index
     * @param K
     * @param visited
     * @param nodes
     */
    public void findNodesAboveWithDistanceK(Node<Integer> root, int index, int K, Set<Integer> visited, List<Integer> nodes) {
        if (root != null && index <= K) {
            if (index == K) {
                nodes.add(root.getData());
            } else if (root.getParent() == null) { // root node's parent should be null
                findNodesUnderWithDistanceK(root.getLeft(), index + 1, K, visited, nodes);
                findNodesUnderWithDistanceK(root.getRight(), index + 1, K, visited, nodes);
            } else {
                findNodesAboveWithDistanceK(root.getParent(), index + 1, K, visited, nodes);
                // check left side
                findNodesUnderWithDistanceK(root.getLeft(), index + 1, K, visited, nodes);
                //check right side
                findNodesUnderWithDistanceK(root.getRight(), index + 1, K, visited, nodes);
            }
        }
    }

    /**
     * Finds nodes under the root node.
     *
     * @param root
     * @param index
     * @param K
     * @param visited
     * @param nodes
     */
    public void findNodesUnderWithDistanceK(Node<Integer> root, int index, int K, Set<Integer> visited, List<Integer> nodes) {
        if (root != null && !visited.contains(root.getData()) && index <= K) {
            // mark visited
            visited.add(root.getData());
            if (index == K) {
                nodes.add(root.getData());
            } else {
                //check left side
                findNodesUnderWithDistanceK(root.getLeft(), index + 1, K, visited, nodes);
                //check right side
                findNodesUnderWithDistanceK(root.getRight(), index + 1, K, visited, nodes);
            }
        }
    }

    // [5, 8, 1, 3, 9, 2, 4, 7]
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(5);
        // left
        root.setLeft(new Node<>(8));
        root.getLeft().setLeft(new Node<>(1));
        // right
        root.setRight(new Node<>(3));
        root.getRight().setLeft(new Node<>(9));
        root.getRight().getLeft().setLeft(new Node<>(2));
        root.getRight().getLeft().setRight(new Node<>(6));
        // right's right
        root.getRight().setRight(new Node<>(4));
        root.getRight().getRight().setRight(new Node<>(7));

        // print
        TreeUtils.printPrettyTree(root);
        TreeQuestion tree = new TreeQuestion();
        List<Integer> result = tree.findNodesUnderWithDistanceK(root, 3, 2);
        LOGGER.debug("result={}", result);
    }
}


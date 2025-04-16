package com.rslakra.theorem.interview;

import com.rslakra.theorem.adts.tree.Node;
import com.rslakra.theorem.adts.tree.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    /**
     * Returns the list of nodes that are at K distance from the target node.
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> findNodesFromTargetOfDistanceK(Node root, int target, int k) {
        List<Integer> nodes = new ArrayList<>();
        if (root != null) {
            Node targetNode = findTargetNode(root, target);
            System.out.println("targetNode=" + targetNode);
//            TreeUtils.printPrettyTree(targetNode);
            if (targetNode != null) {
                findNodesWithDistanceK(root, targetNode, k, nodes);
            }
        }

        return nodes;
    }

    public Node findTargetNode(Node<Integer> root, Integer target) {
        if (root != null) {
            if (root.getData().compareTo(target) == 0) {
                return root;
            }

            Node left = findTargetNode(root.getLeft(), target);
            if (left != null) {
                return left;
            }

            Node right = findTargetNode(root.getRight(), target);
            if (right != null) {
                return right;
            }
        }

        return null;
    }

    public void findNodesWithDistanceK(Node root, Node target, int k, List<Integer> nodes) {
        if (root != null) {

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
        // right's right
        root.getRight().setRight(new Node<>(4));
        root.getRight().getRight().setRight(new Node<>(7));

        // print
        TreeUtils.printPrettyTree(root);
        Tree tree = new Tree();
        tree.findNodesFromTargetOfDistanceK(root, 3, 2);
    }
}


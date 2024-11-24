package com.rslakra.theorem.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Singh Lakra
 * @created 09/25/2017 10:52:59 AM
 */
public class BinarySearchTrees {

    private static class Node {

        private int data;

        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    BinarySearchTrees() {

    }

    public int height(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }

        return (1 + Math.max(height(rootNode.left), height(rootNode.right)));
    }

    /**
     * @param rootNode
     */
    public void levelPrints(Node rootNode) {
        if (rootNode == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(rootNode);
        while (!nodes.isEmpty()) {
            int level = nodes.size();
            while (level > 0) {
                Node node = nodes.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }

                level--;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        BinarySearchTrees bTrees = new BinarySearchTrees();
        bTrees.root = new Node(1);
        bTrees.root.left = new Node(2);
        bTrees.root.right = new Node(3);
        bTrees.root.left.left = new Node(4);
        bTrees.root.left.right = new Node(5);
        bTrees.root.right.left = new Node(6);
        bTrees.root.right.right = new Node(7);
        bTrees.root.left.left = new Node(8);
        System.out.println("height:" + bTrees.height(bTrees.root));
        System.out.println();
        bTrees.levelPrints(bTrees.root);
    }

}

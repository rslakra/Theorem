/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.devamatre.theorem.firecode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-20 01:01:16 PM
 * @since 1.0.0
 */
public class BinaryTree {

    public BinaryTree() {

    }

    /**
     * @param root
     * @return
     */
    public int sum(TreeNode root) {
        int sum = 0;

        if (root != null) {
            sum += root.data;

            if (root.left != null) {
                sum += sum(root.left);
            }

            if (root.right != null) {
                sum += sum(root.right);
            }
        }

        return sum;
    }

    /**
     * Write a function to find the total number of leaf nodes in a binary tree. A node is described as a leaf node if
     * it doesn't have any children. If there are no leaf nodes, return 0.
     *
     * @param root
     * @return
     */
    public int numberOfLeaves(TreeNode root) {
        int leaves = 0;
        if (root != null) {
            if (root.left == null && root.right == null) {
                leaves++;
            }

            if (root.left != null) {
                leaves += numberOfLeaves(root.left);
            }

            if (root.right != null) {
                leaves += numberOfLeaves(root.right);
            }
        }

        return leaves;
    }

    public int numberOfLeaves(TreeNode root, boolean optimized) {
        if (root == null) {
            return 0;
        }

        return (root.left == null && root.right == null ? 1 : numberOfLeaves(root.left) + numberOfLeaves(root.right));
    }

    /**
     *
     */
    public TreeNode initBinaryTree(TreeNode root) {
        TreeNode left = new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null));
        TreeNode right = new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null));
        root = new TreeNode(1, left, right);
        return root;
    }

    /**
     * Given a binary tree, write a method to recursively traverse the tree in the preorder manner. Mark a node as
     * visited by adding its data to the list - Arraylist <Integer> preorderedList.
     * <p>
     * Example:
     */
    ArrayList<Integer> preorderedList = new ArrayList<Integer>();

    public void preorder(TreeNode root) {
        if (root != null) {
            if (!preorderedList.contains(root.data)) {
                preorderedList.add(root.data);
            }

            if (root.left != null) {
                preorder(root.left);
            }

            if (root.right != null) {
                preorder(root.right);
            }
        }
    }

    /**
     * Given a binary tree, write a method to iteratively traverse the tree in the preorder manner. Mark a node as
     * visited by adding its data to a list - Arraylist <Integer> preorderedList. Return this list.
     * <p>
     * Example:
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderItr(TreeNode root) {
        ArrayList<Integer> listPreOrderItr = new ArrayList<Integer>();
        if (root != null) {
            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                listPreOrderItr.add(node.data);
                if (node.right != null) {
                    nodes.push(node.right);
                }

                if (node.left != null) {
                    nodes.push(node.left);
                }
            }
        }

        return listPreOrderItr;
    }

    /**
     * Given a binary tree, write a method to return its size. The size of a tree is the number of nodes it contains.
     * <p>
     * Example:
     *
     * @param root
     * @return
     */
    public int size(TreeNode root) {
        return (root == null ? 0 : (1 + size(root.left) + size(root.right)));
        // int size = 0;
        // if (root != null) {
        // size++;
        // size += size(root.left);
        // size += size(root.right);
        // }
        //
        // return size;
    }

    /**
     * Given the root node of a Binary Tree, determine if it is a Binary Search Tree.
     * <p>
     * Examples:
     * <p>
     * output ==> true
     * <p>
     * output ==> false
     *
     * @param root
     * @return
     */
    public static boolean validateBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBST(TreeNode root, Integer min, Integer max) {
        if (root != null) {
            if (root.data < min || root.data > max) {
                return false;
            } else {
                return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
            }
        }

        return true;
    }

    /**
     * @param root
     * @param binarySearchTree
     * @return
     */
    public TreeNode initBinaryTree(TreeNode root, boolean binarySearchTree) {
        TreeNode left = null;
        TreeNode right = null;
        if (binarySearchTree) {
            left = new TreeNode(15, new TreeNode(14, null, null), new TreeNode(18, null, null));
            right = new TreeNode(30, null, null);
        } else {
            left = new TreeNode(30, new TreeNode(14, null, null), new TreeNode(18, null, null));
            right = new TreeNode(15, null, null);
        }
        root = new TreeNode(20, left, right);

        return root;
    }

    /**
     * Given a binary tree, write a method to find and return the node with data = the input data. Do not use
     * recursion.
     * <p>
     * Example:
     * <p>
     * findNode(root, 5) ==> 5
     * <p>
     * Note: Return null, if desired node is not found.
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode findNode(TreeNode root, int val) {
        if (root != null) {
            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);
            while (!nodes.isEmpty()) {
                root = nodes.pop();
                if (root.data == val) {
                    break;
                } else {
                    if (root.right != null) {
                        nodes.push(root.right);
                    }

                    if (root.left != null) {
                        nodes.push(root.left);
                    }
                }
            }
        }

        return (root == null ? null : (root.data == val ? root : null));
    }

    /**
     * Given a binary search tree and an integer k, implement a method to find and return the kth smallest node.
     * <p>
     * Example:
     *
     *
     * <p>
     * K = 2, Output = 4
     *
     * @param root
     * @param k
     * @return
     */
    public TreeNode findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> nodes = new Stack<>();
        while (!nodes.isEmpty() || root != null) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                root = nodes.pop();
                if (--k == 0) {
                    return root;
                }
                root = root.right;
            }
        }

        return root;
    }

    /**
     * @param root
     */
    private void pushLeft(TreeNode root, Stack<TreeNode> treeNodes) {
        while (root != null) {
            treeNodes.push(root);
            root = root.left;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        TreeNode rootNode = null;
        rootNode = bTree.initBinaryTree(rootNode);
        System.out.println("numberOfLeaves:" + bTree.numberOfLeaves(rootNode));
        bTree.preorder(rootNode);
        System.out.println(bTree.preorderedList);
        System.out.println(bTree.preorderItr(rootNode));
        System.out.println(bTree.size(rootNode));

        // rootNode = bTree.initBinaryTree(rootNode, true);
        // System.out.println(bTree.preorderItr(rootNode));
        // System.out.println(BinaryTree.validateBST(rootNode));
        //
        // rootNode = bTree.initBinaryTree(rootNode, false);
        // System.out.println(bTree.preorderItr(rootNode));
        // System.out.println(BinaryTree.validateBST(rootNode));
        //
        // rootNode = bTree.initBinaryTree(rootNode);
        // TreeNode temp = bTree.findNode(rootNode, 5);
        // System.out.println(TreeNode.toString(temp));
        // temp = bTree.findNode(rootNode, 9);
        // System.out.println(TreeNode.toString(temp));

        // find kth element
        rootNode = bTree.initBinaryTree(rootNode, true);
        System.out.println(TreeNode.inOrderTraversal(rootNode));
        rootNode = bTree.findKthSmallest(rootNode, 2);
        System.out.println(TreeNode.toString(rootNode));
    }

}

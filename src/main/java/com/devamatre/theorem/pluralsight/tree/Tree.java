/**
 *
 */
package com.devamatre.theorem.pluralsight.tree;

import java.util.Stack;

/**
 * @author Rohtash Lakra
 */
public class Tree<E> {

    private static int PRE_INDEX = 0;

    public Tree() {
        PRE_INDEX = 0;
    }

    /**
     * @param value
     * @param inOrderValues
     * @param startIndex
     * @param endIndex
     * @return
     */
    public int findIndex(E value, E[] inOrderValues, int startIndex, int endIndex) {
        int index = -1;
        if (inOrderValues != null) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (inOrderValues[i] == value) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    /**
     * @param preOrderValues
     * @param inOrderValues
     * @param iStartIndex
     * @param iEndIndex
     * @return
     */
    public TreeNode<E> buildTree(E[] preOrderValues, E[] inOrderValues, int iStartIndex, int iEndIndex) {
        if (iStartIndex > iEndIndex) {
            return null;
        }

        TreeNode<E> treeNode = null;

        if (PRE_INDEX > preOrderValues.length - 1) {
            return null;
        }

        treeNode = new TreeNode<>(preOrderValues[PRE_INDEX++]);
        if (iStartIndex == iEndIndex) {
            return treeNode;
        }

        int index = findIndex(treeNode.getData(), inOrderValues, iStartIndex, iEndIndex);
        treeNode.setLeftNode(buildTree(preOrderValues, inOrderValues, iStartIndex, index - 1));
        treeNode.setRightNode(buildTree(preOrderValues, inOrderValues, index + 1, iEndIndex));

        return treeNode;
    }

    /**
     * @param rootNode
     * @return
     */
    public static int maxHeight(TreeNode<?> rootNode) {
        return (rootNode == null ? 0
                                 : 1 + Math.max(maxHeight(rootNode.getLeftNode()), maxHeight(rootNode.getRightNode())));
    }

    /**
     * @param rootNode
     */
    public void preOrderTraversal(TreeNode<E> rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.getData() + " ");
            preOrderTraversal(rootNode.getLeftNode());
            preOrderTraversal(rootNode.getRightNode());
        }
    }

    /**
     * Returns the string representation of the node in the pre-order (ROOT->Left->Right) traversal order.
     *
     * @return
     */
    public static String toStringPreOrderTraversal(TreeNode<?> rootNode) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
        if (rootNode != null) {
            Stack<TreeNode<?>> nodes = new Stack<>();
            nodes.push(rootNode);
            while (!nodes.isEmpty()) {
                rootNode = nodes.pop();
                if (rootNode != null && sBuilder.length() > 1) {
                    sBuilder.append(", ");
                }
                sBuilder.append(rootNode.getData().toString());
                // push right first to stack to print later.
                if (rootNode.hasRightNode()) {
                    nodes.push(rootNode.getRightNode());
                }

                if (rootNode.hasLeftNode()) {
                    nodes.push(rootNode.getLeftNode());
                }
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the string representation of the node in the in-order (Left->ROOT->Right) traversal order.
     *
     * @return
     */
    public static String toStringInOrderTraversal(TreeNode<?> rootNode) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
        if (rootNode != null) {
            Stack<TreeNode<?>> nodes = new Stack<>();
            while (!nodes.isEmpty() || rootNode != null) {
                if (rootNode != null) {
                    nodes.push(rootNode);
                    rootNode = rootNode.getLeftNode();
                } else {
                    rootNode = nodes.pop();
                    // visit this node
                    if (rootNode != null && sBuilder.length() > 1) {
                        sBuilder.append(", ");
                    }
                    sBuilder.append(rootNode.getData().toString());

                    rootNode = rootNode.getRightNode();
                }
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the string representation of the node in the post-order (Left->Right->ROOT) traversal order.
     *
     * @return
     */
    public static String toStringPostOrderTraversal(TreeNode<?> rootNode) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
        if (rootNode != null) {
            Stack<TreeNode<?>> nodes = new Stack<>();
            TreeNode<?> lastVisited = null;
            while (!nodes.isEmpty() || rootNode != null) {
                if (rootNode != null) {
                    nodes.push(rootNode);
                    rootNode = rootNode.getLeftNode();
                } else {
                    TreeNode<?> peekNode = nodes.peek();
                    // if right child exists and traversing from left node, then move to right.
                    if (peekNode.hasRightNode() && peekNode.getRightNode() != lastVisited) {
                        rootNode = peekNode.getRightNode();
                    } else {
                        // visit this node
                        if (peekNode != null && sBuilder.length() > 1) {
                            sBuilder.append(", ");
                        }
                        sBuilder.append(peekNode.getData().toString());
                        lastVisited = nodes.pop();
                    }
                }
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Integer[] preOrderValues = {7, 10, 4, 3, 1, 2, 8, 11};
        Integer[] inOrderValues = {4, 10, 3, 1, 7, 11, 8, 2};
        TreeNode<Integer> rootNode = tree.buildTree(preOrderValues, inOrderValues, 0, inOrderValues.length - 1);
        tree.preOrderTraversal(rootNode);
        System.out.println();
        System.out.println("Height:" + Tree.maxHeight(rootNode));

        System.out.println("PreOrder Traversal");
        System.out.println(Tree.toStringPreOrderTraversal(rootNode));
        System.out.println("InOrder Traversal");
        System.out.println(Tree.toStringInOrderTraversal(rootNode));
        System.out.println("PostOrder Traversal");
        System.out.println(Tree.toStringPostOrderTraversal(rootNode));
    }

}

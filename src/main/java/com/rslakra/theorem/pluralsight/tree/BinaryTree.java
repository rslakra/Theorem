/**
 *
 */
package com.rslakra.theorem.pluralsight.tree;

/**
 * @author Rohtash Lakra
 */
public class BinaryTree<E> extends Tree<E> {

    protected TreeNode<E> rootNode;

    public BinaryTree() {

    }

    public boolean hasLeft(TreeNode<E> node) {
        return node != null && node.getLeftNode() != null;
    }

    /**
     * @param node
     * @param newNode
     * @return
     */
    protected TreeNode<E> add(TreeNode<E> node, TreeNode<E> newNode) {
        if (node == null) {
            return newNode;
        }

        TreeNode<E> nextNode = null;
        if (node.compareTo(newNode) <= 0) {
            nextNode = add(node.getRightNode(), newNode);
            node.setRightNode(nextNode);
        } else if (node.compareTo(newNode) > 0) {
            nextNode = add(node.getLeftNode(), newNode);
            node.setLeftNode(nextNode);
        }
        nextNode.setParent(node);

        return node;
    }

    /**
     * @return
     */
    public final int getHeight(TreeNode<E> rootNode) {
        return maxHeight(rootNode);
    }

    /**
     * @return
     */
    public int getHeight() {
        return getHeight(rootNode);
    }

    /**
     * Adds the new node to the tree.
     *
     * @param data
     */
    public void add(E data) {
        rootNode = add(rootNode, new TreeNode<E>(data));
    }

    /**
     * @param node
     * @param newNode
     * @return
     */
    protected final TreeNode<E> findNode(TreeNode<E> node, TreeNode<E> newNode) {
        if (node == null) {
            return null;
        } else if (node.compareTo(newNode) < 0) {
            return findNode(node.getRightNode(), newNode);
        } else if (node.compareTo(newNode) > 0) {
            return findNode(node.getLeftNode(), newNode);
        } else {
            return node;
        }
    }

    /**
     * @param data
     * @return
     */
    public TreeNode<E> findNode(E data) {
        return findNode(rootNode, new TreeNode<E>(data));
    }

    /**
     * Returns the node, to be replaced with deleted node.
     *
     * <pre>
     * - Find the child to be replaced with deleted node.
     * - Three Scenarios:
     *  1. Removed node has no right child
     *   - Left child replaces the deleted node.
     *  2. Removed node's right child has no left child
     *   - Right child replaces the deleted node.
     *  3. Removed node's right child has left child
     *   - Right child's left most child node replaces the deleted node.
     * </pre>
     *
     * @param nodeDeleted
     * @return
     */
    protected TreeNode<E> findReplacedWith(TreeNode<E> nodeDeleted) {
        if (nodeDeleted == null) {
            return null;
        }

        if (nodeDeleted.isLeafNode()) {
            return nodeDeleted;
        }

        // Removed node has right child
        if (nodeDeleted.hasRightNode()) {
            // Removed node's right child has left child
            if (nodeDeleted.getRightNode().hasLeftNode()) {
                // Right child's left most child node replaces the deleted node.
                TreeNode<E> leftMostNode = null;
                TreeNode<E> nextNode = nodeDeleted.getRightNode().getLeftNode();
                while (nextNode != null) {
                    leftMostNode = nextNode;
                    nextNode = nextNode.getLeftNode();
                }

                return leftMostNode;
                // return findReplacedWith(nodeDeleted.getRightNode().getLeftNode());
            } else {
                // Removed node's right child has no left child
                // right child replaces the deleted node.
                return nodeDeleted.getRightNode();
            }
        } else {
            // Removed node has no right child, then removed nodes left child replaces it.
            return nodeDeleted.getLeftNode();
        }
    }

    /**
     * Replaces the child's parent node's child with the <code>newNode</code>.
     *
     * @param childNode
     * @param newNode
     */
    private void updateParentsChildNode(TreeNode<E> childNode, TreeNode<E> newNode) {
        if (childNode.hasParent()) {
            // left leaf node
            if (childNode.isLeftNode()) {
                childNode.getParent().setLeftNode(null);
            } else if (childNode.isRightNode()) {
                // right leaf node
                childNode.getParent().setRightNode(null);
            }
        }
    }

    /**
     * Removes the given node.
     * <p>
     * Steps:
     *
     * <pre>
     * - Find the node to be deleted
     * - Check, if deleted node is leaf node. If yes, simply delete it from the parent node.
     * - If non-leaf node
     *   - Find the child to be replaced with deleted node.
     *   - Three Scenarios:
     *    1. Removed node has no right child
     *       - Left child replaces the deleted node.
     *    2. Removed node's right child has no left child
     *       - Right child replaces the deleted node.
     *    3. Removed node's right child has left child
     *       - Right child's left most child node replaces the deleted node.
     * </pre>
     *
     * @param data
     */
    public TreeNode<E> remove(E data) {
        TreeNode<E> nodeDeleted = findNode(data);
        if (nodeDeleted != null) {
            // check removed node is leaf node.
            if (nodeDeleted.isLeafNode()) {
                updateParentsChildNode(nodeDeleted, null);
            } else {
                // if it's non-leaf node.
                TreeNode<E> nodeReplaced = findReplacedWith(nodeDeleted);
                if (nodeReplaced != null) {
                    if (nodeReplaced.isLeafNode()) {
                        updateParentsChildNode(nodeReplaced, null);
                    } else if (nodeReplaced.hasRightNode()) {
                        nodeReplaced.getRightNode().setParent(nodeReplaced.getParent());
                        nodeReplaced.getParent().setLeftNode(nodeReplaced.getRightNode());
                        nodeReplaced.setRightNode(null);
                    }

                    if (nodeDeleted.hasRightNode() && nodeDeleted.getRightNode().compareTo(nodeReplaced) != 0) {
                        nodeReplaced.setRightNode(nodeDeleted.getRightNode());
                        if (nodeReplaced.hasRightNode()) {
                            nodeReplaced.getRightNode().setParent(nodeReplaced);
                        }
                    }

                    if (nodeDeleted.hasLeftNode() && nodeDeleted.getLeftNode().compareTo(nodeReplaced) != 0) {
                        nodeReplaced.setLeftNode(nodeDeleted.getLeftNode());
                        if (nodeReplaced.hasLeftNode()) {
                            nodeReplaced.getLeftNode().setParent(nodeReplaced);
                        }
                    }
                }

                // update parent's child node
                updateParentsChildNode(nodeDeleted, nodeReplaced);

                // update parent node
                nodeReplaced.setParent(nodeDeleted.getParent());
                if (nodeDeleted.compareTo(rootNode) == 0) {
                    // root node
                    rootNode = nodeReplaced;
                }

                nodeDeleted.setLeftNode(null);
                nodeDeleted.setRightNode(null);
            }
        }

        return nodeDeleted;
    }

    /**
     * Returns the string representation of this object.
     */
    @Override
    public String toString() {
        return toStringInOrderTraversal(rootNode);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(7);

        System.out.println("Tree:" + tree);
        System.out.println("Height:" + tree.getHeight());
        System.out.println();

        // remove node with value 1
        TreeNode<Integer> nodeRemoved = tree.remove(1);
        System.out.println("Node Removed:" + nodeRemoved);
        System.out.println("Tree:" + tree);
        System.out.println("Height:" + tree.getHeight());
        System.out.println();

        // remove node with value 4
        nodeRemoved = tree.remove(4);
        System.out.println("Node Removed:" + nodeRemoved);
        System.out.println("Tree:" + tree);
        System.out.println("Height:" + tree.getHeight());
        System.out.println();
    }

}

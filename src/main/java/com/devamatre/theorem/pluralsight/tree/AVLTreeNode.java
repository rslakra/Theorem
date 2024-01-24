/**
 *
 */
package com.devamatre.theorem.pluralsight.tree;

/**
 * @author Rohtash Lakra
 */
public class AVLTreeNode<E> extends TreeNode<E> {

    private TreeState treeState;
    private int balanceFactor;

    public AVLTreeNode(E data) {
        super(data);
    }

    /**
     * @return
     */
    public TreeState getTreeState() {
        return treeState;
    }

    /**
     * @param treeState
     */
    public void setTreeState(TreeState treeState) {
        this.treeState = treeState;
    }

    /**
     * @return
     */
    public int getBalanceFactor() {
        return balanceFactor;
    }

    /**
     * @param balanceFactor
     */
    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    /**
     * @return
     */
    public int getLeftHeight() {
        return (hasLeftNode() ? getHeight(getLeftNode()) : 0);
    }

    /**
     * @return
     */
    public int getRightHeight() {
        return (hasRightNode() ? getHeight(getRightNode()) : 0);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

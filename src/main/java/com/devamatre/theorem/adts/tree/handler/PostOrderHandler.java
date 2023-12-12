package com.devamatre.theorem.adts.tree.handler;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.array.ArrayUtils;
import com.devamatre.theorem.adts.tree.Node;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/26/23 4:58 PM
 */
public class PostOrderHandler<E extends Comparable<? super E>> extends AbstractTreeHandler<E> {

    /**
     * Handles the preOrder operations.
     */
    public PostOrderHandler() {
        super(TraversalMode.POST_ORDER_TRAVERSAL);
    }

    /**
     * @param postOrderData
     * @return
     */
    private Node<E> buildPostOrder(E[] postOrderData) {
        index--;
        if (index < 0 || index >= postOrderData.length) { // check index is valid or not
            return null;
        } else if (BeanUtils.isEmpty(postOrderData[index])) { // is null/empty data
            return null;
        } else if (BeanUtils.isKindOf(postOrderData[index], Integer.class)
                   && ((Integer) postOrderData[index]).intValue() == -1) { // is data -1 integer.
            return null;
        }
        Node<E> newNode = new Node<>(postOrderData[index]);
        newNode.setRight(buildPostOrder(postOrderData));
        newNode.setLeft(buildPostOrder(postOrderData));
        return newNode;
    }

    /**
     * Returns the <code>treeNode</code> builds with an array of <code>E</code> data.
     *
     * @param elements
     * @return
     */
    @Override
    public Node<E> buildTree(E[] elements) {
        if (TraversalMode.POST_ORDER_TRAVERSAL == getTraversalMode() && BeanUtils.isNotEmpty(elements)) {
            setIndex(elements.length);
            setRoot(buildPostOrder(elements));
            setSize(TreeUtils.getCount(root));
            return root;
        }

        return null;
    }

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type. If the <code>includeNullLeafs</code> is
     * set to be true, the leafs with null included in the results.
     *
     * @param treeNode
     * @param includeNullLeafs
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> treeNode, boolean includeNullLeafs) {
        List<E> data = TreeUtils.postOrder(treeNode, includeNullLeafs);
        ArrayUtils.replaceNullWithMinus(data);
        return ArrayUtils.toIntArray(data);
    }

    /**
     * Converts the <code>treeNode</code> into an array of <code>E</code> type.
     *
     * @param treeNode
     * @return
     */
    @Override
    public E[] treeConverter(Node<E> treeNode) {
        return treeConverter(treeNode, false);
    }

}

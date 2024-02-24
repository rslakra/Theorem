/**
 *
 */
package com.devamatre.theorem.leetcode.linkedlist;

import com.devamatre.theorem.leetcode.list.ListNode;
import com.devamatre.theorem.leetcode.list.ListUtils;

/**
 * @author Rohtash Lakra
 */
public class LinkedList<E> {

    private ListNode<E> head;
    private int size = 0;

    public LinkedList() {
    }

    /**
     * Returns the <code>head</code> node.
     *
     * @return
     */
    public ListNode<E> getHead() {
        return head;
    }

    /**
     * Returns the size of the linked list.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds the node the end of the linked list.
     *
     * @param rootNode
     * @param data
     */
    private ListNode<E> addNode(ListNode<E> rootNode, E data) {
        if (rootNode == null) {
            rootNode = new ListNode<E>(data);
            size++;
        } else {
            rootNode.next = addNode(rootNode.next, data);
        }

        return rootNode;
    }

    /**
     * Adds the node the end of the linked list.
     *
     * @param data
     */
    public void addNode(E[] data) {
        for (int i = 0; i < data.length; i++) {
            addNode(data[i]);
        }
    }

    /**
     * Adds the node the end of the linked list.
     *
     * @param data
     */
    public void addNode(E data) {
        head = addNode(head, data);
    }


    /**
     * Returns the node if exists otherwise null.
     *
     * @param rootNode
     * @param data
     * @return
     */
    protected ListNode<E> findNode(ListNode<E> rootNode, E data) {
        if (rootNode == null) {
            return null;
        } else if (rootNode.data.equals(data)) {
            return rootNode;
        }

        return findNode(rootNode.next, data);
    }

    /**
     * Returns the node if exists otherwise null.
     *
     * @param data
     * @return
     */
    public ListNode<E> findNode(E data) {
        return findNode(head, data);
    }

    /**
     * Removes the node from the linked list.
     *
     * @param rootNode
     * @param data
     * @return
     */
    protected ListNode<E> removeNode(ListNode<E> parentNode, ListNode<E> rootNode, E data) {
        if (rootNode == null) {
            return null;
        }

        if (rootNode.data.equals(data)) {
            if (parentNode == null) {
                head = head.next;
                size--;
            } else {
                parentNode.next = rootNode.next;
                size--;
            }

            return rootNode;
        }

        return removeNode(rootNode, rootNode.next, data);
    }

    /**
     * Removes the node from the linked list.
     *
     * @param data
     * @return
     */
    public ListNode<E> removeNode(E data) {
        return removeNode(null, head, data);
    }

    /**
     * Returns the sum of the <code>leftOperand</code> and <code>rightOperand</code>.
     *
     * @param leftOperand
     * @param rightOperand
     * @return
     */
    protected E sumNodes(ListNode<E> leftOperand, ListNode<E> rightOperand) {
        return null;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ListUtils.toString(head);
    }

}

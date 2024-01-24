/**
 *
 */
package com.devamatre.theorem.leetcode.linkedlist;


import com.devamatre.theorem.leetcode.list.ListNode;

/**
 * @author Rohtash Lakra
 */
public class LinkedList<E> {

    private ListNode<E> root;
    private int size = 0;

    public LinkedList() {
    }

    /**
     * @return
     */
    public ListNode<E> getRoot() {
        return root;
    }

    /**
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * @param rootNode
     * @param data
     */
    protected ListNode<E> addLast(ListNode<E> rootNode, E data) {
        if (rootNode == null) {
            size++;
            return new ListNode<E>(data);
        } else {
            rootNode.setNext(addLast(rootNode.getNext(), data));
            return rootNode;
        }
    }

    /**
     * @param data
     */
    public void addLast(E data) {
        root = addLast(root, data);
    }

    /**
     * @param rootNode
     * @param data
     * @return
     */
    protected ListNode<E> findNode(ListNode<E> rootNode, E data) {
        if (rootNode == null) {
            return null;
        } else if (rootNode.getData().equals(data)) {
            return rootNode;
        }

        return findNode(rootNode.getNext(), data);
    }

    /**
     * @param data
     * @return
     */
    public ListNode<E> findNode(E data) {
        return findNode(root, data);
    }

    /**
     * @param rootNode
     * @param data
     * @return
     */
    protected ListNode<E> removeNode(ListNode<E> parentNode, ListNode<E> rootNode, E data) {
        if (rootNode == null) {
            return null;
        }

        if (rootNode.getData().equals(data)) {
            if (parentNode == null) {
                root = root.getNext();
            } else {
                parentNode.setNext(rootNode.getNext());
            }

            return rootNode;
        }

        return removeNode(rootNode, rootNode.getNext(), data);
    }

    /**
     * @param data
     * @return
     */
    public ListNode<E> removeNode(E data) {
        return removeNode(null, root, data);
    }

    /**
     * @param listNode
     * @return
     */
    public Integer toInteger(ListNode<E> listNode) {
        if (listNode != null) {
            return (Integer) listNode.getData();
        }

        return 0;
    }

    /**
     * Returns the nodes and return the sum.
     *
     * @param leftOperand
     * @param rightOperand
     * @return
     */
    protected int addNodes(ListNode<E> leftOperand, ListNode<E> rightOperand) {
        if (leftOperand != null && rightOperand != null) {
            return (toInteger(leftOperand) + toInteger(rightOperand));
        } else {
            if (leftOperand == null) {
                return toInteger(rightOperand);
            }

            if (rightOperand == null) {
                return toInteger(leftOperand);
            }

            return 0;
        }
    }

    /**
     * @param other
     * @return
     */
    @SuppressWarnings("unchecked")
    public LinkedList<E> sum(LinkedList<E> other) {
        LinkedList<E> sumList = new LinkedList<>();
        if (root != null || other != null) {
            ListNode<E> leftOperand = root;
            ListNode<E> rightOperand = other.getRoot();
            int carry = 0;
            while (leftOperand != null || rightOperand != null) {
                int sum = addNodes(leftOperand, rightOperand) + carry;
                carry = sum / 10;
                sum = sum % 10;
                sumList.addLast((E) Integer.valueOf(sum));
                if (leftOperand != null) {
                    leftOperand = leftOperand.getNext();
                }

                if (rightOperand != null) {
                    rightOperand = rightOperand.getNext();
                }
            }

            if (carry > 0) {
                sumList.addLast((E) Integer.valueOf(carry));
            }
        }

        return sumList;
    }

    /**
     * @param other
     * @return
     */
    public ListNode<E> multiply(ListNode<E> other) {
        return other;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        ListNode<E> current = root;
        while (current != null) {
            if (sBuilder.length() > 1) {
                sBuilder.append(", ");
            }
            sBuilder.append(current.getData().toString());
            current = current.getNext();
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linkList = new LinkedList<>();
        // linkList.addLast(5);
        linkList.addLast(4);
        linkList.addLast(3);
        System.out.println(linkList);
        System.out.println("Size:" + linkList.getSize());
        System.out.println("Found:" + linkList.findNode(4));
        // System.out.println("Removed Node:" + linkList.removeNode(5));
        // System.out.println(linkList);
        LinkedList<Integer> linkList2 = new LinkedList<>();
        linkList2.addLast(5);
        linkList2.addLast(6);
        linkList2.addLast(4);
        System.out.println(linkList2);
        System.out.println("Size:" + linkList2.getSize());
        System.out.println("Found:" + linkList.findNode(0));

        LinkedList<Integer> sumList = linkList.sum(linkList2);
        System.out.println(sumList);
        System.out.println("Size:" + sumList.getSize());

    }

}

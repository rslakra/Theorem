package com.devamatre.theorem.adts.list;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 7:26 PM
 */
public enum ListUtils {

    INSTANCE;

    /**
     * @param nums
     * @return
     */
    public static <T> Node buildLinkedList(T[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Node previous = new Node(-1);
        Node head = new Node((Comparable) nums[0]);
        previous.setNext(head);
        for (int i = 1; i < nums.length; i++) {
            head.setNext(new Node((Comparable) nums[i]));
            head = head.getNext();
        }

        return previous.getNext();
    }

    /**
     * @param head
     */
    public static void printList(Node head) {
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.getData() + "\t");
            temp = (Node) temp.getNext();
        }
        System.out.println();
    }

    /**
     * Creates a singly linked list.
     *
     * @param listValues
     * @return
     */
    public static <T> Node buildSinglyLinkedList(List<T> listValues) {
        if (listValues == null || listValues.size() == 0) {
            throw new IllegalArgumentException("Please pass in a valid listValues to create a singly linked list.");
        }

        Node head = new Node((Comparable) listValues.get(0));
        Node current = head;
        for (int i = 1; i < listValues.size(); i++) {
            current.setNext(new Node((Comparable) listValues.get(i)));
            current = current.getNext();
        }

        return head;
    }


    /**
     * Reverses the nodes of the list and returns the head of the reversed list.
     *
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node previous;
        Node current;
        Node next;
        previous = head;
        current = head.getNext();
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head.setNext(null);

        return previous;
    }

    /**
     * @param head
     */
    public static void printAsList(final Node head) {
        Node listNode = head;
        System.out.println("\n--------------------------------------------");
        while (listNode != null) {
            System.out.print(listNode.getData());
            listNode = listNode.getNext();
            if (listNode != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

}

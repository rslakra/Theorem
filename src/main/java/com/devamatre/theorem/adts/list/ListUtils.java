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
    public static <T> ListNode buildLinkedList(T[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode previous = new ListNode(-1);
        ListNode head = new ListNode((Comparable) nums[0]);
        previous.setNext(head);
        for (int i = 1; i < nums.length; i++) {
            head.setNext(new ListNode((Comparable) nums[i]));
            head = head.getNext();
        }

        return previous.getNext();
    }

    /**
     * @param head
     */
    public static void printList(ListNode head) {
        ListNode temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.getValue() + "\t");
            temp = (ListNode) temp.getNext();
        }
        System.out.println();
    }

    /**
     * Creates a singly linked list.
     *
     * @param listValues
     * @return
     */
    public static <T> ListNode buildSinglyLinkedList(List<T> listValues) {
        if (listValues == null || listValues.size() == 0) {
            throw new IllegalArgumentException("Please pass in a valid listValues to create a singly linked list.");
        }

        ListNode head = new ListNode((Comparable) listValues.get(0));
        ListNode current = head;
        for (int i = 1; i < listValues.size(); i++) {
            current.setNext(new ListNode((Comparable) listValues.get(i)));
            current = current.getNext();
        }

        return head;
    }
}

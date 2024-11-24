package com.rslakra.theorem.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 12:43:39 PM
 */
public class LinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Inserts the node at the end of the linked list.
     *
     * @param head
     * @param data
     * @return
     */
    public static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            // Iteration Solution
            // Node lastNode = head;
            // while(lastNode.next != null) {
            // lastNode = lastNode.next;
            // }
            // lastNode.next = new Node(data);

            // Recursion Solution (Best)
            head.next = insert(head.next, data);
        }

        return head;
    }

    /**
     * @param head
     */
    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt();
        while (n-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        sc.close();
    }

}

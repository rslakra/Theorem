package com.devamatre.theorem.hackerrank.linkedlist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 12:43:39 PM
 */
public class DetectCycle {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * @param head
     * @param data
     * @return
     */
    public static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
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

    /*
     *
     */
    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Set<Node> visited = new HashSet<Node>();
        Node itr = head;
        while (itr != null) {
            if (visited.contains(itr)) {
                return true;
            } else {
                visited.add(itr);
            }
            itr = itr.next;
        }

        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        // int N = sc.nextInt();
        //
        // while(N-- > 0) {
        // int ele = sc.nextInt();
        // head = insert(head, ele);
        // }

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;

        // display(head);
        sc.close();

        System.out.println(hasCycle(head));
    }

}

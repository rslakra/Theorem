/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.theorem.firecode.list;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-20 12:36:44 PM
 * @since 1.0.0
 */
public class CircularLinkedList {

    private ListNode root;

    CircularLinkedList() {
    }

    /**
     * @param data
     * @return
     */
    public void addNode(int data) {
        if (root == null) {
            root = new ListNode(data);
            root.next = root;
        } else {
            ListNode current = root;
            while (current != null && current.next != root) {
                current = current.next;
            }

            current.next = new ListNode(data);
            current.next.next = root;
        }
    }

    /**
     * @param size
     */
    public void initCircularLinkedList(int size) {
        root = null;
        for (int i = 1; i <= size; i++) {
            addNode(i);
        }
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return ListNode.toString(root, true);
    }

    /**
     * @param head
     * @return
     */
    public ListNode deleteAtTail(ListNode head) {
        if (head != null) {
            ListNode prev = null;
            ListNode current = head;
            while (current != null && current.next != head) {
                prev = current;
                current = current.next;
            }

            if (prev != null) {
                prev.next = head;
            }
        }

        return head;
    }

    /**
     * Given a circular linked list, implement a method to delete its head node. Return the list's new head node. x =
     * indicates head node 1->2->3->4->*1 ==> 2->3->4->*2
     *
     * @param head
     * @return
     */
    public ListNode deleteAtHead(ListNode head) {
        if (head != null) {
            if (head.next == head) {
                head = null;
            } else {
                ListNode tempNode = head;
                while (tempNode != null && tempNode.next != head) {
                    tempNode = tempNode.next;
                }

                if (tempNode != null) {
                    head = head.next;
                    tempNode.next = head;
                }
            }
        }

        return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CircularLinkedList linkList = new CircularLinkedList();
        linkList.initCircularLinkedList(5);
        System.out.println(linkList);

        // linkList.root = linkList.deleteAtTail(linkList.root);
        // System.out.println(ListNode.toString(linkList.root, true));

        linkList.root = linkList.deleteAtHead(linkList.root);
        System.out.println(ListNode.toString(linkList.root, true));

    }

}

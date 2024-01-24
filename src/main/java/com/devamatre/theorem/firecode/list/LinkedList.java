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
package com.devamatre.theorem.firecode.list;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-20 01:05:32 PM
 * @since 1.0.0
 */
public class LinkedList {

    private ListNode root;

    public LinkedList() {

    }

    /**
     * @param data
     * @return
     */
    public void addNode(int data) {
        root = ListNode.addNode(root, data);
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return ListNode.toString(root, false);
    }

    /**
     * @param size
     */
    public void initSinglyLinkedList(int size) {
        for (int i = 1; i <= size; i++) {
            root = ListNode.addNode(root, i);
        }
    }

    /**
     * Given a singly-linked list, check whether its length is even or odd in a single pass.
     * <p>
     * An Empty list has 0 nodes which makes the number of nodes in it even. Examples: 1->2->3->4 == true
     * <p>
     * 1->2->3->4->5 == false
     *
     * @param head
     * @return
     */
    public Boolean isListEven(ListNode head) {
        if (head == null) {
            return true;
        } else {
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }

            return (count % 2 == 0);
        }
    }

    /**
     * Given a singly-linked list, implement a method to delete the node at a given position (starting from 1 as the
     * head position) and return the head of the list. Do nothing if the input position is out of range.
     * <p>
     * Examples:
     * <p>
     * LinkedList: 1->2->3->4 , Head = 1
     * <p>
     * deleteAtMiddle(Head,3) ==> 1->2->4
     *
     * @param head
     * @param position
     * @return
     */
    public ListNode deleteAtMiddle(ListNode head, int position) {
        if (head != null) {
            if (position == 1) {
                head = head.next;
            } else {
                ListNode prev = null;
                ListNode current = head;
                int ctr = 1;
                while (current != null && ctr < position && current.next != null) {
                    prev = current;
                    ctr++;
                    current = current.next;
                }

                if (prev != null && (position - ctr) == 0) {
                    prev.next = prev.next.next;
                }
            }
        }

        return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList linkList = new LinkedList();
        System.out.println(linkList);
        linkList.initSinglyLinkedList(5);
        System.out.println(linkList);

        System.out.println(linkList.isListEven(linkList.root));

        // linkList.initSinglyLinkedList(5);
        System.out.println("Delete head");
        linkList.root = linkList.deleteAtMiddle(linkList.root, 1);
        System.out.println(linkList);

        // linkList.initSinglyLinkedList(5);
        System.out.println("Delete 3rd Node");
        linkList.root = linkList.deleteAtMiddle(linkList.root, 6);
        System.out.println(linkList);

    }

}

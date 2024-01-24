/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.hackerrank.linkedlist;

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-19 07:40:02 PM
 * @since 1.0.0
 */
public class RemoveDuplicates {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }

    public static Node removeDuplicates(Node head) {
        // Write your code here
        if (head != null) {
            Node start = head;
            while (start != null) {
                Node prev = start;
                Node itr = start.next;
                while (itr != null) {
                    if (start.data == itr.data) {
                        prev.next = itr.next;
                    } else {
                        prev = itr;
                    }
                    itr = itr.next;
                }
                start = start.next;
            }
        }

        return head;
    }

    /**
     * @param head
     * @param data
     * @return
     */
    public static Node insertRecursively(Node head, int data) {
        if (head == null) {
            return new Node(data);
        } else {
            head.next = insertRecursively(head.next, data);
        }

        return head;
    }

    /**
     * @param head
     * @param data
     * @return
     */
    public static Node insertIteratively(Node head, int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
        } else if (head.next == null) {
            head.next = p;
        } else {
            Node start = head;
            while (start.next != null) {
                start = start.next;
            }
            start.next = p;

        }

        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node head = null;
        int n = in.nextInt();
        while (n-- > 0) {
            int ele = in.nextInt();
            head = insertRecursively(head, ele);
        }
        in.close();
        head = removeDuplicates(head);
        display(head);
    }

}

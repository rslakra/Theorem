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
package com.devamatre.theorem.geeksforgeeks.linklist;

/**
 * Reverse the linked list.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-05-07 07:50:33 AM
 * @since 1.0.0
 */
public class ReverseLinklist {

    private Node root;

    private boolean isOptimized = true;
    private Node lastNode;

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * @param parentNode
     * @param data
     * @return
     */
    public void addNode(int data) {
        final Node newNode = new Node(data);
        if (isOptimized) {
            if (lastNode == null) {
                root = newNode;
            } else {
                lastNode.next = newNode;
            }
            lastNode = newNode;
        } else {
            if (root == null) {
                root = newNode;
            } else {
                Node current = root;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
    }

    /**
     * @param node
     */
    public void printLinklist(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * @param node
     */
    public Node reverseLinklist(Node node) {
        Node prev = null;
        Node next = null;
        Node curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node = prev;
        return node;
    }

    /**
     * @param curr
     */
    public void reverseRecursively(Node curr, Node prev) {
        if (curr == null) {
            return;
        }

        if (curr.next == null) {
            root = curr;
            curr.next = prev;
            return;
        }

        Node next = curr.next;
        curr.next = prev;
        reverseRecursively(next, curr);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReverseLinklist linkList = new ReverseLinklist();
        linkList.addNode(1);
        linkList.addNode(2);
        linkList.addNode(3);
        linkList.addNode(4);
        linkList.addNode(5);

        System.out.println("Linklist");
        linkList.printLinklist(linkList.root);

        System.out.println("Reversed Linklist");
        linkList.root = linkList.reverseLinklist(linkList.root);
        linkList.printLinklist(linkList.root);

        System.out.println("Reverse Recursively");
        linkList.reverseRecursively(linkList.root, null);
        linkList.printLinklist(linkList.root);
    }

}

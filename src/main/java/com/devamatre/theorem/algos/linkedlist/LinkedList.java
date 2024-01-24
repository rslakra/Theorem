/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.algos.linkedlist;

import com.devamatre.theorem.adts.list.Node;

/**
 * @author Rohtash Lakra
 * @created 11/03/2016 04:28:44 PM
 */
public class LinkedList<E extends Comparable<? super E>> {

    // head
    private Node head;

    public LinkedList() {
    }

    /**
     * Returns true if the head is null;
     *
     * @return
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * @param node
     * @param data
     * @return
     */
    Node linkNode(Node node, E data) {
        if (node == null) {
            node = new Node(data);
        } else {
            node.setNext(linkNode(node.getNext(), data));
        }

        return node;
    }

    /**
     * @param node
     * @param fullList
     * @return
     */
    public static String toString(Node node, boolean fullList) {
        String nodeString = node == null ? "" : node.toString();
        if (fullList && (node != null && node.getNext() != null)) {
            nodeString += ", " + toString(node.getNext(), fullList);
        }

        return nodeString;
    }

    /**
     * @param node
     * @param data
     * @return
     */
    private Node addNode(Node node, E data) {
        if (node == null) {
            return new Node(data);
        } else {
            node.setNext(addNode(node.getNext(), data));
        }

        return node;
    }

    /**
     * @param data
     */
    public void addNode(E data) {
        head = addNode(head, data);
    }

    /**
     * Returns the middle element of the linked list.
     * <p>
     * Time Complexity: O(N)
     *
     * @return
     */
    public Node findMiddle() {
        Node middle = head;
        if (middle != null) {
            Node current = head.getNext();
            int length = 0;
            while (current.getNext() != null) {
                length++;
                if (length % 2 == 0) {
                    middle = middle.getNext();
                }

                current = current.getNext();
            }

            if (length % 2 == 1) {
                middle = middle.getNext();
            }

        }

        return middle;
    }

    /**
     * Returns true if the linked list has a loop otherwise false.
     *
     * @return
     */
    public boolean hasLoop() {
        Node slow = head;
        if (slow != null) {
            Node fast = head.getNext();
            while (fast != null && fast.getNext() != null) {
                if (fast == slow) {
                    return true;
                }

                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
        }

        return false;
    }

    /**
     * Returns the node, where the loop starts.
     *
     * @return
     */
    public Node findLoopNode() {
        Node loopStartNode = null;
        Node slow = head;
        if (slow != null) {
            Node fast = head.getNext();
            while (fast != null && fast.getNext() != null) {
                if (slow == fast) {
                    break;
                }

                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }

            while (slow != null && loopStartNode != slow.getNext()) {
                loopStartNode = loopStartNode.getNext();
                slow = slow.getNext();
            }
        }

        return loopStartNode;
    }

    /**
     * @param k
     * @return
     */
    public Node findKthLastElement(int k) {
        Node middle = head;
        if (middle != null) {
            Node current = head.getNext();
            int size = 0;
            while (current != null) {
                size++;
                if (size > k - 1) {
                    middle = middle.getNext();
                }

                current = current.getNext();
            }
        }

        return middle;
    }

    /**
     * @param node
     * @param lastKthNode
     * @param current
     * @param k
     * @return
     */
    private Node findKthLastNodeRecursively(Node node, Node lastKthNode, int current, int k) {
        if (node == null) {
            return lastKthNode;
        }

        if (current < k) {
            return findKthLastNodeRecursively(node.getNext(), lastKthNode, current + 1, k);
        } else {
            return findKthLastNodeRecursively(node.getNext(), lastKthNode.getNext(), current, k);
        }
    }

    /**
     * @param k
     * @return
     */
    public Node findKthLastNodeRecursively(int k) {
        return findKthLastNodeRecursively(head, head, 0, k);
    }

    /**
     * @param k
     * @return
     */
    public Node findKthLastElementIterative(int k) {
        Node node = head;
        if (node != null) {
            Node lastKthNode = head;
            for (int i = 0; node != null && i < k - 1; i++) {
                node = node.getNext();
            }

            while (node != null && node.getNext() != null) {
                node = node.getNext();
                lastKthNode = lastKthNode.getNext();
            }

            return lastKthNode;
        }

        return node;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ("[" + toString(head, true) + "]");
    }

    /**
     * @return
     */
    public void listWithLoop() {
        Node middle = findMiddle();
        Node tail = head;
        while (tail != null && tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(middle);
    }

    /**
     * Returns the count from the given node.
     *
     * @param node
     * @return
     */
    public int getCount(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (1 + getCount(node.getNext()));
        }
    }

    /**
     * @return
     */
    public int getCount() {
        int count = 0;
        boolean useRecursion = true;
        if (useRecursion) {
            count = getCount(head);
        } else {
            Node tmp = head;
            while (tmp != null) {
                count++;
                tmp = tmp.getNext();
            }
        }
        return count;
    }

    /**
     * Deletes the first node.
     */
    public void deleteFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    /**
     * Returns the previous node.
     *
     * @param key
     * @return
     */
    private Node findParentNode(int key) {
        Node prevNode = null;
        Node temp = head;
        while (temp != null) {
            if (temp.getData().compareTo(key) == 0) {
                break;
            }
            prevNode = temp;
            temp = temp.getNext();
        }

        return prevNode;
    }

    /**
     * Swaps the left and right nodes.
     *
     * @param leftNode
     * @param rightNode
     */
    public void swapNode(Node leftNode, Node rightNode) {
        if (leftNode != null && rightNode != null) {
            Node temp = leftNode.getNext();
            leftNode.setNext(rightNode.getNext());
            rightNode.setNext(temp);
        }
    }

    /**
     * Swap nodes for two given keys. Nodes should be swapped by changing links. It has following cases to be handled.
     * 1) x and y may or may not be adjacent. 2) Either x or y may be a head node. 3) Either x or y may be last node. 4)
     * x and/or y may not be present in linked list.
     *
     * @param leftKey
     * @param rightKey
     */
    public void swapNodes(int leftKey, int rightKey) {
        if (head != null && leftKey != rightKey) {
            // find left node and it's parent
//            Node leftNodeParent = null;
//            Node leftNode = head;
//            while (leftNode != null && leftNode.data != leftKey) {
//                leftNodeParent = leftNode;
//                leftNode = leftNode.getNext();
//            }
//
//            // find left node and it's parent
//            Node rightNodeParent = null;
//            Node rightNode = head;
//            while (rightNode != null && rightNode.data != rightKey) {
//                rightNodeParent = rightNode;
//                rightNode = rightNode.getNext();
//            }
//
//            if (leftNode != null && rightNode != null) {
//                // if left node parent is null
//                if (leftNodeParent == null) {
//                    head = rightNode;
//                } else {
//                    leftNodeParent.getNext() = rightNode;
//                }
//
//                // if right node parent is null
//                if (rightNodeParent == null) {
//                    head = leftNode;
//                } else {
//                    rightNodeParent.getNext() = leftNode;
//                }
//
//                Node temp = leftNode.getNext();
//                leftNode.getNext() = rightNode.getNext();
//                rightNode.getNext() = temp;
//            }
        }
    }

    /**
     * Reverses the linked list by changing the links between nodes.
     */
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;
        // change next to previous, previous to current and current to next.
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    /**
     * @param previous
     * @param current
     */
    public Node reverseRecursively(Node previous, Node current) {
        if (current.getNext() == null) {
            head = current;
            current.setNext(previous);
            return null;
        }

        Node next = current.getNext();
        current.setNext(previous);
        reverseRecursively(current, next);
        return head;
    }

    public void reverseRecursively() {
        head = reverseRecursively(null, head);
    }

    /**
     * Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, and merges the
     * two together into one list which is in increasing order. SortedMerge() should return the new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     * <p>
     * For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20, then SortedMerge()
     * should return a pointer to the head node of the merged list 2->3->5->10->15->20.
     * <p>
     * There are many cases to deal with: either ‘a’ or ‘b’ may be empty, during processing either ‘a’ or ‘b’ may run
     * out first, and finally there’s the problem of starting the result list empty, and building it up while going
     * through ‘a’ and ‘b’.
     *
     * @param left
     * @param right
     */
    public static <E extends Comparable<? super E>> LinkedList sortedMerge(LinkedList left, LinkedList right) {
        LinkedList linkListMerged = null;
        // both linked lists are null, return null
        if ((left == null || left.isEmpty()) && (right == null || right.isEmpty())) {
            return linkListMerged;
        }

        // If first linked list is null, return second linked list.
        if (left == null || left.isEmpty()) {
            return right;
        }

        // if 2nd linked list is null, return 1st linked list.
        if (right == null || right.isEmpty()) {
            return left;
        }

        linkListMerged = new LinkedList();
        Node<E> temp1 = left.head;
        Node temp2 = left.head;
        Node nextNode = linkListMerged.head;
        while (temp1 != null && temp2 != null) {
            // fist find the smaller node.
            Node newNode = null;
            if (nextNode == null) {
                linkListMerged.head = newNode;
                nextNode = linkListMerged.head;
                nextNode.setNext(nextNode == temp1 ? temp2 : temp1);
                nextNode = nextNode.getNext();
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } else {
                // nextNode.getNext() = newNode;
                nextNode.setNext(null);
                break;
            }
        }

        return linkListMerged;
    }

    /**
     * Prints the list.
     */
    public void printList() {
        Node tmp = head;
        StringBuilder sBuilder = new StringBuilder();
        while (tmp != null) {
            if (tmp == head) {
                sBuilder.append(tmp.getData());
            } else {
                sBuilder.append(" ").append(tmp.getData());
            }
            tmp = tmp.getNext();
        }

        System.out.println(sBuilder.toString());
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linkList = new LinkedList<>();
        System.out.println(linkList);
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            linkList.addNode(i);
        }
        System.out.println(linkList);
        System.out.println();

        int k = 3;
        Node<?> lastKthNode = linkList.findKthLastElement(k);
        System.out.println("lastKthNode:" + toString(lastKthNode, false));
        lastKthNode = linkList.findKthLastNodeRecursively(k);
        System.out.println("lastKthNode:" + toString(lastKthNode, false));
        lastKthNode = linkList.findKthLastElementIterative(k);
        System.out.println("lastKthNode:" + toString(lastKthNode, false));

        Node middle = linkList.findMiddle();
        System.out.println("Middle:" + toString(middle, false));

        linkList = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            linkList.addNode(i);
        }
        System.out.println("Loop:" + linkList.hasLoop());
        System.out.println();

        linkList.listWithLoop();
        System.out.println("Loop:" + linkList.hasLoop());
        Node loopNode = linkList.findLoopNode();
        System.out.println("Loop Node:" + toString(loopNode, false));

        /* Start with the empty list */
        LinkedList linkList3 = new LinkedList();
        linkList3.addNode(1);
        linkList3.addNode(2);
        linkList3.addNode(3);
        linkList3.addNode(4);
        linkList3.addNode(5);
        linkList3.addNode(6);
        linkList3.printList();

        // linkList.deleteFirst();
        // linkList.deleteFirst();
        // linkList.printList();
        // System.out.println("Nodes Count:" + linkList.getCount());

        // linkList.swapNodes(1, 5);
        // linkList.reverse();
        // linkList.reverseRecursively();
        // linkList.printList();

        LinkedList linkList1 = new LinkedList();
        linkList1.addNode(10);
        linkList1.addNode(22);
        linkList1.addNode(30);
        linkList1.addNode(43);
        linkList1.addNode(50);
        linkList1.addNode(64);
        linkList1.printList();

        LinkedList linkList2 = new LinkedList();
//        linkList2.addLast(11);
//        linkList2.addLast(20);
//        linkList2.addLast(33);
//        linkList2.addLast(34);
//        linkList2.addLast(55);
//        linkList2.addLast(60);
        linkList2.printList();

        LinkedList mergedLinkedList = LinkedList.sortedMerge(linkList1, linkList2);
        mergedLinkedList.printList();

    }

}

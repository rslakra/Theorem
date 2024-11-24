package com.rslakra.theorem.adts.list;

import com.rslakra.theorem.adts.linkedlist.LinkedList;
import com.rslakra.theorem.algos.linkedlist.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 7:26 PM
 */
public enum ListUtils {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(ListUtils.class);

    /**
     * Builds the linkedList recursively with the provided <code>newData</code>.
     *
     * @param index
     * @param input
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> buildNodesRecursively(int index, E[] input) {
        LOGGER.debug("+buildNodesRecursively({}, {})", index, Arrays.toString(input));
        // if input is null or an invalid index
        if (input == null || input.length == 0 || index < 0 || index >= input.length) {
            return null;
        }

        LOGGER.debug("input[{}]:{}", index, input[index]);
        Node<E> headNode = new Node(input[index]);
        headNode.setNext(buildNodesRecursively(index + 1, input));
        LOGGER.debug("-buildNodesRecursively(), headNode:{}", headNode);
        return headNode;
    }

    /**
     * Builds the linkedList recursively with the provided <code>newData</code>.
     *
     * @param input
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> buildNodesRecursively(E[] input) {
        return buildNodesRecursively(0, input);
    }

    /**
     * Builds the linkedList recursively with the provided <code>newData</code>.
     *
     * @param headNode
     * @param newData
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> buildNodesRecursively(Node<E> headNode, E newData) {
        if (headNode == null) {
            headNode = new Node(newData);
        } else {
            headNode.setNext(buildNodesRecursively(headNode.getNext(), newData));
        }

        return headNode;
    }

    /**
     * Builds the linkedList.
     *
     * @param linkedList
     * @param input
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void buildLinkedList(LinkedList<E> linkedList, E[] input) {
        linkedList.addHead(buildNodesRecursively(0, input));
    }

    /**
     * Builds the linkedList of the provided <code>input</code>
     *
     * @param input
     * @return
     */
    public static <E extends Comparable<? super E>> LinkedList<E> buildLinkedList(E[] input) {
        LinkedList<E> linkedList = new LinkedList<>();
        buildLinkedList(linkedList, input);
        return linkedList;
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
     * Builds the linkedList recursively with the provided <code>newData</code>.
     *
     * @param index
     * @param input
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> ListNode<E> buildListNodesRecursively(int index, E[] input) {
        LOGGER.debug("+buildListNodesRecursively({}, {})", index, Arrays.toString(input));
        // if input is null or an invalid index
        if (input == null || input.length == 0 || index < 0 || index >= input.length) {
            return null;
        }

        LOGGER.debug("input[{}]:{}", index, input[index]);
        ListNode<E> headNode = new ListNode(input[index]);
        headNode.next = buildListNodesRecursively(index + 1, input);
        LOGGER.debug("-buildListNodesRecursively(), headNode:{}", headNode);
        return headNode;
    }

    /**
     * Builds the linkedList recursively with the provided <code>newData</code>.
     *
     * @param input
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> ListNode<E> buildListNodesRecursively(E[] input) {
        return buildListNodesRecursively(0, input);
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

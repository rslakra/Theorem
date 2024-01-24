package com.devamatre.theorem.hackerrank;

/**
 * @author Rohtash Singh Lakra
 * @created 09/12/2017 02:56:34 PM
 */
public class Node {

    private int data;
    private Node next;

    private Node left;
    private Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

/**
 *
 */
package com.devamatre.theorem.pluralsight.linkedlist;

/**
 * @author Rohtash Lakra
 */
public class Node<T> {

    private T data;
    private Node<T> previous;
    private Node<T> next;

    /**
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * @return
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * Return true if the previous node is not null otherwise false.
     *
     * @return
     */
    public boolean hasPrevious() {
        return (getPrevious() != null);
    }

    /**
     * The <code>previous</code> to be set.
     *
     * @param previous
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    /**
     * @return
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Return true if the next node is not null otherwise false.
     *
     * @return
     */
    public boolean hasNext() {
        return (getNext() != null);
    }

    /**
     * The <code>next</code> to be set.
     *
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * @param isDoubly
     * @return
     */
    public static String toString(Node<?> node, final boolean isDoubly) {
        StringBuilder sBuilder = new StringBuilder();
        if (node != null) {
            if (isDoubly) {
                if (node.hasPrevious()) {
                    sBuilder.append(toString(node.getPrevious(), isDoubly));
                }
            }

            sBuilder.append(node.getData());

            if (node.hasNext()) {
                sBuilder.append(toString(node.getNext(), isDoubly));
            }
        }

        return sBuilder.toString();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return Node.toString(this, false);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node<Integer> first = new Node<Integer>(1);
        Node<Integer> second = new Node<Integer>(2);
        second.setPrevious(first);
        first.setNext(second);
        Node<Integer> third = new Node<Integer>(3);
        third.setPrevious(second);
        second.setNext(third);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

}

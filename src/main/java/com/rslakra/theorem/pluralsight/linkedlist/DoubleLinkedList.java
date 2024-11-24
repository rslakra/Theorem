/**
 *
 */
package com.rslakra.theorem.pluralsight.linkedlist;

/**
 * @author Rohtash Lakra
 */
public class DoubleLinkedList<T> extends LinkedList<T> {

    public DoubleLinkedList() {

    }

    /**
     * @param index
     * @param node
     */
    public void insertAt(int index, Node<T> node) {
        if (index <= 0 || (index - 1) > getSize()) {
            throw new IndexOutOfBoundsException("Invalid Index:" + index);
        }

        if ((index - 1) == getSize()) {
            addLast(node);
        } else {
            Node<T> current = head;
            int ctr = 1;
            while (current != null && ctr < index - 1) {
                current = current.getNext();
                ctr++;
            }

            node.setNext(current.getNext());
            current.getNext().setPrevious(node);
            current.setNext(node);
            node.setPrevious(current);
            size++;
        }

    }

    /**
     * @param index
     * @param data
     */
    public void insertAt(int index, T data) {
        insertAt(index, new Node<T>(data));
    }

    /**
     * @param node
     */
    public void addFirst(Node<T> node) {
        Node<T> temp = getHead();
        head = node;
        head.setNext(temp);
        size++;
        if (getSize() == 1) {
            tail = head;
        } else {
            temp.setPrevious(head);
        }
    }

    /**
     * @param data
     */
    public void addFirst(T data) {
        addFirst(new Node<T>(data));
    }

    /**
     * @param node
     */
    public void addLast(Node<T> node) {
        if (getSize() == 0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    /**
     * @param data
     */
    public void addLast(T data) {
        addLast(new Node<T>(data));
    }

    // Remove Operations

    /**
     * @param index
     */
    public void removeAt(int index) {
        if (index <= 0 || (index - 1) > getSize()) {
            throw new IndexOutOfBoundsException("Invalid Index:" + index);
        }

        if (getSize() > 0) {
            if (getSize() == 1) {
                removeFirst();
            } else {
                Node<T> current = head;
                int ctr = 1;
                while (current != null && ctr < index - 1) {
                    current = current.getNext();
                    ctr++;
                }

                Node<T> next = current.getNext();
                if (index < getSize()) {
                    current.setNext(next.getNext());
                    next.getNext().setPrevious(current);
                    // de-link deleted node.
                    next.setNext(null);
                } else {
                    current.setNext(null);
                }
                next.setPrevious(null);
                size--;

                if (getSize() == 0) {
                    tail = head;
                }
            }
        }

    }

    /**
     * Removes the first node.
     */
    public void removeFirst() {
        if (getSize() > 0) {
            head = head.getNext();
            size--;
            if (getSize() == 0) {
                tail = head;
            } else {
                head.setPrevious(null);
            }
        }
    }

    /**
     * Removes the last node.
     */
    public void removeLast() {
        if (getSize() > 0) {
            if (getSize() == 1) {
                removeFirst();
            } else {
                tail = tail.getPrevious();
                tail.setNext(null);
                size--;

                if (getSize() == 0) {
                    tail = head;
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");
        if (head != null) {
            Node<T> current = head;
            while (current != null) {
                sBuilder.append(current.getData());
                if (current.hasNext()) {
                    sBuilder.append(", ");
                }
                current = current.getNext();
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkList = new DoubleLinkedList<>();
        linkList.addFirst(4);
        linkList.addFirst(3);
        linkList.addFirst(1);
        linkList.addLast(5);
        linkList.addLast(6);
        System.out.println(linkList);
        System.out.println("Size:" + linkList.getSize());
        System.out.println();

        // insert
        linkList.insertAt(2, 2);
        System.out.println("After Insert");
        System.out.println(linkList);
        System.out.println("Size:" + linkList.getSize());
        System.out.println();

        // remove
        linkList.removeFirst();
        linkList.removeAt(2);
        linkList.removeLast();
        System.out.println("After Remove");
        System.out.println(linkList);
        System.out.println("Size:" + linkList.getSize());
    }

}

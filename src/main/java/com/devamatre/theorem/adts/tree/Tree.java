package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * <url>https://en.wikipedia.org/wiki/Tree_structure</url>
 * <p>
 * Hypothetical animal labelled tree
 *
 * <pre>
 * Tree of Life
 * |-- Vertebrates
 * |   |-- Amphibian
 * |   |   |-- Frog
 * |   |-- Birds
 * |   |   |-- Peacock
 * |   |-- Mammals
 * |   |   |-- Cow
 * |   |   |-- Human
 * |   |   |-- Zebra
 * |   |-- Fishes
 * |   |-- Reptiles
 * |   |    |-- Lizard
 * |   |    |-- Snake
 * |-- Seaweed
 * </pre>
 * <p>
 * An example of the biological classification of some animals.
 * <pre>
 * Kingdom
 * |-- Animalia
 * |   |-- Arthropod
 * |   |   |-- Insect
 * |   |   |   |-- Diptera
 * |   |   |   |   |-- Muscidae
 * |   |   |   |   |   |-- Musca
 * |   |   |   |   |   |   |-- Domestica
 * |   |   |   |   |   |   |   |-- Housefly
 * |   |-- Chordate
 * |   |   |-- Mammal
 * |   |   |   |-- Carnivora
 * |   |   |   |   |-- Falidae
 * |   |   |   |   |   |-- Felis
 * |   |   |   |   |   |   |-- Domestica
 * |   |   |   |   |   |   |   |-- House Cat
 * |   |   |   |   |   |   |-- Leo
 * |   |   |   |   |   |   |   |-- Lion
 * |   |   |   |-- Primate
 * |   |   |   |   |-- Hominidae
 * |   |   |   |   |   |-- Homo
 * |   |   |   |   |   |   |-- Sapiens
 * |   |   |   |   |   |   |   |-- Human
 * |   |   |   |   |-- Pongidae
 * |   |   |   |   |   |-- Pan
 * |   |   |   |   |   |   |-- Troglodytes
 * |   |   |   |   |   |   |   |-- Chimpanzee
 * </pre>
 * <p>
 * An example of a web page tree
 * <pre>
 * <html>
 * |-- <head>
 * |   |-- <meta>
 * |   |-- <title>
 * |-- <body>
 * |   |-- <h1>
 * |   |   |-- <p>
 * |   |-- <h2>
 * |   |   |-- <p>
 * |   |-- <p>
 * |   |-- <ul>
 * |   |   |-- <li>
 * |   |-- <ol>
 * |   |   |-- <li>
 * |   |-- <button>
 * |   |-- <code>
 * |   |-- <table>
 * |   |   |-- <thead>
 * |   |   |   |-- <tr>
 * |   |   |   |   |-- <th>
 * |   |   |   |   |-- <td>
 * |   |   |-- <tbody>
 * |   |   |   |-- <tr>
 * |   |   |   |   |-- <th>
 * |   |   |   |   |-- <td>
 * |   |   |-- <tr>
 * |   |   |   |-- <th>
 * |   |   |   |-- <td>
 * |   |-- <div>
 * |-- <footer>
 * </pre>
 * <p>
 * <p>
 * An example of a cluster diagram
 * <pre>
 * Cluster
 * |-- Analytics
 * |   |-- Cluster
 * |   |    |-- Hierarchical
 * |   |-- Graph
 * |   |    |-- Tree
 * |   |-- Optimization
 * |   |    |-- Aspect Ratio
 * |-- Animate
 * |   |-- Pause
 * |   |-- Parallel
 * |   |-- Interpolate
 * |   |   |-- Array
 * |   |   |-- Matrix
 * |-- Data
 * |   |-- Schema
 * |   |   |-- Table
 * |   |   |   |-- Field
 * |-- Query
 * |   |-- Create
 * |   |-- Select
 * |   |   |-- Field
 * |   |-- Update
 * |   |-- Delete
 * |   |-- <div>
 * |-- Operator
 * |   |   |-- Unary
 * |   |   |-- Binary
 * |   |   |   |-- Addition
 * |   |   |   |-- Division
 * |   |   |   |-- Multiply
 * |   |   |   |-- Subtract
 * |   |   |-- Logical
 * |   |   |   |-- And
 * |   |   |   |-- Or
 * |   |   |   |-- Not
 * </pre>
 * <p>
 * The polygon hierarchy
 * <pre>
 * Polygon
 * |-- Hexagon
 * |   |-- 6 Sides
 * |-- Pentagon
 * |   |-- 5 Sides
 * |-- Triangle
 * |   |-- 3 Sides
 * |   |   |-- Equilateral
 * |   |   |-- Isosceles
 * |   |   |-- Scalene
 * |   |-- Angles
 * |   |   |-- Acute
 * |   |   |-- Right
 * |   |   |-- Obtuse
 * |-- Quadrilateral
 * |   |-- Sides
 * |   |   |-- Parallelogram
 * |   |   |   |-- Rectangle
 * |   |   |   |-- Rhombus
 * |   |   |   |-- Square
 * |   |   |   |-- Trapezoid
 * |   |-- Kite
 * *
 * </pre>
 * <p>
 * Continents Hierarchy
 *
 * <pre>
 * Continent
 * |-- Asia
 * |   |-- India
 * |   |   |-- Delhi
 * |   |   |-- Kolkata
 * |   |   |-- Mumbai
 * |   |   |-- Rohtak
 * |   |-- China
 * |   |   |-- Bejing
 * |   |   |-- Guangzhou
 * |   |   |-- Shanghai
 * |   |-- Japan
 * |   |-- Indonesia
 * |-- North America
 * |   |-- United States
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class Tree<E extends Comparable<? super E>> extends AbstractTree<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tree.class);

    /**
     * Helps to handle if the binary tree allows duplicates or not.
     * <p>
     * By default, this binary search tree allows duplicates.
     *
     * @param allowDuplicates
     */
    public Tree(boolean allowDuplicates) {
        super(allowDuplicates);
    }

    /**
     * Helps to handle if the binary tree allows duplicates or not.
     * <p>
     * By default, this binary search tree allows duplicates.
     */
    public Tree() {
        this(true);
    }

    /**
     * Removes all items from the tree
     */
    @Override
    public void clear() {

    }

    /**
     * Adds the <code>childNode</code> node as the child node of the <code>rootNode</code> node.
     * <p>
     * By default, tree allows duplicate values, so a binary tree should handle it separately if it doesn't allow
     * duplicate values.
     *
     * @param rootNode
     * @param childNode
     * @return
     */
    @Override
    public Node<E> addNode(Node<E> rootNode, Node<E> childNode) {
        LOGGER.debug("addNode({}, {})", rootNode, childNode);
        if (Objects.isNull(rootNode)) {
            rootNode = childNode;
        } else {
            rootNode.addChild(childNode);
        }
        setSize(rootNode.getSize());
//        increaseSize(rootNode.getSize());

        return rootNode;
    }

    /**
     * Adds the <code>childNode</code> as children of the tree.
     *
     * @param childNode
     */
    public void addChild(Node<E> childNode) {
        if (Objects.isNull(getRoot())) {
            setRoot(childNode);
        } else {
            getRoot().addChild(childNode);
        }
        increaseSize(getRoot().getSize());
    }

    /**
     * Adds the <code>data</code> as children of the tree.
     *
     * @param data
     */
    public void addChild(E data) {
        setRoot(addNode(getRoot(), data));
    }

    /**
     * Returns the node of the provided <code>data</code> if exists in the tree otherwise null.
     *
     * @param rootNode
     * @param data
     * @return
     */
    @Override
    protected Node<E> findNode(Node<E> rootNode, E data) {
        return (Objects.isNull(rootNode) ? null : rootNode.findChild(data));
    }

    /**
     * @param rootNode
     * @param data
     * @return
     */
    @Override
    public boolean contains(Node<E> rootNode, E data) {
        return Objects.nonNull(findNode(rootNode, data));
    }

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param rootNode
     * @param data
     * @return
     */
    @Override
    public boolean removeNode(Node<E> rootNode, E data) {
        Node<E> nodeFound = findNode(rootNode, data);
//        return Objects.nonNull(nodeFound);
        return false;
    }

    /**
     * Returns true if the node is deleted otherwise false.
     *
     * @param data
     * @return
     */
    public boolean delete(E data) {
        boolean deleted = false;
        // if not empty, check which node to delete.
        if (getRoot() != null) {
            Node<E> delNode = findNode(getRoot(), data);
            // if node exists, delete it.
            if (delNode != null) {
                Node<E> parent = delNode.getParent();
                // update tree's size
                int childSize = delNode.getChildren().size() + 1;
                deleted = parent.getChildren().remove(delNode);
                if (deleted) {
                    decreaseSize();
                    decreaseSize(childSize);
                }
                delNode.setParent(null);
            }
        }

        return deleted;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    public String toString() {
        inOrderTraversal();
        StringBuilder sBuilder = new StringBuilder("[");
        if (BeanUtils.isNotNull(getRoot())) {
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(getRoot());
            while (!queue.isEmpty()) {
                Node<E> pollNode = queue.poll();
                sBuilder.append(pollNode.getData().toString());
                if (pollNode.hasChildren()) {
                    for (Node<E> treeNode : pollNode.getChildren()) {
                        queue.add(treeNode);
                    }
                }
                // append separator if queue is not empty
                if (!queue.isEmpty()) {
                    sBuilder.append(", ");
                }
            }
        }

        return sBuilder.append("]").toString();
    }

    /**
     *
     */
    @Override
    public void printPrettyTree() {
        LOGGER.debug("{}", TreeUtils.toStringNaryTree(getRoot(), true));
    }
}

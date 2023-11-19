package com.devamatre.theorem.adts.tree;

import java.util.Iterator;

/**
 * @author Rohtash Lakra
 * @created 10/18/23 1:54 PM
 */
public interface TreeIterator extends Iterator<Node> {

    /**
     * @return
     */
    Iterator<Node> inOrderIterator();

    /**
     * @return
     */
    Iterator<Node> preOrderIterator();

    /**
     * @return
     */
    Iterator<Node> postOrderIterator();

    /**
     * Iterates the tree in the level order traversal (or Breadth First Search)/BFS
     *
     * @return
     */
    Iterator<Node> levelOrderIterator();

}

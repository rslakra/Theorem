package com.devamatre.theorem.algos.tree;

import com.devamatre.theorem.adts.tree.BinarySearchTree;
import com.devamatre.theorem.adts.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/30/2023 5:57 PM
 */
public class FindPaths extends BinarySearchTree<Integer> {

    /**
     * @param rootNode
     * @return
     */
    public void findAllPaths(Node<Integer> rootNode, List<List<Integer>> paths, List<Integer> path) {
        if (Objects.isNull(rootNode)) {
            return;
        }

        // add node to the path
        path.add(rootNode.getData());

        // add path in the paths list
        if (rootNode.isLeaf()) {
            paths.add(path);
        }
        findAllPaths(rootNode.getLeft(), paths, path);
        findAllPaths(rootNode.getRight(), paths, path);
        path.remove(rootNode.getData());
    }

    /**
     * @param rootNode
     * @return
     */
    public List<List<Integer>> findAllRoot2LeafPaths(Node<Integer> rootNode) {
        List<List<Integer>> paths = new LinkedList<>();
        if (Objects.nonNull(rootNode)) {
            findAllPaths(rootNode, paths, new LinkedList<>());
        }

        return paths;
    }

    /**
     * @param rootNode
     * @return
     */
    public List<List<Integer>> findRoot2LeafPathsInRange(Node<Integer> rootNode) {
        return null;
    }

}

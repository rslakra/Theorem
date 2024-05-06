package com.devamatre.theorem.coderbyte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 */
public class TreeConstructorTwo {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeConstructorTwo.class);

    /**
     * Returns the pairs from the provided <code>pair</code> string.
     *
     * @param pair
     * @return
     */
    private static String[] getPairs(String pair) {
        return pair
            .substring(1, pair.length() - 1)
            .split(",");
    }

    /**
     * Count the parent and child relationships. In any binary tree, the same node can be a parent of 2 nodes and any
     * child node be children of any 1 prent.
     *
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(2n)
     * </pre>
     *
     * @param strArr
     * @return
     */
    public static boolean treeConstructor(String[] strArr) {
        LOGGER.debug("+treeConstructor({})", strArr);
        Map<String, Integer> parents = new HashMap<>();
        Map<String, Integer> children = new HashMap<>();
        for (String pair : strArr) {
            String[] pairs = getPairs(pair);
            String child = pairs[0];
            String parent = pairs[1];
            LOGGER.debug("pairs:{}, parent:{}, child:{}", pairs, parent, child);
            // update parent's frequency
            parents.put(parent, parents.getOrDefault(parent, 0) + 1);
            // update children frequency
            children.put(child, children.getOrDefault(child, 0) + 1);
            // check if either parent frequency is > 2 or children frequency > 1
            if (parents.get(parent) > 2 || children.get(child) > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Run DFS on the adjList.
     *
     * @param rootNode
     * @param adjList
     * @param visited
     */
    private static void dfs(String rootNode, Map<String, Set<String>> adjList, Set<String> visited) {
        visited.add(rootNode);
        if (adjList.containsKey(rootNode)) {
            for (String neighbor : adjList.get(rootNode)) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    /**
     * Returns the rootNode (mother vertex) of the directed acyclic graph.
     *
     * @param adjList
     * @return
     */
    private static String findRootNode(Map<String, Set<String>> adjList) {
        LOGGER.debug("+findRootNode({})", adjList);
        String rootNode = null;
        Set<String> visited = new HashSet<>();
        for (String node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, adjList, visited);
                rootNode = node;
            }
        }

        /**
         * If there exist mother vertex (or vertices) in given graph, then v must be one (or one of them)
         * <p>
         * Now check if v is actually a mother vertex (or graph has a mother vertex). We basically check if every vertex is
         * reachable from v or not.
         * <p>
         * Reset all values in visited[] as false   and do DFS beginning from v to check if all vertices are reachable from
         * it or not.
         */
        Set<String> verified = new HashSet<>();
        dfs(rootNode, adjList, verified);
        LOGGER.debug("visited:{}, verified:{}", visited, verified);
        if (!verified.containsAll(visited)) {
            rootNode = null;
        }

        LOGGER.debug("-findRootNode(), rootNode:{}", rootNode);
        return rootNode;
    }

    /**
     * @param inputData
     * @return
     */
    private static Map<String, Set<String>> buildAdjacencyList(String[] inputData) {
        LOGGER.debug("+buildAdjacencyList({})", inputData);
        Map<String, Set<String>> adjList = new HashMap<>();
        for (String pair : inputData) {
            String[] pairs = getPairs(pair);
            String parent = pairs[1];
            String child = pairs[0];
            LOGGER.debug("pairs:{}, parent:{}, child:{}", pairs, parent, child);
            // fill adjacency list of directed graph
            if (!adjList.containsKey(parent)) {
                adjList.put(parent, new HashSet<>());
            }
            adjList.get(parent).add(child);
        }

        LOGGER.debug("-buildAdjacencyList(), adjList:{}", adjList);
        return adjList;
    }

    /**
     * Build a directed graph using adjacency list of nodes.
     * <p>
     * And to check if it's a valid tree or not, just traverse all the nodes and it's children, and if any children is
     * already visited, it means, it's the children of 2 nodes.
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param strArr
     * @return
     */
    public static boolean treeConstructorWithGraph(String[] strArr) {
        LOGGER.debug("+treeConstructorWithGraph({})", strArr);
        // build a directed graph's adjList
        Map<String, Set<String>> adjList = buildAdjacencyList(strArr);

        // now traverse the adjList
        String rootNode = findRootNode(adjList);
        LOGGER.debug("rootNode:{}", rootNode);
        if (rootNode == null) {
            return false;
        }

        // do BFS on the queue
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(rootNode);
        LOGGER.debug("queue:{}", queue);
        // traverse all the nodes of the graph
        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            LOGGER.debug("currentNode:{}, visited:{}", currentNode, visited);
            // if it's already visited, then it's not a valid binary tree.
            if (visited.contains(currentNode)) {
                LOGGER.debug("-treeConstructorWithGraph(), false");
                return false;
            }

            // mark the node visited
            visited.add(currentNode);
            // find all neighbor of the rootNode and add in queue
            if (adjList.containsKey(currentNode)) {
                LOGGER.debug("Adding neighbors of [{}] into queue ...", currentNode);
                for (String neighbor : adjList.get(currentNode)) {
                    queue.add(neighbor);
                }
            } else {
                LOGGER.debug("No neighbors of [{}]", currentNode);
            }
        }

        LOGGER.debug("-treeConstructorWithGraph(), true");
        return true;
    }

}

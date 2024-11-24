package com.rslakra.theorem.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @created 1/30/24 4:37 PM
 */
public class LC987VerticalOrderTraversalOfBinaryTree {

    static class NodeData {

        TreeNode rootNode; // node
        int xAxis; // horizontal distance
        int yAxis; // vertical distance

        NodeData(TreeNode rootNode, int xAxis, int yAxis) {
            this.rootNode = rootNode;
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }
    }

    // node data comparator
    private Comparator<NodeData>
            nodeDataComparator =
            (left, right) -> (left.yAxis == right.yAxis ? left.rootNode.val - right.rootNode.val
                    : left.yAxis - right.yAxis);

    /**
     * @param rootNode
     * @return
     */
    private Map<Integer, List<NodeData>> groupByXAxisDistance(TreeNode rootNode) {
        Map<Integer, List<NodeData>> nodeGroups = new TreeMap<>();
        Queue<NodeData> queue = new LinkedList<>();
        queue.offer(new NodeData(rootNode, 0, 0));
        while (!queue.isEmpty()) {
            NodeData nodeData = queue.poll();
            List<NodeData> nodeGroup = nodeGroups.getOrDefault(nodeData.xAxis, new ArrayList<>());
            if (!nodeGroups.containsKey(nodeData.xAxis)) {
                nodeGroups.put(nodeData.xAxis, nodeGroup);
            }
            nodeGroup.add(nodeData);
            Collections.sort(nodeGroup, nodeDataComparator);

            if (nodeData.rootNode.left != null) {
                // left node of the rootNode, xAxis - 1 (horizontal distance), and yAxis + 1 (vertical distance)
                queue.offer(new NodeData(nodeData.rootNode.left, nodeData.xAxis - 1, nodeData.yAxis + 1));
            }

            if (nodeData.rootNode.right != null) {
                // right node of the rootNode, xAxis - 1 (horizontal distance), and yAxis + 1 (vertical distance)
                queue.offer(new NodeData(nodeData.rootNode.right, nodeData.xAxis + 1, nodeData.yAxis + 1));
            }
        }

        return nodeGroups;
    }

    /**
     * @param nodeDataList
     * @return
     */
    private List<Integer> asIntList(List<NodeData> nodeDataList) {
        return nodeDataList.stream().map(nodeData -> nodeData.rootNode.val).collect(Collectors.toList());
    }

    /**
     * <url>https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree</url>
     *
     * <pre>
     *  Time Complexity: <code>O(log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<NodeData>> nodeGroups = groupByXAxisDistance(root);
        List<Integer> xAxisDistances = new ArrayList<>(nodeGroups.keySet());
//        Comparator<Integer> keyComparator = (x, y) -> x - y;
//        Collections.sort(xAxisDistances, keyComparator);
        for (int key : xAxisDistances) {
            results.add(asIntList(nodeGroups.get(key)));
        }

        return results;
    }

}

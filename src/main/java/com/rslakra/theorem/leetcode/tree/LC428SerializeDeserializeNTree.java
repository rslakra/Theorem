package com.rslakra.theorem.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Rohtash Lakra
 * Created: 8/15/20 11:57 AM
 * Version: 1.0.0
 */
public class LC428SerializeDeserializeNTree {

    static class Node {

        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
            children = new ArrayList<>();
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public void addChild(int value) {
            addChild(new Node(value));
        }

        public void addChildren(List<Node> children) {
            this.children.addAll(children);
        }

        /**
         * @return
         */
        @Override
        public String toString() {
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(value);
            if (children.size() > 0) {
                sBuilder.append(children.toString());
            }

            return sBuilder.toString();
        }
    }

    public String serialize(Node node) {
        return (node == null ? "" : node.toString());
    }

    public Node deserializeOptimized(String str) {
        Node node = null;
        if (str != null && str.trim().length() > 0) {
            Stack<String> symbols = new Stack<>();
            String subStr = null;
            int startIndex = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
                    symbols.push("[");
                } else if (str.charAt(i) == ']') {
                    symbols.pop();
                } else if (!symbols.isEmpty()) {
                    continue;
                } else if (str.charAt(i) == ',') {
                    subStr = str.substring(i);
                    node.addChild(deserializeOptimized(subStr));
                }
            }

            if (startIndex == 0) {
                subStr = str;
            } else if (startIndex > 0) {
                subStr = str.substring(startIndex, str.length());
            }

            node = new Node(Integer.valueOf(subStr));
        }

        return node;
    }


    public Node deserialize(String str) {
        Node node = null;
        if (str != null && str.trim().length() > 0) {
            String value = null;
            int lastIndex = str.indexOf("[");
            if (lastIndex != -1) {
                value = str.substring(0, lastIndex).trim();
                node = new Node(Integer.valueOf(value));
                node.addChildren(childDeserializer(str.substring(lastIndex + 1, str.length() - 1)));
            } else {
                node = new Node(Integer.valueOf(str.trim()));
            }
        }

        return node;
    }

    private List<String> split(String str) {
        List<String> tokens = null;
        if (str != null) {
            tokens = new ArrayList<>();
            int startIndex = 0;
            Stack<String> symbols = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[') {
                    symbols.push("[");
                } else if (str.charAt(i) == ']') {
                    symbols.pop();
                } else if (!symbols.isEmpty()) {
                    continue;
                } else if (str.charAt(i) == ',') {
                    tokens.add(str.substring(startIndex, i));
                    startIndex = i + 1;
                }
            }

            if (startIndex == 0) {
                tokens.add(str);
            } else if (startIndex > 0) {
                tokens.add(str.substring(startIndex, str.length()));
            }
        }

        return tokens;
    }

    private List<Node> childDeserializer(String str) {
        List<Node> children = new ArrayList<>();
        if (str != null && str.trim().length() > 0) {
            List<String> values = split(str);
            if (values != null) {
                for (String child : values) {
                    // System.out.println(child);
                    String value = null;
                    int lastIndex = child.indexOf("[");
                    if (lastIndex != -1) {
                        value = child.substring(0, lastIndex).trim();
                        Node node = new Node(Integer.valueOf(value));
                        children.add(node);
                        node.addChildren(childDeserializer(child.substring(lastIndex + 1, child.length() - 1)));
                    } else {
                        children.add(new Node(Integer.valueOf(child.trim())));
                    }
                }
            }
        }

        return children;
    }

    public Node buildLeftTree() {
        //1st Level
        Node root = new Node(0);
        //2nd level
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        root.addChild(one);
        // root.addChild(two);
        // root.addChild(three);

        // //3rd level
        // Node four = new Node(4);
        // Node five = new Node(5);
        // one.addChild(four);
        // one.addChild(five);

        return root;
    }


    public Node buildCenterTree() {
        //1st Level
        Node root = new Node(0);
        //2nd level
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        root.addChild(one);
        root.addChild(two);
        root.addChild(three);

        //3rd level
        Node four = new Node(4);
        Node five = new Node(5);
        two.addChild(four);
        two.addChild(five);

        return root;
    }


    public Node buildRightTree() {
        //1st Level
        Node root = new Node(0);
        //2nd level
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        root.addChild(one);
        root.addChild(two);
        root.addChild(three);

        //3rd level
        Node four = new Node(4);
        Node five = new Node(5);
        three.addChild(four);
        three.addChild(five);

        return root;
    }


    public static void main(String[] args) {

        LC428SerializeDeserializeNTree tree = new LC428SerializeDeserializeNTree();
        // List<String> tokens = tree.split("1[4, 5]");
        // tokens.forEach(str -> System.out.println(str));
        // System.out.println();
        // tokens = tree.split("1[4, 5[6, 7]], 2, 3");
        // tokens.forEach(str -> System.out.println(str));
        // System.out.println();
        // tokens = tree.split("1[4], 2[6, 7], 3");
        // tokens.forEach(str -> System.out.println(str));
        // System.out.println();
        // tokens = tree.split("1[4, 5], 2, 3[[6[8], 7]]");
        // tokens.forEach(str -> System.out.println(str));

        // left tree
        Node leftTree = tree.buildLeftTree();
        String leftSerialized = tree.serialize(leftTree);
        System.out.println(leftSerialized);
        Node leftDeserializedTree = tree.deserialize(leftSerialized);
        String leftDeserialized = tree.serialize(leftDeserializedTree);
        System.out.println(leftDeserialized);
        // leftDeserializedTree = tree.deserializeOptimized(leftSerialized);
        // leftDeserialized = tree.serialize(leftDeserializedTree);
        // System.out.println(leftDeserialized);
        System.out.println();

        //center tree
        Node centerTree = tree.buildCenterTree();
        String centerSerialized = tree.serialize(centerTree);
        System.out.println(centerSerialized);
        Node centerDeserializedTree = tree.deserialize(centerSerialized);
        String centerDeserialized = tree.serialize(centerDeserializedTree);
        System.out.println(centerDeserialized);
        System.out.println();

        //right tree
        Node rightTree = tree.buildRightTree();
        String rightSerialized = tree.serialize(rightTree);
        System.out.println(rightSerialized);
        Node rightDeserializedTree = tree.deserialize(rightSerialized);
        String rightDeserialized = tree.serialize(rightDeserializedTree);
        System.out.println(rightDeserialized);
        System.out.println();
    }

}

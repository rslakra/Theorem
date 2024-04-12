package com.devamatre.theorem.coderbyte;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 * <p>
 * https://javachallengers.com/tree-data-structure-with-java/
 * https://github.com/rajat4255/Tree-constructor/blob/main/main.py
 * https://coderbyte.com/solution/Tree%20Constructor
 */
public class TreeConstructorTwo {

    public static boolean treeConstructor(String[] strArr) {
        Map<String, Integer> parents = new TreeMap<>();
        Map<String, Integer> children = new TreeMap<>();
        for (String pair : strArr) {
            String[] vals = pair.substring(1, pair.length() - 1).split(",");
            String child = vals[0];
            String parent = vals[1];

            if (!children.containsKey(child)) {
                children.put(child, 1);
            } else {
                children.put(child, children.get(child) + 1);
            }

            if (!parents.containsKey(parent)) {
                parents.put(parent, 1);
            } else {
                parents.put(parent, parents.get(parent) + 1);
            }

            if (children.get(child) > 1 || parents.get(parent) > 2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] inputData = new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        boolean result = TreeConstructorTwo.treeConstructor(inputData);
        System.out.println(result);

        inputData = new String[]{"(1,2)", "(1,3)"};
        result = TreeConstructorTwo.treeConstructor(inputData);
        System.out.println(result);

        inputData = new String[]{"(1,2)", "(2,4)", "(7,2)"};
        result = TreeConstructorTwo.treeConstructor(inputData);
        System.out.println(result);

        inputData = new String[]{"(1,2)", "(7,2)"};
        result = TreeConstructorTwo.treeConstructor(inputData);
        System.out.println(result);
    }
}

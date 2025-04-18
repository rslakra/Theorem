/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.theorem.firecode.tree;

import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-26 08:21:08 AM
 * @since 1.0.0
 */
public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the string representation of this node in pre-order traversal.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public static String preOrderTraversal(TreeNode root) {
        StringBuilder sBuilder = new StringBuilder("[");
        if (root != null) {
            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);
            while (!nodes.isEmpty()) {
                root = nodes.pop();
                sBuilder.append(root.data);

                if (root.left != null || root.right != null) {
                    sBuilder.append(", ");
                }

                if (root.right != null) {
                    nodes.push(root.right);
                }

                if (root.left != null) {
                    nodes.push(root.left);
                }
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the string represenation of this node in in-order traversal.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public static String inOrderTraversal(TreeNode root) {
        StringBuilder sBuilder = new StringBuilder("[");
        if (root != null) {
            InOrderIterator inOrder = new InOrderIterator(root);
            while (inOrder.hasNext()) {
                sBuilder.append(inOrder.next().data);
                if (inOrder.hasNext()) {
                    sBuilder.append(" ");
                }
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the string represenation of this node.
     *
     * @param root
     * @return
     */
    public static String toString(TreeNode root) {
        return preOrderTraversal(root);
    }

}

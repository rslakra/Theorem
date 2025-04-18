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

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-11-05 10:46:55 AM
 * @since 1.0.0
 */
public class InOrderIterator implements Iterator<TreeNode> {

    private Stack<TreeNode> treeNodes = new Stack<>();

    /**
     *
     */
    public InOrderIterator(TreeNode root) {
        if (root != null) {
            pushLeft(root);
        }
    }

    /**
     * @param root
     */
    private void pushLeft(TreeNode root) {
        while (root != null) {
            treeNodes.push(root);
            root = root.left;
        }
    }

    /**
     * @return
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        return (!treeNodes.isEmpty());
    }

    /**
     * @return
     * @see java.util.Iterator#next()
     */
    @Override
    public TreeNode next() {
        TreeNode treeNode = treeNodes.pop();
        pushLeft(treeNode.right);
        return treeNode;
    }
}

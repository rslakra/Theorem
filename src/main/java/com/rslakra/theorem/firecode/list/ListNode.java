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
package com.rslakra.theorem.firecode.list;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-20 04:00:30 PM
 * @since 1.0.0
 */
public class ListNode {

    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }

    /**
     * @param parent
     * @param data
     * @return
     */
    public static ListNode addNode(ListNode parent, int data) {
        if (parent == null) {
            parent = new ListNode(data);
        } else {
            parent.next = addNode(parent.next, data);
        }

        return parent;
    }

    /**
     * Returns the string represenation of this node.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public static String toString(ListNode root, boolean isCircular) {
        StringBuilder sBuilder = new StringBuilder("[");
        ListNode current = root;
        while (current != null) {
            sBuilder.append(current.data);
            if (isCircular) {
                if (current.next != root) {
                    sBuilder.append(", ");
                } else if (current.next == root) {
                    break;
                }
            } else {
                if (current.next != null) {
                    sBuilder.append(", ");
                }
            }
            current = current.next;
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }
}

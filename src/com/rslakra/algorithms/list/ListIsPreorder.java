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
package com.rslakra.algorithms.list;

import java.util.List;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-08-28 09:57:07 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class ListIsPreorder {
	
	static class Node {
		Node parent;
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	/**
	 * Given an ArrayList of Nodes, with each Node having an ID and a parent ID,
	 * determine whether the List is given in preorder.
	 * 
	 * 
	 * Create a stack to store nodes in the current path when traversing.
	 * Push node[i] into stack once node[i] is verified to be valid (valid only
	 * when parent of node[i] is in stack.
	 * In preorder a parent must show up earlier than its child)
	 * Whenever stack top is not the parent of node[i], pop until parent of
	 * node[i] is at stack top. Push node[i].
	 * If all nodes popped but parent of node[i] still not found, then node[i]
	 * is not in preorder sequence.
	 * 
	 * @return
	 */
	public static boolean isPreOrder(List<Node> nodes) {
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPreOrder(null));
	}
	
}

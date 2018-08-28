/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.datastructure.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-08-22 09:42:10 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class TreeNode {
	private final static boolean SHOW_DEPTH = true;
	private TreeNode parent;
	private String data;
	private List<TreeNode> children;
	
	/**
	 * Creates the new node.
	 * 
	 * @param parent
	 * @param data
	 */
	public TreeNode(TreeNode parent, String data) {
		this.parent = parent;
		if (data == null || data.trim().length() == 0) {
			throw new IllegalArgumentException("data is null!");
		}
		this.data = data;
	}
	
	/**
	 * 
	 * @param data
	 */
	public TreeNode(String data) {
		this(null, data);
	}
	
	/**
	 * Returns the length of the path to its root.
	 * 
	 * @param parent
	 * @return
	 */
	public static int maxDepth(final TreeNode treeNode) {
		if (treeNode == null) {
			return 0;
		} else {
			return (maxDepth(treeNode.getParent()) + 1);
		}
	}
	
	/**
	 * Returns the lenght of the longest path to a leaf.
	 * 
	 * @param parent
	 * @return
	 */
	public static int maxHeight(final TreeNode node) {
		if (node == null) {
			return 1;
		} else {
			int maxDepth = 1;
			if (node.hasChildren()) {
				for (TreeNode child : node.getChildren()) {
					maxDepth = Math.max(maxHeight(child) + 1, maxDepth);
				}
			}
			
			return maxDepth;
		}
	}
	
	/**
	 * Returns the edge count of the node.
	 * 
	 * @param node
	 * @return
	 */
	public static int maxEdges(final TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int edgeCount = 0;
			if (node.hasChildren()) {
				for (TreeNode child : node.getChildren()) {
					edgeCount += (maxEdges(child) + 1);
				}
			}
			
			return edgeCount;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public TreeNode getParent() {
		return parent;
	}
	
	/**
	 * The parent node to be set.
	 * 
	 * @param parent
	 */
	public void setParent(final TreeNode parent) {
		this.parent = parent;
	}
	
	/**
	 * Returns true if the node has the parent othewise false.
	 * 
	 * @return
	 */
	public boolean hasParent() {
		return (getParent() != null);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Returns true if the node has children otherwise false.
	 * 
	 * @return
	 */
	public boolean hasChildren() {
		return (getChildren() != null && getChildren().size() > 0);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<TreeNode> getChildren() {
		return children;
	}
	
	/**
	 * 
	 * @param treeNode
	 */
	public void addChild(final TreeNode treeNode) {
		if (children == null) {
			children = new LinkedList<>();
		}
		
		if (treeNode != null) {
			children.add(treeNode);
		}
	}
	
	/**
	 * Adds the new child for this node.
	 * 
	 * @param data
	 */
	public void addChild(final String data) {
		addChild(new TreeNode(this, data));
	}
	
	/**
	 * Returns the string representation of this object.
	 * For Example:
	 * 
	 * <pre>
	 * CEO
	 * |-- CTO
	 * |   |-- Server
	 * |   |-- iOS
	 * |   |   |-- Objective-C
	 * |   |   |-- Swift
	 * |   |-- Android
	 * |-- CFO
	 * </pre>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder nodeString = new StringBuilder();
		// if (hasParent()) {
		// nodeString.append("|\n");
		// }
		
		if (getData() != null) {
			nodeString.append(getData());
			if (SHOW_DEPTH) {
				nodeString.append(" [").append(maxHeight(this)).append("]");
			}
			nodeString.append("\n");
		}
		
		if (hasChildren()) {
			for (TreeNode child : getChildren()) {
				int nodeLevel = maxDepth(child);
				for (int i = 1; i < nodeLevel - 1; i++) {
					nodeString.append("|   ");
				}
				nodeString.append("|-- ").append(child.toString());
			}
		}
		
		return nodeString.toString();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ROOT
		TreeNode root = new TreeNode(null, "CEO");
		System.out.println(root);
		System.out.println("Edges:" + TreeNode.maxEdges(root));
		System.out.println();
		
		// CTO
		TreeNode cto = new TreeNode(root, "CTO");
		root.addChild(cto);
		// Server
		cto.addChild("Server");
		// IOS
		TreeNode iOS = new TreeNode(cto, "iOS");
		cto.addChild(iOS);
		iOS.addChild("Objective-C");
		iOS.addChild("Swift");
		// Android
		cto.addChild("Android");
		
		// CFO
		TreeNode cfo = new TreeNode(root, "CFO");
		root.addChild(cfo);
		System.out.println(root);
		System.out.println("Edges:" + TreeNode.maxEdges(root));
	}
}

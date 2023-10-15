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
package com.devamatre.algorithms.tree;

import java.util.Scanner;

import com.devamatre.datastructure.trees.Node;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-08-29 05:42:28 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public final class TreeUtils {
	
	/**
	 * 
	 * @param height
	 * @return
	 */
	public static int countSpaces(final int height) {
		return (int) (3 * Math.pow(2, height - 2) - 1);
	}
	
	/**
	 * 
	 * @param height
	 * @return
	 */
	public static int countSlashes(final int height) {
		return ((height <= 3) ? (height - 1) : (int) (3 * Math.pow(2, height - 3) - 1));
	}
	
	/**
	 * Returns the length of the path to its root.
	 * 
	 * @param node
	 * @return
	 */
	public static <T> int maxDepth(Node<T> node) {
		return (node == null ? 0 : 1 + maxDepth(node.getParent()));
	}
	
	/**
	 * Returns the length of the longest path to a leaf.
	 * 
	 * @param node
	 * @return
	 */
	public static <T> int maxHeight(Node<T> node) {
		return (node == null ? 0 : 1 + (Math.max(maxHeight(node.getLeftNode()), maxHeight(node.getRightNode()))));
	}
	
	/**
	 * Adds the <code>totalSpaces</code>.
	 * 
	 * @param count
	 * @param treeBuilder
	 */
	public static void addSpaces(final int totalSpaces, final StringBuilder treeBuilder) {
		for (int i = 0; i < totalSpaces; i++) {
			treeBuilder.append(" ");
		}
	}
	
	/**
	 * Prints the preety tree.
	 * 
	 * <pre>
	 *      1  
	 *     / \
	 *    /   \
	 *   2     3
	 * </pre>
	 * 
	 * @param root
	 * @param currentHeight
	 * @param maxHeight
	 * @return
	 */
	public static <T> StringBuilder printPrettyTree(Node<T> root, int currentHeight, int maxHeight) {
		final StringBuilder treeBuilder = new StringBuilder();
		int spaces = countSpaces(maxHeight - currentHeight + 1);
		if (root == null) {
			// create a 'spatial' block and return it
			String row = String.format("%" + (2 * spaces + 1) + "s%n", "");
			// now repeat this row space+1 times
			final String block = new String(new char[spaces + 1]).replace("\0", row);
			return new StringBuilder(block);
		}
		
		if (currentHeight == maxHeight) {
			return new StringBuilder(root.getData().toString());
		}
		
		int slashes = countSlashes(maxHeight - currentHeight + 1);
		treeBuilder.append(String.format("%" + (spaces + 1) + "s%" + spaces + "s", root.getData().toString(), ""));
		treeBuilder.append("\n");
		/*
		 * now print / and \
		 * but make sure that left and right exists
		 */
		char leftSlash = root.hasLeftChild() ? '/' : ' ';
		char rightSlash = root.hasRightChild() ? '\\' : ' ';
		int spaceInBetween = 1;
		for (int i = 0, space = spaces - 1; i < slashes; i++, space--, spaceInBetween += 2) {
			addSpaces(space, treeBuilder);
			treeBuilder.append(leftSlash);
			addSpaces(spaceInBetween, treeBuilder);
			treeBuilder.append(rightSlash + "");
			addSpaces(space, treeBuilder);
			treeBuilder.append("\n");
		}
		
		// sb.append("\n");
		
		/* now get string representations of left and right subtrees */
		final StringBuilder leftTreeBuilder = printPrettyTree(root.getLeftNode(), currentHeight + 1, maxHeight);
		final StringBuilder rightTreeBuilder = printPrettyTree(root.getRightNode(), currentHeight + 1, maxHeight);
		/* now line by line print the trees side by side */
		final Scanner leftScanner = new Scanner(leftTreeBuilder.toString());
		final Scanner rightScanner = new Scanner(rightTreeBuilder.toString());
		// spaceInBetween+=1;
		while (leftScanner.hasNextLine()) {
			if (currentHeight == maxHeight - 1) {
				treeBuilder.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
				treeBuilder.append("\n");
				spaceInBetween -= 2;
			} else {
				treeBuilder.append(leftScanner.nextLine());
				treeBuilder.append(" ");
				treeBuilder.append(rightScanner.nextLine());
				treeBuilder.append("\n");
			}
		}
		
		leftScanner.close();
		rightScanner.close();
		
		return treeBuilder;
	}
	
	/**
	 * Removes the last space.
	 * 
	 * @param nodeBuilder
	 */
	public static void trimLastSpace(final StringBuilder nodeBuilder) {
		// remove last white space.
		int lastIndex = nodeBuilder.lastIndexOf(" ");
		if (lastIndex != -1) {
			nodeBuilder.deleteCharAt(lastIndex);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Node<Integer> root = new Node<Integer>(1);
		root.addLeftNode(2);
		root.addRightNode(3);
		System.out.println(maxHeight(root));
		System.out.println(printPrettyTree(root, 0, maxHeight(root)));
		
		root.getLeftNode().addLeftNode(4);
		System.out.println(printPrettyTree(root, 0, maxHeight(root)));
	}
	
}

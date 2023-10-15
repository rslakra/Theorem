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
package com.rslakra.datastructure.trees;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-09-11 06:11:03 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class GenericTree<E> {
	
	private GenericNode<E> root;
	
	/**
	 * 
	 * @param data
	 */
	public GenericTree(E data) {
		root = new GenericNode<E>(data);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasChildren() {
		return (root == null ? false : root.hasChildren());
	}
	
	/**
	 * 
	 * @return
	 */
	public int countChildren() {
		return (hasChildren() ? root.getChildren().size() : 0);
	}
	
	/**
	 * 
	 * @param parent
	 * @param data
	 */
	public void addChild(GenericNode<E> parent, GenericNode<E> child) {
		if (parent == null) {
			root.addChild(child);
		} else {
			parent.addChild(child);
		}
	}
	
	/**
	 * 
	 * @param parent
	 * @param data
	 */
	public void addChild(GenericNode<E> parent, E data) {
		this.addChild(parent, new GenericNode<E>(data));
	}
	
	/**
	 * 
	 * @param child
	 */
	public void addChild(GenericNode<E> child) {
		root.addChild(child);
	}
	
	/**
	 * 
	 * @param data
	 */
	public void addChild(E data) {
		root.addChild(data);
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (root == null ? "" : root.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericTree<String> gTree = new GenericTree<>("Lakra");
		GenericNode<String> rohtash = new GenericNode<String>("Rohtash");
		rohtash.addChild("Harsh");
		rohtash.addChild("Anuj");
		gTree.addChild(rohtash);
		GenericNode<String> rajesh = new GenericNode<String>("Rajesh");
		gTree.addChild(rajesh);
		System.out.println(gTree);
	}
	
}

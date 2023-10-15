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
package com.devamatre.datastructure.trees;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-09-11 06:11:22 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class GenericNode<E> implements Comparator<GenericNode<E>> {
	
	private E data;
	private List<GenericNode<E>> children;
	
	/**
	 * 
	 * @param data
	 */
	public GenericNode(E data) {
		this.data = data;
		children = new LinkedList<>();
	}
	
	/**
	 * 
	 * @return
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<GenericNode<E>> getChildren() {
		return children;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasChildren() {
		return (children.size() > 0);
	}
	
	/**
	 * 
	 * @return
	 */
	public int countChildren() {
		return (hasChildren() ? getChildren().size() : 0);
	}
	
	/**
	 * 
	 * @param parent
	 * @param data
	 */
	public void addChild(GenericNode<E> parent, GenericNode<E> child) {
		if (parent == null) {
			addChild(child);
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
		children.add(child);
	}
	
	/**
	 * 
	 * @param data
	 */
	public void addChild(E data) {
		this.addChild(new GenericNode<E>(data));
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean equals(GenericNode<E> other) {
		return (getData() == other.getData());
	}
	
	/**
	 * @param object
	 * @param other
	 * @return
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(GenericNode<E> object, GenericNode<E> other) {
		if (object != other) {
			// if (object.equals(other)) {
			// return 0;
			// }
		}
		
		return 0;
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		final StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("{");
		if (getData() != null) {
			sBuilder.append(getData().toString());
		}
		
		if (hasChildren()) {
			sBuilder.append(", {");
			for (Iterator<GenericNode<E>> iterator = children.iterator(); iterator.hasNext();) {
				GenericNode<E> child = iterator.next();
				sBuilder.append(child.toString());
				if (iterator.hasNext()) {
					sBuilder.append(", ");
				}
			}
			sBuilder.append("}");
		}
		sBuilder.append("}");
		
		return sBuilder.toString();
	}
	
}

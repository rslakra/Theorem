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
package com.devamatre.datastructure.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Maintains the trie data structure.
 * 
 * <pre>
 * {
 * 	a={
 * 		m={}, 
 * 		n={
 * 			d={}, 
 * 			y={}
 * 		  }, 
 * 		r={
 * 			e={}
 * 		  }
 * 	  }, 
 * 	l={
 * 		a={
 * 			k={
 * 				r={
 * 					a={}
 * 				  }
 *  		  }
 *  	   }, 
 *  	e={
 *  		o={}
 *  	  },
 *  	i={
 *  		o={
 *  			n={}
 *  		  }
 *  	  }
 *  	}
 * }
 * </pre>
 * 
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-09-11 05:07:50 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class TrieNode {
	private boolean leaf;
	private Map<Character, TrieNode> children;
	
	public TrieNode() {
		children = new TreeMap<>();
	}
	
	/**
	 * Returns the value of the <code>leaf</code>.
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return leaf;
	}
	
	/**
	 * Inserts the key into the 'trie' structure.
	 * 
	 * @param trieNode
	 */
	public void insert(String key) {
		if (key != null) {
			TrieNode currentNode = this;
			for (int i = 0; i < key.length(); i++) {
				Character cKey = key.charAt(i);
				if (!currentNode.children.containsKey(cKey)) {
					currentNode.children.put(cKey, new TrieNode());
				}
				currentNode = currentNode.children.get(cKey);
			}
			currentNode.leaf = true;
		}
	}
	
	/**
	 * Returns true if the key exists otherwise false.
	 * 
	 * @param key
	 * @return
	 */
	public boolean find(String key) {
		if (key != null) {
			TrieNode currentNode = this;
			for (int i = 0; i < key.length(); i++) {
				currentNode = currentNode.children.get(key.charAt(i));
				if (currentNode == null) {
					return false;
				}
			}
			
			return currentNode.leaf;
		}
		
		return false;
	}
	
	/**
	 * Returns true if it has children otherwise false.
	 * 
	 * @return
	 */
	public boolean hasChildren() {
		return (!children.isEmpty());
	}
	
	/**
	 * Returns true if the key is deleted otherwise false.
	 * 
	 * @param key
	 * @return
	 */
	public boolean delete(TrieNode current, final String key) {
		if (current != null) {
			if (key != null) {
				for (int i = 0; i < key.length(); i++) {
					if (current.hasChildren()) {
						current = current.children.get(key.charAt(i));
						// delete(current, key.substring(i + 1, key.length()));
					}
				}
			}
			
			if (key == null && current.isLeaf()) {
				if (!current.hasChildren()) {
					return true;
				} else {
					current.leaf = false;
					return false;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return children.toString();
	}
}

/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.datastructure.trees;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-13 04:36:10 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class TreeDemo {

	/**
	 * 
	 * @param bTree
	 */
	public static void fillPresidentTree(BinaryTree<String> bTree) {
		bTree.add("Lincoin");
		bTree.add("Jefferson");
		bTree.add("Jackson");
		bTree.add("Adams");
		bTree.add("Kennedy");
		bTree.add("Washington");
		bTree.add("Madison");
		bTree.add("Roosevelt");
		bTree.add("Buchanan");
	}

	/**
	 * 
	 * @param bTree
	 */
	public static void fillAnimalSpeciesTree(BinaryTree<String> bTree) {
		bTree.add("Anamilia");
		bTree.add("Chordate");
		bTree.add("Mammal");
		bTree.add("Arthropoda");
		bTree.add("Insect");
		bTree.add("Primate");
		bTree.add("Carnivora");
		bTree.add("Diptera");
		bTree.add("Hominidac");
		bTree.add("Pongidae");
		bTree.add("Felidae");
		bTree.add("Muscidae");
		bTree.add("Homo");
		bTree.add("Pan");
		bTree.add("Felis");
		bTree.add("Musca");
		bTree.add("Sapiens");
		bTree.add("Troglodytes");
		bTree.add("Domestica");
		bTree.add("Leo");
		bTree.add("Domestica");
		bTree.add("Human");
		bTree.add("Chimpanzee");
		bTree.add("House Cat");
		bTree.add("Lion");
		bTree.add("Housefly");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree<String> bTree = new BinaryTree<String>();
		fillPresidentTree(bTree);
		System.out.println("Size:" + bTree.getSize());
		System.out.println(bTree.contain("Jackson"));

		System.out.println(bTree);
	}

}

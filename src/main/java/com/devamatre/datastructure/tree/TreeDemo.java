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
package com.devamatre.datastructure.trees;

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

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
package com.rslakra.datastructure.hashes;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-01-07 03:36:09 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class HashDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashTable<Integer, Integer> hashTable = new HashTable<>();
		System.out.println(hashTable.get(1));
		System.out.println();

		// add entries in hashmap.
		hashTable.put(1, 11);
		hashTable.put(2, 12);
		hashTable.put(3, 13);
		hashTable.put(4, 14);
		System.out.println("Size:" + hashTable.size());
		System.out.println(hashTable.get(1));
		System.out.println();
		// remove entries from hash map.
		hashTable.remove(3);
		System.out.println("Size:" + hashTable.size());
		System.out.println(hashTable);
		System.out.println();

		// check has key or value in hash table
		System.out.println(hashTable.hasKey(2));
		System.out.println(hashTable.hasKey(3));
		System.out.println(hashTable.hasValue(14));
		System.out.println();
		
//		HashTable<Integer, Integer> newHashTable = new HashTable<>();
//		newHashTable.put(10, 1);
//		newHashTable.put(hashTable, hashTable);

	}

}

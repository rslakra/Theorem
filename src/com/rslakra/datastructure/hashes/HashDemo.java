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

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
 * @created 2018-01-07 03:41:59 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class HashTable<K, V> {

	private int capacity;
	private HashEntry[] entries;
	private int size;

	class HashEntry<K, V> {
		K key;
		V value;

		public HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Returns the value of key.
		 *
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Returns the value of value.
		 *
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		public int hashCode() {
			if (key != null && value != null) {
				return 31 * key.hashCode() * value.hashCode();
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
			return new StringBuilder().append(key).append("=").append(value).toString();
		}

	}

	/**
	 * 
	 * @param capacity
	 */
	public HashTable(int capacity) {
		this.capacity = capacity;
		entries = new HashEntry[this.capacity];
		size = 0;
	}

	/**
	 * 
	 */
	public HashTable() {
		this(16);
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the hash for the key.
	 * 
	 * @param key
	 * @return
	 */
	private int keyHash(K key) {
		int hash = key.hashCode() % this.capacity;
		// mandatory to handle collisions, if any
		while (entries[hash] != null && !entries[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;
		}

		return hash;
	}

	/**
	 * Returns the value of the key.
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V get(K key) {
		return (V) entries[keyHash(key)];
	}

	/**
	 * The value of the key to be set.
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		entries[keyHash(key)] = new HashEntry<K, V>(key, value);
		size++;
	}

	public V remove(K key) {
		V value = (V) entries[keyHash(key)];
		entries[keyHash(key)] = null;
		size--;
		return value;
	}

}

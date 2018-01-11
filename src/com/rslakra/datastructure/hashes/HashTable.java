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
	private HashEntry<K, V>[] entries;
	private int size;

	/**
	 * Returns the hash for the key.
	 * 
	 * @param key
	 * @return
	 */
	private final int keyHash(K key) {
		int hash = key.hashCode() % this.capacity;
		// mandatory to handle collisions, if any
		while (entries[hash] != null && !entries[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;
		}

		return hash;
	}

	class HashEntry<K, V> {
		final K key;
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

		/**
		 * The value to be set.
		 * 
		 * @param value
		 */
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * Returns the hash code of the hash table.
		 * 
		 * @return
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {
			return ((key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode()));
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

	/**
	 * Remves the element for the key.
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		V value = get(key);

		// handle collissions, if any
		if (value != null) {
			int hash = keyHash(key);
			entries[hash] = null;
			size--;
			hash = (hash + 1) % capacity;

			// find all entries of the similar hash, if any
			while (entries[hash] != null) {
				HashEntry<K, V> entry = entries[hash];
				entries[hash] = null;
				size--;
				put(entry.getKey(), entry.getValue());
				hash = (hash + 1) % capacity;
			}
		}

		return value;
	}

	/**
	 * Returns true if the key exists in the hash table otherwise false.
	 * 
	 * @param key
	 * @return
	 */
	public boolean hasKey(K key) {
		int hash = keyHash(key);
		return (entries[hash] != null && entries[hash].getKey().equals(key));
	}

	/**
	 * Returns true if the value exists in the hash table otherwise false.
	 * 
	 * @param value
	 * @return
	 */
	public boolean hasValue(V value) {
		for (int i = 0; i < capacity; i++) {
			HashEntry<K, V> entry = entries[i];
			if (entry != null && entry.getValue().equals(value)) {
				return true;
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
		StringBuilder sBuilder = new StringBuilder("{");
		boolean isFirst = true;
		for (int i = 0; i < capacity; i++) {
			HashEntry<K, V> entry = entries[i];
			if (entry != null) {
				if (isFirst) {
					isFirst = false;
				} else {
					sBuilder.append(", ");
				}

				sBuilder.append((entry.getKey() == this ? "(this map)" : entry.getKey()));
				sBuilder.append("=");
				sBuilder.append((entry.getValue() == this ? "(this map)" : entry.getValue()));
			}
		}

		return sBuilder.append("}").toString();
	}

}

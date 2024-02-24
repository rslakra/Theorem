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
package com.devamatre.theorem.adts.trie;

import com.devamatre.appsuite.core.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Maintains the trie data structure.
 *
 * <url>https://en.wikipedia.org/wiki/Trie</url>
 *
 * <pre>
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-11 05:07:50 PM
 * @since 1.0.0
 */
public abstract class TrieNode<E extends Comparable<? super E>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrieNode.class);
    private E value;
    private boolean endOfKey;
    private int size = 0;

    /**
     * @param value
     */
    public TrieNode(E value) {
        LOGGER.trace("TrieNode()");
        this.value = value;
    }

    /**
     * Default Constructor.
     */
    public TrieNode() {
        this(null);
    }

    /**
     * Returns the value of the <code>value</code> property.
     *
     * @return
     */
    public E getValue() {
        return value;
    }

    /**
     * The <code>value</code> to be set.
     *
     * @param value
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Returns the value of the <code>endOfKey</code> property.
     *
     * @return
     */
    public final boolean isEndOfKey() {
        return endOfKey;
    }

    /**
     * The <code>leaf</code> to be set.
     *
     * @param endOfKey
     */
    public final void setEndOfKey(boolean endOfKey) {
        this.endOfKey = endOfKey;
    }

    /**
     * Returns the value of the <code>size</code> property.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Increases the size of the nodes count.
     */
    protected void increaseSize() {
        size++;
    }

    /**
     * Increases the size of the nodes count.
     */
    protected void decreaseSize() {
        size--;
        if (size < 0) {
            size = 0;
        }
    }

    /**
     * Inserts the key into the 'trie' structure.
     *
     * @param key
     */
    public abstract void insert(String key);

    /**
     * Returns true if the key exists otherwise false.
     *
     * @param key
     * @return
     */
    public abstract boolean find(String key);

    /**
     * Returns true if the key is deleted otherwise false.
     *
     * @param key
     * @return
     */
    public abstract boolean delete(String key);

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return ToString.of(TrieNode.class, true).add("value", getValue()).add("endOfKey", isEndOfKey()).toString();
    }

}

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
package com.rslakra.theorem.adts.trie;

import com.rslakra.appsuite.core.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

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
public class ArrayTrieNode<E extends Comparable<? super E>> extends TrieNode<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayTrieNode.class);

    private ArrayTrieNode[] children;

    /**
     * @param value
     */
    public ArrayTrieNode(E value) {
        super(value);
        LOGGER.trace("SetTrieNode({}, {})", value);
        // size 256 covers all unicode chars.
        children = new ArrayTrieNode[256];
    }

    /**
     *
     */
    public ArrayTrieNode() {
        this(null);
    }

    /**
     * Returns the <code>children</code> object.
     *
     * @return
     */
    private ArrayTrieNode[] getChildren() {
        return children;
    }

    /**
     * Returns true if the trie contains the <code>trieKey</code> otherwise false.
     *
     * @param trieKey
     * @return
     */
    private boolean contains(Character trieKey) {
        return getTrieNode(trieKey) != null;
    }

    /**
     * @param trieKey
     * @return
     */
    private ArrayTrieNode<E> getTrieNode(char trieKey) {
        return getChildren()[trieKey];
    }


    /**
     * Returns the size of the current node.
     *
     * @return
     */
    @Override
    public int getSize() {
        int size = super.getSize();
        ArrayTrieNode<E> rootNode = this;
        for (int i = 0; i < children.length; i++) {
            Character trieKey = (char) i;
            if (rootNode.contains(trieKey)) {
                size += rootNode.getTrieNode(trieKey).getSize();
            }
        }

        return size;
    }

    /**
     * Returns the string representation of <code>rootNode</code> node.
     *
     * @param rootNode
     * @return
     */
    private String toStringRecursively(ArrayTrieNode<E> rootNode) {
        ToString trieBuilder = ToString.of(ArrayTrieNode.class, true);
        if (rootNode != null) {
            // iterate over all the children of the rootNode
            for (int i = 0; i < children.length; i++) {
                Character trieKey = (char) i;
                // build to string of all the values of a node.
                if (rootNode.contains(trieKey)) {
                    trieBuilder.add(Objects.toString(trieKey));
                    ArrayTrieNode<E> trieNode = rootNode.getTrieNode(trieKey);
                    trieBuilder.add(toStringRecursively(trieNode));
                    trieBuilder.add("value", trieNode.getValue());
                    trieBuilder.add("endOfKey", trieNode.isEndOfKey());
                }
            }
        }

        return trieBuilder.toString();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see Object#toString()
     */
    public String toString() {
        return ToString.of(ArrayTrieNode.class, true)
            .add(toStringRecursively(this))
            .toString();
    }

    /**
     * Inserts the key into the 'trie' structure.
     *
     * @param key
     */
    @Override
    public void insert(String key) {
        LOGGER.trace("+insert({})", key);
        if (key != null) {
            ArrayTrieNode<E> rootNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character trieKey = key.charAt(i);
                if (!rootNode.contains(trieKey)) {
                    rootNode.getChildren()[trieKey] = new ArrayTrieNode<>();
                    rootNode.increaseSize();
                }
                rootNode = rootNode.getTrieNode(trieKey);
            }
            rootNode.setEndOfKey(true);
        }
        LOGGER.trace("-insert()");
    }

    /**
     * Returns true if the key exists otherwise false.
     *
     * @param key
     * @return
     */
    @Override
    public boolean find(String key) {
        LOGGER.debug("+find({})", key);
        if (key != null) {
            ArrayTrieNode<E> rootNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character trieKey = key.charAt(i);
                if (rootNode.contains(trieKey)) {
                    rootNode = rootNode.getTrieNode(trieKey);
                } else {
                    LOGGER.debug("trieKey:{} does not exists!, return false", trieKey);
                    return false;
                }
            }

            LOGGER.debug("rootNode:{}", rootNode);
            return rootNode.isEndOfKey();
        }

        LOGGER.debug("-find(), false");
        return false;
    }

    /**
     * Returns true if the key is deleted otherwise false.
     *
     * @param key
     * @return
     */
    @Override
    public boolean delete(final String key) {
        boolean nodeDeleted = false;
        if (key != null) {
            ArrayTrieNode<E> rootNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character trieKey = key.charAt(i);
                if (rootNode.contains(trieKey)) {
                    rootNode = rootNode.getTrieNode(trieKey);
                } else {
                    LOGGER.debug("trieKey:{} does not exists!, return false", trieKey);
                    return false;
                }
            }

            // if it's the last rootNode, mark the leaf rootNode = false
            if (rootNode.isEndOfKey()) {
                rootNode.setEndOfKey(false);
                rootNode.setValue(null);
                nodeDeleted = true;
            }
        }

        return nodeDeleted;
    }

}

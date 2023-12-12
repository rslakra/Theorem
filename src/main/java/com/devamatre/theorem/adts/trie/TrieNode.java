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

import java.util.Map;
import java.util.TreeMap;

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
public class TrieNode {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrieNode.class);
    private Map<Character, TrieNode> children;
    private boolean leaf;

    /**
     *
     */
    public TrieNode() {
        LOGGER.trace("TrieNode()");
        children = new TreeMap<>();
    }

    /**
     * Returns the <code>children</code> object.
     *
     * @return
     */
    protected Map<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * Returns the value of the <code>leaf</code>.
     *
     * @return
     */
    public final boolean isLeaf() {
        return leaf;
    }

    /**
     * Inserts the key into the 'trie' structure.
     *
     * @param key
     */
    public void insert(String key) {
        LOGGER.debug("+insert({})", key);
        if (key != null) {
            TrieNode trieNode = this;
            for (int i = 0; i < key.length(); i++) {
                Character nodeKey = key.charAt(i);
                if (!trieNode.children.containsKey(nodeKey)) {
                    trieNode.children.put(nodeKey, new TrieNode());
                }
                trieNode = trieNode.children.get(nodeKey);
            }
            trieNode.leaf = true;
        }
        LOGGER.debug("-insert()");
    }

    /**
     * Returns true if the key exists otherwise false.
     *
     * @param key
     * @return
     */
    public boolean find(String key) {
        LOGGER.debug("+find({})", key);
        if (key != null) {
            TrieNode trieNode = this;
            for (int i = 0; i < key.length(); i++) {
                Character nodeKey = key.charAt(i);
                if (!trieNode.children.containsKey(nodeKey)) {
                    LOGGER.debug("-find(), contains:false");
                    return false;
                }
                trieNode = trieNode.children.get(nodeKey);
            }

            LOGGER.debug("-find(), leaf:{}", trieNode.isLeaf());
            return trieNode.isLeaf();
        }

        LOGGER.debug("-find(), false");
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
     * Returns the size of the current node.
     *
     * @return
     */
    public int getSize() {
        int size = 0;
        if (!children.isEmpty()) {
            for (Character key : children.keySet()) {
                size += children.get(key).getSize();
            }
            size += children.size();
        }

        return size;
    }

    /**
     * Returns true if the key is deleted otherwise false.
     *
     * @param key
     * @return
     */
    public boolean delete(final String key) {
        boolean nodeDeleted = false;
        if (key != null) {
            TrieNode trieNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character nodeKey = key.charAt(i);
                if (trieNode.children.containsKey(nodeKey)) {
                    trieNode = trieNode.children.get(nodeKey);
                }
            }

            // if it's the last trieNode, mark the leaf trieNode = false
            if (trieNode.isLeaf()) {
                trieNode.leaf = false;
                nodeDeleted = true;
            }
        }

        return nodeDeleted;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        final ToString strBuilder = ToString.of(TrieNode.class, true);
        strBuilder.add(children.toString());
        strBuilder.add("leaf", isLeaf());
        return strBuilder.toString();
    }

}

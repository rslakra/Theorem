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

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

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
public class SetTrieNode<E extends Comparable<? super E>> extends TrieNode<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetTrieNode.class);
    private char keyChar;
    private Set<SetTrieNode<E>> children;

    /**
     * @param keyChar
     * @param value
     */
    public SetTrieNode(char keyChar, E value) {
        super(value);
        this.keyChar = keyChar;
        LOGGER.trace("SetTrieNode({}, {})", keyChar, value);
        children = new HashSet<>();
    }

    /**
     * @param keyChar
     */
    public SetTrieNode(char keyChar) {
        this(keyChar, null);
    }

    /**
     * @return
     */
    public char getKeyChar() {
        return keyChar;
    }

    /**
     * Returns the <code>children</code> object.
     *
     * @return
     */
    private Set<SetTrieNode<E>> getChildren() {
        return children;
    }

    /**
     * Returns
     *
     * @param trieKey
     * @return
     */
    private Optional<SetTrieNode<E>> getTrieNode(char trieKey) {
        return getChildren().stream().filter(trieNode -> trieNode.getKeyChar() == trieKey).findFirst();
    }

    /**
     * Returns true if the trie contains the <code>trieKey</code> otherwise false.
     *
     * @param trieKey
     * @return
     */
    private boolean contains(Character trieKey) {
        return getTrieNode(trieKey).isPresent();
    }

    /**
     * Returns the size of the current node.
     *
     * @return
     */
    @Override
    public int getSize() {
        int size = 0;
        if (!getChildren().isEmpty()) {
            // self children count
            size += getChildren().size();
            // then children's children count
            for (SetTrieNode<E> trieNode : getChildren()) {
                size += trieNode.getSize();
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
    private String toStringRecursively(SetTrieNode<E> rootNode) {
        ToString strBuilder = ToString.of(SetTrieNode.class, true);
        if (rootNode != null) {
            strBuilder.add(Objects.toString(rootNode.getKeyChar()));
            // iterate over all the children of the rootNode
            for (SetTrieNode<E> trieNode : rootNode.getChildren()) {
                // build to string of all the values of a node.
                strBuilder.add(toStringRecursively(trieNode));
            }
            strBuilder.add("value", rootNode.getValue());
            strBuilder.add("endOfKey", rootNode.isEndOfKey());
        }

        return strBuilder.toString();
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getKeyChar());
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != getClass()) {
            return false;
        }

        return getKeyChar() == ((SetTrieNode<E>) other).getKeyChar();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see Object#toString()
     */
    public String toString() {
        return ToString.of(SetTrieNode.class, true)
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
            SetTrieNode<E> rootNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character trieKey = key.charAt(i);
                if (!rootNode.contains(trieKey)) {
                    rootNode.getChildren().add(new SetTrieNode<>(trieKey));
                }
                rootNode = rootNode.getTrieNode(trieKey).get();
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
            SetTrieNode<E> rootNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character trieKey = key.charAt(i);
                Optional<SetTrieNode<E>> trieNodeOptional = rootNode.getTrieNode(trieKey);
                if (trieNodeOptional.isPresent()) {
                    rootNode = trieNodeOptional.get();
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
            SetTrieNode<E> rootNode = this;
            // iterate over all characters of the key
            for (int i = 0; i < key.length(); i++) {
                Character trieKey = key.charAt(i);
                Optional<SetTrieNode<E>> trieNodeOptional = rootNode.getTrieNode(trieKey);
                if (trieNodeOptional.isPresent()) {
                    rootNode = trieNodeOptional.get();
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

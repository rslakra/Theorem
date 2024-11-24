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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-09-11 05:07:42 PM
 * @since 1.0.0
 */
public class MapTrieTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapTrieTest.class);
    public static String[] KEYBOARD = {"the", "quick", "brown", "fox", "jumps", "over", "the", "little", "lazy", "dog"};
    public static String[]
        TRIE_DATA = {
        "those", "funny", "letters", "next", "to", "the", "amazing", "brown", "apple", "fruit", "baskets", "are", "a",
        "secret", "amount", "codes", "apply", "and", "mount", "around", "it"
    };

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> buildTrieData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{"apple", 5});
        inputs.add(new Object[]{"rohtash", 7});
        inputs.add(new Object[]{"and", 3});
        inputs.add(new Object[]{"singh", 5});
        inputs.add(new Object[]{"or", 2});
        inputs.add(new Object[]{"lakra", 5});
        inputs.add(new Object[]{"rohtash singh lakra", 17});
        inputs.add(new Object[]{"the quick brown fox jumps over the little lazy dog", 37});
        inputs.add(new Object[]{
            "those funny letters next to the amazing brown apple fruit baskets are a secret amount codes apply and mount around it",
            80});

        return inputs.iterator();
    }

    /**
     * Build Tree with strings.
     */
    @Test(dataProvider = "buildTrieData")
    public void testBuildTrie(String input, int expected) {
        Trie trie = TrieUtils.buildTrie(Arrays.asList(input.split(" ")));
        LOGGER.debug("Size:{}, trie:{}", trie.getSize(), trie);
        assertNotNull(trie);
        assertEquals(expected, trie.getSize());
    }

    /**
     * Build Tree with strings.
     */
    @Test
    public void testFind() {
        Trie trie = TrieUtils.buildTrie(Arrays.asList(KEYBOARD));
        LOGGER.debug("Size:{}, trie:{}", trie.getSize(), trie);
        assertNotNull(trie);
        assertEquals(37, trie.getSize());

        // find key
        String key = "the";
        LOGGER.debug("Find key:{}", key);
        assertTrue(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        key = "fox";
        LOGGER.debug("Find key:{}", key);
        assertTrue(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        key = "lakra";
        LOGGER.debug("Find key:{}", key);
        assertFalse(trie.find(key));
        LOGGER.debug("trie:{}", trie);
    }

    /**
     * Build Tree with strings.
     */
    @Test
    public void testDelete() {
        Trie trie = TrieUtils.buildTrie(Arrays.asList(KEYBOARD));
        LOGGER.debug("Size:{}, trie:{}", trie.getSize(), trie);
        assertNotNull(trie);
        assertEquals(37, trie.getSize());

        // delete key
        String key = "the";
        assertTrue(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertTrue(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));

        key = "fox";
        assertTrue(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertTrue(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));

        key = "lakra";
        assertFalse(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertFalse(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));
    }

    /**
     * Build Tree with strings.
     */
    @Test
    public void testTrie() {
        Trie trie = TrieUtils.buildTrie(Arrays.asList(TRIE_DATA));
        LOGGER.debug("Size:{}, trie:{}", trie.getSize(), trie);
        assertNotNull(trie);
        assertEquals(80, trie.getSize());

        // find key
        String key = "the";
        LOGGER.debug("Find key:{}", key);
        assertTrue(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        key = "brown";
        LOGGER.debug("Find key:{}", key);
        assertTrue(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        key = "amount";
        LOGGER.debug("Find key:{}", key);
        assertTrue(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        key = "mount";
        LOGGER.debug("Find key:{}", key);
        assertTrue(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        key = "lakra";
        LOGGER.debug("Find key:{}", key);
        assertFalse(trie.find(key));
        LOGGER.debug("trie:{}", trie);

        // delete key
        key = "the";
        assertTrue(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertTrue(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));

        key = "brown";
        assertTrue(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertTrue(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));

        key = "amount";
        assertTrue(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertTrue(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));

        key = "mount";
        assertTrue(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertTrue(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));

        key = "lakra";
        assertFalse(trie.find(key));
        LOGGER.debug("Delete key:{}", key);
        assertFalse(trie.delete(key));
        LOGGER.debug("trie:{}", trie);
        assertFalse(trie.find(key));
    }

}

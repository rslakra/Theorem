package com.devamatre.theorem.adts.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/6/23 2:48 PM
 */
public class TrieUtilsTest {

    /**
     * @return
     */
    @DataProvider
    public Iterator<Object[]> fillTrieData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{"a", 1});
        inputs.add(new Object[]{"apple", 5});
        inputs.add(new Object[]{"be an ant", 5});
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
    @Test(dataProvider = "fillTrieData")
    public void testFillTrie(String input, int expected) {
        Trie trie = new MapTrie();
        TrieUtils.fillTrie(trie, Arrays.asList(input.split(" ")));
        assertNotNull(trie);
        assertEquals(expected, trie.getSize());
    }

    /**
     * Build Tree with strings.
     */
    @Test(dataProvider = "fillTrieData")
    public void testBuildTrie(String input, int expected) {
        Trie trie = TrieUtils.buildTrie(Arrays.asList(input.split(" ")));
        assertNotNull(trie);
        assertEquals(expected, trie.getSize());
    }

    /**
     * Build Tree with strings.
     */
    @Test(dataProvider = "fillTrieData")
    public void testGetSize(String input, int expected) {
        Trie trie = TrieUtils.buildTrie(Arrays.asList(input.split(" ")));
        assertNotNull(trie);
        assertEquals(expected, trie.getSize());
    }

}

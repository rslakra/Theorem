package com.devamatre.theorem.adts.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * @created 11/16/23 8:51 PM
 */
public class MapTrieNodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapTrieNodeTest.class);

    /**
     * @param inputData
     * @return
     */
    public MapTrieNode buildTrieNode(List<String> inputData) {
        MapTrieNode trieNode = new MapTrieNode();
        TrieUtils.fillTrieNode(trieNode, inputData);
        LOGGER.debug("trieNode:{}", trieNode);
        return trieNode;
    }

    /**
     * @return
     */
    public MapTrieNode buildTrieNode() {
        MapTrieNode trieNode = new MapTrieNode();
        TrieUtils.fillTrieNode(trieNode,
                               Arrays.asList("am", "an", "and", "are", "bag", "bat", "cat", "cat", "dog", "done",
                                             "dose", "dot", "trie", "try"));
        LOGGER.debug("trieNode:{}", trieNode);
        return trieNode;
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> insertData() {
        List<Object[]> inputs = new ArrayList<>();
        // am, and, are, bag, bat, cat, car, dog, done, dose, dot, trie, try
        inputs.add(new Object[]{Arrays.asList("a"), 1});
        inputs.add(new Object[]{Arrays.asList("am"), 2});
        inputs.add(new Object[]{Arrays.asList("and"), 3});
        inputs.add(new Object[]{Arrays.asList("trie"), 4});
        inputs.add(new Object[]{Arrays.asList("am", "and", "are"), 6});
        inputs.add(new Object[]{Arrays.asList("bag", "bat"), 4});
        inputs.add(new Object[]{Arrays.asList("dog", "done", "dose", "dot"), 8});
        inputs.add(new Object[]{Arrays.asList("trie", "try"), 5});
        inputs.add(new Object[]{Arrays.asList("am", "an", "and", "are", "dog", "done", "dose", "dot", "trie"), 18});

        return inputs.iterator();
    }

    /**
     * Tests the <code>insert()</code> method.
     */
    @Test(dataProvider = "insertData")
    public void testInsert(List<String> inputData, int expected) {
        LOGGER.debug("testIsLeaf({})", inputData);
        MapTrieNode<String> trieNode = buildTrieNode(inputData);
        assertEquals(expected, trieNode.getSize());
    }

    /**
     * Tests the <code>getSize()</code> method.
     */
    @Test(dataProvider = "insertData")
    public void testGetSize(List<String> inputData, int expected) {
        LOGGER.debug("testGetSize({})", inputData);
        MapTrieNode<String> trieNode = buildTrieNode(inputData);
        assertEquals(expected, trieNode.getSize());
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> findData() {
        List<Object[]> inputs = new ArrayList<>();
        // a, and, ant, base, bat, care, dose, dot, trie, true
        inputs.add(new Object[]{"a", false});
        inputs.add(new Object[]{"and", true});
        inputs.add(new Object[]{"ant", false});
        inputs.add(new Object[]{"base", false});
        inputs.add(new Object[]{"care", false});
        inputs.add(new Object[]{"dose", true});
        inputs.add(new Object[]{"dot", true});
        inputs.add(new Object[]{"trie", true});
        inputs.add(new Object[]{"true", false});

        return inputs.iterator();
    }

    /**
     * Tests the <code>find()</code> method.
     */
    @Test(dataProvider = "findData")
    public void testFind(String inputData, boolean expected) {
        LOGGER.debug("testFind({})", inputData);
        MapTrieNode trieNode = buildTrieNode();
        boolean result = trieNode.find(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }

    /**
     * Data Input
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> deleteData() {
        List<Object[]> inputs = new ArrayList<>();
        // a, and, ant, base, bat, care, dose, dot, trie, true
        inputs.add(new Object[]{"a", false});
        inputs.add(new Object[]{"and", true});
        inputs.add(new Object[]{"ant", false});
        inputs.add(new Object[]{"base", false});
        inputs.add(new Object[]{"care", false});
        inputs.add(new Object[]{"dose", true});
        inputs.add(new Object[]{"dot", true});
        inputs.add(new Object[]{"trie", true});
        inputs.add(new Object[]{"true", false});

        return inputs.iterator();
    }

    /**
     * Tests the <code>delete()</code> method.
     */
    @Test(dataProvider = "deleteData")
    public void testDelete(String inputData, boolean expected) {
        LOGGER.debug("testDelete({})", inputData);
        MapTrieNode trieNode = buildTrieNode();
        boolean result = trieNode.delete(inputData);
        LOGGER.debug("result:{}", result);
        assertEquals(expected, result);
    }
}

package com.devamatre.theorem.adts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 2:01 PM
 */
public class AlgoUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlgoUtilsTest.class);

    /**
     * Tests the <code>printElements()</code> method.
     */
    @Test
    public void testPrintElements() {
        AlgoUtils.printElements(Arrays.asList(1, 2, 3, 4, 5));
    }

    /**
     * Tests the <code>printArray()</code> method.
     */
    @Test
    public void testPrintArray() {
        AlgoUtils.printArray(new Integer[]{1, 2, 3, 4, 5});
    }

    /**
     * Tests the <code>printArray()</code> method.
     */
    @Test
    public void testPrint2DArray() {
        AlgoUtils.printArray(new Integer[][]{{1, 3, 5}, {2, 4, 6}});
    }

    /**
     * Tests the <code>uniqueIntArrayGenerator()</code> method.
     */
    @Test
    public void testUniqueIntArrayGeneratorFirstElementNonEmpty() {
        boolean firstElementEmpty = false;
        int upperBound = 10;
        int size = 7;
        Integer[] result = AlgoUtils.uniqueIntArrayGenerator(size, upperBound, firstElementEmpty);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(size, result.length);
        assertNotNull(result[0]);
        Arrays.stream(result).forEach(item -> assertTrue(item < upperBound));
    }

    /**
     * Tests the <code>uniqueIntArrayGenerator()</code> method.
     */
    @Test
    public void testUniqueIntArrayGeneratorFirstElementEmpty() {
        boolean firstElementEmpty = true;
        int upperBound = 10;
        int size = 7;
        Integer[] result = AlgoUtils.uniqueIntArrayGenerator(size, upperBound, firstElementEmpty);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(size, result.length);
        assertEquals(null, result[0]);
        Arrays.stream(result).forEach(item -> {
            if (item != null) {
                assertTrue(item < upperBound);
            }
        });
    }

    /**
     * Tests the <code>uniqueIntSetGenerator()</code> method.
     */
    @Test
    public void testUniqueIntSetGenerator() {
        int upperBound = 10;
        int size = 7;
        Set<Integer> result = AlgoUtils.uniqueIntSetGenerator(size, upperBound);
        LOGGER.debug("result: {}", result);
        assertEquals(size, result.size());
        result.forEach(item -> assertTrue(item < upperBound));
    }

    /**
     * Tests the <code>uniqueIntListGenerator()</code> method.
     */
    @Test
    public void testUniqueIntListGenerator() {
        int upperBound = 10;
        int size = 7;
        List<Integer> result = AlgoUtils.uniqueIntListGenerator(size, upperBound);
        LOGGER.debug("result: {}", result);
        assertEquals(size, result.size());
        result.forEach(item -> assertTrue(item < upperBound));
    }

    /**
     * Tests the <code>randomIntArrayGenerator()</code> method.
     */
    @Test
    public void testRandomIntArrayGeneratorFirstElementNonEmpty() {
        boolean firstElementEmpty = false;
        int upperBound = 10;
        int size = 7;
        Integer[] result = AlgoUtils.randomIntArrayGenerator(size, upperBound, firstElementEmpty);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(size, result.length);
        assertNotNull(result[0]);
        Arrays.stream(result).forEach(item -> assertTrue(item < upperBound));
    }

    /**
     * Tests the <code>randomIntArrayGenerator()</code> method.
     */
    @Test
    public void testRandomIntArrayGeneratorFirstElementEmpty() {
        boolean firstElementEmpty = true;
        int upperBound = 10;
        int size = 7;
        Integer[] result = AlgoUtils.randomIntArrayGenerator(size, upperBound, firstElementEmpty);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(size, result.length);
        assertEquals(null, result[0]);
        Arrays.stream(result).forEach(item -> {
            if (item != null) {
                assertTrue(item < upperBound);
            }
        });
    }

    /**
     * Tests the <code>randomIntListGenerator()</code> method.
     */
    @Test
    public void testRandomIntListGenerator() {
        int upperBound = 10;
        int size = 7;
        List<Integer> result = AlgoUtils.randomIntListGenerator(size, upperBound);
        LOGGER.debug("result: {}", result);
        assertEquals(size, result.size());
        result.forEach(item -> assertTrue(item < upperBound));
    }

    /**
     * Tests the <code>positiveIntArrayGenerator()</code> method.
     */
    @Test
    public void testPositiveIntArrayGeneratorFirstElementNonEmpty() {
        boolean firstElementEmpty = false;
        int size = 7;
        Integer[] result = AlgoUtils.positiveIntArrayGenerator(size, firstElementEmpty);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(size, result.length);
        assertNotNull(result[0]);
        Arrays.stream(result).forEach(item -> assertTrue(item <= size));
    }

    /**
     * Tests the <code>positiveIntArrayGenerator()</code> method.
     */
    @Test
    public void testPositiveIntArrayGeneratorFirstElementEmpty() {
        boolean firstElementEmpty = true;
        int size = 7;
        Integer[] result = AlgoUtils.positiveIntArrayGenerator(size, firstElementEmpty);
        LOGGER.debug("result: {}", Arrays.toString(result));
        assertEquals(size, result.length);
        assertEquals(null, result[0]);
        Arrays.stream(result).forEach(item -> {
            if (item != null) {
                assertTrue(item <= size);
            }
        });
    }

    /**
     * Tests the <code>positiveIntSetGenerator()</code> method.
     */
    @Test
    public void testPositiveIntSetGenerator() {
        int upperBound = 10;
        int size = 7;
        Set<Integer> result = AlgoUtils.positiveIntSetGenerator(size);
        LOGGER.debug("result: {}", result);
        assertEquals(size, result.size());
        result.forEach(item -> assertTrue(item < upperBound));
    }

    /**
     * Tests the <code>positiveIntListGenerator()</code> method.
     */
    @Test
    public void testPositiveIntListGenerator() {
        int size = 7;
        List<Integer> result = AlgoUtils.positiveIntListGenerator(size);
        LOGGER.debug("result: {}", result);
        assertEquals(size, result.size());
        result.forEach(item -> assertTrue(item <= size));
    }

    /**
     * Tests the <code>hash()</code> method.
     */
    @Test
    public void testHashCode() {
        List<String> strings = Arrays.asList("abc", "acb", "bac", "cab");
        strings.forEach(str -> System.out.println("str:" + str + ", hashCode: " + Objects.hash(str)));
    }

    /**
     * Tests the <code>listAsStack()</code> method.
     */
    @Test
    public void testListAsStack() {
        LOGGER.debug("testListAsStack()");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        LOGGER.debug("list:{}", list);
        Stack<Integer> stack = AlgoUtils.listAsStack(list);
        LOGGER.debug("stack:{}", stack);
        assertEquals(list.size(), stack.size());
        assertEquals(list, stack);
    }

    /**
     * Tests the <code>stackAsList()</code> method.
     */
    @Test
    public void testStackAsList() {
        LOGGER.debug("testStackAsList()");
        Stack<Integer> stack = AlgoUtils.listAsStack(Arrays.asList(1, 2, 3, 4, 5));
        LOGGER.debug("stack:{}", stack);
        List<Integer> list = AlgoUtils.stackAsList(stack);
        LOGGER.debug("list:{}", list);
        assertEquals(list.size(), stack.size());
        assertEquals(list, stack);
    }

}

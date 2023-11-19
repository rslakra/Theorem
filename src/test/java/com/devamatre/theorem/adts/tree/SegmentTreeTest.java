package com.devamatre.theorem.adts.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 5:53 PM
 */
public class SegmentTreeTest {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentTreeTest.class);

    /**
     * Print Binary Tree
     */
    @Test
    public void testBuildSegmentTree() {
        SegmentTree segmentTree = new SegmentTree();
        int[] input = new int[]{1, 2, 3, 4, 5};
        segmentTree.buildSegmentTree(input);
        LOGGER.debug("segmentTree:{}", segmentTree);

        int rangeSum = segmentTree.getRangeSum(0, input.length);
        LOGGER.debug("rangeSum:{}", rangeSum);
        assertEquals(0, rangeSum);

        rangeSum = segmentTree.getRangeSum(0, input.length - 1);
        LOGGER.debug("rangeSum:{}", rangeSum);
        assertEquals(15, rangeSum);

        segmentTree.update(-1, 5);
        segmentTree.update(7, 5);
        segmentTree.update(2, 5);
        LOGGER.debug("segmentTree:{}", segmentTree);

        rangeSum = segmentTree.getRangeSum(0, input.length - 1);
        LOGGER.debug("rangeSum:{}", rangeSum);
        assertEquals(17, rangeSum);

        rangeSum = segmentTree.getRangeSum(1, 3);
        LOGGER.debug("rangeSum:{}", rangeSum);
        assertEquals(11, rangeSum);
    }
}

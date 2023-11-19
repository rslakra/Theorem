package com.devamatre.theorem.adts.tree;

import com.devamatre.theorem.adts.sort.CountingSort;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 10/18/23 11:53 AM
 */
public class CountSortTreeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountingSort.class);

    @Test
    public void testCountSortTree() {
        CountSortTree<Integer> tree = new CountSortTree<>();
        tree.addLeftChild(3);
        tree.addLeftChild(5);
        tree.addRightChild(1);
        LOGGER.debug("tree: {}", tree);
    }

}

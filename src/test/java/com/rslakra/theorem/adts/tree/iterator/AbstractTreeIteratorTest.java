package com.rslakra.theorem.adts.tree.iterator;

import com.rslakra.theorem.adts.tree.TreeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 11/27/23 12:39 PM
 */
public abstract class AbstractTreeIteratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTreeIteratorTest.class);

    /**
     * Returns the <code>TreeIterator</code> object.
     *
     * @return
     */
    public abstract TreeIterator buildTreeIterator();

    /**
     * Logs the <code>treeIterator</code> object.
     *
     * @param treeIterator
     */
    public void logTreeIterator(TreeIterator treeIterator) {
        LOGGER.debug("+logTreeIterator({})", treeIterator);
        while (treeIterator.hasNext()) {
            LOGGER.debug("{}", treeIterator.next());
        }
        LOGGER.debug("-logTreeIterator({})", treeIterator);
    }

}

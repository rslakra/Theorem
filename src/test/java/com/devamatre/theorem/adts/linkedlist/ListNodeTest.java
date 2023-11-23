package com.devamatre.theorem.adts.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.AlgoUtils;
import com.devamatre.theorem.adts.list.ListType;
import com.devamatre.theorem.adts.list.ListUtils;
import com.devamatre.theorem.adts.list.Node;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 2:18 PM
 */
public class ListNodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListNodeTest.class);

    @Test
    public void testCreateSinglyLinkedList() {
        List<Integer> values = AlgoUtils.randomIntListGenerator(10, 20);
        LOGGER.debug("Size:{}, list:{}", values.size(), values);
        assertNotNull(values);
        assertEquals(10, values.size());

        Node<Integer> head = ListUtils.buildSinglyLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        LOGGER.debug("head:{}", head);
        assertNotNull(head);
    }


    /**
     * Tests the <code>ArrayList</code>.
     */
    @Test
    public void testLinkedList() {
        // array list.
        List<String> list = new LinkedList<>();
        LOGGER.debug("Size:{}, list:{}", list.size(), list);
        assertNotNull(list);
        assertEquals(0, list.size());
        ListType.fillList(list);

        LOGGER.debug("Size:{}, list:{}", list.size(), list);
        assertNotNull(list);
        assertEquals(51, list.size());
    }
}

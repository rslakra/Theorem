package com.devamatre.theorem.adts.list;

import com.devamatre.theorem.adts.AlgoUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 2:18 PM
 */
public class ListNodeTest {

    @Test
    public void testCreateSinglyLinkedList() {
        System.out.println("0x7F: " + 0x7F);
        List<Integer> values = AlgoUtils.randomIntListGenerator(10, 20);
        AlgoUtils.printElements(values);
        ListNode head = ListUtils.buildSinglyLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(head);
        System.out.println("The end.");
    }
}

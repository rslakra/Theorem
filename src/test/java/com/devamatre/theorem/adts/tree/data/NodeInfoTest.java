package com.devamatre.theorem.adts.tree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 12/12/23 12:38 PM
 */
public class NodeInfoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeInfoTest.class);

    @Test
    public void testNodeInfo() {
        NodeInfo<Integer> nodeInfo = new NodeInfo<>(1, 1);
        LOGGER.debug("nodeInfo:{}", nodeInfo);
        assertNotNull(nodeInfo);
        assertNull(nodeInfo.getNode());
        assertEquals(1, nodeInfo.getLevel());
        assertEquals(1, nodeInfo.getHeight());
        assertEquals(Long.valueOf(0).longValue(), nodeInfo.getDiameter());
    }
}

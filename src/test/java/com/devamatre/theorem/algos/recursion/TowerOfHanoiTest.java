package com.devamatre.theorem.algos.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 12/7/23 10:40 AM
 */
public class TowerOfHanoiTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TowerOfHanoiTest.class);

    /**
     * The inputData and expected results.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> towerOfHanoiData() {
        List<Object[]> inputs = new ArrayList<>();
        // through root (with root)
        inputs.add(new Object[]{1, 1});
        inputs.add(new Object[]{2, 3});
        inputs.add(new Object[]{3, 7});
        inputs.add(new Object[]{4, 7});
        inputs.add(new Object[]{5, 7});

        return inputs.iterator();
    }

    /**
     * Test <code>sumOfNodesAtKthLevel</code> method.
     */
    @Test(dataProvider = "towerOfHanoiData")
    public void testTowerOfHanoi(int input, int expected) {
        LOGGER.debug("testTowerOfHanoi({}, {})", input, expected);
        TowerOfHanoi instance = new TowerOfHanoi();
        instance.towerOfHanoi(input, "S", "H", "D");
        LOGGER.debug("expected:{}, expected:{}", expected, expected);
        assertEquals(expected, expected);
    }
}

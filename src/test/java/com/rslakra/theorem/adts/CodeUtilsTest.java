package com.rslakra.theorem.adts;

import static org.testng.AssertJUnit.assertNotNull;

import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 3:23 PM
 */
public class CodeUtilsTest {

    @Test
    public void testCodeUtils() {
        assertNotNull(CodeUtils.INSTANCE);
    }

}

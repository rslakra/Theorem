package com.devamatre.theorem.adts;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

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

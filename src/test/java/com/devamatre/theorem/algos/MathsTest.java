package com.devamatre.theorem.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 10/15/2023 11:17 AM
 */
public class MathsTest {

    @Test
    public void testPower() {
        double power = Maths.power(2, 3);
        assertEquals(8, power);
    }

}

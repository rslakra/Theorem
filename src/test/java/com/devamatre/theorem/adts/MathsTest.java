package com.devamatre.theorem.adts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 9/9/23 6:17 PM
 */
public class MathsTest {

    @Test
    public void testGCD() {
        Assertions.assertEquals(4, Maths.gcd(8, 12));
        assertEquals(4, Maths.gcdEuclidean(8, 12));
        assertEquals(4, Maths.gcdEuclideanRecursively(8, 12));
    }

}

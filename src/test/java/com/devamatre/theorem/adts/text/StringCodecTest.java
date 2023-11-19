package com.devamatre.theorem.adts.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 4/21/21 5:11 PM
 */
public class StringCodecTest {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(StringCodecTest.class);

    @Test
    public void testStringCodec() {
        StringCodec stringCodec = new StringCodec();
        List<String> listStrings = Arrays.asList("Rohtash", "Singh", "Lakra", "7#Rohtash5#Singh5#Lakra");
        LOGGER.debug("{}", listStrings);
        assertEquals(4, listStrings.size());
        String encoded = stringCodec.encode(listStrings);
        LOGGER.debug("encoded:{}, length:{}", encoded, encoded.length());
        assertEquals(49, encoded.length());
        assertEquals("7#Rohtash5#Singh5#Lakra23#7#Rohtash5#Singh5#Lakra", encoded);
        List<String> result = stringCodec.decode(encoded);
        LOGGER.debug("result:{}", result);
        assertEquals(4, result.size());
        assertEquals(listStrings, result);
    }
}

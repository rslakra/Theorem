package com.rslakra.theorem.domain.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.rslakra.appsuite.core.text.TextUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 11/18/23 1:42 PM
 */
public class NameTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameTest.class);


    /**
     *
     */
    @Test
    public void testName() {
        Name name = new Name("Rohtash", "Singh", "Lakra");
        assertNotNull(name);
        LOGGER.debug("name:{}", name);
        assertEquals("Rohtash", name.getFirstName());
        assertEquals("Singh", name.getMiddleName());
        assertEquals("Lakra", name.getLastName());
        System.out.println();
        LOGGER.debug("name:{}", TextUtils.toString(name));
        System.out.println();
        LOGGER.debug("name:{}", TextUtils.toString(name, true));
        System.out.println();
        LOGGER.debug("name:{}", TextUtils.toString(name, true, true));

        List<Name> names = new ArrayList<>();
        names.add(new Name("Rohtash", "Singh", "Lakra"));
        names.add(new Name("Sangita", "Lakra"));
        assertNotNull(name);
        assertEquals(2, names.size());

        LOGGER.debug("names:{}", names);
        System.out.println();
        LOGGER.debug("name:{}", TextUtils.toString(names));
        System.out.println();
        LOGGER.debug("name:{}", TextUtils.toString(names, true));
        System.out.println();
        LOGGER.debug("name:{}", TextUtils.toString(names, true, true));
    }

}

package com.rslakra.theorem.adts.search.text;

import static com.rslakra.theorem.adts.search.text.AbstractSearchable.testSearchable;

import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 11/14/23 6:36 PM
 */
public class SearchableTest {

    @Test
    public void testBoyerMooreHorspoolSearchable() {
        testSearchable(new BoyerMooreHorspoolSearchable());
    }

    @Test
    public void testNaiveAbstractSearchable() {
        testSearchable(new NaiveAbstractSearchable());
    }

}
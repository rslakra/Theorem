/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.adts.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 6:55 PM
 */
public class DateTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTest.class);

    /**
     * Valid year data.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isValidYearData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1905, 2, 13, "2/13/1905"});
        inputs.add(new Object[]{1983, 6, 1, "6/1/1983"});
        inputs.add(new Object[]{2000, 10, 29, "10/29/2000"});

        return inputs.iterator();
    }

    /**
     * Tests the <code>buildTree</code> method.
     */
    @Test(dataProvider = "isValidYearData")
    public void testIsValidYear(Integer year, Integer month, Integer day, String expected) {
        Date date = new Date(year, month, day);
        LOGGER.debug("date:{}", date);
        assertNotNull(date);
        assertEquals(expected, date.toShort());
    }


    /**
     * Valid year data.
     *
     * @return
     */
    @DataProvider
    public Iterator<Object[]> isLeapMonthData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1905, 2, 13, false});
        inputs.add(new Object[]{1983, 6, 01, false});
        inputs.add(new Object[]{2000, 2, 29, true});

        return inputs.iterator();
    }

    /**
     * @param year
     * @param month
     * @param day
     * @param expected
     */
    @Test(dataProvider = "isLeapMonthData")
    public void testIsLeapMonth(Integer year, Integer month, Integer day, Boolean expected) {
        Date date = new Date(year, month, day);
        LOGGER.debug("date:{}", date);
        assertNotNull(date);
        assertEquals(expected, date.isLeapYear());
        assertEquals(expected, date.isLeapMonth());
    }

    @Test
    public void testIsLastDayOfMonth() {

    }

    @Test
    public void testIsFirstDayOfMonth() {

    }

    @Test
    public void testIsLastMonthOfYear() {

    }

    @Test
    public void testIsFirstMonthOfYear() {

    }

    @Test
    public static void testDate() {
        Date myDate = new Date(1905, 2, 13);
        assertNotNull(myDate);
        assertEquals("2/13/1905", myDate.toShort());
        LOGGER.debug("myDate:{}, Leap Year:{}", myDate, myDate.isLeapYear());

        Date yourDate = new Date(1983, 6, 01);
        assertNotNull(yourDate);
        assertEquals("6/1/1983", yourDate.toShort());
        LOGGER.debug("yourDate:{}, Leap Year:{}", yourDate, yourDate.isLeapYear());

        Date ourDate = new Date(2000, 10, 29);
        assertNotNull(ourDate);
        assertEquals("10/29/2000", ourDate.toShort());
        LOGGER.debug("ourDate:{}, Leap Year:{}", ourDate, ourDate.isLeapYear());

        Date today = new Date(1905, 12, 31);
        assertNotNull(today);
        assertEquals("12/31/1905", today.toShort());
        assertTrue(today.isLastDayOfMonth());
        assertTrue(today.isLastMonthOfYear());
        LOGGER.debug("today:{}, Leap Year:{}", today, today.isLeapYear());
        LOGGER.debug("isLastDayOfMonth:{}, isLastMonthOfYear:{}", today.isLastDayOfMonth(), today.isLastMonthOfYear());

        Date date = new Date(2020, 10, 29);
        assertNotNull(date);
        assertEquals("10/29/2020", date.toShort());
        LOGGER.debug("date:{}, Leap Year:{}", date, date.isLeapYear());
    }

}

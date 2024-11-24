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
package com.rslakra.theorem.adts.time;

public class DateTransformerTest {

    public static void main(String[] args) {
        DateTransformer myDate = new DateTransformer(1905, 2, 13);
        System.out.println("myDate:" + myDate);

        /*
         * Increment Test-cases.
         */
        Date tomorrow = myDate.increment();
        System.out.println("tomorrow:" + tomorrow);
        System.out.println();

        // Last Month of Year
        DateTransformer lastMonthOfYear = new DateTransformer(1905, 12, 31);
        System.out.println("lastMonthOfYear:" + lastMonthOfYear);
        Date nextDayOfLastMonthOfYear = lastMonthOfYear.increment();
        System.out.println("nextDayOfLastMonthOfYear:" + nextDayOfLastMonthOfYear);
        System.out.println();

        // Last day of Month
        DateTransformer lastDayOfMonth = new DateTransformer(1905, 11, 30);
        System.out.println("lastDayOfMonth:" + lastDayOfMonth);
        Date nextDayOfLastDayOfMonth = lastDayOfMonth.increment();
        System.out.println("nextDayOfLastDayOfMonth:" + nextDayOfLastDayOfMonth);
        System.out.println();
        System.out.println();
        /*
         * Decrement Test-cases.
         */
        DateTransformer todayDate = new DateTransformer(2016, 9, 2);
        System.out.println("todayDate:" + todayDate);

        Date yesterday = todayDate.decrement();
        System.out.println("yesterday:" + yesterday);
        System.out.println();

        // Last Month of Year
        DateTransformer firstMonthOfYear = new DateTransformer(2016, 1, 1);
        System.out.println("firstMonthOfYear:" + firstMonthOfYear);
        Date previousDayOfFirstMonthOfYear = firstMonthOfYear.decrement();
        System.out.println("previousDayOfFirstMonthOfYear:" + previousDayOfFirstMonthOfYear);
        System.out.println();

        // Last day of Month
        DateTransformer firstDayOfMonth = new DateTransformer(1905, 11, 1);
        System.out.println("firstDayOfMonth:" + firstDayOfMonth);
        Date previousDayOfFirstDayOfMonth = firstDayOfMonth.decrement();
        System.out.println("previousDayOfFirstDayOfMonth:" + previousDayOfFirstDayOfMonth);
    }

}

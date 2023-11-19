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
package com.devamatre.theorem.adts;

public class DateTransformer extends Date {
    // private DateType dateType;

    /**
     * @param year
     * @param month
     * @param day
     */
    public DateTransformer(int year, int month, int day) {
        this(null, year, month, day);
    }

    /**
     * @param dateType
     * @param year
     * @param month
     * @param day
     */
    public DateTransformer(DateType dateType, int year, int month, int day) {
        super(year, month, day);
        // this.dateType = dateType;
    }

    /**
     * Increments the date to tomorrow's date.
     *
     * @return
     */
    public Date increment() {
        if (isLastMonthOfYear() && isLastDayOfMonth()) {
            setYear(getYear() + 1);
            setMonth(1);
            setDay(1);
        } else if (isLastDayOfMonth()) {
            setMonth(getMonth() + 1);
            setDay(1);
        } else {
            setDay(getDay() + 1);
        }

        return new Date(getYear(), getMonth(), getDay());
    }

    /**
     * Decrements the date to yesterday's date.
     *
     * @return
     */
    public Date decrement() {
        if (isFirstMonthOfYear() && isFirstDayOfMonth()) {
            setYear(getYear() - 1);
            setMonth(12);
            setDay(31);
        } else if (isFirstDayOfMonth()) {
            setMonth(getMonth() - 1);
            if (isExtendedMonth()) {
                setDay(31);
            } else if (isStandardMonth()) {
                setDay(30);
            } else if (isLeapMonth()) {
                setDay(29);
            } else {
                setDay(28);
            }
        } else {
            setDay(getDay() - 1);
        }

        return new Date(getYear(), getMonth(), getDay());
    }

}

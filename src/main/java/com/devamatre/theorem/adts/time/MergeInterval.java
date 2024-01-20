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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18]
 *
 * @author Rohtash Lakra
 * @date 02/14/2017 09:29:19 PM
 */
public class MergeInterval {

    /**
     * @param intervals
     * @return
     */
    public static List<Interval<Integer>> mergeIntervals(List<Interval<Integer>> intervals) {
        List<Interval<Integer>> result = new ArrayList<>();
        if (intervals != null && intervals.size() > 0) {
            // first sort the list.
            Collections.sort(intervals);
            // now merge intervals
            Interval<Integer> previous = intervals.get(0);
            for (Interval<Integer> current : intervals) {
                if (current.getStart().compareTo(previous.getEnd()) > 0) {
                    result.add(previous);
                    previous = current;
                } else {
                    previous = new Interval(previous.getStart(), Math.max(current.getEnd(), previous.getEnd()));
                }
            }

            result.add(previous);
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println(mergeIntervals(intervals));

    }

}

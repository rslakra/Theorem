/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
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
package com.rslakra.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18]
 * 
 * @author Rohtash Singh Lakra
 * @date 02/14/2017 09:29:19 PM
 *
 */
public class MergeIntervals {

	static class Interval {
		int first;
		int end;

		Interval(int first, int end) {
			this.first = first;
			this.end = end;
		}

		public String toString() {
			return "[" + first + ", " + end + "]";
		}
	}

	/**
	 * 
	 * @param intervals
	 * @return
	 */
	public static List<Interval> mergeIntervals(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();

		if (intervals != null && intervals.size() > 0) {
			// first sort the list.
			intervals.sort(new Comparator<Interval>() {

				/**
				 * @see java.util.Comparator#compare(java.lang.Object,
				 *      java.lang.Object)
				 */
				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.first != o2.first) {
						return o1.first - o2.first;
					} else {
						return o1.end - o2.end;
					}
				}
			});

			// now merge intervals
			Interval previous = intervals.get(0);
			for (Interval current : intervals) {
				if (current.first > previous.end) {
					result.add(previous);
					previous = current;
				} else {
					previous = new Interval(previous.first, Math.max(current.end, previous.end));
				}
			}

			result.add(previous);
		}

		return result;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));

		System.out.println(mergeIntervals(intervals));

	}

}

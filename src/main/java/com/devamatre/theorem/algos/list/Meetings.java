package com.devamatre.theorem.algos.list;

import com.devamatre.theorem.adts.time.Interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Dec 05, 2020 16:47:32
 */
public class Meetings {


    /**
     * person can not attend two or more meetings at one time. It means if the timings of two meetings are overlapping,
     * then she/he will not able to attend it.
     * <p>
     * <p>
     * Time Complexity: O(N^2) Space Complexity: O(1)
     *
     * @param meetings
     */
    public static boolean canAttendMeetings(List<Interval<Integer>> meetings) {
        if (meetings != null) {
            for (int i = 0; i < meetings.size(); i++) {
                for (int j = i + 1; j < meetings.size(); j++) {
//                    if (meetings.get(i).overlaps(meetings.get(j))) {
//                        return false;
//                    }
                }
            }
        }

        return true;
    }

    /**
     * Time Complexity: O(N^2) Space Complexity: O(1)
     */
    public static void testCanAttendMeetings() {
        List<Interval<Integer>> intervals = Arrays.asList(Interval.of(6, 7), Interval.of(2, 4), Interval.of(7, 8));
        System.out.println("Can attend meetings:" + canAttendMeetings(intervals) + ", with intervals: " + intervals);
        System.out.println(
            "Can attend meetings:" + canAttendMeetingsWithMergeIntervals(intervals) + ", with intervals: " + intervals);
        System.out.println();

        // [[1, 4],[2, 5],[7, 9]]
        intervals =
            Arrays.asList(Interval.of(1, 4), Interval.of(2, 5), Interval.of(7, 8), Interval.of(6, 8),
                          Interval.of(8, 9));
        System.out.println("Can attend meetings:" + canAttendMeetings(intervals) + ", with intervals: " + intervals);
        System.out.println(
            "Can attend meetings:" + canAttendMeetingsWithMergeIntervals(intervals) + ", with intervals: " + intervals);
    }


    /**
     * Time Complexity: O(N LOG N) Space Complexity: O(N)
     *
     * @param meetings
     * @return
     */
    public static boolean canAttendMeetingsWithMergeIntervals(List<Interval<Integer>> meetings) {
        if (meetings != null) {
            Collections.sort(meetings);
            Stack<Interval> stack = new Stack<>();
            for (int i = 0; i < meetings.size(); i++) {
                Interval current = meetings.get(i);
                if (stack.isEmpty()) {
                    stack.push(current);
//                } else if (current.overlaps(stack.peek())) {
//                    Interval merged = current.merge(stack.pop());
//                    stack.push(merged);
                } else {
                    stack.push(current);
                }
            }

//            System.out.println("stack: " + stack);

            return (stack.size() < meetings.size() ? false : true);
        }

        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        testCanAttendMeetings();
    }
}

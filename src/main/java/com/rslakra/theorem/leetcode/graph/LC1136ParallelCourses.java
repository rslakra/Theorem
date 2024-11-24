package com.rslakra.theorem.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Nov 28, 2020 17:46:47
 */
public class LC1136ParallelCourses {

    /**
     * There are N courses, labelled from 1 to N.
     * <p>
     * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y:
     * course X has to be studied before course Y.
     * <p>
     * In one semester you can study any number of courses as long as you have studied all the prerequisites for the
     * course you are studying.
     * <p>
     * Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses,
     * return -1.
     * <p>
     * Example 1: Input: N = 3, relations = [[1,3],[2,3]] Output: 2 Explanation: In the first semester, courses 1 and 2
     * are studied. In the second semester, course 3 is studied.
     * <p>
     * Example 2: Input: N = 3, relations = [[1,2],[2,3],[3,1]] Output: -1 Explanation: No course can be studied because
     * they depend on each other.
     * <p>
     * Note: 1 <= N <= 5000 1 <= relations.length <= 5000 relations[i][0] != relations[i][1] There are no repeated
     * relations in the input.
     */
    public int minimumSemesters(int[][] relations) {
        if (relations != null && relations.length > 0) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, List<Integer>> dependencies = new HashMap<>();
            for (int[] r : relations) {
                graph.putIfAbsent(r[0], new ArrayList<>());
                graph.get(r[0]).add(r[1]);

                // build dependencies
                dependencies.putIfAbsent(r[1], new ArrayList<>());
                dependencies.get(r[1]).add(r[0]);
            }

            Queue<Integer> queue = new LinkedList<>();
            // build in-degree count
            Map<Integer, Integer> inDegree = new HashMap<>();
            for (int[] r : relations) {
                if (dependencies.containsKey(r[0])) {
                    inDegree.putIfAbsent(r[0], dependencies.get(r[0]).size());
                } else {
                    inDegree.putIfAbsent(r[0], 0);
                }

                if (!inDegree.containsKey(r[1]) && dependencies.containsKey(r[1])) {
                    inDegree.putIfAbsent(r[1], dependencies.get(r[1]).size());
                }
            }

            for (Integer key : graph.keySet()) {
                if (inDegree.get(key) == 0) {
                    queue.offer(key);
                }
            }

            int semesters = 0;
            int n = inDegree.size();
            while (!queue.isEmpty()) {
                // dependencies
                n--;
                int v = queue.poll();
                if (!graph.containsKey(v)) {
                    continue;
                }

                int node = graph.get(v).get(0);
                int breadth = inDegree.get(node);
                for (int i = 0; i < breadth; i++) {
                    inDegree.put(node, inDegree.get(node) - 1);
                    if (inDegree.get(node) == 0) {
                        queue.offer(node);
                    }
                }

                semesters++;
            }

            return (n == 0 ? semesters : -1);
        }

        return -1;
    }

    public static void main(String[] args) {
        LC1136ParallelCourses parallelCourses = new LC1136ParallelCourses();
        //case 1
        int[][] courses = {{1, 3}, {2, 3}};
        System.out.println(Arrays.toString(courses));
        int semesters = parallelCourses.minimumSemesters(courses);
        System.out.println("semesters: " + semesters);
        System.out.println();

        //case 2
        courses = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        semesters = parallelCourses.minimumSemesters(courses);
        System.out.println("semesters: " + semesters);
        System.out.println();

        //case 3
        courses = new int[][]{{1, 3}, {2, 3}, {3, 4}, {3, 5}, {4, 5}};
        System.out.println(Arrays.toString(courses));
        semesters = parallelCourses.minimumSemesters(courses);
        System.out.println("semesters: " + semesters);
        System.out.println();

    }
}

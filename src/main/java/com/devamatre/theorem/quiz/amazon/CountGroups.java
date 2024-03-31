package com.devamatre.theorem.quiz.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 3/7/24 3:00 PM
 */
public class CountGroups {

    private static void countGroups(List<List<Integer>> adjList, int node, boolean[] visited) {
        visited[node] = true;
        for (int j = 0; j < adjList.get(node).size(); j++) {
            if (!visited[j]) {
                countGroups(adjList, j, visited);
            }
        }
    }

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */

    public static int countGroups(List<String> related) {
        // build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < related.size(); i++) {
            adjList.add(new ArrayList<>());
            String input = related.get(i);
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '1') {
                    adjList.get(i).add(j);
                }
            }
        }
        System.out.println("adjList:" + adjList);

        boolean[] visited = new boolean[adjList.size()];
        int count = 0;
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                count++;
                countGroups(adjList, i, visited);
            }
        }

        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int result = CountGroups.countGroups(Arrays.asList("110", "110", "001"));
        System.out.println("result:" + result);
        result = CountGroups.countGroups(Arrays.asList("10000", "01000", "00100", "00010"));
        System.out.println("result:" + result);
    }

}

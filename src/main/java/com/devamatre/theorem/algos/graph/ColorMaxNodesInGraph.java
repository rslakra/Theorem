/**
 *
 */
package com.devamatre.theorem.algos.graph;

/**
 * @author Rohtash Lakra
 * @created Aug 3, 2019 8:42:16 PM
 * @version 1.0.0
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ColorMaxNodesInGraph {

    private static int maxColoredNodes(final Map<Character, Set<Character>> graph) {
        final Map<Character, Boolean> colored = new HashMap<>();
        final char start = graph.keySet().stream().findFirst().get();
        final int maxColoredNodes = maxColoredNodes(graph, start, colored, false);
        return maxColoredNodes;
    }

    private static int maxColoredNodes(final Map<Character, Set<Character>> graph, char node,
                                       final Map<Character, Boolean> nodesColor, boolean parentColored) {
        if (nodesColor.keySet().contains(node)) {
            return 0;
        }
        final Set<Character> neighs = graph.get(node);
        int countIfNodeNotColored = 0;
        nodesColor.put(node, false);
        for (char neigh : neighs) {
            if (!nodesColor.keySet().contains(neigh)) {
                countIfNodeNotColored += maxColoredNodes(graph, neigh, nodesColor, false);
            }
        }
        int countIfNodeColored = 0;
        if (!parentColored && canColor(neighs, nodesColor)) {
            nodesColor.put(node, true);
            countIfNodeColored = 1;
            for (char neigh : neighs) {
                if (!nodesColor.keySet().contains(neigh)) {
                    countIfNodeColored += maxColoredNodes(graph, neigh, nodesColor, true);
                }
            }
        }
        return Math.max(countIfNodeNotColored, countIfNodeColored);
    }

    private static boolean canColor(final Set<Character> neighbours, final Map<Character, Boolean> nodesColor) {
        return !neighbours.stream().anyMatch(n -> nodesColor.get(n) != null && nodesColor.get(n));
    }

    public static void main(String[] args) {
        final Map<Character, Set<Character>> graph = new HashMap<>();
        /*
         * a -- b | / | |/ | d c
         *
         * Amnswer: 2. (a,c) or (d,c)
         */
        graph.put('a', new HashSet(Arrays.asList('b', 'd')));
        graph.put('b', new HashSet(Arrays.asList('a', 'c', 'd')));
        graph.put('c', new HashSet(Arrays.asList('b')));
        graph.put('d', new HashSet(Arrays.asList('a', 'b')));
        System.out.println(ColorMaxNodesInGraph.maxColoredNodes(graph));

        graph.clear();
        /*
         * a -- b -- c Answer: 2. a,c
         */
        graph.put('b', new HashSet(Arrays.asList('a', 'c')));
        graph.put('c', new HashSet(Arrays.asList('b')));
        graph.put('a', new HashSet(Arrays.asList('b')));
        System.out.println(ColorMaxNodesInGraph.maxColoredNodes(graph));

        graph.clear();
        /*
         * c d e f \ \ / / \ \ / / a | b / /\ \ / / \ \ g h i j
         *
         * Answer 8. c,d,e,f,g,h,i,j
         */
        graph.put('c', new HashSet(Arrays.asList('a')));
        graph.put('d', new HashSet(Arrays.asList('a')));
        graph.put('e', new HashSet(Arrays.asList('a')));
        graph.put('f', new HashSet(Arrays.asList('a')));
        graph.put('g', new HashSet(Arrays.asList('b')));
        graph.put('h', new HashSet(Arrays.asList('b')));
        graph.put('i', new HashSet(Arrays.asList('b')));
        graph.put('j', new HashSet(Arrays.asList('b')));
        graph.put('a', new HashSet(Arrays.asList('c', 'd', 'e', 'f', 'b')));
        graph.put('b', new HashSet(Arrays.asList('g', 'h', 'i', 'j', 'a')));

        System.out.println(ColorMaxNodesInGraph.maxColoredNodes(graph));

    }
}

package com.rslakra.theorem.leetcode.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Author: Rohtash Lakra
 * Created: 4/18/20 1:26 PM Version: 1.0.0
 */
public class Graph {

    private int size;
    private List<List<Integer>> graph;

    public Graph() {
        graph = new ArrayList<>();
    }

    /**
     * @param size
     * @param vertices
     * @return
     */
    public void buildGraph(int size, List<List<Integer>> vertices) {
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }

        vertices.forEach(vertex -> {
            graph.get(vertex.get(0)).add(vertex.get(1));
            graph.get(vertex.get(1)).add(vertex.get(0));
        });
    }

    /**
     *
     */
    public void printGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator<List<Integer>> itr = graph.iterator();
        while (itr.hasNext()) {
            stringBuilder.append(itr.next());
            if (itr.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        // [[0,1],[1,2],[2,0],[1,3]]
        List<List<Integer>> vertices = new ArrayList<>();
        //[0, 1]
        List<Integer> vertex = new ArrayList<>();
        vertex.add(0);
        vertex.add(1);
        vertices.add(vertex);
// [1, 2]
        vertex = new ArrayList<>();
        vertex.add(1);
        vertex.add(2);
        vertices.add(vertex);
        //[2,0]
        vertex = new ArrayList<>();
        vertex.add(2);
        vertex.add(0);
        vertices.add(vertex);
        //[1,3]
        vertex = new ArrayList<>();
        vertex.add(1);
        vertex.add(3);
        vertices.add(vertex);
        System.out.println(vertices);
        graph.buildGraph(vertices.size(), vertices);
        graph.printGraph();
    }
}

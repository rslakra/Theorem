/**
 *
 */
package com.rslakra.theorem.algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * You are given a two-dimensional array (matrix) of potentially unequal height and width containing only 0s and 1s.
 * Each 0 represents land, and each 1 represents part of a river. A river consists of any number of 1s that are either
 * horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming a river
 * determine its size. Write a function that returns an array of the sizes of all rivers represented in the input
 * matrix. Note that these sizes do not need to be in any particular order.
 * <p>
 * Time Complexity:O(Row * Column)
 * <p>
 * Space Complexity: O(Row * Column)
 *
 * <pre>
 * Input:
 * [0, 1, 1]
 * [1, 0, 1]
 *
 * Output:[3, 1]
 *
 *
 * Input:
 * [0, 1, 1, 1, 1]
 * [1, 0, 1, 0, 1]
 * [1, 1, 0, 1, 1]
 * [1, 0, 1, 0, 1]
 *
 * Output:
 * [9, 4, 1]
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 22, 2019 12:04:30 PM
 */
public class FindRevers {

    /**
     * @param matrix
     * @param row
     * @param column
     * @param visited
     */
    public int traverseRecursively(int[][] matrix, int row, int column, boolean[][] visited) {
        if (row < 0 || column < 0 || row > matrix.length - 1 || column > matrix[row].length - 1) {
            return 0;
        }

        if (visited[row][column]) {
            return 0;
        }

        visited[row][column] = true;
        if (matrix[row][column] == 0) {
            return 0;
        }

        int countRevers = 1;
        // top
        countRevers += traverseRecursively(matrix, row - 1, column, visited);
        // left
        countRevers += traverseRecursively(matrix, row, column - 1, visited);
        // right
        countRevers += traverseRecursively(matrix, row, column + 1, visited);
        // bottom
        countRevers += traverseRecursively(matrix, row + 1, column, visited);

        return countRevers;
    }

    /**
     * @param matrix
     * @return
     */
    public List<Integer> riverSizesRecursively(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    int result = traverseRecursively(matrix, i, j, visited);
                    if (result > 0) {
                        riverSizes.add(result);
                    }
                }
            }
        }

        return riverSizes;
    }

    /**
     * @param visited
     * @param row
     * @param column
     * @return
     */
    public boolean isVisited(boolean[][] visited, int row, int column) {
        return visited[row][column];
    }

    class Node {

        int row;
        int column;

        Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    /**
     * @param matrix
     * @param row
     * @param column
     * @param visited
     * @param nodes
     */
    public void findNeighbors(int[][] matrix, int row, int column, boolean[][] visited, Stack<Node> nodes) {
        // top
        if (row > 0 && !visited[row - 1][column]) {
            nodes.push(new Node(row - 1, column));
        }

        // left
        if (column > 0 && !visited[row][column - 1]) {
            nodes.push(new Node(row, column - 1));
        }

        // right
        if (column < matrix[row].length - 1 && !visited[row][column + 1]) {
            nodes.push(new Node(row, column + 1));
        }

        // bottom
        if (row < matrix.length - 1 && !visited[row + 1][column]) {
            nodes.push(new Node(row + 1, column));
        }
    }

    /**
     * @param matrix
     * @param row
     * @param column
     * @param visited
     * @param riverSizes
     */
    public void traverseIteratively(int[][] matrix, int row, int column, boolean[][] visited,
                                    List<Integer> riverSizes) {
        int countRevers = 0;
        Stack<Node> nodes = new Stack<>();
        nodes.push(new Node(row, column));
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            row = node.row;
            column = node.column;
            if (visited[row][column]) {
                continue;
            }

            visited[row][column] = true;
            if (matrix[row][column] == 0) {
                continue;
            }

            countRevers++;
            findNeighbors(matrix, node.row, node.column, visited, nodes);
        }

        if (countRevers > 0) {
            riverSizes.add(countRevers);
        }
    }

    /**
     * @param matrix
     * @return
     */
    public List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    traverseIteratively(matrix, i, j, visited, riverSizes);
                }
            }
        }

        return riverSizes;
    }

    /**
     * @param row
     * @param column
     */
    public int[][] initRevers(int row, int column) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + j) % 2;
                if ((matrix.length > 1 && matrix[0].length > 1) && matrix[i][j] + i % 2 == 0) {
                    matrix[i][j] = 1;
                }
            }
        }

        if (matrix.length > 1 && matrix[0].length > 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] == 1 && i % 2 == 0) {
                    matrix[i][i] = 0;
                }
            }
        }

        return matrix;
    }

    /**
     * @param matrix
     */
    public void printRevers(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FindRevers findRevers = new FindRevers();
        int[][] matrix = findRevers.initRevers(1, 1);
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));

        matrix = findRevers.initRevers(1, 3);
        System.out.println();
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));

        matrix = findRevers.initRevers(2, 3);
        System.out.println();
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));

        matrix = findRevers.initRevers(3, 4);
        System.out.println();
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));

        matrix = findRevers.initRevers(4, 5);
        System.out.println();
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));

        matrix = findRevers.initRevers(5, 5);
        System.out.println();
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));

        matrix = findRevers.initRevers(5, 6);
        System.out.println();
        System.out.println("Input:");
        findRevers.printRevers(matrix);
        System.out.println("Output:");
        System.out.println(findRevers.riverSizes(matrix));
        System.out.println(findRevers.riverSizesRecursively(matrix));
    }

}

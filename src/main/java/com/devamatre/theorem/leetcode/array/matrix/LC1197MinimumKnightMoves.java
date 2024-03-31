package com.devamatre.theorem.leetcode.array.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * <url>https://leetcode.com/problems/minimum-knight-moves</url>
 *
 * @author Rohtash Lakra
 * @created 3/16/24 10:53 AM
 */
public class LC1197MinimumKnightMoves {

    class KnightMoves {

        final int[] knightMoves = new int[]{2, 1}; // consider left, top

        final int row;
        final int col;
        final int level;

        KnightMoves(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }

        KnightMoves(int row, int col) {
            this(row, col, 0);
        }

        int getRow() {
            return row;
        }

        int getCol() {
            return col;
        }

        int getLevel() {
            return level;
        }

        // top-left
        KnightMoves topLeft() {
            // row - 2, col - 1
            return new KnightMoves(getRow() - knightMoves[0], getCol() - knightMoves[1], getLevel() + 1);
        }

        // top-right
        KnightMoves topRight() {
            // row - 2, col - 1
            return new KnightMoves(getRow() - knightMoves[0], getCol() + knightMoves[1], getLevel() + 1);
        }

        // bottom-left
        KnightMoves bottomLeft() {
            // row + 2, col - 1
            return new KnightMoves(getRow() + knightMoves[0], getCol() - knightMoves[1], getLevel() + 1);
        }

        // bottom-right
        KnightMoves bottomRight() {
            // row + 2, col - 1
            return new KnightMoves(getRow() + knightMoves[0], getCol() + knightMoves[1], getLevel() + 1);
        }

        // left-top
        KnightMoves leftTop() {
            // row - 1, col - 2
            return new KnightMoves(getRow() - knightMoves[1], getCol() - knightMoves[0], getLevel() + 1);
        }

        // left-bottom
        KnightMoves leftBottom() {
            // row - 1, col - 2
            return new KnightMoves(getRow() - knightMoves[1], getCol() + knightMoves[0], getLevel() + 1);
        }

        // right-top
        KnightMoves rightTop() {
            // row - 1, col - 2
            return new KnightMoves(getRow() + knightMoves[1], getCol() - knightMoves[0], getLevel() + 1);
        }

        // right-bottom
        KnightMoves rightBottom() {
            // row - 1, col - 2
            return new KnightMoves(getRow() + knightMoves[1], getCol() + knightMoves[0], getLevel() + 1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(getRow(), getCol());
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || object.getClass() != KnightMoves.class) {
                return false;
            }

            KnightMoves knightMoves = (KnightMoves) object;
            return (getRow() == knightMoves.getRow() && getCol() == knightMoves.getCol());
        }

        @Override
        public String toString() {
            return "[" + getRow() + ", " + getCol() + "]";
        }
    }

    /**
     * @param grid
     * @param knightMoves
     * @return
     */
    private boolean isValidMove(int[][] grid, KnightMoves knightMoves) {
        return (knightMoves.getRow() >= 0 && knightMoves.getRow() < grid.length && knightMoves.getCol() >= 0
                && knightMoves.getCol() < grid[0].length);
    }

    /**
     * @param grid
     * @param source
     * @param target
     * @return
     */
    private int dfsMinimumKnightMoves(int[][] grid, KnightMoves source, KnightMoves target, Set<KnightMoves> visited) {
        // base case
        if (source.getRow() < 0 || source.getRow() >= grid.length || source.getCol() < 0
            || source.getCol() >= grid[0].length
            //|| (source.getRow() > target.getRow() && source.getCol() > target.getCol())
            || visited.contains(source)) {
            return grid.length * grid[0].length;
        } else if (source.equals(target)) {
            System.out.println("source:" + source + ", 1");
            return 0;
        }

        System.out.println("source:" + source + ", target:" + target + ", visited:" + visited);
        // mark visited
        visited.add(source);

        int minMoves = Math.min(Math.min(
            // top
            Math.min(dfsMinimumKnightMoves(grid, source.topLeft(), target, visited),
                     dfsMinimumKnightMoves(grid, source.topRight(), target, visited)),
            // left
            Math.min(dfsMinimumKnightMoves(grid, source.leftTop(), target, visited),
                     dfsMinimumKnightMoves(grid, source.leftBottom(), target, visited))), Math.min(
            // right
            Math.min(dfsMinimumKnightMoves(grid, source.rightTop(), target, visited),
                     dfsMinimumKnightMoves(grid, source.rightBottom(), target, visited)),
            // bottom
            Math.min(dfsMinimumKnightMoves(grid, source.bottomLeft(), target, visited),
                     dfsMinimumKnightMoves(grid, source.bottomRight(), target, visited))));

        // backtracking
        visited.remove(source);
        minMoves += 1;
        System.out.println("minMoves:" + minMoves);
        return minMoves;
    }


    /**
     * @param grid
     * @param queue
     * @param visited
     * @param nextMove
     */
    private void addNextMove(int[][] grid, Queue<KnightMoves> queue, Set<KnightMoves> visited, KnightMoves nextMove) {
        // if next move is valid and add it in queue.
        if (isValidMove(grid, nextMove) && !visited.contains(nextMove)) {
            // mark visited and add in queue
            visited.add(nextMove);
            queue.add(nextMove);
        }
    }

    /**
     * @param grid
     * @param source
     * @param target
     * @return
     */
    private int bfsMinimumKnightMoves(int[][] grid, KnightMoves source, KnightMoves target, Set<KnightMoves> visited) {
        Queue<KnightMoves> queue = new LinkedList<>();
        addNextMove(grid, queue, visited, source);
        while (!queue.isEmpty()) {
            KnightMoves knightMoves = queue.poll();
            if (knightMoves.equals(target)) {
                return knightMoves.getLevel();
            }

            // top left
            addNextMove(grid, queue, visited, knightMoves.topLeft());
            // top right
            addNextMove(grid, queue, visited, knightMoves.topRight());
            // bottom left
            addNextMove(grid, queue, visited, knightMoves.bottomLeft());
            // bottom right
            addNextMove(grid, queue, visited, knightMoves.bottomRight());
            // left-top
            addNextMove(grid, queue, visited, knightMoves.leftTop());
            // left-bottom
            addNextMove(grid, queue, visited, knightMoves.leftBottom());
            // right-top
            addNextMove(grid, queue, visited, knightMoves.rightTop());
            // right-bottom
            addNextMove(grid, queue, visited, knightMoves.rightBottom());
        }

        return -1;
    }

    /**
     * @param grid
     * @param sourceRow
     * @param sourceCol
     * @param targetRow
     * @param targetCol
     * @return
     */
    public int findMinimumKnightMoves(int[][] grid, int sourceRow, int sourceCol, int targetRow, int targetCol) {
        Set<KnightMoves> visited = new HashSet<>();
//        return dfsMinimumKnightMoves(grid, new KnightMoves(sourceRow, sourceCol), new KnightMoves(targetRow, targetCol),
//                                     visited);
        return bfsMinimumKnightMoves(grid, new KnightMoves(sourceRow, sourceCol), new KnightMoves(targetRow, targetCol),
                                     visited);
    }

}

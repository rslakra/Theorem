package com.rslakra.theorem.algos.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 4:47 PM
 */
public class MazePaths {

    private static final Logger LOGGER = LoggerFactory.getLogger(MazePaths.class);

    /**
     * @param maze
     * @param target
     * @param row
     * @param col
     * @return
     */
    private int countPaths(int[][] maze, int[] target, int row, int col) {
        // end of rows or end of columns
        if (row == target[0] || col == target[1]) {
            return 1;
        }

        // go to right
        int rightPaths = countPaths(maze, target, row, col + 1);
        // go down
        int downPaths = countPaths(maze, target, row + 1, col);
        return rightPaths + downPaths;
    }

    /**
     * @param maze
     * @param target
     * @return
     */
    public int countPaths(int[][] maze, int[] target) {
        return countPaths(maze, target, 0, 0);
    }


    /**
     * @param maze
     * @param target
     * @param row
     * @param col
     * @return
     */
    private void findPaths(int[][] maze, int[] target, int row, int col, List<List<Integer>> paths,
                           List<Integer> path) {
        LOGGER.debug("findPaths({}, {}, {}, {})", row, col, Arrays.toString(target), path);
        // if out of maze coordinates, just return.
        if (row > target[0] || col > target[1]) {
            return;
        }

        // visit the node and add in the path
        path.add(maze[row][col]);

        // end of rows or end of columns
        if (row == target[0] && col == target[1]) {
            // visit the node and add in the path
            LOGGER.debug("path:{}", path);
            paths.add(new ArrayList<>(path));
        }

        // go to right
        findPaths(maze, target, row, col + 1, paths, path);
        // go down
        findPaths(maze, target, row + 1, col, paths, path);
        /**
         * remove the last path at back-tracking
         *
         * Note: - might get ArrayIndexOutOfBound exception because the primitive type array value considered an index
         * and array's remove method is called to remove by index instead of remove by value. So cast the value to
         * object to call the right method.
         *
         * It's better remove the value by index (last added value)
         */
//        path.remove((Object) maze[row][col]);
        path.remove(path.size() - 1);
    }

    /**
     * Returns the paths to the target from the (0,0) starting point.
     *
     * @param maze
     * @param target
     * @return
     */
    public List<List<Integer>> findPaths(int[][] maze, int[] target) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(maze, target, 0, 0, paths, new ArrayList<>());
        return paths;
    }

}

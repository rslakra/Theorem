package com.devamatre.theorem.leetcode.point;

/**
 * https://leetcode.com/problems/reaching-points/
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Jan 02, 2021 09:40:43
 */
public class LC780ReachingPoints {

    /**
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx > ty) {
                if (sy == ty) {
                    return ((tx - sx) % ty == 0);
                }
                tx = tx % ty;
            } else {
                if (sx == tx) {
                    return ((ty - sy) % tx == 0);
                }
                ty = ty % tx;
            }
        }

        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC780ReachingPoints lc780ReachingPoints = new LC780ReachingPoints();
        int sx = 1;
        int sy = 1;
        int tx = 3;
        int ty = 5;
        System.out.println("sx:" + sx + ", sy:" + sy + ", tx:" + tx + ", ty:" + ty);
        System.out.println("reachingPoints:" + lc780ReachingPoints.reachingPoints(sx, sy, tx, ty));
        System.out.println();
        sx = 1;
        sy = 1;
        tx = 2;
        ty = 2;
        System.out.println("sx:" + sx + ", sy:" + sy + ", tx:" + tx + ", ty:" + ty);
        System.out.println("reachingPoints:" + lc780ReachingPoints.reachingPoints(sx, sy, tx, ty));
        System.out.println();
    }
}

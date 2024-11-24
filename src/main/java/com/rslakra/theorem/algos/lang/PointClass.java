/**
 *
 */
package com.rslakra.theorem.algos.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 */
public class PointClass {

    static final class Point {

        private double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof Point)) {
                return false;
            }

            Point point = (Point) other;
            return (x == point.x ? (y == point.y ? true : false) : false);
        }
    }

    public static void main(final String[] args) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 2));
        pointList.add(new Point(3, 4));
        System.out.println(pointList.size());
        // remove the second Point
        pointList.remove(new Point(3, 4));
        System.out.println(pointList.size());
        // Not removed!
    }

}

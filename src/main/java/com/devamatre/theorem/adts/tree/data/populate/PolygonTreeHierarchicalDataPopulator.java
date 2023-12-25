package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

/**
 * The polygon hierarchy
 *
 * <pre>
 * Polygon
 * |-- Hexagon
 * |   |-- 6 Sides
 * |-- Pentagon
 * |   |-- 5 Sides
 * |-- Triangle
 * |   |-- 3 Sides
 * |   |   |-- Equilateral
 * |   |   |-- Isosceles
 * |   |   |-- Scalene
 * |   |-- Angles
 * |   |   |-- Acute
 * |   |   |-- Right
 * |   |   |-- Obtuse
 * |-- Quadrilateral
 * |   |-- Sides
 * |   |   |-- Parallelogram
 * |   |   |   |-- Rectangle
 * |   |   |   |-- Rhombus
 * |   |   |   |-- Square
 * |   |   |   |-- Trapezoid
 * |   |-- Kite
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:49 AM
 */
public class PolygonTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        tree.addNode("Polygon");
        // add next level children
        Node<String> polygon = tree.findNode("Polygon");
        tree.addNode(polygon, "Hexagon");
        tree.addNode(polygon, "Pentagon");
        tree.addNode(polygon, "Triangle");
        tree.addNode(polygon, "Quadrilateral");

        // add next level children
        tree.addNode(tree.findNode("Hexagon"), "6 Sides");
        // add next level children
        tree.addNode(tree.findNode("Pentagon"), "5 Sides");
        // add next level children
        Node<String> triangle = tree.findNode("Triangle");
        tree.addNode(triangle, "3 Sides");
        tree.addNode(triangle, "Angles");

        // add next level children
        Node<String> threeSides = tree.findNode("3 Sides");
        tree.addNode(threeSides, "Equilateral");
        tree.addNode(threeSides, "Isosceles");
        tree.addNode(threeSides, "Scalene");

        // add next level children
        Node<String> angles = tree.findNode("Angles");
        tree.addNode(angles, "Acute");
        tree.addNode(angles, "Right");
        tree.addNode(angles, "Obtuse");
        // add next level children
        Node<String> quadrilateral = tree.findNode("Quadrilateral");
        tree.addNode(quadrilateral, "Sides");
        tree.addNode(quadrilateral, "Kite");
        // add next level children
        tree.addNode(tree.findNode("Sides"), "Parallelogram");
        // add next level children
        Node<String> parallelogram = tree.findNode("Parallelogram");
        tree.addNode(parallelogram, "Rectangle");
        tree.addNode(parallelogram, "Rhombus");
        tree.addNode(parallelogram, "Square");
        tree.addNode(parallelogram, "Trapezoid");

        return tree;
    }
}

package com.devamatre.theorem.adts.tree.data.populate;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.Node;

/**
 * An example of a web page tree
 * <pre>
 * <html>
 * |-- <head>
 * |   |-- <meta>
 * |   |-- <title>
 * |-- <body>
 * |   |-- <h1>
 * |   |   |-- <p>
 * |   |-- <h2>
 * |   |   |-- <p>
 * |   |-- <p>
 * |   |-- <ul>
 * |   |   |-- <li>
 * |   |-- <ol>
 * |   |   |-- <li>
 * |   |-- <button>
 * |   |-- <code>
 * |   |-- <table>
 * |   |   |-- <thead>
 * |   |   |   |-- <tr>
 * |   |   |   |   |-- <th>
 * |   |   |   |   |-- <td>
 * |   |   |-- <tbody>
 * |   |   |   |-- <tr>
 * |   |   |   |   |-- <th>
 * |   |   |   |   |-- <td>
 * |   |   |-- <tr>
 * |   |   |   |-- <th>
 * |   |   |   |-- <td>
 * |   |-- <div>
 * |-- <footer>
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/21/23 8:46 AM
 */
public class WebPageTreeHierarchicalDataPopulator implements TreeHierarchicalDataPopulator<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        tree.addNode("<html>");
        // add next level children
        Node<String> html = tree.findNode("<html>");
        tree.addNode(html, "<head>");
        tree.addNode(html, "<body>");
        tree.addNode(html, "<footer>");
        // add next level children
        Node<String> head = tree.findNode("<head>");
        tree.addNode(head, "<meta>");
        tree.addNode(head, "<title>");
        // add next level children
        Node<String> body = tree.findNode("<body>");
        tree.addNode(body, "<h1>");
        tree.addNode(body, "<h2>");
        tree.addNode(body, "<p>");
        tree.addNode(body, "<ul>");
        tree.addNode(body, "<ol>");
        tree.addNode(body, "<button>");
        tree.addNode(body, "<code>");
        tree.addNode(body, "<table>");
        tree.addNode(body, "<div>");
        // add next level children
        tree.addNode(tree.findNode("<h1>"), "<p>");
        // add next level children
        tree.addNode(tree.findNode("<h2>"), "<p>");
        // add next level children
        tree.addNode(tree.findNode("<ul>"), "<li>");
        // add next level children
        tree.addNode(tree.findNode("<ol>"), "<li>");
        // add next level children
        Node<String> table = tree.findNode("<table>");
        tree.addNode(table, "<thead>");
        tree.addNode(table, "<tbody>");
        tree.addNode(table, "<tr>");
        // add next level children
        tree.addNode(tree.findNode("<thead>"), "<tr>");
        Node<String> tr = tree.findNode("<tr>");
        tree.addNode(tr, "<th>");
        tree.addNode(tr, "<td>");
        tree.addNode(tree.findNode("<tbody>"), "<tr>");
        tree.addNode(tr, "<th>");
        tree.addNode(tr, "<td>");

        return tree;
    }
}

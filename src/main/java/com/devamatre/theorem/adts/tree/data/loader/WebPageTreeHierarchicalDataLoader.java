package com.devamatre.theorem.adts.tree.data.loader;

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
public class WebPageTreeHierarchicalDataLoader implements TreeHierarchicalDataLoader<String> {

    /**
     * Fills the provided <code>tree</code> with the hierarchical data.
     *
     * @param tree
     * @return
     */
    @Override
    public AbstractTree<String> fillHierarchicalData(AbstractTree<String> tree) {
        // add rootNode
        Node<String> rootNode = new Node<>("<html>");
        tree.addNode(null, rootNode);

        // add next level children
        tree.addNode(rootNode, "<head>");
        tree.addNode(rootNode, "<body>");
        tree.addNode(rootNode, "<footer>");
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
        Node<String> table = new Node<>("<table>");
        tree.addNode(body, table);
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
        Node<String> thead = new Node<>("<thead>");
        Node<String> tbody = new Node<>("<tbody>");
        Node<String> tr = new Node<>("<tr>");
        tree.addNode(table, thead);
        tree.addNode(table, tbody);
        tree.addNode(table, tr);
        // add next level children
        Node<String> thTr = new Node<>("<tr>");
        tree.addNode(thead, thTr);
        // add next level children
        tree.addNode(thTr, "<th>");
        tree.addNode(thTr, "<td>");
        // add next level children
        Node<String> tbTr = new Node<>("<tr>");
        tree.addNode(tbody, tbTr);
        tree.addNode(tbTr, "<th>");
        tree.addNode(tbTr, "<td>");
        // add next level children
        tree.addNode(tr, "<th>");
        tree.addNode(tr, "<td>");

        return tree;
    }
}

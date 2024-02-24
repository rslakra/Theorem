package com.devamatre.theorem.algos.graph;

import com.devamatre.theorem.adts.NumberUtils;
import com.devamatre.theorem.adts.graph.vertex.Edge;
import com.devamatre.theorem.adts.graph.vertex.Vertex;
import com.devamatre.theorem.adts.graph.vertex.VertexBasedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Rohtash Lakra
 * @created 2/12/24 12:38 PM
 */
public class GraphAlgorithm {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphAlgorithm.class);

    /**
     * Returns the parent index of the provided index.
     *
     * @param parent
     * @param index
     * @return
     */
    private int findParent(int[] parent, int index) {
        if (parent[index] == index) {
            return index;
        }

        return findParent(parent, parent[index]);
    }

    /**
     * @param graph
     */
    public void kruskals(VertexBasedGraph<Integer> graph) {
        LOGGER.debug("+kruskals({})", graph);
        // sort all edges
        SortedSet<Edge> allEdges = new TreeSet<>();
        for (Vertex vertex : graph.getAllVertices()) {
            allEdges.addAll(vertex.getEdges());
        }
        LOGGER.debug("allEdges:{}", allEdges);

        int vertices = graph.getVertices().size();
        Edge[] edges = new Edge[vertices - 1];
        // build parent's array and fill with own index.
        // means everyone is their own parent.
        int[] parent = new int[vertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        LOGGER.debug("parent:{}", parent);

        int index = 0;
        // for each edge,
        for (Edge edge : allEdges) {
            if (index == vertices - 1) {
                break;
            }

            LOGGER.debug("index:{}, edge:{}", index, edge);
            int sourceParent = findParent(parent, NumberUtils.asInteger(edge.getSource().getData()).intValue());
            int targetParent = findParent(parent, NumberUtils.asInteger(edge.getTarget().getData()).intValue());
            LOGGER.debug("sourceParent:{}, targetParent:{}", sourceParent, targetParent);
            if (sourceParent != targetParent) {
                edges[index] = edge;
                index++;
                parent[sourceParent] = targetParent;
            }
            LOGGER.debug("parent:{}", Arrays.toString(parent));
        }

        LOGGER.debug("edges:{}", Arrays.toString(edges));
        LOGGER.debug("-kruskals()");
    }

}

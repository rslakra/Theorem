package com.rslakra.theorem.leetcode;

import java.util.List;

/**
 * Author: Rohtash Lakra
 * Created: 4/18/20 11:42 AM
 * Version: 1.0.0
 */
public class LC1192CriticalConnectionsInNetwork {

    /**
     * https://leetcode.com/problems/critical-connections-in-a-network/
     * <p>
     * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
     * where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other
     * server directly or indirectly through the network.
     * <p>
     * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
     * <p>
     * Return all critical connections in the network in any order.
     * <p>
     * <p>
     * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]] Output: [[1,3]] Explanation: [[3,1]] is also accepted.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * -> 1 <= n <= 10^5 -> n-1 <= connections.length <= 10^5 -> connections[i][0] != connections[i][1] -> There are no
     * repeated connections.
     *
     * @param n
     * @param connections
     * @return
     * @see https://cp-algorithms.com/graph/cutpoints.html
     * @see https://yy-zhou.github.io/2019/09/lc-1192-critical-connections-in-a-network/
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        return null;
    }
}

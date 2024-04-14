package com.devamatre.theorem.leetcode.design;

import java.util.TreeMap;

/**
 * <url>https://leetcode.com/problems/snapshot-array</url>
 *
 * @author Rohtash Lakra
 * @created 4/10/24 4:43 PM
 */
public class LC1146SnapshotArray {

    private TreeMap<Integer, Integer>[] snapshots;
    private int snapId = 0;

    public LC1146SnapshotArray(int length) {
        // sort by reverse order
        snapshots = new TreeMap[length];
        // init with default values
        for (int i = 0; i < snapshots.length; i++) {
            snapshots[i] = new TreeMap<>();
            snapshots[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        snapshots[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return snapshots[index].floorEntry(snapId).getValue().intValue();
//        if (!snapshots[index].isEmpty() && snapshots[index].containsKey(snapId)) {
//            return snapshots[index].get(snapId);
//        }
//
//        return -1;
    }

    public int get(int index) {
        return get(index, snapId);
    }
}

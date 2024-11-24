package com.rslakra.theorem.quiz.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 3/7/24 2:31 PM
 */
public class ProcessLogs {

    static class LogTransaction {

        Integer senderUserId;
        Integer recipientUserid;
        Integer amountOfTransaction;
    }

    private static LogTransaction parseTransaction(String transaction) {
        LogTransaction logTransaction = new LogTransaction();
        String[] tokens = transaction.split(" ");
        logTransaction.senderUserId = Integer.parseInt(tokens[0]);
        logTransaction.recipientUserid = Integer.parseInt(tokens[1]);
        logTransaction.amountOfTransaction = Integer.parseInt(tokens[2]);

        return logTransaction;
    }

    public static List<Map.Entry<Integer, Integer>> sortMapEntries(Set<Map.Entry<Integer, Integer>> entries) {
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(entries);
        Collections.sort(sortedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        return sortedList;
    }

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     */
    public static List<String> processLogs(List<String> logs, int threshold) {
        // user's transaction frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (String transaction : logs) {
            // senderUserId, recipientUserid, amoutOfTransaction
            LogTransaction logTrx = parseTransaction(transaction);
            map.put(logTrx.senderUserId, map.getOrDefault(logTrx.senderUserId, 0) + 1);
            if (logTrx.senderUserId != logTrx.recipientUserid) {
                map.put(logTrx.recipientUserid, map.getOrDefault(logTrx.recipientUserid, 0) + 1);
            }
        }

        System.out.println("map:" + map);
        // remove user's that are under the threshhold
        Set<Integer> keySet = new HashSet<>(map.keySet());
        for (Integer userId : keySet) {
            if (map.get(userId) < threshold) {
                map.remove(userId);
            }
        }
        System.out.println("after remove map:" + map);

        List<Map.Entry<Integer, Integer>> entries = sortMapEntries(map.entrySet());
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            result.add(entry.getKey().toString());
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String>
            userIds =
            ProcessLogs.processLogs(Arrays.asList("88 99 200", "88 99 30", "99 32 100", "12 12 15"), 2);
        System.out.println(userIds);
        System.out.println(Integer.parseInt("999999999"));
    }
}

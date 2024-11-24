package com.rslakra.theorem.quiz.gusto;

import com.rslakra.theorem.adts.map.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Rohtash Lakra
 * @created 1/30/24 7:01 PM
 */
public class DistributeMoneyEvenlyAsPossible {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributeMoneyEvenlyAsPossible.class);

    /**
     * Given a pool of money, recipients who are owed money, distribute the money as evenly as possible.
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param amount
     * @param limits
     * @return
     */
    public Map<String, Integer> distributeMoneyEvenly(int amount, Map<String, Integer> limits) {
        LOGGER.debug("distributeMoneyEvenly({}, {})", amount, limits);
        Map<String, Integer> result = new HashMap<>();

        Boolean[] allStatus = new Boolean[limits.size()];
        for (int i = 0; i < allStatus.length; i++) {
            allStatus[i] = Boolean.FALSE;
        }

        while (amount > 0) {
            int index = 0;
            for (Map.Entry<String, Integer> entry : limits.entrySet()) {
                int value = result.getOrDefault(entry.getKey(), 0);
                if (amount > 0 && value < entry.getValue()) {
                    value++;
                    result.put(entry.getKey(), value);
                    amount--;
                } else {
                    // if owe money
                    if (!allStatus[index].booleanValue()) {
                        allStatus[index] = Boolean.TRUE;
                    }
                }
                index++;
            }

            // break loop balance > 0 and all distribution reached the limit
            if (Arrays.stream(allStatus).allMatch(Boolean.TRUE::equals)) {
                break;
            }
        }

        return result;
    }

    /**
     * Given a pool of money, recipients who are owed money, distribute the money as evenly as possible.
     *
     * <pre>
     *  Time Complexity: O(n log n)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param amount
     * @param limits
     * @return
     */
    public Map<String, Integer> distributeMoneyEvenly2(int amount, Map<String, Integer> limits) {
        Map<String, Integer> result = new TreeMap<>();
        limits = MapUtils.sortByValue(limits);

        // iterate each entry and allocate money
        for (Map.Entry<String, Integer> entry : limits.entrySet()) {
            if (amount >= entry.getValue()) {
                result.put(entry.getKey(), entry.getValue());
                amount -= entry.getValue();
            }
        }

        return result;
    }

}

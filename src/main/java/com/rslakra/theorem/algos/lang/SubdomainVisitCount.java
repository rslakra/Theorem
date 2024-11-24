/**
 *
 */
package com.rslakra.theorem.algos.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rohtash Lakra
 */
public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<String>();
        if (cpdomains != null) {
            HashMap<String, Integer> allDomains = new HashMap<>();
            for (int i = 0; i < cpdomains.length; i++) {
                String[] tokens = cpdomains[i].split("\\s+");
                String[] tokenDomains = tokens[1].split("\\.");
                int value = Integer.valueOf(tokens[0]);
                String str = "";
                for (int j = tokenDomains.length - 1; j >= 0; --j) {
                    str = tokenDomains[j] + ((j < tokenDomains.length - 1) ? "." : "") + str;
                    allDomains.put(str, allDomains.getOrDefault(str, 0) + value);
                }
            }

            for (String key : allDomains.keySet()) {
                list.add(allDomains.get(key) + " " + key);
            }
        }

        return list;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] cpdomains = new String[]{"1000 qa.devamatre.com"};
        System.out.println(subdomainVisits(cpdomains));
    }

}

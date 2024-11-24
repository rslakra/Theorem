package com.rslakra.theorem.algos.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 22, 2019 2:36:48 PM
 */
public class FindCommonHotels {

    /**
     * @param listHotelIds
     * @return
     */
    public List<Integer> findCommonHotels(List<List<Integer>> listHotelIds) {
        List<Integer> listResults = null;
        for (List<Integer> list : listHotelIds) {
            if (listResults == null) {
                listResults = list;
            } else {
                listResults.retainAll(list);
            }
        }

        return listResults;
    }

    public Set<Integer> findHotels(List<List<Integer>> listHotelIds) {
        Set<Integer> listResults = Collections.EMPTY_SET;
        for (List<Integer> list : listHotelIds) {
            if (listResults == null) {
                listResults.addAll(list);
            } else {
                listResults.retainAll(list);
            }
        }

        return listResults;
    }

    /**
     * @return
     */
    public List<List<Integer>> getListHotelIds() {
        List<List<Integer>> listHotelIds = new ArrayList<List<Integer>>();
        listHotelIds.add(new ArrayList<>(Arrays.asList(2, 3, 4, 3, 4)));
        listHotelIds.add(new ArrayList<>(Arrays.asList(2, 5, 3, 3, 3)));
        listHotelIds.add(new ArrayList<>(Arrays.asList(7, 3, 1, 3, 3)));

        return listHotelIds;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FindCommonHotels findCommonHotels = new FindCommonHotels();
        System.out.println(findCommonHotels.findCommonHotels(findCommonHotels.getListHotelIds()));
        System.out.println(findCommonHotels.findHotels(findCommonHotels.getListHotelIds()));

    }

}

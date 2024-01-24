package com.devamatre.theorem.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:08:00 AM
 */
public class TicketCounter {

    /**
     * @param ticketInfos
     * @param peopleDestinations
     */
    public void distributePeople(Map<String, Integer> ticketInfos, String[] peopleDestinations) {

    }

    /**
     * 5 2 3 CALIFORNIA 10 HAWAII 8 NEWYORK 12
     * <p>
     * NEWYORK NEWYORK CALIFORNIA NEWYORK HAWAII
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int noOfPeople = scanner.nextInt();
        int noOfWindows = scanner.nextInt();
        int noOfDestinations = scanner.nextInt();

        // ticket destination and price
        Map<String, Integer> ticketInfos = new HashMap<>();
        for (int i = 0; i < noOfDestinations; i++) {
            String dataString = scanner.nextLine();
            if (dataString != null) {
                String[] dataSlices = dataString.split(" ");
                ticketInfos.put(dataSlices[0], Integer.parseInt(dataSlices[1]));
            }
        }

        // people destinations
        String[] peopleDestinations = new String[noOfPeople];
        for (int i = 0; i < peopleDestinations.length; i++) {
            peopleDestinations[i] = scanner.nextLine();
        }

        scanner.close();

        float totalMinCost = 0.0f;
        Map<String, Integer> peopleDistributed = new HashMap<>();
        // distribute people
        for (int i = 0; i < peopleDestinations.length; i++) {
            if ((i + 1 < peopleDestinations.length - 1) && peopleDestinations[i].equals(peopleDestinations[i + 1])) {

            } else {

            }
            if (peopleDistributed.containsKey(peopleDestinations[i])) {

            } else {
                peopleDistributed.put(peopleDestinations[i], 1);
            }
        }

    }

}

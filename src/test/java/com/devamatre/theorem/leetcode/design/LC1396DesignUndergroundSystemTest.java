package com.devamatre.theorem.leetcode.design;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <url>https://leetcode.com/problems/design-underground-system</url>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/02/2024 8:14 AM
 */
public class LC1396DesignUndergroundSystemTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC1396DesignUndergroundSystemTest.class);

    /**
     * <pre>
     * Input
     * ["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
     * [[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
     *
     * Output
     * [null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
     *
     * Explanation
     * UndergroundSystem undergroundSystem = new UndergroundSystem();
     * undergroundSystem.checkIn(45, "Leyton", 3);
     * undergroundSystem.checkIn(32, "Paradise", 8);
     * undergroundSystem.checkIn(27, "Leyton", 10);
     * undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
     * undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
     * undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
     * undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
     * undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
     * undergroundSystem.checkIn(10, "Leyton", 24);
     * undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
     * undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
     * undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
     *
     *
     * Example 2:
     *
     * Input
     * ["UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"]
     * [[],[10,"Leyton",3],[10,"Paradise",8],["Leyton","Paradise"],[5,"Leyton",10],[5,"Paradise",16],["Leyton","Paradise"],[2,"Leyton",21],[2,"Paradise",30],["Leyton","Paradise"]]
     *
     * Output
     * [null,null,null,5.00000,null,null,5.50000,null,null,6.66667]
     *
     * Explanation
     * UndergroundSystem undergroundSystem = new UndergroundSystem();
     * undergroundSystem.checkIn(10, "Leyton", 3);
     * undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
     * undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000, (5) / 1 = 5
     * undergroundSystem.checkIn(5, "Leyton", 10);
     * undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
     * undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000, (5 + 6) / 2 = 5.5
     * undergroundSystem.checkIn(2, "Leyton", 21);
     * undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
     * undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667, (5 + 6 + 9) / 3 = 6.66667
     * </pre>
     *
     * @return
     */
    @DataProvider
    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        input.add(new Object[]{
            Arrays.asList("UndergroundSystem", "checkIn", "checkIn", "checkIn", "checkOut", "checkOut", "checkOut",
                          "getAverageTime", "getAverageTime", "checkIn", "getAverageTime", "checkOut",
                          "getAverageTime"),
            Arrays.asList(Arrays.asList(45, "Leyton", 3), Arrays.asList(32, "Paradise", 8),
                          Arrays.asList(27, "Leyton", 10), Arrays.asList(45, "Waterloo", 15),
                          Arrays.asList(27, "Waterloo", 20), Arrays.asList(32, "Cambridge", 22),
                          Arrays.asList("Paradise", "Cambridge"), Arrays.asList("Leyton", "Waterloo"),
                          Arrays.asList(10, "Leyton", 24), Arrays.asList("Leyton", "Waterloo"),
                          Arrays.asList(10, "Waterloo", 38), Arrays.asList("Leyton", "Waterloo")),
            Arrays.asList(null, null, null, null, null, null, null, 14.00000, 11.00000, null, 11.00000, null, 12.00000)
        });

        return input.iterator();
    }

    /**
     * Tests the <code>LC1146SnapshotArray</code> class.
     *
     * @param actions
     * @param inputs
     * @param expected
     */
    @Test(dataProvider = "inputData")
    public void testCountHillValley(final List<String> actions, List<List<Object>> inputs, List<Double> expected) {
        LC1396DesignUndergroundSystem instance = null;
        for (int i = 0; i < actions.size(); i++) {
            List<Object> inputData = inputs.get(i);
            LOGGER.debug("inputData:{}", inputData);
            // "UndergroundSystem", "checkIn", "checkIn", "checkIn", "checkOut", "checkOut", "checkOut",
            //                         "getAverageTime", "getAverageTime", "checkIn", "getAverageTime", "checkOut", "getAverageTime"
            switch (actions.get(i)) {
                case "UndergroundSystem":
                    instance = new LC1396DesignUndergroundSystem();
                    break;

                case "checkIn":
                    instance.checkIn(Integer.parseInt(inputData.get(0).toString()), inputData.get(1).toString(),
                                     Integer.parseInt(inputData.get(2).toString()));
                    break;

                case "checkOut":
                    instance.checkOut(Integer.parseInt(inputData.get(0).toString()), inputData.get(1).toString(),
                                      Integer.parseInt(inputData.get(2).toString()));
                    break;

                case "getAverageTime":
                    Double avgTime = instance.getAverageTime(inputData.get(0).toString(), inputData.get(1).toString());
                    LOGGER.debug("avgTime:{}", avgTime);
                    assertEquals(expected, avgTime);
                    break;

                default:
                    LOGGER.debug("Invalid action:{}", actions.get(i));
                    break;
            }
        }
    }
}

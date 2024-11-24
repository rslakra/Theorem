package com.rslakra.theorem.algos.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 01/20/2024 4:33 PM
 */
public class BigNumberTest {

    @Test
    public void testBigNumber() {
        BigNumber bigNumber = new BigNumber();
        int[] nums = {4, 5, 8, 90, 89};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{4, 5, 90, 9, 89};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{3, 300, 30, 3000};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{12, 121};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{10, 2};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{999999998, 999999997, 999999999};
        System.out.println(bigNumber.largestNumber(nums));

        nums = new int[]{0, 0};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{0, 0, 0, 0};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{0, 1};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{0, 1, 0, 0};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        nums = new int[]{1};
        System.out.println(bigNumber.largestNumber(nums));
        System.out.println(bigNumber.largestNumberOptimized(nums));

        // extra tests
        nums = new int[]{1, 2};
        System.out.println(Arrays.toString(nums) + ":" + bigNumber.sumNumbers(nums));
        nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(nums) + ":" + bigNumber.sumNumbers(nums));
        nums = new int[]{10, 2};
        System.out.println(Arrays.toString(nums) + ":" + bigNumber.sumNumbers(nums));
        nums = new int[]{1, 10, 2};
        System.out.println(Arrays.toString(nums) + ":" + bigNumber.sumNumbers(nums));
    }

}

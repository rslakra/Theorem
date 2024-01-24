/**
 *
 */
package com.devamatre.theorem.algos.lang;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 10, 2019 5:31:37 PM
 */
public class MissingNumber {

    /**
     * @param nums
     * @return
     */
    public int findMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return (i + 1);
            }
        }

        return -1;
    }

    /**
     * @param nums
     * @param count
     * @return
     */
    public int findMissingNumberUsingMath(int[] nums, int count) {
        int result = count * (count + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return (result - sum);
    }

    /**
     * @param nums
     * @return
     */
    public int findMissingNumberXor(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }

        return sum;
    }

    /**
     * @param nums
     * @return
     */
    public List<Integer> findMissingNumbers(int[] nums, int missingCount) {
        List<Integer> missing = new ArrayList<>();
        int size = nums.length + missingCount;
        BitSet bSet = new BitSet(size);
        for (int i = 0; i < nums.length; i++) {
            bSet.set(nums[i] - 1);
        }

        int index = 0;
        for (int i = 0; i < missingCount; i++) {
            index = bSet.nextClearBit(index);
            missing.add(++index);
        }

        return missing;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {1, 2, 3, 5, 6};
        System.out.println(missingNumber.findMissingNumber(nums));
        System.out.println(missingNumber.findMissingNumberUsingMath(nums, 6));
        System.out.println(missingNumber.findMissingNumberXor(nums));
        System.out.println(missingNumber.findMissingNumbers(nums, 1));

        nums = new int[]{8, 2, 3, 4, 9, 1};
        System.out.println(missingNumber.findMissingNumbers(nums, 4));
    }

}

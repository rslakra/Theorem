/**
 *
 */
package com.devamatre.theorem.leetcode.lang;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 5:27:40 PM
 */
public class LC7ReverseInteger {

    /**
     * https://leetcode.com/problems/reverse-integer
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            int rem = x % 10;
            x /= 10;
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0;
            }
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0;
            }
            num = num * 10 + rem;
        }

        return num;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new LC7ReverseInteger().reverse(21));
        System.out.println(new LC7ReverseInteger().reverse(321));
        System.out.println(new LC7ReverseInteger().reverse(1534236469));
        System.out.println(new LC7ReverseInteger().reverse(-2147483412));
    }

}

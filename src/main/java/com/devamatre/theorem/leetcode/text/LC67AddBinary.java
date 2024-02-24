package com.devamatre.theorem.leetcode.text;

/**
 * @author Rohtash Lakra
 * @created 2/7/24 5:26 PM
 */
public class LC67AddBinary {

    int toInt(String str, int index) {
        return index >= 0 && index < str.length() ? Integer.valueOf(str.charAt(index)) - 48 : 0;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int aEnd = a.length() - 1;
        int bEnd = b.length() - 1;
        StringBuilder sBuilder = new StringBuilder();
        int carry = 0;
        while (aEnd >= 0 && bEnd >= 0) {
            int sum = carry + toInt(a, aEnd) + toInt(b, bEnd);
            aEnd--;
            bEnd--;
            carry = sum / 2;
            sBuilder.insert(0, sum % 2);
        }

        // if a has any elements
        while (aEnd >= 0) {
            int sum = carry + toInt(a, aEnd);
            aEnd--;
            carry = sum / 2;
            sBuilder.insert(0, sum % 2);
        }

        // if b has any elements
        while (bEnd >= 0) {
            int sum = carry + toInt(b, bEnd);
            bEnd--;
            carry = sum / 2;
            sBuilder.insert(0, sum % 2);
        }

        if (carry > 0) {
            sBuilder.insert(0, carry % 2);
        }

        return sBuilder.toString();
    }
}

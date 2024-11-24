/**
 *
 */
package com.rslakra.theorem.leetcode.text;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 22, 2019 8:15:11 PM
 */
public class LC415AddStrings {

    /**
     * @param str
     * @param index
     * @return
     */
    private final int toInt(String str, int index) {
        return (int) (str.charAt(index) - '0');
    }

    /**
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "";
        } else if (num1 == null && num2 != null) {
            return num2;
        } else if (num1 != null && num2 == null) {
            return num1;
        } else {
            String num = null;
            String[] result = null;
            if (num1.length() > num2.length()) {
                num = num2;
                result = new String[num1.length() + 1];
                result[0] = "0";
                for (int i = 0; i < num1.length(); i++) {
                    result[i + 1] = String.valueOf(num1.charAt(i));
                }
            } else {
                num = num1;
                result = new String[num2.length() + 1];
                result[0] = "0";
                for (int i = 0; i < num2.length(); i++) {
                    result[i + 1] = String.valueOf(num2.charAt(i));
                }
            }

            int k = result.length - 1;
            int sum = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                sum = Integer.parseInt(result[k]) + toInt(num, i);
                result[k] = String.valueOf((sum % 10));
                k--;
                result[k] = String.valueOf(Integer.parseInt(result[k]) + (sum / 10));
            }

            for (int i = k; i >= 0; i--) {
                sum = Integer.parseInt(result[i]);
                if (sum > 9) {
                    result[k] = String.valueOf((sum % 10));
                    k--;
                    result[k] = String.valueOf(Integer.parseInt(result[k]) + (sum / 10));
                }
            }

            boolean allZero = true;
            int index = 0;
            for (; index < result.length && (allZero = result[index].equals("0")); index++) {

            }
            if (allZero) {
                return "0";
            }

            StringBuilder sBuilder = new StringBuilder();
            for (; index < result.length; index++) {
                sBuilder.append(result[index]);
            }

            return sBuilder.toString();
        }
    }


    /**
     * @param num1
     * @param num2
     */
    private final void printNumbers(String num1, String num2) {
        if (num1.length() > num2.length()) {
            System.out.println(num1);
            int result = num1.length() - num2.length();
            for (int i = 0; i < result; i++) {
                System.out.print("0");
            }
            System.out.println(num2);
            for (int i = 0; i < num1.length() + 1; i++) {
                System.out.print("-");
            }
        } else {
            int result = num2.length() - num1.length();
            for (int i = 0; i < result; i++) {
                System.out.print("0");
            }
            System.out.println(num1);
            System.out.println(num2);
            for (int i = 0; i < num2.length() + 1; i++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC415AddStrings addStrings = new LC415AddStrings();

        String num1 = "645";
        String num2 = "99";
        addStrings.printNumbers(num1, num2);
        System.out.println(addStrings.addStrings(num1, num2));
        System.out.println();

        num1 = "344";
        num2 = "6464";
        addStrings.printNumbers(num1, num2);
        System.out.println(addStrings.addStrings(num1, num2));
        System.out.println();

        num1 = "9999";
        num2 = "9999";
        addStrings.printNumbers(num1, num2);
        System.out.println(addStrings.addStrings(num1, num2));
        System.out.println();

        num1 = "1";
        num2 = "1";
        addStrings.printNumbers(num1, num2);
        System.out.println(addStrings.addStrings(num1, num2));
        System.out.println();

    }

}

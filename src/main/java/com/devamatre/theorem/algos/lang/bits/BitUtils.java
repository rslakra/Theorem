/**
 *
 */
package com.devamatre.theorem.algos.lang.bits;

/**
 * @author Rohtash Lakra
 */
public class BitUtils {

    /**
     * @param number
     * @param group
     * @return
     */
    public static String toBinaryString(int number, int group) {
        StringBuilder result = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % group == 0) {
                result.append(" ");
            }
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }

    private void testLeftShift(int number) {
        System.out.println(toBinaryString(number, 2));
        for (int i = 0; i < 5; i++) {
            int result = (number << i);
            System.out.println(number + " << " + i + " = " + result);
            System.out.println(toBinaryString(result, 2));
        }
    }

    private void testRightShift(int number) {
        System.out.println(toBinaryString(number, 2));
        for (int i = 1; i <= 5; i++) {
            int result = (number >> i);
            System.out.println(toBinaryString(result, 2));
            System.out.println(number + " >> " + i + " = " + result);
        }
    }

    private void testUnsignedRightShift(int number) {

    }

    public void testBitShifts() {
        int number = 1;
        testLeftShift(number);
        System.out.println();
        testRightShift(number);
        System.out.println();
        testUnsignedRightShift(number);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    /**
     * @param num
     * @return
     */
    public static int lowBit(int num) {
        StringBuilder sBuilder = new StringBuilder(Integer.toBinaryString(num));
        int index = sBuilder.indexOf("1");
        if (index != -1) {
            sBuilder.replace(index, index + 1, "0");
        }
        return Integer.parseInt(sBuilder.toString(), 2);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new BitUtils().testBitShifts();
        System.out.println();
        int leftOperatn = 5;
        int rightOperand = 35;
        System.out.println(leftOperatn + " << " + rightOperand + " = " + (leftOperatn << rightOperand));
        leftOperatn = 24;
        rightOperand = 3;
        System.out.println(leftOperatn + " >> " + rightOperand + " = " + (leftOperatn >> rightOperand));
        System.out.println(toBinaryString(-4, 2));
        System.out.println(sum(3));
        System.out.println(sum(5));
        System.out.println();

        int num = 36;
        System.out.println(lowBit(num));
    }

}

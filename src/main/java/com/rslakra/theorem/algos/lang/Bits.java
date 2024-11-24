/**
 *
 */
package com.rslakra.theorem.algos.lang;

import com.rslakra.theorem.adts.BitUtils;

/**
 * @author Rohtash Lakra
 */
public class Bits {

    private void testLeftShift(int number) {
        System.out.println(BitUtils.toBinaryString(number, 2));
        for (int i = 0; i < 5; i++) {
            int result = (number << i);
            System.out.println(number + " << " + i + " = " + result);
            System.out.println(BitUtils.toBinaryString(result, 2));
        }
    }

    private void testRightShift(int number) {
        System.out.println(BitUtils.toBinaryString(number, 2));
        for (int i = 1; i <= 5; i++) {
            int result = (number >> i);
            System.out.println(BitUtils.toBinaryString(result, 2));
            System.out.println(number + " >> " + i + " = " + result);
        }
    }

    private void testUnsignedRightShift(int number) {
        System.out.println(number);
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
        StringBuilder strBuilder = new StringBuilder(Integer.toBinaryString(num));
        int index = strBuilder.indexOf("1");
        if (index != -1) {
            strBuilder.replace(index, index + 1, "0");
        }
        return Integer.parseInt(strBuilder.toString(), 2);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Bits().testBitShifts();
        System.out.println();
        int leftOperatn = 5;
        int rightOperand = 35;
        System.out.println(leftOperatn + " << " + rightOperand + " = " + (leftOperatn << rightOperand));
        leftOperatn = 24;
        rightOperand = 3;
        System.out.println(leftOperatn + " >> " + rightOperand + " = " + (leftOperatn >> rightOperand));
        System.out.println();

        int binaryGrouping = 4;
        for (int i = 0; i < 16; i++) {
            System.out.println("BitUtils.toBinaryString:" + BitUtils.toBinaryString(i, binaryGrouping));
        }

        System.out.println(sum(3));
        System.out.println(sum(5));
        System.out.println();

        for (int i = 0; i < 32; i++) {
            System.out.println(
                "i:" + i + ", lowBit:" + lowBit(i) + ", BitUtils.toBinaryString:" + Integer.toBinaryString(i));
        }

        int num = 36;
        System.out.println(lowBit(num));
    }

}

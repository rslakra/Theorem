package com.devamatre.theorem.leetcode.text;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 -
 * 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123 Output: "One Hundred Twenty Three"
 * <p>
 * Example 2:
 * <p>
 * Input: 12345 Output: "Twelve Thousand Three Hundred Forty Five"
 * <p>
 * Example 3:
 * <p>
 * Input: 1234567 Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 * Example 4:
 * <p>
 * Input: 1234567891 Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight
 * Hundred Ninety One"
 * <p>
 * Author: Rohtash Singh Lakra Created: 12/22/19 12:14 PM
 */
public final class LC273Integer2EnglishWords {

    private static final String SPACE = " ";
    //ONES
    private static final String[]
        UNITS =
        {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    //TWOS
    private static final String[][] TENS = {
        /* Fully Divisible */
        {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"},

        /* Fully Not Divisible */
        {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"}};

    //place values
    private final Map<Integer, String> placeValues = new HashMap<>();

    public LC273Integer2EnglishWords() {
        placeValues.put(3, "Hundred");
        placeValues.put(4, "Thousand");
        placeValues.put(7, "Million");
        placeValues.put(10, "Billion");
        placeValues.put(13, "Trillion");
        placeValues.put(16, "Quadrillion");
        placeValues.put(19, "Quintillion");
        placeValues.put(22, "Sextillion");
        placeValues.put(25, "Septillion");
        placeValues.put(28, "Octillion");
        placeValues.put(31, "Nonillion");
        placeValues.put(34, "Decillion");
        placeValues.put(37, "Undecillion");
        placeValues.put(40, "Duodecillion");
        placeValues.put(43, "Tredecillion");
        placeValues.put(46, "Quatttuor-decillion");
        placeValues.put(49, "Quindecillion");
        placeValues.put(52, "Sexdecillion");
        placeValues.put(55, "Septen-decillion");
        placeValues.put(58, "Octodecillion");
        placeValues.put(61, "Novemdecillion");
        placeValues.put(64, "Vigintillion");
        placeValues.put(304, "Centillion");
    }

    /**
     * Returns the previous minimum digit.
     *
     * @param digit
     * @return
     */
    private int findDivisorDigit(final int digit) {
        int tempValue = digit;
        while (!placeValues.containsKey(tempValue)) {
            tempValue--;
        }

        return tempValue;
    }

    /**
     * Returns the 2 digit numbers english.
     *
     * @param number
     * @return
     */
    public String twoDigitEnglish(final int number) {
        // fully divisible row contains TEN, TWENTY,..., NINETY
        if (number % 10 == 0) {
            return TENS[0][(number / 10)];
        } else if (number > 10 && number < 20) {
            return TENS[1][(number % 10)];
        } else {
            return String.format("%s %s", TENS[0][(number / 10)], UNITS[number % 10]);
        }
    }

    /**
     * Returns the digits count in the decimal number.
     *
     * @param number
     * @return
     */
    public static int countDecimalDigits(final long number) {
        return (number == 0 ? 1 : (int) Math.log10(number) + 1);
    }

    /**
     * @param number
     * @return
     */
    public static int toInt(long number) {
        return Long.valueOf(number).intValue();
    }

    /**
     * Returns the first <code>digits</code> digits number.
     *
     * @param digits
     * @return
     */
    public static long firstNDigitNumber(final int digits) {
        return (long) Math.pow(10, digits - 1);
    }

    /**
     * @param number
     * @return
     */
    public String twoDigitEnglishOptimized(final int number) {
        final StringBuilder wordBuilder = new StringBuilder();
        int divisor = findDivisorDigit(countDecimalDigits(number));
        long minNumber = firstNDigitNumber(divisor);
        wordBuilder.append(toEnglish(number / minNumber));
        wordBuilder.append(SPACE).append(placeValues.get(divisor));
        wordBuilder.append(SPACE).append(toEnglish(number % minNumber));
        return wordBuilder.toString();
    }

    /**
     * Returns the word representation of the number.
     *
     * @param number
     * @return
     */
    public String toEnglish(final long number) {
        final StringBuilder wordBuilder = new StringBuilder();
        int digits = countDecimalDigits(number);
        switch (digits) {
            case 1:
                wordBuilder.append(UNITS[toInt(number)]);
                break;
            case 2:
                wordBuilder.append(twoDigitEnglish(toInt(number)));
                break;
            default:
                int divisor = findDivisorDigit(digits);
                long minNumber = firstNDigitNumber(divisor);
                wordBuilder.append(toEnglish(number / minNumber));
                wordBuilder.append(SPACE).append(placeValues.get(divisor));
                if (number % minNumber != 0) {
                    wordBuilder.append(SPACE).append(toEnglish(number % minNumber));
                }
                break;
        }

        return wordBuilder.toString();
    }

    /**
     * @param digits
     */
    public void testNDigitNumber(final int digits) {
        System.out.println(digits + " Digit Numbers");
        Random random = new Random();
        long minNumber = firstNDigitNumber(digits);
        long maxNumber = firstNDigitNumber(digits + 1);
        long longNumber = random.longs(minNumber, maxNumber).findAny().getAsLong();
        System.out.println(longNumber + " : " + toEnglish(longNumber));
        System.out.println();
    }

    /**
     * @param number
     */
    public void testNumber(final long number) {
        System.out.println(number + " : " + toEnglish(number));
        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC273Integer2EnglishWords testNumbers = new LC273Integer2EnglishWords();
        /*
         for (int i = 0; i <= 10; i++) {
         testNumbers.testNDigitNumber(i);
         }
         */

        testNumbers.testNumber(10001);
    }
}

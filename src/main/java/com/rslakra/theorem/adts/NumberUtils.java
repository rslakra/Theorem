/**
 *
 */
package com.rslakra.theorem.adts;

import com.rslakra.appsuite.core.BeanUtils;
import com.rslakra.appsuite.core.MathUtils;
import com.rslakra.theorem.adts.lang.Maths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public enum NumberUtils {

    INSTANCE;

    public static final boolean DEBUG = false;
    public static final String SPACE = " ";

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtils.class);
    private boolean active = false;

    NumberUtils() {
    }

    /**
     * Returns the <code>Double</code> value of the provided int <code>value</code>.
     *
     * @param value
     * @return
     */
    public static Double asDouble(int value) {
        return Double.valueOf(value);
    }

    /**
     * Returns the <code>Float</code> value of the provided int <code>value</code>.
     *
     * @param value
     * @return
     */
    public static Float asFloat(int value) {
        return Float.valueOf(value);
    }

    /**
     * Returns the <code>Double</code> value of the provided int <code>value</code>.
     *
     * @param value
     * @return
     */
    public static Integer asInteger(Comparable value) {
        return (Integer) value;
    }

    /**
     * Returns the <code>Double</code> value of the provided <code>left</code> and <code>right</code> integers.
     *
     * @param left
     * @param right
     * @return
     */
    public static Double multiply(int left, int right) {
        return Double.valueOf(left * right);
    }

    /**
     * Returns the null safe value of the <code>number</code>.
     *
     * @param number
     * @return
     */
    public static BigDecimal nullSafeGet(BigDecimal number) {
        return Objects.isNull(number) ? BigDecimal.ZERO : number;
    }

    /**
     * @param value
     * @return
     */
    public static boolean isEqualsToZero(BigDecimal value) {
        return BigDecimal.ZERO.compareTo(value) == 0;
    }

    /**
     * @param value
     * @return
     */
    public static boolean isGreaterThanZero(BigDecimal value) {
        return BigDecimal.ZERO.compareTo(value) > 0;
    }

    /**
     * @param value
     * @return
     */
    public static boolean isLessThanZero(BigDecimal value) {
        return BigDecimal.ZERO.compareTo(value) > 0;
    }

    /**
     * @param object
     * @return
     */
    public static BigDecimal toBigDecimal(Object object) {
        return BeanUtils.asType(Objects.toString(object), BigDecimal.class);
    }

    /**
     * Returns an average of the given numbers.
     *
     * @param inputArray
     * @return
     */
    public int average(final List<Integer> inputArray) {
        int average = 0;
        if (BeanUtils.isNotEmpty(inputArray)) {
            int total = 0;
            for (int index = 0; index < inputArray.size(); index++) {
                total += inputArray.get(index);
            }

            average = (total / inputArray.size());
        }

        LOGGER.debug("average:{}", average);
        return average;
    }


    /**
     * @return
     */
    public List<Integer> readRandomNumbers() {
        List<Integer> listNumbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        final Random rand = new Random();
        int inputNumber = 0;
        do {
            System.out.println("Please enter a non-negative number:");
            inputNumber = in.nextInt();
            if (inputNumber > 0) {
                int total = 0;
                for (int i = 0; i < listNumbers.size(); i++) {
                    listNumbers.add(rand.nextInt(100));
                }
            }
        } while (inputNumber != 0);
        in.close();

        LOGGER.debug("average:{}", average(listNumbers));

        return listNumbers;
    }

    /**
     * @return
     */
    public void randomNumbersAverage() {
        List<Integer> listNumbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        final Random rand = new Random();
        int inputNumber = 0;
        do {
            System.out.println("Please enter a non-negative number:");
            inputNumber = in.nextInt();
            if (inputNumber > 0) {
                int total = 0;
                for (int i = 0; i < listNumbers.size(); i++) {
                    listNumbers.add(rand.nextInt(100));
                }
            }
        } while (inputNumber != 0);
        in.close();

        LOGGER.debug("average:{}", average(listNumbers));
    }

    /**
     * Returns the previous minimum digit.
     *
     * @param digit
     * @return
     */
    private int findDivisorDigit(final int digit) {
        int tempValue = digit;
        while (!Maths.hasPlaceValue(tempValue)) {
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
            return Maths.getDigits(number / 10, true);
        } else if (number > 10 && number < 20) {
            return Maths.getDigits(number % 10, false);
        } else {
            return Maths.getDigits(number / 10, true) + SPACE + Maths.getDigits(number % 10);
        }
    }

    /**
     * @param number
     * @return
     */
    public String twoDigitEnglishOptimized(final int number) {
        final StringBuilder wordBuilder = new StringBuilder();
        if (DEBUG) {
            LOGGER.debug("number: " + number);
        }

        int divisor = findDivisorDigit(MathUtils.countDecimalDigits(number));
        long minNumber = MathUtils.firstNDigitNumber(divisor);
        if (DEBUG) {
            LOGGER.debug("divisor: " + divisor + ", minNumber: " + minNumber);
        }
        wordBuilder.append(toEnglish(number / minNumber));
        wordBuilder.append(SPACE).append(Maths.getPlaceValue(divisor));
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
        if (DEBUG) {
            LOGGER.debug("number: " + number);
        }
        final StringBuilder wordBuilder = new StringBuilder();
        int digits = MathUtils.countDecimalDigits(number);
        switch (digits) {
            case 1:
                wordBuilder.append(Maths.getDigits(MathUtils.toInteger(number)));
                break;
            case 2:
                wordBuilder.append(twoDigitEnglish(MathUtils.toInteger(number)));
                break;
            default:
                int divisor = findDivisorDigit(digits);
                long minNumber = MathUtils.firstNDigitNumber(divisor);
                if (DEBUG) {
                    LOGGER.debug("divisor: " + divisor + ", minNumber: " + minNumber);
                }
                wordBuilder.append(toEnglish(number / minNumber));
                wordBuilder.append(SPACE).append(Maths.getPlaceValue(divisor));
                wordBuilder.append(SPACE).append(toEnglish(number % minNumber));
                break;
        }

        return wordBuilder.toString();
    }


    /**
     * Decimal & Binary
     * <url>https://www.cuemath.com/numbers/binary-to-decimal</url>
     * <p>
     * Converts the number into binary number.
     */
    public static int[] decimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        // divide until number != 0
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        // iterate stack and build an array
        int index = 0;
        int[] binary = new int[stack.size()];
        while (!stack.isEmpty()) {
            binary[index++] = stack.pop().intValue();
        }

        return binary;
    }

    /**
     * Converts the binary number into decimal number.
     *
     * @param binary
     * @return
     */
    public static int binaryToDecimal(int[] binary) {
        int number = 0;
        for (int i = 0; i < binary.length; i++) {
            number = (number * 2) + binary[i];
        }

        return number;
    }


}

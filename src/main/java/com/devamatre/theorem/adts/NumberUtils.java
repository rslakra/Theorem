/**
 *
 */
package com.devamatre.theorem.adts;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.appsuite.core.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public enum NumberUtils {

    INSTANCE;

    public static final boolean DEBUG = false;
    public static final String SPACE = " ";

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtils.class);
    private boolean active = false;

    //place values

    NumberUtils() {
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

}

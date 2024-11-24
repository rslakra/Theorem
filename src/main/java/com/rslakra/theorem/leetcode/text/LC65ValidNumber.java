/**
 *
 */
package com.rslakra.theorem.leetcode.text;

import java.util.regex.Pattern;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 20, 2019 10:48:19 PM
 */
public class LC65ValidNumber {

    /**
     * @return
     */
    private boolean isLogEnabled() {
        return true;
    }

    /**
     * @param str
     */
    private void log(String str) {
        if (isLogEnabled()) {
            System.out.println(str);
        }
    }


    /**
     * Returns true if the number is natural number otherwise false.
     *
     * @param str
     * @return
     */
    private boolean isNaturalNumber(String str) {
        return false;
    }

    /**
     * Validate if a given string can be interpreted as a decimal number.
     *
     * <pre>
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     * </pre>
     * <p>
     * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front
     * before implementing one. However, here is a list of characters that can be in a valid decimal number:
     *
     * <pre>
     * Numbers 0-9 Exponent - "e"
     * Positive/negative sign - "+"/"-"
     * Decimal point - "."
     * </pre>
     * <p>
     * Of course, the context of these characters also matters in the input.
     *
     * @param str
     * @return
     */
    public boolean isNumber(String str) {
        log("+isNumber(" + str + ")");
        if (str == null) {
            log("-isNumber() - false");
            return false;
        }

        str = str.trim();
        if (str.length() == 0) {
            log("-isNumber() - false");
            return false;
        }

        int index = str.indexOf('e');
        if (index != -1) {
            return (isNumber(str.substring(0, index)) && isValidExponent(str.substring(index + 1)));
        } else {
            if (str.replace(".", "").length() == 0) {
                return false;
            }

            int i = 0;
            // ignore +
            int plusCount = 0;
            for (; i < str.length() && str.charAt(i) == '+'; i++) {
                plusCount++;
            }
            if (plusCount > 1) {
                log("-isNumber() - false, plusCount:" + plusCount);
                return false;
            }

            // ignore -
            int minusCount = 0;
            for (; i < str.length() && str.charAt(i) == '-'; i++) {
                minusCount++;
            }
            if (minusCount > 1) {
                log("-isNumber() - false, minusCount:" + minusCount);
                return false;
            }

            // ignore .
            int dotCount = 0;
            for (; i < str.length() && str.charAt(i) == '.'; i++) {
                dotCount++;
            }
            if (dotCount > 1) {
                log("-isNumber() - false, dotCount:" + dotCount);
                return false;
            }

            for (; i < str.length(); i++) {
                if (str.charAt(i) == '+') {
                    plusCount++;
                    continue;
                }

                if (str.charAt(i) == '-') {
                    minusCount++;
                    continue;
                }

                if (str.charAt(i) == '.') {
                    dotCount++;
                    continue;
                }

                if (plusCount > 0 && minusCount > 0) {
                    log("-isNumber() - false");
                    return false;
                }

                if (plusCount > 1) {
                    log("-isNumber() - false, plusCount:" + plusCount);
                    return false;
                }

                if (minusCount > 1) {
                    log("-isNumber() - false, minusCount:" + minusCount);
                    return false;
                }

                if (dotCount > 1) {
                    log("-isNumber() - false, dotCount:" + dotCount);
                    return false;
                }

                if (!isNumber(str, i, true)) {
                    log("-isNumber() - false");
                    return false;
                }
            }

            if (plusCount > 0 && minusCount > 0) {
                log("-isNumber() - false");
                return false;
            }

            if (plusCount > 1) {
                log("-isNumber() - false, plusCount:" + plusCount);
                return false;
            }

            if (minusCount > 1) {
                log("-isNumber() - false, minusCount:" + minusCount);
                return false;
            }

            if (dotCount > 1) {
                log("-isNumber() - false, dotCount:" + dotCount);
                return false;
            }

            log("-isNumber() - true");
            return true;
        }
    }

    /**
     * @param str
     * @return
     */
    public boolean isValidExponent(String str) {
        log("+isValidExponent(" + str + ")");
        if (str == null || str.trim().length() == 0) {
            log("-isValidExponent() - false");
            return false;
        }

        if (str.contains(".")) {
            log("-isValidExponent() - false");
            return false;
        }

        if (!isNumber(str)) {
            log("-isValidExponent() - false");
            return false;
        }

        log("-isValidExponent() - true");
        return true;
    }

    /**
     * @param str
     * @param index
     * @return
     */
    public boolean isNumber(String str, int index, boolean withDot) {
        log("+isNumber(" + str + "," + index + ", " + withDot + ")");
        if (index < 0 || index >= str.length()) {
            log("-isNumber(): false");
            return false;
        }

        if (str.charAt(index) < '0' || str.charAt(index) > '9') {
            if (withDot && str.charAt(index) == '.') {
                log("-isNumber(): true");
                return true;
            }

            log("-isNumber(): false");
            return false;
        }

        log("-isNumber(): true");
        return true;
    }

    /**
     * @param str
     * @return
     */
    public boolean isNumberNaiveSolution(String str) {
        if (str == null) {
            return false;
        }

        str = str.trim();
        if (str.length() == 0) {
            return false;
        }

        try {
            Double dNumber = Double.parseDouble(str);
            char cChar = str.charAt(str.length() - 1);
            if (cChar == 'f' || cChar == 'F' || cChar == 'D' || cChar == 'd') {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    /**
     * @param str
     * @return
     */
    public boolean isNumberRegEx(String str) {
        String numRegEx = "(-|\\+)?((\\d+\\.?\\d*)|(\\.\\d+))(e(-|\\+)?\\d+)?";
        return Pattern.compile(numRegEx).matcher(str.trim()).matches();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC65ValidNumber validNumber = new LC65ValidNumber();
        String[] strs = {"0", " 0.1 ", "abc", "1 a", "2e10", " -90e3   ", " 1e", "e3", " 6e-1", " 99e2.5 ", "53.5e93",
                         " --6 ", "-+3", "95a54e53", ".", "..", "..0", "0.."};
        for (int i = 0; i < strs.length; i++) {
            // System.out.println(strs[i] + " is number: " + validNumber.isNumber(strs[i]));

            System.out.println(strs[i] + " is number: " + validNumber.isNumberNaiveSolution(strs[i]));
            System.out.println(strs[i] + " is number: " + validNumber.isNumberRegEx(strs[i]));
        }
    }

}

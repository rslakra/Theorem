package com.devamatre.theorem.coderbyte;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 03/11/2021 5:27 PM
 */
public class StringReduction {


    /**
     * https://justprogrammng.blogspot.com/2012/06/interviewstreet-challenge-string.html
     * https://stackoverflow.com/questions/8033553/length-of-smallest-string-with-three-letter-alphabet-achievable-by-replacing-two
     * https://github.com/eraydmrcoglu/coderbyte-java-solutions/blob/main/Medium/StringReduction.java
     */

//    private static int solve(String input) {
//        int len = input.length();
//
//        int i = 0;
//        while (i < len - 1) {
//            char current = input.charAt(i);
//            char next = input.charAt(i + 1);
//
//            if (current == next) {
//                input = input.substring(0, i) + input.substring(i + 2);
//                len = input.length();
//                i = 0;
//                continue;
//            }
//            i++;
//        }
//
//        return input.length();
//    }

    /**
     * Pseudo-code
     *
     * <pre>
     *  1. Count the number of occurrences of each letter in input
     *  2. If two 2 these counts are 0, then return string.length
     *  3. else if (all counts are even) or (all counts are odd), return 2
     *  4. else return 1
     * </pre>
     *
     * @param str
     * @return
     */
    // working
    public static int solve2(String str) {
        // code goes here
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            // check which char is it and increase the count of that
            if (str.charAt(i) == 'a') {
                a++;
            } else if (str.charAt(i) == 'b') {
                b++;
            } else if (str.charAt(i) == 'c') {
                c++;
            }
        }

        //
        if (a == str.length() || b == str.length() || c == str.length()) {
            return str.length();
        } else if ((a % 2 == 0 && b % 2 == 0 && c % 2 == 0) || (a % 2 == 1 && b % 2 == 1 && c % 2 == 1)) {
            return 2;
        } else {
            return 1;
        }
    }


//    public int solve3(String s) {
//        Map<String, String> keys = new HashMap<>();
//        keys.put("ab", "c");
//        keys.put("ac", "b");
//        keys.put("bc", "a");
//
//        keys.put("ba", "c");
//        keys.put("ca", "b");
//        keys.put("cb", "a");
//
//        String original;
//        while (!s.equals(original)) {
//            original = s;
//            for (String key : keys.keySet()) {
//                s = s.replace(key, keys.get(key));
//            }
//        }
//
//        return s.length;
//    }


    int minimum = 1;
    int value = 1;

    private boolean reduce(String input) {
        char[] array = input.toCharArray();
        int len = array.length;
        minimum = array.length;
        boolean flag;
        String cat;
        if (len == 1) {
            value = 1;
            return true;
        } else if (array[0] == array[1] && len == 2) {
            value = 2;
            return true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (array[i + 1] != array[i]) {
                String new_string = Character.toString(array[i]).concat(Character.toString(array[i + 1]));
                char reduce = other(new_string);
                String sub1 = "";
                String sub2 = Character.toString(reduce);
                String sub3 = "";
                if (i == 1) {
                    sub1 = Character.toString(array[0]);
                } else if (i > 1) {
                    sub1 = input.substring(0, i);
                }
                if (i + 2 < len - 1) {
                    sub3 = input.substring(i + 2, len);
                } else if (i + 2 == len - 1) {
                    sub3 = Character.toString(array[i + 2]);
                }
                cat = sub1 + sub2 + sub3;
                flag = reduce(cat);
                if (flag) {
                    minimum = Math.min(minimum, value);
                    return flag;
                }
            }
        }

        return false;
    }

    private char other(String input) {
        char result = 'b';
        if (input.equalsIgnoreCase("bc") || input.equalsIgnoreCase("cb")) {
            result = 'a';
        } else if (input.equalsIgnoreCase("ab") || input.equalsIgnoreCase("ba")) {
            result = 'c';
        }

        return result;
    }
}

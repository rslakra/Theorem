/**
 *
 */
package com.devamatre.theorem.leetcode.text;

/**
 * @author Rohtash Lakra
 */
public class Str {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] = (char) (array[i] + 32);
            }
        }

        return new String(array);
    }

    /**
     * Reverse the string with delimiters but the delimiters position must remain unchanged.
     *
     * <pre>
     * Input: "hello/world:here"
     * Output: "here/world:hello"
     * </pre>
     *
     * @param str
     * @return
     */
    public String reverse(String str) {
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Str str = new Str();
        System.out.println(str.toLowerCase("Rohtash"));
        char[] arr = new char[]{'R', 'o'};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                System.out.print((char) (arr[i] + 32));
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();

        String input = "hello/world:here";
        System.out.println(str.reverse(input));

    }

}

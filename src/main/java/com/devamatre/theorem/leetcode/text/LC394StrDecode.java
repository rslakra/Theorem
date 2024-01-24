/**
 *
 */
package com.devamatre.theorem.leetcode.text;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Jun 30, 2019 7:27:09 PM
 */
public class LC394StrDecode {

    /**
     * @param str
     * @param index
     * @return
     */
    private final int loopCounter(String str, int index) {
        return Integer.parseInt(String.valueOf(str.charAt(index)));
    }

    /**
     * @param str
     * @return
     */
    private String toDecode(int loop, String str) {
        System.out.println("loop:" + loop + ", str:" + str);
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            if (str.contains("[")) {
                int index = 0;
                String tempString = str;
                while (index < str.length()) {
                    if (tempString.contains("[")) {
                        int sIndex = tempString.indexOf("[");
                        sBuilder.append(tempString.substring(0, sIndex - 1));
                        int eIndex = tempString.indexOf("]");
                        tempString = tempString.substring(sIndex + 1, eIndex);
                        sBuilder.append(toDecode(loopCounter(tempString, sIndex - 1), tempString));
                        index = eIndex;
                    } else {
                        sBuilder.append(tempString);
                    }
                }
            } else {
                sBuilder.append(str);
            }
        }

        return sBuilder.toString();
    }

    /**
     * @param str
     * @return
     */
    public String decodeString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        return toDecode(loopCounter(str, 0), str.substring(2, str.length() - 1));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC394StrDecode strDecoder = new LC394StrDecode();
        String str = "2[abc]";
        System.out.println(strDecoder.decodeString(str));
        str = "2[a3[b]c]";
        System.out.println(strDecoder.decodeString(str));
    }

}

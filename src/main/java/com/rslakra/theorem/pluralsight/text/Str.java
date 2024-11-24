/**
 *
 */
package com.rslakra.theorem.pluralsight.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 */
public enum Str {

    INSTANCE;

    /**
     * @param find
     * @return
     */
    public Map<Character, Integer> makeFindTable(String find) {
        final Map<Character, Integer> map = new HashMap<Character, Integer>();
        if (find != null) {
            map.put('?', find.length());
            final int len = find.length();
            for (int i = len - 2; i >= 0; i--) {
                map.put(find.charAt(i), (len - i - 1));
            }
        }

        return map;
    }

    /**
     * @param cChar
     * @return
     */
    public int getDirtyIndex(Map<Character, Integer> map, char cChar) {
        if (map.containsKey(cChar)) {
            return map.get(cChar);
        }

        return map.get('?');
    }

    /**
     * @param source
     * @param find
     * @return
     */
    public List<Integer[]> findString(String source, String find) {
        List<Integer[]> indexes = new ArrayList<>();
        Map<Character, Integer> map = makeFindTable(find);
        System.out.println(map);
        int index = 0;
        while (index < (source.length() - find.length())) {
            int lastIndex = find.length() - 1;
            while (lastIndex >= 0 && find.charAt(lastIndex) == source.charAt((index + lastIndex))) {
                lastIndex--;
            }

            if (lastIndex < 0) {
                // the string ends here
                // check for the match and return indexes.
                int lastIndexOfPattern = index + find.length();
                if (source.substring(index, lastIndexOfPattern).equals(find)) {
                    indexes.add(new Integer[]{index, lastIndexOfPattern - 1});
                }
                index += find.length();
            } else {
                index += getDirtyIndex(map, source.charAt(lastIndex + find.length() - 1));
            }
        }

        return indexes;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Str str = Str.INSTANCE;
        String source = "how are the things going on?";
        source =
            "Whether you’re planning your next big adventure with the whole group or just catching up with your family, calling is now even better.";
        source =
            "The window also offers a View more on Pluralsight.com option to view that course on the web. The redirect to Pluralsight.com will only work if the device has an active internet connection. If there is no connection the app will attempt to open the page in the browser, but the browser will display an error message because the device is not connected to the internet.";
        String find = "the";
        System.out.println(source);
        List<Integer[]> indexes = str.findString(source, find);
        for (Integer[] integers : indexes) {
            System.out.println(Arrays.toString(integers));
        }

    }

}

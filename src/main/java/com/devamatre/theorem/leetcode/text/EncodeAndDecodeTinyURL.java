/**
 *
 */
package com.devamatre.theorem.leetcode.text;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 */
public class EncodeAndDecodeTinyURL {

    // Map to store 62 possible characters
    private static final String ALPHA_NUMS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String HOST = "http://tinyurl.com/";

    private Map<String, String> url2Code;
    private Map<String, String> code2Url;

    public EncodeAndDecodeTinyURL() {
        url2Code = new HashMap<>();
        code2Url = new HashMap<>();
    }

    /**
     * @param hashCode
     * @return
     */
    private String idToShortURL(int hashCode) {
        StringBuilder urlBulder = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (hashCode != 0) {
            urlBulder.append(ALPHA_NUMS.charAt(hashCode % ALPHA_NUMS.length()));
            hashCode = hashCode / ALPHA_NUMS.length();
        }

        // Reverse shortURL to complete base conversion
        urlBulder.reverse();

        return urlBulder.toString();
    }

    /**
     * Encodes a URL to a shortened URL.
     *
     * @param longUrl
     * @return
     */
    public String encode(String longUrl) {
        String urlShort = url2Code.get(longUrl);
        if (urlShort == null) {
            String base64Encoded = Base64.getEncoder().encodeToString(longUrl.getBytes());
            int hashCode = base64Encoded.hashCode();
            // convert hashCode to base62 base
            urlShort = idToShortURL(hashCode);
            url2Code.put(longUrl, urlShort);
            code2Url.put(urlShort, longUrl);
        }
        urlShort = HOST + urlShort;

        return urlShort;
    }

    /**
     * Function to get integer ID back from a short url.
     *
     * @param urlShort
     * @return
     */
    private int toIdFromUrlShort(String urlShort) {
        int hashCode = 0;

        if (urlShort != null && urlShort.length() > 0) {
            // A simple base conversion logic
            for (int i = 0; i < urlShort.length(); i++) {
                char cChar = urlShort.charAt(i);
                hashCode = hashCode * 62;
                if ('a' <= cChar && cChar <= 'z') {
                    hashCode += (cChar - 'a');
                }
                if ('A' <= cChar && cChar <= 'Z') {
                    hashCode += (cChar - 'A' + 26);
                }
                if ('0' <= cChar && cChar <= '9') {
                    hashCode += (cChar - '0' + 52);
                }
            }
        }

        return hashCode;
    }

    /**
     * Decodes a shortened URL to its original URL.
     *
     * @param shortUrl
     * @return
     */
    public String decode(String shortUrl) {
        String urlString = null;
        if (shortUrl != null) {
            shortUrl = shortUrl.substring(HOST.length());
            urlString = code2Url.get(shortUrl);
        }

        return urlString;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EncodeAndDecodeTinyURL urlShortner = new EncodeAndDecodeTinyURL();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = urlShortner.encode(longUrl);
        System.out.println(shortUrl + " for longUrl:" + longUrl);
        longUrl = urlShortner.decode(shortUrl);
        System.out.println(shortUrl + " decoded longUrl:" + longUrl);
    }

}

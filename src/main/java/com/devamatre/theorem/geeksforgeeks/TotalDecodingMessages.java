package com.devamatre.theorem.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 */
public class TotalDecodingMessages {

    /**
     * @param digits
     * @return
     */
    public static boolean isEncodable(int index, char[] digits) {
        if (digits != null && index < digits.length) {
            if (digits[index] - 48 > 0 && index + 1 < digits.length && digits[index + 1] - 48 < 7) {
                return true;
            }
        }

        return false;
    }

    /**
     * @author Rohtash Lakra
     */
    private class TrieNode {

        Map<Character, TrieNode> children;
        boolean end;

        public TrieNode() {
            children = new HashMap<>();
            end = false;
        }

        /**
         * @param index
         * @param digits
         * @return
         */
        private boolean isEncodableWithNextDigit(int index, char[] digits) {
            return (index + 1 < digits.length
                    && ((digits[index] - 48 > 0 && digits[index] - 48 <= 2) && digits[index + 1] - 48 < 7));
        }

        /**
         * @param index
         * @param digits
         * @return
         */
        private char nextEncodableDigit(int index, char[] digits) {
            return (char) ((digits[index] - 48) + (digits[index + 1] - 48));
        }

        /**
         * @param rootNode
         * @param index
         * @param digits
         */
        public void insert(TrieNode rootNode, int index, char[] digits) {
            for (int i = index; i < digits.length; i++) {
                TrieNode nextNode = rootNode.children.get(digits[i]);
                if (nextNode == null) {
                    nextNode = new TrieNode();
                    rootNode.children.put(digits[i], nextNode);
                    insert(nextNode, index + 1, digits);
                    nextNode.end = (index == digits.length - 1);
                    rootNode = nextNode;
                }

                if (isEncodableWithNextDigit(i, digits)) {
                    char nextChar = nextEncodableDigit(i, digits);
                    TrieNode nextDigitsNode = rootNode.children.get(nextChar);
                    if (nextDigitsNode == null) {
                        nextDigitsNode = new TrieNode();
                        rootNode.children.put(nextChar, nextDigitsNode);
                        insert(nextDigitsNode, index + 2, digits);
                        nextNode.end = (index + 1 == digits.length - 1);
                    }
                    rootNode = nextDigitsNode;
                }
            }

            rootNode.end = true;
        }

        /**
         * @param rootNode
         * @param digits
         * @return
         */
        public List<String> decodedMessages(TrieNode rootNode, char[] digits) {
            List<String> allMessages = new ArrayList<>();
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                TrieNode nextNode = rootNode.children.get(digits[i]);
                if (nextNode != null) {
                    sBuilder.append(digits[i]);
                    if (nextNode.end) {
                        allMessages.add(sBuilder.toString());
                        sBuilder.setLength(0);
                    }
                }

                if (isEncodableWithNextDigit(i, digits)) {
                    char nextChar = nextEncodableDigit(i, digits);
                    TrieNode nextDigitsNode = rootNode.children.get(nextChar);
                    if (nextDigitsNode != null) {
                        nextDigitsNode = new TrieNode();
                        rootNode.children.put(nextChar, nextDigitsNode);
                        insert(nextDigitsNode, i + 2, digits);
                    }
                }

                rootNode = nextNode;
            }

            return allMessages;
        }

    }

    /**
     * @return
     */
    public int totalDecodingMessages(char[] digits) {
        System.out.println(Arrays.toString(digits));
        List<TrieNode> words = new ArrayList<>();
        TrieNode rootNode = new TrieNode();
        rootNode.insert(rootNode, 0, digits);
        return words.size();
    }

    public static void main(String[] args) {
        TotalDecodingMessages decodingMessages = new TotalDecodingMessages();
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        HashMap<Integer, Integer> results = new HashMap<>();
        for (int index = 0; index < testCases; index++) {
            input.nextInt();
            char[] digits = input.next().toCharArray();
            int totalMessages = decodingMessages.totalDecodingMessages(digits);
            results.put(index, totalMessages);
        }

        for (int index = 0; index < testCases; index++) {
            System.out.println(results.get(index));
        }

        input.close();
    }

}

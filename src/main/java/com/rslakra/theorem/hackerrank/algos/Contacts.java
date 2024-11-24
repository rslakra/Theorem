/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.theorem.hackerrank.algos;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-24 01:45:31 PM
 * @since 1.0.0
 */
public class Contacts {

    static class Node {

        HashMap<Character, Node> children;
        int count;

        Node() {
            children = new HashMap<Character, Node>();
        }

        public int getCount() {
            return count;
        }

        public Node getChild(char cChar) {
            return children.get(cChar);
        }

        public boolean contains(char cChar) {
            return children.containsKey(cChar);
        }

        public void putIfAbsent(char cChar) {
            children.putIfAbsent(cChar, new Node());
        }
    }

    static class Trie {

        Node root = new Node();

        public void addNode(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                node.putIfAbsent(word.charAt(i));
                node = node.getChild(word.charAt(i));
                node.count++;
            }
        }

        public int findPartials(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                node = node.getChild(prefix.charAt(i));
                if (node == null) {
                    return 0;
                }
            }

            return node.getCount();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie trie = new Trie();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if ("add".equals(op)) {
                trie.addNode(contact);
            } else if ("find".equals(op)) {
                System.out.println(trie.findPartials(contact));
            }
        }
        in.close();
    }
}

package com.rslakra.java.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 01/27/2017 10:39:52 AM
 */
public class StringAlgorithms {
	
	/**
	 * Given an input string, reverse the string word by word. A word is defined
	 * as a sequence of non-space characters.
	 * 
	 * The input string does not contain leading or trailing spaces and the
	 * words are always separated by a single space.
	 * 
	 * For example:
	 * 
	 * <pre>
	 * 	String str = "The great day ahead";
	 * 	return "ahead day great The"
	 * </pre>
	 * 
	 * @param string
	 */
	public static String wordReversal(final String string) {
		// long sTime = System.currentTimeMillis();
		String wordReversed = string;
		if(null != string) {
			String[] words = string.split(" ");
			if(null != words) {
				StringBuilder sBuilder = new StringBuilder();
				for(int i = words.length - 1; i >= 0; i--) {
					sBuilder.append(words[i]);
					if(i > 0) {
						sBuilder.append(" ");
					}
				}
				wordReversed = sBuilder.toString();
			}
		}
		// System.out.println("Took:" + (System.currentTimeMillis() - sTime));
		return wordReversed;
	}
	
	/**
	 * 
	 * @param string
	 * @param startIndex
	 * @param endIndex
	 */
	private static void wordReverse(char[] string, int startIndex, int endIndex) {
		while(endIndex > startIndex) {
			char temp = string[startIndex];
			string[startIndex] = string[endIndex];
			string[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
	
	/**
	 * 
	 * @param string
	 */
	public static void wordReversal(final char[] string) {
		// long sTime = System.currentTimeMillis();
		if(null != string) {
			int startIndex = 0;
			for(int ctr = 0; ctr < string.length; ctr++) {
				if(string[ctr] == ' ') {
					wordReverse(string, startIndex, ctr - 1);
					startIndex = ctr + 1;
				}
			}
			
			wordReverse(string, startIndex, string.length - 1);
			
			// now reverse all the characters.
			wordReverse(string, 0, string.length - 1);
		}
		// System.out.println("Took:" + (System.currentTimeMillis() - sTime));
	}
	
	/**
	 * TODO - Implement Me!
	 * 
	 * @param string
	 * @return
	 */
	public static void wordReversalByArrayCopy(char[] string) {
		char[] reversed = new char[string.length];
		int ctr = string.length - 1;
		int lastIndex = string.length;
		int startIndex = 0;
		while(ctr >= 0) {
			if(string[ctr] == ' ') {
				System.arraycopy(string, (ctr + 1), reversed, startIndex, (lastIndex - 1 - ctr));
				startIndex += (lastIndex - ctr);
				lastIndex = ctr;
			}
			ctr--;
		}
		
		System.arraycopy(string, (ctr + 1), reversed, startIndex, (lastIndex - 1 - ctr));
		System.arraycopy(reversed, 0, string, 0, string.length);
	}
	
	/**
	 * Given two strings s and t, determine if they are isomorphic. Two strings
	 * are isomorphic if the characters in s can be replaced to get t.
	 * 
	 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
	 * 
	 * @param string
	 * @param another
	 * @return
	 */
	public static boolean isIsomorphic(String string, String another) {
		if(string == null || another == null) {
			return false;
		} else if(string.length() != another.length()) {
			return false;
		} else {
			HashMap<Character, Character> isomorphic = new HashMap<>();
			for(int i = 0; i < string.length(); i++) {
				char key = string.charAt(i);
				char value = another.charAt(i);
				if(isomorphic.containsKey(key)) {
					if(isomorphic.get(key) != value) {
						return false;
					}
				} else if(isomorphic.containsValue(value)) {
					return false;
				} else {
					isomorphic.put(key, value);
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * Java Solution
	 * 
	 * To understand this solution, you can use s="aab" and p="*ab".
	 * 
	 * @return
	 */
	public static boolean wildCardMatching(String source, String criteria) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
		
		while(i < source.length()) {
			if(j < criteria.length() && (criteria.charAt(j) == '?' || criteria.charAt(j) == source.charAt(i))) {
				++i;
				++j;
			} else if(j < criteria.length() && criteria.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if(starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}
		
		while(j < criteria.length() && criteria.charAt(j) == '*') {
			++j;
		}
		
		return j == criteria.length();
	}
	
	/**
	 * Starting point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// String string = "The great day ahead";
		String string = "Rohtash Singh Lakra";
		string = "The quick brown fox jumps over the little lazy dog.";
		
		System.out.println("string:" + string);
		String wordReversed = wordReversal(string);
		System.out.println("wordReversed:" + wordReversed);
		
		char[] values = string.toCharArray();
		wordReversal(values);
		System.out.println(Arrays.toString(values));
		
		values = string.toCharArray();
		wordReversalByArrayCopy(values);
		System.out.println(Arrays.toString(values));
		
		string = "foo";
		String another = "bar";
		System.out.println("isIsomorphic(" + string + ", " + another + "):" + isIsomorphic(string, another));
		
		String source = "aaxab";
		String criteria = "*ab";
		System.out.println("wildCardMatching(" + source + ", " + criteria + "):" + wildCardMatching(source, criteria));
		
	}
	
}

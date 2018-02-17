package com.rslakra.algorithms;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 02/16/2017 07:33:13 PM
 *
 */
public class ExcelSheetAlgos {
	
	/**
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number. For example:
	 * 
	 * A -> 1
	 * B -> 2
	 * C -> 3
	 * ...
	 * Z -> 26
	 * AA -> 27
	 * AB -> 28
	 * ...
	 * AAA -> 703
	 * 
	 * 
	 * @param columnTitle
	 * @return
	 */
	public static int columnNumber(String columnTitle) {
		int columnNumber = 0;
		if(columnTitle != null) {
			char[] columns = columnTitle.toCharArray();
			int ctr = 0;
			for(int i = columns.length - 1; i >= 0; ctr++, i--) {
				columnNumber = columnNumber + (int) Math.pow(26, ctr) * (columns[i] - 'A' + 1);
			}
		}
		
		return columnNumber;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String columnTitle = "AAA";
		System.out.println("columnNumber(" + columnTitle + "):" + columnNumber(columnTitle));
	}
	
}

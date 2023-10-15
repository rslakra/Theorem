/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.algorithms;

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

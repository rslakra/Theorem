/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018
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
package com.rslakra.datastructure.testcases;

public class Bits {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		int c = 3;
		
		System.out.println("a&b: " + (a & b));
		System.out.println("a&c: " + (a & c));
		System.out.println("b&c: " + (b & c));
		System.out.println();
		
		System.out.println("a|b: " + (a | b));
		System.out.println("a|c: " + (a | c));
		System.out.println("b|c: " + (b | c));
		System.out.println();
		
		System.out.println("a>>b: " + (a >> b));
		System.out.println("a>>c: " + (a >> c));
		System.out.println("b>>c: " + (b >> c));
		System.out.println();
		
		System.out.println("a<<b: " + (a << b));
		System.out.println("a<<c: " + (a << c));
		System.out.println("b<<c: " + (b << c));
		System.out.println();
		
		int d = 2;
		d |= a;
		System.out.println("d|=a: " + d);
		d |= b;
		System.out.println("d|=b: " + d);
		d |= c;
		System.out.println("d|=c: " + d);
		System.out.println();
		
	}
	
}

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
package com.rslakra.java;

import java.util.Scanner;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2017-10-17 08:04:39 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class CommonFactors {

	/**
	 * 
	 * @param divisible
	 * @param divisor
	 * @return
	 */
	public static int greatestCommonDivisor(int nominator, int denominator) {
		if (denominator == 0) {
			return nominator;
		} else {
			return greatestCommonDivisor(denominator, nominator % denominator);
		}
	}

	/**
	 * 
	 * @param divisible
	 * @param divisor
	 * @return
	 */
	public static int highestCommonFactor(int nominator, int denominator) {
		int commonFactor = denominator == 0 ? nominator : denominator;
		while (denominator != 0) {
			if (nominator % denominator == 0) {
				break;
			}
			commonFactor = nominator % denominator;
			nominator = denominator;
			denominator = commonFactor;
		}

		return commonFactor;
	}

	/**
	 * Formula:
	 * 
	 * LCM(a, b) = a * b / GCD(a, b)
	 * 
	 * @param divisible
	 * @param divisor
	 * @return
	 */
	public static int leastCommonDenominator(int nominator, int denominator) {
		return (nominator * denominator / greatestCommonDivisor(nominator, denominator));

	}

	/**
	 * @param args
	 * 
	 *            For Example:
	 * 
	 *            <code>
	 * 	6 4
	 *  12 8
	 *  30 15
	 * 	54 24
	 *  84 18
	 *  108 24
	 * </code>
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int divisible = in.nextInt();
		int divisor = in.nextInt();
		in.close();
		System.out.println("GCF of " + divisible + " and " + divisor);
		System.out.println(greatestCommonDivisor(divisible, divisor));
		System.out.println(highestCommonFactor(divisible, divisor));
		System.out.println();
		System.out.println("LCM of " + divisible + " and " + divisor);
		System.out.println(leastCommonDenominator(divisible, divisor));

	}

}

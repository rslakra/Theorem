package com.rslakra.algorithms;

/**
 * The Fibonacci sequence is a series of numbers where a number is found by
 * adding up the two numbers before it. Starting with 0 and 1, the sequence goes
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so forth.
 * 
 * Written as a rule, the expression is xn = xn-1 + xn-2.
 * 
 * @author Rohtash Singh Lakra
 * @date 11/03/2016 02:13:54 PM
 *
 */
public final class FibonacciaSeries {
	
	/**
	 * 
	 * @param number
	 */
	public void generateFibonacciaSeries(int number) {
		if(number > 0) {
			int first = 0;
			int next = 1;
			System.out.println("Fibonaccia series for:" + number);
			System.out.println(first);
			System.out.println(next);
			int sum = 0;
			for(int i = 0; i < number - 2; i++) {
				sum = next + first;
				first = next;
				next = sum;
				System.out.println(sum);
			}
		} else {
			System.out.println("Invalid Number! number:" + number);
		}
	}
	
	/**
	 * 
	 * @param number
	 */
	public int recursiveFibonacciaSeries(int number) {
		if(number == 0) {
			return 0;
		} else if(number == 1) {
			return 1;
		} else {
			return (recursiveFibonacciaSeries(number - 1) + recursiveFibonacciaSeries(number - 2));
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciaSeries fSeries = new FibonacciaSeries();
		int number = 10;
		fSeries.generateFibonacciaSeries(number);
		System.out.println();
		System.out.println(fSeries.recursiveFibonacciaSeries(number));
	}
	
}

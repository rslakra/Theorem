package com.rslakra.testcases;

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

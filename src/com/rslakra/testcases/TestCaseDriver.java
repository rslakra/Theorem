package com.rslakra.testcases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestCaseDriver {
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		final String dataFilePath = args[0];
		final String outFilePath = args[1];
		try {
			final BufferedReader fileReader = new BufferedReader(new FileReader(dataFilePath));
			final PrintWriter outFile = new PrintWriter(new FileWriter(outFilePath));
			System.out.println("fileReader:" + fileReader + ", outFile:" + outFile);
			
			final String className = fileReader.readLine();
			final String command = fileReader.readLine();
			System.out.println("className:" + className + ", command:" + command);
			
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
}

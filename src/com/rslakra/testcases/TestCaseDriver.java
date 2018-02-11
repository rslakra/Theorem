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

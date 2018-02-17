/******************************************************************************
 * Copyright (C) Devamatre Technologies 2009-2018

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
package com.rslakra.datastructure.bos;

import com.rslakra.datastructure.utils.Objects;
import com.rslakra.datastructure.utils.ToString;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 09/08/2016 01:51:59 PM
 *
 */
public class Name {
	private String firstName;
	private String middleName;
	private String lastName;
	
	/**
	 * 
	 * @param name
	 */
	public Name() {
		this(null, null, null);
	}
	
	/**
	 * 
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Objects.toString(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Name name = new Name("Rohtash", "Singh", "Lakra");
		System.out.println(Objects.toString(name));
		System.out.println();
		System.out.println(new ToString(true).toString(name));
		System.out.println();
		System.out.println(new ToString(true, true).toString(name));
		
		Name[] names = new Name[2];
		names[0] = new Name("Rohtash", "Singh", "Lakra");
		names[1] = new Name("Sangita", null, "Lakra");
		System.out.println();
		System.out.println(Objects.toString(names));
		System.out.println();
		System.out.println(new ToString(true).toString(names));
		System.out.println();
		System.out.println(new ToString(true, true).toString(names));
	}
	
}

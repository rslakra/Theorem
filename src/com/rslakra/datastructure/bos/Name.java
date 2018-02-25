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
package com.rslakra.datastructure.bos;

import java.util.Objects;

import com.devamatre.logger.LogManager;
import com.rslakra.utils.StringHelper;

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
	 * @param firstName
	 *            the firstName to set
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
	 * @param middleName
	 *            the middleName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the string representation of this object.
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return StringHelper.toString(this);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogManager.configure(LogManager.LOG4J_PROPERTY_FILE);

		Name name = new Name("Rohtash", "Singh", "Lakra");
		System.out.println(Objects.toString(name));
		System.out.println();
		System.out.println(StringHelper.toString(name, true));
		System.out.println();
		System.out.println(StringHelper.toString(name, true, true));

		Name[] names = new Name[2];
		names[0] = new Name("Rohtash", "Singh", "Lakra");
		names[1] = new Name("Sangita", null, "Lakra");
		System.out.println();
		System.out.println(StringHelper.toString(names));
		System.out.println();
		System.out.println(StringHelper.toString(name, true));
		System.out.println();
		System.out.println(StringHelper.toString(name, true, true));
	}

}

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

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 09/08/2016 01:51:47 PM
 *
 */
public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;

	public Address() {

	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Returns the string representation of this object.
	 */
	public String toString() {
		return Objects.toString(this);
		// StringBuilder sBuilder = new StringBuilder();
		// if(StringHelper.isNotNull(getStreet())) {
		// sBuilder.append(getStreet()).append("\n");
		// }
		//
		// if(StringHelper.isNotNull(getCity())) {
		// sBuilder.append(getCity()).append("\n");
		// }
		//
		// if(StringHelper.isNotNull(getState())) {
		// sBuilder.append(getState()).append(" ");
		// }
		//
		// if(StringHelper.isNotNull(getZip())) {
		// sBuilder.append(getZip()).append("\n");
		// }
		//
		// return sBuilder.toString();
	}

}

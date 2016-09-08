package com.rslakra.core.bos;

import com.rslakra.utils.StringHelper;

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
	 * @param street the street to set
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
	 * @param city the city to set
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
	 * @param state the state to set
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
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * Returns the string representation of this object.
	 */
	public String toString() {
		return StringHelper.toString(this);
//		StringBuilder sBuilder = new StringBuilder();
//		if(StringHelper.isNotNull(getStreet())) {
//			sBuilder.append(getStreet()).append("\n");
//		}
//		
//		if(StringHelper.isNotNull(getCity())) {
//			sBuilder.append(getCity()).append("\n");
//		}
//		
//		if(StringHelper.isNotNull(getState())) {
//			sBuilder.append(getState()).append(" ");
//		}
//		
//		if(StringHelper.isNotNull(getZip())) {
//			sBuilder.append(getZip()).append("\n");
//		}
//		
//		return sBuilder.toString();
	}
	
}

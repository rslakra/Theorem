package com.rslakra.core.bos;

import com.rslakra.utils.StringHelper;
import com.rslakra.utils.ToString;

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
		return StringHelper.toString(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Name name = new Name("Rohtash", "Singh", "Lakra");
		System.out.println(StringHelper.toString(name));
		System.out.println();
		System.out.println(new ToString(true).toString(name));
		System.out.println();
		System.out.println(new ToString(true, true).toString(name));
		
		Name[] names = new Name[2];
		names[0] = new Name("Rohtash", "Singh", "Lakra");
		names[1] = new Name("Sangita", null, "Lakra");
		System.out.println();
		System.out.println(StringHelper.toString(names));
		System.out.println();
		System.out.println(new ToString(true).toString(names));
		System.out.println();
		System.out.println(new ToString(true, true).toString(names));
	}
	
}

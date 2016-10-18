package com.rslakra.utils;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 10/18/2016 02:15:00 PM
 *
 */
public final class ObjectHelper {
	/**
	 * Returns true if the object is null or otherwise false.
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {
		return (null == object);
	}
	
	/**
	 * Returns true if the object is not null otherwise false.
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNotNull(Object object) {
		return (!isNull(object));
	}
	
	/**
	 * Returns true if either the strings array is null or empty otherwise
	 * false.
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isNullOrEmpty(Object... objects) {
		return (isNull(objects) || objects.length == 0);
	}
	
	/**
	 * Returns the string representation of the specified <code>object</code>;
	 * 
	 * @param object
	 * @param useReflection
	 * @return
	 */
	public static String toString(Object object, boolean useReflection) {
		return (useReflection ? new ToString().toString(object) : object.toString());
	}
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {
		return toString(object, true);
	}
}

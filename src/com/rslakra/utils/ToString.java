/**
 * 
 */
package com.rslakra.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Rohtash Singh Lakra
 * @date 09/08/2016 04:39:36 PM
 *
 */
public final class ToString {
	/*
	 * excludePackageName
	 */
	private boolean excludePackageName;
	
	/*
	 * includeClassName
	 */
	private boolean includeClassName;
	
	/**
	 * Parameterized Constructor.
	 * 
	 * @param excludePackageName
	 * @param includeClassName
	 */
	public ToString(boolean excludePackageName, boolean includeClassName) {
		this.excludePackageName = excludePackageName;
		this.includeClassName = includeClassName;
	}
	
	/**
	 * Parameterized Constructor.
	 * 
	 * @param includeClassName
	 */
	public ToString(boolean includeClassName) {
		this(false, includeClassName);
	}
	
	/**
	 * Default Constructor.
	 */
	public ToString() {
		this(false, false);
	}
	
	/**
	 * Returns the string representation of the specified <code>object</code>
	 * including all fields.
	 * 
	 * @param object
	 * @param includeClassName
	 * @return
	 */
	public String toString(Object object) {
		if(object == null) {
			return "null";
		}
		
		Class<?> objectClass = object.getClass();
		if(objectClass == String.class) {
			return (String) object;
		} else if(objectClass.isArray()) {
			String classArrayType = (includeClassName ? objectClass.getComponentType().toString() : "") + "[]{";
			if(excludePackageName) {
				int index = classArrayType.lastIndexOf(".");
				if(index > 0 && index < classArrayType.length() - 1) {
					classArrayType = classArrayType.substring(index + 1);
				}
			}
			
			for(int i = 0; i < Array.getLength(object); i++) {
				if(i > 0) {
					classArrayType += ", ";
				}
				
				Object objectArray = Array.get(object, i);
				if(objectClass.getComponentType().isPrimitive()) {
					classArrayType += objectArray;
				} else {
					// recursion call.
					classArrayType += toString(objectArray);
				}
			}
			
			return classArrayType + "}";
		}
		
		String className = (excludePackageName ? objectClass.getSimpleName() : objectClass.getName());
		/*
		 * Check this class fields as well as supper classes, if any.
		 */
		do {
			if(includeClassName) {
				className += "[";
			} else {
				className = "[";
			}
			
			Field[] classFields = objectClass.getDeclaredFields();
			AccessibleObject.setAccessible(classFields, true);
			// get the names and values of all fields
			for(Field field : classFields) {
				if(!Modifier.isStatic(field.getModifiers())) {
					if(!className.endsWith("[")) {
						className += ", ";
					}
					className += field.getName() + "=";
					try {
						Class<?> classType = field.getType();
						Object value = field.get(object);
						if(classType.isPrimitive()) {
							className += value;
						} else {
							// recursion call.
							className += toString(value);
						}
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			className += "]";
			objectClass = objectClass.getSuperclass();
		} while(objectClass != null && !objectClass.isInstance(Object.class));
		
		return className;
	}
	
}

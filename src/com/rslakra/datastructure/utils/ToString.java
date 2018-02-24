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
package com.rslakra.datastructure.utils;

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
		if (object == null) {
			return "null";
		}

		Class<?> objectClass = object.getClass();
		if (objectClass == String.class) {
			return (String) object;
		} else if (objectClass.isArray()) {
			String classArrayType = (includeClassName ? objectClass.getComponentType().toString() : "") + "[]{";
			if (excludePackageName) {
				int index = classArrayType.lastIndexOf(".");
				if (index > 0 && index < classArrayType.length() - 1) {
					classArrayType = classArrayType.substring(index + 1);
				}
			}

			for (int i = 0; i < Array.getLength(object); i++) {
				if (i > 0) {
					classArrayType += ", ";
				}

				Object objectArray = Array.get(object, i);
				if (objectClass.getComponentType().isPrimitive()) {
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
			if (includeClassName) {
				className += "[";
			} else {
				className = "[";
			}

			Field[] classFields = objectClass.getDeclaredFields();
			AccessibleObject.setAccessible(classFields, true);
			// get the names and values of all fields
			for (Field field : classFields) {
				if (!Modifier.isStatic(field.getModifiers())) {
					if (!className.endsWith("[")) {
						className += ", ";
					}
					className += field.getName() + "=";
					try {
						Class<?> classType = field.getType();
						Object value = field.get(object);
						if (classType.isPrimitive()) {
							className += value;
						} else {
							// recursion call.
							className += toString(value);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			className += "]";
			objectClass = objectClass.getSuperclass();
		} while (objectClass != null && !objectClass.isInstance(Object.class));

		return className;
	}

}
